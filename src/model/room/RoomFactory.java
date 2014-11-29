/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.room;

import db.DirectoriesManager;
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

    public Room create(String name) {
        Scanner arq = null;
        Room room = new Room();
        try {

//            arq = new Scanner(new File("src/roons.txt"));
            arq = new Scanner(new File(DirectoriesManager.getRoomFile()));
            while (arq.hasNextLine()) {
                String line = arq.nextLine();
                if (line != null
                        && !line.trim().equals("")) {
                    String[] components = line.split("#");
                    if (components[0].equals(name)) {
                        room.setName(components[0]);
                        String[] objects = null;
                        if (components[1] != null
                                && !components[1].trim().equals("")) {
                            objects = components[1].split(":");
                        }
                        String[] doors = null;
                        if (components[2] != null
                                && !components[2].trim().equals("")) {
                            doors = components[2].split(":");
                        }
                        room.setDescription(components[3]);
                        for (int i = 0; objects != null && i < objects.length; i++) {
                            TAObject obj = ObjectFactory.getInstance().create(objects[i]);
                            obj.add(room);
                            if (obj != null) {
                                room.putRoom(obj);
                            }
                        }
                        for (int i = 0; doors != null && i < doors.length; i++) {
                            Door door = DoorFactory.getInstance().create(components[0] + ":" + doors[0]);
                            room.addDoor(door);
                        }
                        return room;
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjectFactory.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            arq.close();
        }
        return null;
    }
}
