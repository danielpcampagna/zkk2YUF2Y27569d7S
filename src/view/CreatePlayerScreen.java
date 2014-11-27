/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PlayerController;
import exception.IODataExistingException;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class CreatePlayerScreen implements IView {

    private Scanner keyboard = new Scanner(System.in);
    private SimpleMessage my;
    private PlayerController player;

    public CreatePlayerScreen(PlayerController player) {
        this.player = player;
        my = new SimpleMessage(SimpleMessage.CENTER, "TEXT ADVENTURES/LOGIN", ""
                + "\n"
                + " 1o - Informe o Login [ENTER]\n"
                + " 2o - Informe uma Senha [ENTER]\n"
                + " 3o - Confirme a Senha [ENTER]\n"
                + "\n"
                + "\n"
                + "\n", 60);
    }

    @Override
    public void show() {

        my.show();
        String login = null;
        String senha = null;
        String confirmacaoSenha = null;
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
                if (!(senha.trim().equals(confirmacaoSenha.trim()))){
                    new SimpleMessage(SimpleMessage.ERRO, "ERRO", "Os dois campos deve ser iguais").show();
                }
            }
            senha = keyboard.next();
            confirmacaoSenha = keyboard.next();
            valid = senha.length() >= 4
                    && senha.length() <= 20
                    && senha.trim().equals(confirmacaoSenha.trim());
        } while (!valid);

        player.setLogin(login);
        player.setSenha(senha);

        try {
            player.save();
        } catch (IODataExistingException ex) {
            new SimpleMessage(SimpleMessage.ERRO, "Erro", ex.getMessage());
        }
    }

}
