package model.object.action_check;
// #[regen=yes,id=DCE.C4494C5E-ED52-A3A6-12BA-F8013449E87D]
// </editor-fold> 

import java.util.List;
import model.object.IObject;
import model.player.Game;

public class ACKeyCheck implements IActionCheck {

    private int key;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CBFDDFEF-2EE5-830F-BB56-C31C1FE5852B]
    // </editor-fold> 

    public ACKeyCheck(int key) {
        this.key = key;
    }

    @Override
    public boolean analyze(IObject obj) {
        List<IObject> inventory = Game.getInstance().getCharacter().getInventory().getObjects();
        for (IObject ob : inventory) {
            //supondo que objeto não desaparece só por que ele foi usado
            if (ob.getID() == key) {
                Game.getInstance().getCharacter().getMemory().getAnalysis().add(obj.getAnalysis());
                System.out.println(obj.getAnalysis());
                return true;
            }
        }
        System.out.println("não foi possivel analisar " + obj.getDescription());
        return false;
    }

}
