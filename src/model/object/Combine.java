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
public class Combine extends Action{
    private String nameCombined;
    @Override
    public void process() {
        getGameText().concat("combina-lo com " + getObj().getName() +"gerou o item "+ nameCombined);
          //adiciona na sala atual o objeto encontrado.
          Game.getInstance().getLocal().putRoom(ObjectFactory.getInstance().create(nameCombined));
          Game.getInstance().getCharacter().getInventory().removeInventory(getObj());
    }
    
}
