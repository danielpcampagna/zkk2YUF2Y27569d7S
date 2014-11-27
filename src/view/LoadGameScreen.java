/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.PlayerController;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class LoadGameScreen implements IView{

    private Scanner keyboard = new Scanner(System.in);
    private IView my;
    private IView nexView;
    private PlayerController player;
    
    public LoadGameScreen(PlayerController player) {
        my = new SimpleMessage(SimpleMessage.CENTER, "Olá " + player.getLogin() + "!", ""
                + "O que deseja faze?\n"
                + "\n"
                + "1 - Continuar Jogo\n"
                + "2 - Novo Jogo\n"
                + "3 - Sair"
                + "\n"
                + "\n"
                + "");
    }
    
    @Override
    public void show() {
        my.show();
        int op;
        op = keyboard.nextInt();
        switch(op){
            case 1:
                nexView = new PlayingScreen(player.getGame());
                break;
            case 2:
                
                break;
            default:
        }
    }
    
}
