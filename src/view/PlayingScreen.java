/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import exception.NotFoundCommandException;
import java.io.IOException;
import java.util.Scanner;
import model.object.TAObject;
import model.player.Game;
import model_noUml.Command;

/**
 *
 * @author Daniel
 */
class PlayingScreen implements IView {

    private static final String LOCAL = "local";
    private static final String INVENTORY = "inventory";
    private static final String NOEXIST = "no exist";

    private Scanner keyboard = new Scanner(System.in);
    private Game currentGame;
    private IView my;

    private String place;

    PlayingScreen(Game game) {
        if (game == null) {
            throw new IllegalArgumentException("Jogo nulo");
        }
        this.currentGame = game;

    }

    @Override
    public void show() {
        String op;
        boolean valid = false;
        Command command = null;
        TAObject tmp;
        TAObject trg;
        do {
            my = new SimpleMessage(SimpleMessage.CENTER,
                    currentGame.getLocal().getName(),
                    currentGame.getLocal().getDescription());
            my.show();
            // entrada da ação
            do {
                op = keyboard.nextLine();

                try {
                    command = new Command(op);
                    valid = true;
                } catch (NotFoundCommandException ex) {
                    System.err.println(ex.getMessage());
                    valid = false;
                } catch (IOException ex) {
                    valid = false;
                } catch (NullPointerException ex) {
                    System.err.println("O que você quer dizer com \"" + op + "\"?");
                    valid = false;
                }
            } while (!valid);

            // tratamento da ação
            switch (command.getObjectType()) {
                case Command.OBJECT:
                    switch (command.getVerb()) {
                        case "combine":
                        case "throw":

                            tmp = verifyPlace(command.getObjects()[0]);
                            trg = verifyPlace(command.getObjects()[1]);

                            if (tmp != null && trg != null) {
                                tmp.run(command.getVerb(), trg);
                                new SimpleMessage(SimpleMessage.CENTER,
                                        currentGame.getLocal().getName(),
                                        tmp.getAction().getGameText().getText()).show();
                            } else {
                                new SimpleMessage(SimpleMessage.CENTER, "Item inexistente").show();
                            }
                            break;
                        case "atack":
                        case "check":
                        case "drop":
                        case "get":
                            tmp = verifyPlace(command.getObjects()[0]);

                            if (tmp != null) {
                                tmp.run(command.getVerb(), null);
                                new SimpleMessage(SimpleMessage.CENTER,
                                        currentGame.getLocal().getName(),
                                        tmp.getAction().getGameText().getText()).show();

                            } else {
                                System.err.println("Não existe!");
                            }

                    }
                    try {
                        TAObject object = currentGame.getInstance().getCharacter().getInventory().getObject(command.getObjects()[0]);
                    } catch (NullPointerException ex) {
                        System.err.println("Não existe " + command.getObjects()[0] + "!");
                    }
                    break;
                case Command.ROOM:

                    if (command.getObjects() != null
                            && command.getObjects().length == 1) {
                        switch (command.getVerb()) {
                            case "go":
                                try{
                                currentGame.setLocal(currentGame.getLocal().getDoors().get(currentGame.getLocal().getName() + ":" + command.getObjects()[0]).open());
                                }catch(NullPointerException ex){
                                    System.err.println("Você nao pode ir para \"" + command.getObjects()[0] + "\"");
                                }
                                break;
                            default:
                        }
                    }

                    break;
                case Command.NULL:
                    switch (command.getVerb()) {
                        case "exit":
                            return;
                        case "inventory":
                            new SimpleMessage(SimpleMessage.CENTER,
                                    "Inventário", currentGame.getCharacter().getInventory().see().getText()).show();
                            break;
                        case "see":
                            currentGame.getLocal().see();
                            break;
                    }
                    break;
                default:
            }
        } while (true);

    }

    private TAObject verifyPlace(String obj) {
        if (currentGame.getCharacter().getInventory().containsKey(obj)) {
            return currentGame.getCharacter().getInventory().getObject(obj);
        } else if (currentGame.getLocal().getObjects().containsKey(obj)) {
            return currentGame.getLocal().getObject(obj);
        } else {
            return null;
        }
    }

}
