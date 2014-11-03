package model.object.action_get;

import model.object.IObject;
import model.player.Game;
import model.player.Character;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B715D615-3C1E-7AEA-0652-7132221A5699]
// </editor-fold> 
public class AGConditionalGet implements IActionGet {

    private int force;
    private int resistence;
    private int agility;
    private int inteligence;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2650C240-9D18-9E9A-9614-A89A7525E99D]
    // </editor-fold> 
    public AGConditionalGet(int force, int resistence, int agility, int inteligence) {
        this.force = force;
        this.resistence = resistence;
        this.agility = agility;
        this.inteligence = inteligence;
    }

    @Override
    public boolean get(IObject obj) {
        Character c = Game.getInstance().getCharacter();
        if (c.checkAtributes(force, resistence, agility, inteligence)) {
            return Game.getInstance().getCharacter().getInventory().add(obj);
        }
        return false;
    }

}
