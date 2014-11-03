package model.object.action_drop;
// #[regen=yes,id=DCE.6A2AEEC1-98F2-0D0D-017F-8BC2F32D3545]
// </editor-fold> 

import model.object.IObject;

public class ADNotDrop implements IActionDrop {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.205F8BA4-919A-E054-27DF-3D8CA06EC6CA]
    // </editor-fold> 
    public ADNotDrop () {
    }

    @Override
    public boolean drop(IObject obj) {
        System.out.println("não pode jogar este objeto fora");
        return false;
    }

}

