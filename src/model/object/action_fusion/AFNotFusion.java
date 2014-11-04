package model.object.action_fusion;
// #[regen=yes,id=DCE.1546663D-14BA-B787-6402-139A6EE1233E]
// </editor-fold> 

import model.object.IObject;

public class AFNotFusion implements IActionFusion {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.00CEF50C-55C5-2FA2-FDA6-5A51D64B567D]
    // </editor-fold> 
    public AFNotFusion () {
    }

    @Override
    public boolean combine(IObject obj1, IObject obj2) {
        System.out.println("não foi possivel combinar :"+ obj1.getDescription() + " e " + obj2.getDescription());
        return false;
    }

}

