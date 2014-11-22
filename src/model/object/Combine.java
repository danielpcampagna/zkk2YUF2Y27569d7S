/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

import model.player.Game;

/**
 *
 * @author fabio
 */
public class Combine extends Action {

    public Combine(String itemDrop, String condition) {
        super(itemDrop, condition);
    }

    @Override
    public void process() {
        getGameText().concat("combina-lo com " + getObj().getName() + " gerou o item " + getItemDrop());
        //adiciona na sala atual o objeto encontrado.
        Game.getInstance().getLocal().putRoom(ObjectFactory.getInstance().create(getItemDrop()));
        if (Game.getInstance().getCharacter().getInventory().containsKey(getObj().getName())) {
            Game.getInstance().getCharacter().getInventory().removeInventory(getObj());
        } else {
            Game.getInstance().getLocal().removeRoom(getObj());
        }
    }

}
