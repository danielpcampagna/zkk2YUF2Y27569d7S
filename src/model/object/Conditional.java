/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

import model.player.CharacterAtributes;
import model.player.Game;

/**
 *
 * @author fabio
 */
public class Conditional extends Controler {

    private CharacterAtributes atb;

    public Conditional(CharacterAtributes atb) {
        this.atb = atb;
    }

    @Override
    public boolean Unlock(GameText text) {
        if (Game.getInstance().getCharacter().checkAtributes(atb)) {
            text.concat("você possui atributos suficientes e conseguiu ");
            return true;
        } else {
            text.concat("você não conseguiu por falta de atributos ");
            return false;
        }
    }
    @Override
    public String getCodigo() {
        return "CONDITIONAL:"+atb.getForce()+":"+atb.getResistence()+":"+atb.getAgility()+":"+atb.getInteligence();
    }
}
