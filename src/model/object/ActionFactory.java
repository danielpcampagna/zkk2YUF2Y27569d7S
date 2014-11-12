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
public class ActionFactory {

    private static ActionFactory instance;

    private ActionFactory() {
    }

    public Action create() {
        return null;
    }

    public static synchronized ActionFactory getInstance() {
        if (instance == null) {
            instance = new ActionFactory();
        }
        return instance;
    }
}
