/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PlayerController;
import controller.CharacterController;
import controller.GameController;
import controller.RoomController;
import exception.IODataExistingException;
import exception.IOEmptyTableException;
import model.player.Character;
import java.util.Scanner;
import model.player.Game;
import model.room.Room;
import util.RegexRules;

/**
 *
 * @author Daniel
 */
class CreateGameScreen implements IView {

    private Scanner keyboard = new Scanner(System.in);
    private IView my;
    private final String BACK = "-1";
    private PlayerController player;
    public CreateGameScreen(PlayerController player) {
        this.player = player;
        my = new MultiMessage(MultiMessage.CENTER, "Novo Jogo", new String[]{""
            + "\n"
            + " Seu personagem terá 20 pontos para serem distribuidos "
            + "entre os atributos (força, resistência, agilidade, inteligencia).\n"
            + " Escolha sabiamente, pois isso pode interferir o rumo do "
            + "seu jogo.\n"
            + "\n"
            + "\n", ""
            + "\n"
            + " 1o - Informe um nome cujo jogo será salvo\n"
            + " 2o - Informe o nome do seu Personagem\n"
            + " 3o - Informe a quantidade de pontos para Força\n"
            + " 4o - Informe a quantidade de pontos para Resistência\n"
            + " 5o - Informe a quantidade de pontos para Agilidade\n"
            + " 6o - Informe a quantidade de pontos para Inteligência\n"
            + "\n"
            + "\n"
            + "Digite [" + BACK + "] para voltar"}, MultiMessage.MAX_W);
    }

