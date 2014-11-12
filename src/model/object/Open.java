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
public class Open extends Action {

    private String nameDrop;

    @Override
    public void process() {
        getGameText().concat(" abrir o " + getObj().getName());
        //depois de aberto ele é removido
        Game.getInstance().getCharacter().getInventory().removeInventory(getObj());
        if (nameDrop != null) {
            getGameText().concat("ao abri-lo você encontrou " + nameDrop);
            //adiciona na sala atual o objeto encontrado.
            Game.getInstance().getLocal().putRoom(ObjectFactory.getInstance().create(nameDrop));
        }
    }

}
