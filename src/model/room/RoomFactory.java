/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.room;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.object.ObjectFactory;
import model.object.TAObject;


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
        Scanner arq=null;
        Room room = new Room();
        try {
            
            arq = new Scanner(new File("roons.txt"));
           while(arq.hasNext()){
               String nameRoom = arq.next();
               if(!nameRoom.equals(name)){
                   arq.nextLine();
               }else{
                   String line = arq.nextLine();
                   String[] components = line.split("#");
                   String[] objects = components[0].split(":");
                   String[] doors = components[1].split(":");
                   room.setDescription(components[2]);
                   for (int i = 0; i < objects.length; i++) {
                       TAObject obj = ObjectFactory.getInstance().create(objects[i]);
                       if(obj!= null)
                           room.putRoom(obj);
                   }
                   for (int i = 0; i < doors.length; i++) {
                       Door door = new Door(doors[i]);
                       room.addDoor(door);
                   }
                   return room;
               }
           }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjectFactory.class
                    .getName()).log(Level.SEVERE, null, ex);
        }finally{
            arq.close();
        }
        return null;
    }
    }

