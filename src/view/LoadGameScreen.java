/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GameController;
import controller.PlayerController;
import db.DirectoriesManager;
import exception.IOEmptyTableException;
import exception.IONotFoundDataException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.player.Game;
import util.RegexRules;

/**
 *
 * @author Daniel
 */
public class LoadGameScreen implements IView {

    private Scanner keyboard = new Scanner(System.in);
    private IView my;
    private IView nextView;
    private PlayerController player;
    private final String BACK = "-1";

    public LoadGameScreen(PlayerController player) throws IOException {
        
        DirectoriesManager.newInstace(player.load());
        this.player = player;
        init();
    }

    public void init() {
        my = new SimpleMessage(SimpleMessage.CENTER, "Olá " + player.getLogin() + "!", ""
                + "O que deseja fazer?\n"
                + "\n"
                + " 1 - Novo Jogo\n"
                + ((player.getGame() != null
                && player.getGame().size() > 0) ? " 2 - Continuar Jogo\n" : "")
                + "\n"
                + "\n"
                + "Digite [" + BACK + "] para desconectar");
    }

    @Override
    public void show() {
        String op;
        boolean valid;
        do {
            init();
            valid = true;
            my.show();
            System.out.print("Opção: ");
            op = keyboard.nextLine();
            switch (op) {
                case "1":
                    nextView = new CreateGameScreen(player);
                    nextView.show();
                    try {
                        // nao precisa
                        player.load();
                    } catch (IOEmptyTableException ex) {
                    } catch (IONotFoundDataException ex) {
                    }
                    break;
                case "2":
                    try {
                        player.load();

                        String message = "";
                        int i = 0;
                        List<Game> games = player.getGame();
                        for (Game g : games) {
                            message += " " + (i + 1) + " - " + g.getName() + "\n";
                            i++;
                        }
                        message += "\n";
                        new SimpleMessage(SimpleMessage.CENTER,
                                "Escolha uma opção para jogar",
                                message, SimpleMessage.MAX_W).show();
                        do {
                            if (!valid) {
                                new SimpleMessage(SimpleMessage.ERRO, "Erro", "Escolha uma opção válida!", SimpleMessage.MIN_W).show();
                            }
                            System.out.print("Opção: ");
                            op = keyboard.nextLine();
                            valid = RegexRules.isNumber(op)
                                    && Integer.parseInt(op) >= 1
                                    && Integer.parseInt(op) <= games.size();
                        } while (!valid);
                        valid = true;
                        Game select = games.get(Integer.parseInt(op) - 1);
                        Game.getInstance().setName(select.getName());
                        Game.getInstance().setCharacter(select.getCharacter());
                        Game.getInstance().setLocal(select.getLocal());
                        nextView = new PlayingScreen(Game.getInstance());
                        nextView.show();
                    } catch (IOEmptyTableException ex) {
                        new SimpleMessage(SimpleMessage.ERRO, "Erro", "Não existe jogos registrados", SimpleMessage.MIN_W).show();
                    } catch (IONotFoundDataException ex) {
                        new SimpleMessage(SimpleMessage.ERRO, "Erro", "Não existe jogos registrados", SimpleMessage.MIN_W).show();
                    }
                    break;
                case BACK:
                    return;
                default:
                    new SimpleMessage(SimpleMessage.ERRO, "Erro", "Escolha uma opção válida!", SimpleMessage.MIN_W).show();
                    valid = false;
            }

        } while (true);
    }

}
