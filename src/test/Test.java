/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.object.TAObject;
import model.player.Game;
import model.player.Character;

/**
 *
 * @author fabio
 */
public class Test {
    public static void main(String[] args) {
        Game.getInstance().setCharacter(new Character(10,10,10,10));
        TAObject obj = new TAObject(0, 10, 20, 2, "agua", "liquido h2o bebivel", "esta suja");
        obj.run("check");
        System.out.println(obj.getAction().getGameText().getText());
    }
}
