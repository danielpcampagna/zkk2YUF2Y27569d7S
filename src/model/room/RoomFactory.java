/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.room;

/**
 *
 * @author fabio
 */
public class RoomFactory {
    private static RoomFactory instance;

    private RoomFactory() {
    }

    public static synchronized RoomFactory getInstance() {
        if (instance == null) {
            instance = new RoomFactory();
        }
        return instance;
    }
    public Room create(String name){
        return null;
    }
}
