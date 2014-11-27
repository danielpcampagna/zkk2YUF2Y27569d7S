/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

/**
 *
 * @author fabio
 */
public abstract class Action {

    private TAObject obj;
    private GameText gameText;
    private Controler controler;
    private String itemDrop;
    // template method simples

    public Action(String itemDrop, String condition) {
        this.itemDrop = itemDrop;
        gameText = new GameText();
        controler = ControlerFactory.getInstance().create(condition);
    }

    public String getItemDrop() {
        return itemDrop;
    }

    public void setItemDrop(String itemDrop) {
        this.itemDrop = itemDrop;
    }

    public void run() {
        if (controler.Unlock(gameText)) {
            process();
        }
    }

    public abstract void process();
    // <editor-fold defaultstate="collapsed" desc=" Gets e Sets "> 

    public Controler getControler() {
        return controler;
    }

    public void setControler(Controler controler) {
        this.controler = controler;
    }

    public TAObject getObj() {
        return obj;
    }

    public GameText getGameText() {
        return gameText;
    }

    public void setObj(TAObject obj) {
        this.obj = obj;
    }

    public void setGameText(GameText Text) {
        this.gameText = Text;
    }
 // </editor-fold>
}
