/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

/**
 *
 * @author fabio
 */
public class On extends Controler {

    @Override
    public boolean Unlock(GameText text) {
        text.concat("você conseguiu ");
        return true;
    }

    @Override
    public String getCode() {
        return "ON:";
    }

}
