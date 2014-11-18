/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

import model.player.CharacterAtributes;

/**
 *
 * @author fabio
 */
public class ControlerFactory {

    private static ControlerFactory instance;

    private ControlerFactory() {
    }

    public static synchronized ControlerFactory getInstance() {
        if (instance == null) {
            instance = new ControlerFactory();
        }
        return instance;
    }

    public Controler create(String condition) {
        String[] codes = condition.split("|");
        switch (codes[0]) {
            case "ON":
                return new On();
            case "OFF":
                return new Off();
            case "CONDITIONAL":
                return new Conditional(new CharacterAtributes(Integer.parseInt(codes[1]),
                        Integer.parseInt(codes[2]),Integer.parseInt(codes[3]),Integer.parseInt(codes[4])));
            case "KEY":
                return new Key(codes[1]);
        }
        return null;
    }
}
