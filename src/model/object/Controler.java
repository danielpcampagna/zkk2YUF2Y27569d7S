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
    public static final String ON = "ON:";
    public static final String OFF = "OFF::";
    public static final String CONDITIONAL = "CONDITIONAL:";
    public static final String KEY = "KEY:";
    public abstract boolean Unlock(GameText text);
    public abstract String getCode();

   
    
}
