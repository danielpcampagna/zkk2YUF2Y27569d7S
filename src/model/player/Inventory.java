package model.player;

import java.util.List;
import model.object.IObject;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.6A5BC1C3-796F-F2BE-38F8-67A0CA35EB15]
// </editor-fold> 
public class Inventory {

    private List<IObject> objects;
    private int capacity;

    public boolean add(IObject obj) {
        if (capacity >= obj.getAmount() * obj.getSize()) {
            objects.add(obj);
            capacity -= obj.getAmount() * obj.getSize();
            System.out.println("você pegou " + obj.getDescription());
            return true;
        }else{
            System.out.println("inventorio cheio " );
            System.out.println((100- getCapacity())+ "disponiveis");
            System.out.println(obj.getDescription() + " pesa "+obj.getAmount() * obj.getSize());
        }
        return false;
    }

    public void setObjects(List<IObject> objects) {
        this.objects = objects;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<IObject> getObjects() {
        return objects;
    }

    public int getCapacity() {
        return capacity;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D218585E-DCB1-0C2F-A812-B24DE53DABEE]
    // </editor-fold> 
    public Inventory(int capacity) {
        this.capacity = capacity;
    }

}
