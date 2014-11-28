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
        System.out.println(Game.getInstance().getLocal().see().getText());
        TAObject obj = Game.getInstance().getLocal().getObject("agua");
        obj.run("get",null);
        System.out.println(obj.getAction().getGameText().getText());
        
        obj = Game.getInstance().getLocal().getObject("chave");
        obj.run("get",null);
        System.out.println(obj.getAction().getGameText().getText());
        
        obj = Game.getInstance().getLocal().getObject("caixa");
        obj.run("open",null);
        System.out.println(obj.getAction().getGameText().getText());
        
        obj = Game.getInstance().getLocal().getObject("ouro");
        obj.run("get",null);
        System.out.println(obj.getAction().getGameText().getText());
        
        obj = Game.getInstance().getCharacter().getInventory().getObject("agua");
        obj.run("combine",Game.getInstance().getCharacter().getInventory().getObject("ouro"));
        System.out.println(obj.getAction().getGameText().getText());
        
        obj = Game.getInstance().getLocal().getObject("potion verde");
        obj.run("get",null);
        System.out.println(obj.getAction().getGameText().getText());
        
        obj = Game.getInstance().getLocal().getObject("potion vermelha");
        obj.run("get",null);
        System.out.println(obj.getAction().getGameText().getText());
        
      
        obj.run("throw",Game.getInstance().getLocal().getObject("monstro1"));
        System.out.println(obj.getAction().getGameText().getText());
        
        
        
        obj = Game.getInstance().getLocal().getObject("monstro2");
        obj.run("atack",null);
        System.out.println(obj.getAction().getGameText().getText());

        System.out.println(Game.getInstance().getLocal().see().getText());
        Game.getInstance().setLocal(Game.getInstance().getLocal().getDoors().get("teste:room1").open());
        System.out.println(Game.getInstance().getLocal().see().getText());
    }
}
