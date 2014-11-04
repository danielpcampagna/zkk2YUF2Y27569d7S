package model.object.action_atack;
// #[regen=yes,id=DCE.3DC3521F-020F-0BF4-8F4B-51A48DAA39AB]
// </editor-fold> 

import model.object.IObject;

public class AAKill implements IActionAttack {
    private IObject itemDrop;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E4A8E0D6-15B6-E8AD-F874-822690F24471]
    // </editor-fold> 
    public AAKill (IObject itemDrop) {
        this.itemDrop = itemDrop;
    }

    @Override
    public boolean atack(IObject obj) {
       obj.setState("kill");
        System.out.println("você matou o " + obj.getDescription());
        obj.notifyObserver();
        if(itemDrop!=null){
            obj.notifyObserver(itemDrop);
            System.out.println(obj.getDescription() + " dropou " + itemDrop.getDescription());
        }
        return true;
    }

}

