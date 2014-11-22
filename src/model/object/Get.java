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
public class Get extends Action {

    public Get(String itemDrop, String condition) {
        super(itemDrop, condition);
    }

    @Override
    public void process() {
        getGameText().concat(" pegar o objeto " + getObj().getName() );
         //remove da sala 
          Game.getInstance().getLocal().removeRoom( getObj());
          Game.getInstance().getCharacter().getInventory().putInventory(getObj());
    }
    
}
