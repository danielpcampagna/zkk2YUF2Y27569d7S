/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.room;

import model.object.Controler;
import model.object.GameText;

/**
 *
 * @author fabio
 */
public class Door {
    private GameText text;
    private String name;
    private String roomName;
    private RoomFactory factory;
    private Controler controler;
    public Room open(){
        if(controler.Unlock(text)){
            return factory.create(roomName);
        }else{
            return null;
        }
    }
   
}
