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
    private String roomName;
   
    private Controler controler;
    public Room open(){
        if(controler.Unlock(text)){
            return RoomFactory.getInstance().create(roomName);
        }else{
            return null;
        }
    }

    public Door(String roomName) {
        this.roomName = roomName;
        text = new GameText();
    }
    
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
   
}
