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
public class Key extends Controler {

    private String name;

    public Key(String name) {
        this.name = name;
    }

    @Override
    public boolean Unlock(GameText text) {
        if (Game.getInstance().getCharacter().getInventory().containsKey(name)) {
            text.setText(text.getText() + "você usou " + name + " e conseguiu ");
            //removendo do inventario do personagem o item usado para liberar a ação.
            Game.getInstance().getCharacter().getInventory().removeInventory(Game.getInstance().getCharacter().getInventory().getObject(name));
            return true;
        } else {
            text.setText(text.getText() + "você não conseguiu pois não tinha o item necessário");
            return true;
        }
    }

    @Override
    public String getCode() {
        return "KEY:" + name;
    }
}
