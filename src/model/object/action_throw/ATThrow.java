package model.object.action_throw;
// #[regen=yes,id=DCE.37FD6AB2-8215-1586-57B4-B9CE40901F02]
// </editor-fold> 

import model.object.IObject;

public class ATThrow implements IActionThrow {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FE37FAFF-CCFB-A114-C47F-FD3434DE06CE]
    // </editor-fold> 
    public ATThrow () {
    }

    @Override
    public boolean throwObject(IObject obj1, IObject obj2) {
        obj1.atack();
        obj1.drop();
        obj2.atack();
        System.out.println("você lançou o "+obj1.getDescription() +" e acertou o "+ obj2.getDescription());
        return true;
    }

}

