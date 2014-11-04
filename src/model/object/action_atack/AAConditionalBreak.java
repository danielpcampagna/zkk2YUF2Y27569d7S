package model.object.action_atack;
// #[regen=yes,id=DCE.0A35A631-44C0-216E-E5C5-5D703998D3A1]
// </editor-fold> 

import model.object.IObject;
import model.player.Game;

public class AAConditionalBreak implements IActionAttack {

    private IObject itemDrop;
    private int force;
    private int resistence;
    private int agility;
    private int inteligence;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8E119833-0780-5125-334A-01EE13B43E3D]
    // </editor-fold> 
    public AAConditionalBreak(IObject itemDrop, int force, int resistence, int agility, int inteligence) {
        this.force = force;
        this.resistence = resistence;
        this.agility = agility;
        this.inteligence = inteligence;
        this.itemDrop = itemDrop;
    }

    @Override
    public boolean atack(IObject obj) {
        model.player.Character c = Game.getInstance().getCharacter();
        if (c.checkAtributes(force, resistence, agility, inteligence)) {
            obj.setState("broken");
            System.out.println("você quebrou o " + obj.getDescription());
            obj.notifyObserver();
            if (itemDrop != null) {
                obj.notifyObserver(itemDrop);
                System.out.println(obj.getDescription() + " dropou " + itemDrop.getDescription());
            }
            return true;
        }
        System.out.println("não é posssivel quebrar " + obj.getDescription() );
        return false;
    }

}
