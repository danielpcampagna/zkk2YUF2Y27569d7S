package model.object.action_get;
// #[regen=yes,id=DCE.0D465CB0-A0C6-F657-EBB1-ECCB1718AA3D]
// </editor-fold> 

import model.object.IObject;

public class AGNotGet implements IActionGet {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4892EFFF-9602-735D-9AF4-C66F425D11ED]
    // </editor-fold> 
    public AGNotGet () {
    }

    @Override
    public boolean get(IObject obj) {
        System.out.println("não é possivel pegar esse item" + obj.getDescription());
        return false;
    }

}

