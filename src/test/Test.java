/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.object.ObjectFactory;
import model.object.TAObject;
import model.player.Game;
import model.player.Character;
import model.room.Room;
import model.room.RoomFactory;

/**
 *
 * @author fabio
 */
public class Test {
    public static void main(String[] args) {
        Game.getInstance().setCharacter(new Character(10,10,10,10));
        Game.getInstance().setLocal(RoomFactory.getInstance().create("teste"));
        TAObject obj = ObjectFactory.getInstance().create("agua");
        obj.run("check");
        System.out.println(obj.getAction().getGameText().getText());
        obj = ObjectFactory.getInstance().create("chave");
        obj.run("get");
        System.out.println(obj.getAction().getGameText().getText());
        obj = ObjectFactory.getInstance().create("caixa");
        obj.run("open");
        System.out.println(obj.getAction().getGameText().getText());
    }
}
