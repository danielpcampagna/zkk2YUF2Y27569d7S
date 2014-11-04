package model.object.action_fusion;
// #[regen=yes,id=DCE.8421AEA5-8A07-D042-D27D-961942E03E5E]
// </editor-fold> 

import model.object.IObject;
import model.player.Game;

public class AFFusion implements IActionFusion {
    private IObject out;
    private int key;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.37D85101-7D26-CF6A-2A09-1077D8792C94]
    // </editor-fold> 
    public AFFusion (IObject out,int key ) {
        this.out = out;
        this.key = key;
    }

    @Override
    public boolean combine(IObject obj1, IObject obj2) {
        if(obj2.getID()==key){
           Game.getInstance().getCharacter().getInventory().remove(obj1);
           Game.getInstance().getCharacter().getInventory().remove(obj2);
           obj1.notifyObserver(out);//item ficara no local
           System.out.println("a cominação de:"+obj1.getDescription() + " e " + obj2.getDescription() + "\n gerou " + out.getDescription());
           return true;
        }
        return false;
    }

}

