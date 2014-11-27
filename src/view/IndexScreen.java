/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PlayerController;
import java.util.Scanner;
import model.player.Player;

/**
 *
 * @author Daniel
 */
public class IndexScreen implements IView {

    private Scanner keyboard = new Scanner(System.in);
    private SimpleMessage my;
    private IView nextView;

    public IndexScreen() {
        my = new SimpleMessage(SimpleMessage.CENTER, "TEXT ADVENTURES", ""
                + "\n"
                + " 1 - Jogar com minha conta\n"
                + " 2 - Criar nova conta\n"
                + " 3 - Sair do Jogo"
                + "\n"
                + "\n"
                + "\n"
                + "ESCOLHA UMA OPÇÃO E PRESSIONE ENTER PARA COMEÇAR", 60);
    }

    @Override
    public void show() {
        int op;
        while (true) {
            do {
                my.show();
                op = keyboard.nextInt();
                switch (op) {
                    case 1:
                        nextView = new CreatePlayerScreen(new PlayerController(new Player()));
                        break;
                    case 2:
                        nextView = new LoginScreen();
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        nextView = new SimpleMessage(SimpleMessage.ERRO, "Erro", "Opção não existente!");
                }
            } while (op != 1 && op != 2);
            nextView.show();
        }
    }

}
