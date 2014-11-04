package model.object.action_atack;
// #[regen=yes,id=DCE.9A79C3BC-7F33-B569-CADC-0D76F1222B0C]
// </editor-fold> 

import model.object.IObject;

public class AABreak implements IActionAttack {
    private IObject itemDrop;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D70F4A57-D723-5157-3110-1F23BCA65797]
    // </editor-fold> 
    public AABreak (IObject itemDrop) {
        this.itemDrop = itemDrop;
    }

    @Override
    public boolean atack(IObject obj) {
        obj.setState("broken");
        System.out.println("você quebrou o " + obj.getDescription());
        obj.notifyObserver();
        if(itemDrop!=null){
            obj.notifyObserver(itemDrop);
            System.out.println(obj.getDescription() + " dropou " + itemDrop.getDescription());
        }
        return true;
    }

}

