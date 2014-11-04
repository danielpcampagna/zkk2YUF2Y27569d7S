package model.object.action_atack;
// #[regen=yes,id=DCE.93AEE736-7D42-21B9-1200-53FF7E75B4A0]
// </editor-fold> 

import model.object.IObject;
import model.player.Game;

public class AADamaged implements IActionAttack {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.41BA532A-110B-A8F7-188E-896E43FF55C5]
    // </editor-fold> 
    public AADamaged () {
    }

    @Override
    public boolean atack(IObject obj) {
        System.out.println(obj.getDescription() + "sofreu "+ Game.getInstance().getCharacter().getForce() + "danos");
        obj.setDamaged(obj.getDamaged()+Game.getInstance().getCharacter().getForce());
        return true;
    }

}

