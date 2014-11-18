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
public class Check extends Action{

    public Check(String itemDrop, String condition) {
        super(itemDrop, condition);
    }

    @Override
    public void process() {
        getGameText().concat(" observar o "+getObj().getName()+" : " + getObj().getAnalysis());
        //adiciona a analise a memoria do personagem.
        Game.getInstance().getCharacter().getMemory().add(getObj().getAnalysis());
    }
    
}
