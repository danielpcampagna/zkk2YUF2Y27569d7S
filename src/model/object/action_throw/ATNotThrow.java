package model.object.action_throw;
// #[regen=yes,id=DCE.C31EDC8F-6101-71D8-B483-48B3A568E6FC]
// </editor-fold> 

import model.object.IObject;

public class ATNotThrow implements IActionThrow {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A41C62E5-6DAC-326C-B3B5-907B80BC4E7C]
    // </editor-fold> 
    public ATNotThrow () {
    }

    @Override
    public boolean throwObject(IObject obj1, IObject obj2) {
        System.out.println("não é possivel tacar o " + obj1.getDescription());
        return false;
    }

}

