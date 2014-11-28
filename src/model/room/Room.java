/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.room;

import java.util.HashMap;
import java.util.Map;
import model.object.GameText;
import model.object.TAObject;
import model.observer.IObservable;
import model.observer.IObserver;

/**
 *
 * @author fabio
 */
public class Room implements IObserver {

    private Map<String, TAObject> objects;
    private Map<String, Door> doors;
    private int visibility;
    private String description;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Room() {
        this.objects = new HashMap<String, TAObject>();
        this.doors = new HashMap<String, Door>();

    }

    public TAObject getObject(String name) {
        return objects.get(name);
    }
    public boolean contain(String name){
        return objects.containsKey(name);
    }
    public boolean addDoor(Door door) {
        if (!doors.containsKey(door.getRoomNameA()+":"+door.getRoomNameB())) {
            doors.put(door.getRoomNameA()+":"+door.getRoomNameB(), door);
            return true;
        }
        return false;
    }

    public boolean removeDoor(Door door) {
        if (!doors.containsKey(door.getRoomNameA()+":"+door.getRoomNameB())) {
            doors.put(door.getRoomNameA()+":"+door.getRoomNameB(), door);
            return true;
        }
        return false;
    }

    public boolean putRoom(TAObject obj) {
        if (!objects.containsKey(obj.getName())) {
            objects.put(obj.getName(), obj);
            obj.notifyObserver();
            return true;
        }
        return false;
    }

    public boolean removeRoom(TAObject obj) {
        if (objects.containsKey(obj.getName())) {
            objects.remove(obj.getName(), obj);
            obj.notifyObserver();
            return true;
        }
        return false;
    }

    public GameText see() {
        GameText out = new GameText();
        System.err.println(visibility);
        for (TAObject in : objects.values()) {
            if (visibility >= in.getVisibility()) {
                out.setText(out.getText() + in.getName()+" " + in.getDescription()+"\n");
            }
        }
        return out;
    }

    @Override
    public void update() {
        visibility = 0;
        for (TAObject in : objects.values()) {
            visibility += in.getIluminity();
        }

    }

    public Map<String, TAObject> getObjects() {
        return objects;
    }

    public void setObjects(Map<String, TAObject> objects) {
        this.objects = objects;
    }

    public Map<String, Door> getDoors() {
        return doors;
    }

    public void setDoors(Map<String, Door> doors) {
        this.doors = doors;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
