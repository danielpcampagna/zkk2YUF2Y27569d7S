package model.object.action_get;
// #[regen=yes,id=DCE.D6647E0A-E787-5D49-72E2-9B60BDD402D5]
// </editor-fold> 

import java.util.List;
import model.object.IObject;
import model.player.Game;

public class AGKeyGet implements IActionGet {

    private int key;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.26E50CBF-1ECB-4A8E-1E6B-8236B88BD766]
    // </editor-fold> 

    public AGKeyGet(int key) {
        this.key = key;
    }

    @Override
    public boolean get(IObject obj) {
        List<IObject> inventory = Game.getInstance().getCharacter().getInventory().getObjects();
        for (IObject ob : inventory) {
            //supondo que objeto não desaparece só por que ele foi usado
            if (ob.getID() == key) {
               return inventory.add(obj);
            }
        }
        return false;
    }

}
