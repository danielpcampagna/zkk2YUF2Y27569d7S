/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.room;

import model.object.Controler;
import model.object.ControlerFactory;
import model.object.GameText;

/**
 *
 * @author fabio
 */
public class Door {
    private GameText text;
    private String roomNameA;
    private String roomNameB;
   
    private Controler controler;
    public Room open(){
        if(controler.Unlock(text)){
            return RoomFactory.getInstance().create(roomNameB);
        }else{
            return null;
        }
    }

    public Door(String roomNameA,String roomNameB,String condition) {
        this.roomNameA = roomNameA;
        this.roomNameB = roomNameB;
        controler = ControlerFactory.getInstance().create(condition);
        text = new GameText();
    }
    
    public String getRoomNameA() {
        return roomNameA;
    }

    public void setRoomNameA(String roomNameA) {
        this.roomNameA = roomNameA;
    }

    public String getRoomNameB() {
        return roomNameB;
    }

    public void setRoomNameB(String roomNameB) {
        this.roomNameB = roomNameB;
    }
   
}
