/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

import model.player.Character;

/**
 *
 * @author fabio
 */
public abstract class Controler {
    private Character character;
    public abstract boolean Unlock(GameText text);

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
    
}