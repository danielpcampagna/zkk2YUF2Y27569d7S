package model.object.action_fusion;
// #[regen=yes,id=DCE.DACDBDF1-F884-085A-F896-EB2545626194]
// </editor-fold> 

import model.object.IObject;
import model.player.Game;

public class AFQtdFusion implements IActionFusion {

    private IObject out;
    private int key;
    private int qtd1;
    private int qtd2;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1B4191BE-13B0-B743-0337-68BB5FF70871]
    // </editor-fold> 

    public AFQtdFusion(IObject out, int key, int qtd1, int qtd2) {
        this.out = out;
        this.key = key;
        this.qtd1 = qtd1;
        this.qtd2 = qtd2;
    }

    @Override
    public boolean combine(IObject obj1, IObject obj2) {
        if (obj2.getID() == key && obj1.getAmount() >= qtd1 && obj2.getAmount() >= qtd2) {
            obj1.setAmount(obj1.getAmount() - qtd1);
            obj2.setAmount(obj2.getAmount() - qtd2);
            if (obj1.getAmount() == 0) {
                Game.getInstance().getCharacter().getInventory().remove(obj1);
            }
            if (obj2.getAmount() == 0) {
                Game.getInstance().getCharacter().getInventory().remove(obj2);
            }
            obj1.notifyObserver(out);//item ficara no local
            System.out.println("a cominação de:" + obj1.getDescription() + " e " + obj2.getDescription() + "\n gerou " + out.getDescription());
            return true;
        }
        System.out.println("não foi possivel combinar :" + obj1.getDescription() + " e " + obj2.getDescription());
        return false;
    }

}
