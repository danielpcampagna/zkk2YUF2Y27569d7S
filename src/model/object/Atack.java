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
public class Atack extends Action{
    

    Atack(String itemDrop, String condition) {
        super(itemDrop,condition);
    }
    @Override
    public void process() {
      getGameText().concat(" destruir o objeto " + getObj().getName());
      //remover da sala o objeto destruido.
      if(Game.getInstance().getCharacter().getInventory().containsKey(getObj().getName()))
        Game.getInstance().getCharacter().getInventory().removeInventory(getObj());
        else{
            Game.getInstance().getLocal().removeRoom(getObj());
        }
      if(!getItemDrop().equals("NOT")){
          getGameText().concat("ao quebra-lo você encontrou " + getItemDrop());
          //adiciona na sala atual o objeto encontrado.
          Game.getInstance().getLocal().putRoom(ObjectFactory.getInstance().create(getItemDrop()));
          Game.getInstance().getLocal().getObject(getItemDrop()).add(Game.getInstance().getLocal());
      }
    }
    
}
