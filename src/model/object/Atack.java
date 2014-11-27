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
      if(!getItemDrop()[0].equals("NOT")){
          getGameText().concat("ao quebra-lo você encontrou " );
          for (int i = 0; i < getItemDrop().length; i++) {
              getGameText().concat(getItemDrop()[i] +" , ");
          }
          //adiciona na sala atual o objeto encontrado.
          for (int i = 0; i < getItemDrop().length; i++) {
              Game.getInstance().getLocal().putRoom(ObjectFactory.getInstance().create(getItemDrop()[i]));
              Game.getInstance().getLocal().getObject(getItemDrop()[i]).add(Game.getInstance().getLocal());
          }
      }
    }
    
}
