package model.object.action_check;
// #[regen=yes,id=DCE.B3EF840E-C31E-2C5D-2F42-8A7DF0CBAF75]
// </editor-fold> 

import model.object.IObject;
import model.player.Game;

public class ACConditionalCheck implements IActionCheck {

    private int force;
    private int resistence;
    private int agility;
    private int inteligence;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0C90BC7A-E324-2380-6564-AE59FAE7C831]
    // </editor-fold> 
    public ACConditionalCheck(int force, int resistence, int agility, int inteligence) {
        this.force = force;
        this.resistence = resistence;
        this.agility = agility;
        this.inteligence = inteligence;
    }

    @Override
    public boolean analyze(IObject obj) {
        model.player.Character c = Game.getInstance().getCharacter();
        if (c.checkAtributes(force, resistence, agility, inteligence)) {
            Game.getInstance().getCharacter().getMemory().getAnalysis().add(obj.getAnalysis());
            System.out.println(obj.getAnalysis());
            return true;
        }
        System.out.println("não foi possivel analisar " + obj.getDescription());
        return false;
    }

}
