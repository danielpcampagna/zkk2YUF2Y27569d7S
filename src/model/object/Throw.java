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
public class Throw extends Action{

    public Throw(String itemDrop, String condition) {
        super(itemDrop, condition);
    }

    
    @Override
    public void process() {
          getGameText().concat(" jogou o objeto " + getObj().getName() +" no  objeto " + getAffectedObject().getName() + " com isso você ");
         //remove da sala 
          Game.getInstance().getLocal().putRoom( getObj());
          Game.getInstance().getCharacter().getInventory().removeInventory(getObj());
          
          getAffectedObject().run("atack", null);
          getGameText().concat(getAffectedObject().getAction().getGameText().getText());
    }

    
}