    @Override
    public void show() {
        String op;
        String gameName = null;
        String name = null;
        String num = null;
        int force = 0;
        int resistence = 0;
        int agility = 0;
        int inteligence = 0;
        int total = 20;
        boolean valid = true;
        do {
            my.show();
            // preenchendo o campo nome do jogo
            do {
                if (!valid) {
                    if (gameName.equals(BACK)) {
                        return;
                    }
                    new SimpleMessage(SimpleMessage.ERRO, "ERRO",
                            "O nome do jogo deve conter entre 4 e 20 caracteres").show();

                }
                System.out.print("Nome do Jogo: ");
                gameName = keyboard.nextLine();
                valid = gameName != null
                        && gameName.length() >= 4
                        && gameName.length() <= 20;
            } while (!valid);
            valid = true;
            // preenchendo o campo nome personagem
            do {
                if (!valid) {
                    if (name.equals(BACK)) {
                        return;
                    }
                    new SimpleMessage(SimpleMessage.ERRO, "ERRO",
                            "O nome deve conter entre 4 e 20 caracteres").show();
                }
                System.out.print("Nome do Personagem: ");
                name = keyboard.nextLine();
                valid = name != null
                        && name.length() >= 4
                        && name.length() <= 20;
            } while (!valid);
            valid = true;

            do {
                total = 20;
                // preenchendo o campo forca
                do {
                    if (!valid) {
                        if (num.equals(BACK)) {
                            return;
                        }
                        new SimpleMessage(SimpleMessage.ERRO, "ERRO",
                                "Este campo deve ser um Inteiro").show();
                    }

                    System.out.println("Pontuação a ser distribuida: " + total);
                    System.out.print("Força: ");

                    num = keyboard.nextLine();
                    valid = RegexRules.isNumber(num) && Integer.parseInt(num) <= total;
                } while (!valid);
                force = Integer.parseInt(num);
                total -= force;
                valid = true;

                // preenchendo o campo resistência
                if (total > 0) {
                    do {
                        if (!valid) {
                            if (num.equals(BACK)) {
                                return;
                            }
                            new SimpleMessage(SimpleMessage.ERRO, "ERRO",
                                    "Este campo deve ser um Inteiro").show();
                        }

                        System.out.println("Pontuação a ser distribuida: "
                                + total);
                        System.out.print("Resistência: ");

                        num = keyboard.nextLine();
                        valid = RegexRules.isNumber(num) && Integer.parseInt(num) <= total;
                    } while (!valid);
                    resistence = Integer.parseInt(num);
                    total -= resistence;
                    valid = true;
                }

                // preenchendo o campo agilidade
                if (total > 0) {
                    do {
                        if (!valid) {
                            if (num.equals(BACK)) {
                                return;
                            }
                            new SimpleMessage(SimpleMessage.ERRO, "ERRO",
                                    "Este campo deve ser um Inteiro").show();
                        }

                        System.out.println("Pontuação a ser distribuida: "
                                + total);
                        System.out.print("Agilidade: ");

                        num = keyboard.nextLine();
                        valid = RegexRules.isNumber(num) && Integer.parseInt(num) <= total;
                    } while (!valid);
                    agility = Integer.parseInt(num);
                    total -= agility;
                    valid = true;
                }

                // preenchendo o campo inteligência
                if (total > 0) {
                    do {
                        if (!valid) {
                            if (num.equals(BACK)) {
                                return;
                            }
                            new SimpleMessage(SimpleMessage.ERRO, "ERRO",
                                    "Este campo deve ser um Inteiro").show();
                        }

                        System.out.println("Pontuação a ser distribuida: " + total);
                        System.out.print("Inteligência: ");
                        num = keyboard.nextLine();
                        valid = RegexRules.isNumber(num) && Integer.parseInt(num) <= total;
                    } while (!valid);
                    inteligence = Integer.parseInt(num);
                    total -= inteligence;
                    valid = true;
                }
                String[] messagem;
                if (total > 0) {
                    messagem = new String[2];
                } else {
                    messagem = new String[1];
                }
                messagem[0] = ""
                        + "Distribuição dos atributos:\n"
                        + "\n"
                        + "Nome: " + name + "\n"
                        + "\n"
                        + "Força: " + force + "\n"
                        + "Resistência: " + resistence + "\n"
                        + "Agilidade: " + agility + "\n"
                        + "Inteligência: " + inteligence + "\n"
                        + "\n"
                        + "\n"
                        + "Deseja alterar os atributo?(s/n)";
                if (total > 0) {
                    messagem[1] = "Você ainda tem " + total + " pontos para serem "
                            + "distribuidos entre os atributos";
                }
                new MultiMessage(messagem, SimpleMessage.MAX_W).show();

                do {
                    System.out.print("Reposta: ");
                    op = keyboard.nextLine();
                } while (!RegexRules.like(op, RegexRules.GETYESORNO));
            } while (RegexRules.like(op, RegexRules.GETYES));
            new SimpleMessage("Deseja alterar o nome?\n"
                    + "Nome: " + name + "\n", SimpleMessage.MIN_W).show();
            do {
                System.out.print("Reposta: ");
                op = keyboard.nextLine();
            } while (!RegexRules.like(op, RegexRules.GETYESORNO));
        } while (RegexRules.like(op, RegexRules.GETYES));

        //1-criar o personagem
        //2-criar o game
        CharacterController characterCtrl = new CharacterController(
                new Character(name, force, resistence, agility, inteligence));

        Room room = new Room();
        // 1a sala de todos os jogos
        room.setName("previa");
        RoomController roomCtrl = new RoomController(room);
        try {
            characterCtrl.save();
            Game.getInstance().setName(gameName);
            Game.getInstance().setCharacter(characterCtrl.load());
            Game.getInstance().setLocal(roomCtrl.load());
            GameController game = new GameController(Game.getInstance());
            game.save();
            player.addGame(game.load());
            player.update();
            
        } catch (IODataExistingException ex) {
            new SimpleMessage(SimpleMessage.ERRO, "Erro ao Salvar",
                    "Ocorreu um erro ao salvar o seu personagem!").show();
        } catch (IOEmptyTableException ex) {
            new SimpleMessage(SimpleMessage.ERRO, "Erro ao Adicionar Character",
                    "Ocorreu um erro ao adicioanr Character ao Game!").show();
        }
    }

}
