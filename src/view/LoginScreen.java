/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PlayerController;
import db.DirectoriesManager;
import exception.IODataExistingException;
import exception.IOEmptyTableException;
import exception.IONotFoundDataException;
import java.io.IOException;
import java.util.Scanner;
import model.player.Player;

/**
 *
 * @author Daniel
 */
public class LoginScreen implements IView {

    private SimpleMessage my;
    private IView nextView;

    private Scanner keyboard = new Scanner(System.in);
    private PlayerController player;
    private final String BACK = "-1";

    public LoginScreen() {
        my = new SimpleMessage(SimpleMessage.CENTER, "TEXT ADVENTURES/LOGIN", ""
                + "\n"
                + " 1o - Informe o login\n"
                + " 2o - Informe a senha\n"
                + "\n"
                + "\n"
                + "\n"
                + "Digite [" + BACK + "] para voltar", SimpleMessage.MAX_W);
    }

    @Override
    public void show() {
        try {

            String login = null;
            String senha = null;
            boolean valid = false;

            do {
                my.show();
                // preenchendo o campo login
                do {
                    if (login != null && !valid) {
                        if (login.equals(BACK)) {
                            return;
                        }
                        new SimpleMessage(SimpleMessage.ERRO, "ERRO", ""
                                + "O Login deve conter entre 4 e 20 caracteres\n"
                                + "Informe o Login novamente.", SimpleMessage.MIN_W).show();
                        keyboard.nextLine();
                    }
                    System.out.print("Login: ");
                    login = keyboard.nextLine();
                    valid = login.length() >= 4 && login.length() <= 20;
                } while (!valid || login.trim().equals("0"));
                if (login.trim().equals(BACK)) {
                    return;
                }
                valid = false;
                do {
                    if (senha != null && !valid) {
                        if (senha.equals(BACK)) {
                            return;
                        }
                        if (!(senha.length() >= 4
                                && senha.length() <= 20)) {
                            new SimpleMessage(SimpleMessage.ERRO, "ERRO", ""
                                    + "A Senha deve conter entre 4 e 20 caracteres.\n"
                                    + "Informe a senha novamente.", SimpleMessage.MIN_W).show();
                        }
                    }
                    System.out.print("Senha: ");
                    senha = keyboard.nextLine();
                    valid = senha.length() >= 4
                            && senha.length() <= 20;
                } while (!valid);

                player = new PlayerController(new Player());
                player.setLogin(login);
                player.setSenha(senha);
                
                if (DirectoriesManager.newInstace(player.getModel()) != null && player.load() != null) {
                    nextView = new LoadGameScreen(player);
                    nextView.show();
                } else {
                    new SimpleMessage(SimpleMessage.CENTER, "Falha ao Logar", ""
                            + "Login não existente ou senha Inválida!", SimpleMessage.MIN_W).show();
                }
            } while (true);

        } catch (IONotFoundDataException ex) {
            new SimpleMessage(SimpleMessage.CENTER, "Falha ao Logar", ""
                    + "Login não existente ou senha Inválida!", SimpleMessage.MIN_W);
        } catch (IODataExistingException ex) {
            new SimpleMessage(SimpleMessage.ERRO, "Erro", ex.getMessage(), SimpleMessage.MIN_W);
        } catch (IOEmptyTableException ex) {
            new SimpleMessage(SimpleMessage.ERRO, "Erro", ex.getMessage(), SimpleMessage.MIN_W);
        } catch (IOException ex) {
            new SimpleMessage(SimpleMessage.ERRO, "Erro", ex.getMessage(), SimpleMessage.MIN_W);
        }

    }

}
