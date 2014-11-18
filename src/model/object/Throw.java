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
    private String name;

    public Throw(String name) {
        this.name = name;
    }
    
    @Override
    public void process() {
          getGameText().concat(" jogou o " + getObj().getName() );
         //remove da sala 
          Game.getInstance().getLocal().putRoom( getObj());
          Game.getInstance().getCharacter().getInventory().removeInventory(getObj());
    }

    
}
