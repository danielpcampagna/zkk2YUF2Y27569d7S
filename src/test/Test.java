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
        Game.getInstance().setCharacter(new Character(10, 10, 10, 10));
        Game.getInstance().setLocal(RoomFactory.getInstance().create("teste"));
        
        TAObject obj = Game.getInstance().getLocal().getObject("agua");
        obj.run("check");
        System.out.println(obj.getAction().getGameText().getText());
        
        obj = Game.getInstance().getLocal().getObject("chave");
        obj.run("get");
        System.out.println(obj.getAction().getGameText().getText());
        
        obj = Game.getInstance().getLocal().getObject("caixa");
        obj.run("open");
        System.out.println(obj.getAction().getGameText().getText());
        
        obj = Game.getInstance().getLocal().getObject("ouro");
        obj.run("get");
        System.out.println(obj.getAction().getGameText().getText());
        
        obj = Game.getInstance().getLocal().getObject("potion_verde");
        obj.run("get");
        System.out.println(obj.getAction().getGameText().getText());
        
        obj = Game.getInstance().getLocal().getObject("potion_vermelha");
        obj.run("get");
        System.out.println(obj.getAction().getGameText().getText());
        
        obj = Game.getInstance().getCharacter().getInventory().getObject("potion_verde");
        obj.run("combine");
        System.out.println(obj.getAction().getGameText().getText());
        
        obj = Game.getInstance().getCharacter().getInventory().getObject("ouro");
        obj.run("drop");
        System.out.println(obj.getAction().getGameText().getText());
        
        obj = Game.getInstance().getLocal().getObject("monstro1");
        obj.run("atack");
        System.out.println(obj.getAction().getGameText().getText());
        
        obj = Game.getInstance().getLocal().getObject("monstro2");
        obj.run("atack");
        System.out.println(obj.getAction().getGameText().getText());

        System.err.println(Game.getInstance().getLocal().see().getText());
    }
}
