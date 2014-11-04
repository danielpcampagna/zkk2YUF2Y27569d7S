package model.object.action_fusion;
// #[regen=yes,id=DCE.427836A7-2449-987A-5E74-08E0AC4EB0C8]
// </editor-fold> 

import model.object.IObject;
import model.player.Game;

public class AFConditionalFusion implements IActionFusion {

    private int force;
    private int resistence;
    private int agility;
    private int inteligence;
    private IObject out;
    private int key;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.811C671C-A3F5-ACF9-48F5-EFCA9AF81F1F]
    // </editor-fold> 

    public AFConditionalFusion(int force, int resistence, int agility, int inteligence,int key,IObject out) {
        this.force = force;
        this.resistence = resistence;
        this.agility = agility;
        this.inteligence = inteligence;
        this.out = out;
        this.key = key;
    }

    @Override
    public boolean combine(IObject obj1, IObject obj2) {
        model.player.Character c = Game.getInstance().getCharacter();
        if (c.checkAtributes(force, resistence, agility, inteligence)) {
            if (obj2.getID() == key) {
                Game.getInstance().getCharacter().getInventory().remove(obj1);
                Game.getInstance().getCharacter().getInventory().remove(obj2);
                obj1.notifyObserver(out);//item ficara no local
                System.out.println("a cominação de:" + obj1.getDescription() + " e " + obj2.getDescription() + "\n gerou " + out.getDescription());
                return true;
            }
            System.out.println("não foi possivel combinar :"+ obj1.getDescription() + " e " + obj2.getDescription());
        }     
        return false;
    }

}
