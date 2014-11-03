package model.object.action_check;
// #[regen=yes,id=DCE.E7B412DF-47DA-9842-FFA0-453EC9BF5446]
// </editor-fold> 

import model.object.IObject;

public class ACCNotCheck implements IActionCheck {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.64034680-8DD9-2FA4-7F90-9E27D67B2925]
    // </editor-fold> 
    public ACCNotCheck () {
    }

    @Override
    public boolean analyze(IObject obj) {
       System.out.println("não foi possivel analisar " + obj.getDescription());
       return false;
    }

}

