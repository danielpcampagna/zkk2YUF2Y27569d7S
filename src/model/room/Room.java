/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.room;

import java.util.Map;
import model.object.GameText;
import model.object.TAObject;
import model.observer.IObservable;
import model.observer.IObserver;

/**
 *
 * @author fabio
 */
public class Room implements IObserver{

    private Map<String, TAObject> objects;
    private Map<String, Door> doors;
    private int visibility;
    public TAObject getObject(String name) {
        return objects.get(name);
    }

    public boolean putRoom(TAObject obj) {
        if (!objects.containsKey(obj.getName())) {
            objects.put(obj.getName(), obj);
            return true;
        }
        return false;
    }

    public boolean removeRoom(TAObject obj) {
        if (objects.containsKey(obj.getName())) {
            objects.remove(obj);
            return true;
        }
        return false;
    }
    public GameText see(){
        GameText out = new GameText();
        for (TAObject in : objects.values()) {
            if(visibility>=in.getVisibility())
            out.setText(out.getText() + in.getName() + in.getDescription());
        }
        return out;
    }

    @Override
    public void update() {
        visibility = 0;
        for(TAObject in : objects.values()){
            visibility+= in.getIluminity();
        }
        
    }
}
