/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.IController;
import controller.PlayerController;
import exception.IODataExistingException;
import exception.IOEmptyTableException;
import exception.IONotFoundDataException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public LoginScreen() {
        my = new SimpleMessage(SimpleMessage.CENTER, "TEXT ADVENTURES/LOGIN", ""
                + "\n"
                + " 1o - Informe o login\n"
                + " 2o - Informe a senha\n"
                + "\n"
                + "\n"
                + "\n"
                + "ESCOLHA UMA OPÇÃO E PRESSIONE ENTER PARA COMEÇAR", 60);
    }

    @Override
    public void show() {
        try {
            my.show();
            String login = null;
            String senha = null;
            boolean valid = false;

            // preenchendo o campo login
            do {
                if (login != null && !valid) {
                    new SimpleMessage(SimpleMessage.ERRO, "ERRO", "Deve conter entre 4 e 20 caracteres").show();
                    keyboard.next();
                }
                login = keyboard.next();
                valid = login.length() >= 4 && login.length() <= 20;
            } while (!valid);
            valid = false;
            do {
                if (senha != null && !valid) {
                    if (!(senha.length() >= 4
                            && senha.length() <= 20)) {
                        new SimpleMessage(SimpleMessage.ERRO, "ERRO", "Deve conter entre 4 e 20 caracteres").show();
                    }
                }
                senha = keyboard.next();
                valid = senha.length() >= 4
                        && senha.length() <= 20;
            } while (!valid);

            player = new PlayerController(new Player());
            player.setLogin(login);
            player.setSenha(senha);

            if (player.load() != null) {
                nextView = new LoadGameScreen(player);
            }
            nextView.show();
        } catch (IONotFoundDataException ex) {
            new SimpleMessage(SimpleMessage.CENTER, "Falha ao Logar", ""
                    + "Login não existente ou senha Inválida!");
        } catch (IODataExistingException ex) {
            new SimpleMessage(SimpleMessage.ERRO, "Erro", ex.getMessage());
        } catch (IOEmptyTableException ex) {
            new SimpleMessage(SimpleMessage.ERRO, "Erro", ex.getMessage());
        }

    }

}
