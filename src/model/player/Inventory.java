package model.player;

import java.util.HashMap;
import java.util.Map;
import model.object.GameText;

import model.object.TAObject;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.6A5BC1C3-796F-F2BE-38F8-67A0CA35EB15]
// </editor-fold> 
public class Inventory {

    private Map<String, TAObject> objects;
    private int capacity;

    Inventory() {
        objects = new HashMap<>();
        capacity = 100;
    }

    public boolean putInventory(TAObject obj) {
        if (capacity >= obj.getSize()) {
            objects.put(obj.getName(), obj);
            capacity -= obj.getSize();
            return true;
        }
        return false;
    }

    public boolean removeInventory(TAObject obj) {
        if (objects.containsKey(obj.getName())) {
            objects.remove(obj.getName(), obj);
            capacity += obj.getSize();
            return true;
        }
        return false;
    }

    /**
     *
     * @param objects
     */
    public void setObjects(Map<String, TAObject> objects) {
        this.objects = objects;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Map<String, TAObject> getObjects() {
        return objects;
    }

    public int getCapacity() {
        return capacity;
    }

    public Inventory(int capacity) {
        objects = new HashMap<>();
        this.capacity = capacity;
    }

    public TAObject getObject(String name) {
        return objects.get(name);
    }

    public boolean containsKey(String name) {
        return objects.containsKey(name);
    }

    public GameText see() {
        GameText out = new GameText();

        for (TAObject in : objects.values()) {
            out.concat(in.getName() + " " + in.getDescription() + "\n");
        }
        return out;
    }
}
