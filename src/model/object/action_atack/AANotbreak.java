package model.object.action_atack;
// #[regen=yes,id=DCE.A9E24E22-279A-734A-50A9-84E20B8BE63F]
// </editor-fold> 

import model.object.IObject;

public class AANotbreak implements IActionAttack {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8708AE82-41D3-562B-680E-830B779EA8B0]
    // </editor-fold> 
    public AANotbreak () {
    }

    @Override
    public boolean atack(IObject obj) {
        System.out.println("não é posssivel quebrar " + obj.getDescription());
        return false;
    }

}

