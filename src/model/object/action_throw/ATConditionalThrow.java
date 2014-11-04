package model.object.action_throw;
// #[regen=yes,id=DCE.62D6DFF5-A68D-AC2E-E445-36AABF66EDC9]
// </editor-fold> 

import model.object.IObject;
import model.player.Game;

public class ATConditionalThrow implements IActionThrow {

    private int force;
    private int resistence;
    private int agility;
    private int inteligence;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8217471A-6C78-9032-03E5-53D9CDEB863A]
    // </editor-fold> 
    public ATConditionalThrow(int force, int resistence, int agility, int inteligence) {
        this.force = force;
        this.resistence = resistence;
        this.agility = agility;
        this.inteligence = inteligence;
    }

    @Override
    public boolean throwObject(IObject obj1, IObject obj2) {
        model.player.Character c = Game.getInstance().getCharacter();
        if (c.checkAtributes(force, resistence, agility, inteligence)) {
            obj1.atack();
            obj1.drop();
            obj2.atack();
            System.out.println("você lançou o " + obj1.getDescription() + " e acertou o " + obj2.getDescription());
            return true;
        }
        System.out.println("não é possivel tacar o " + obj1.getDescription());
        return false;
    }

}
