package model.player;

import model.observer.IObservable;
import model.observer.IObserver;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.C688E0AE-7C3B-D8BA-8BAA-65F7B3001AE3]
// </editor-fold> 
public class Character extends IObservable implements IObserver {
    /**
     * 20 pontos são distribuidos entre force,resistence,agility,intelligence;
     * force
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5EAD8D81-51C7-11D2-D930-71A019F81A64]
    // </editor-fold> 
    
    private int force;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0D4B5244-004E-CF0A-7325-FA546F8B8047]
    // </editor-fold> 
    private int resistence;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5E105FF9-D93A-397A-9EF4-657E8D9B460C]
    // </editor-fold> 
    private int agility;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C427224B-626B-FD2C-79FD-167D2D0968EA]
    // </editor-fold> 
    private int inteligence;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7DF80A01-46C6-6926-54C7-15D429C5D0FF]
    // </editor-fold> 
    private Inventory mInventory;
    
    private Memory memory;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0CEACD44-6C4F-7001-B836-3721ECE58057]
    // </editor-fold> 
    public Character (int force, int resistence, int agility, int inteligence) {
        this.force = force;
        this.resistence = resistence;
        this.agility = agility;
        this.inteligence = inteligence;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F6A409BE-F7F4-252A-1E56-32595B43362D]
    // </editor-fold> 
    public int getAgility () {
        return agility;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.BC98F887-C650-E69C-DB6D-70BE9ADCCA0E]
    // </editor-fold> 
    public void setAgility (int val) {
        this.agility = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.2299765F-EC9B-692A-7AE9-EE1BCFD598C8]
    // </editor-fold> 
    public int getForce () {
        return force;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C433E5C3-823F-17D5-7759-291B167D3E84]
    // </editor-fold> 
    public void setForce (int val) {
        this.force = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.EB15A25C-FC67-11E3-9E1C-B030ACAF53FD]
    // </editor-fold> 
    public int getIntelligence () {
        return inteligence;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.2FFC15F9-5A1C-71C8-9705-3C962EF199C0]
    // </editor-fold> 
    public void setIntelligence (int val) {
        this.inteligence = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6C8D1C4F-D26B-61E7-C0BE-5FF1CE34097D]
    // </editor-fold> 
    public Inventory getInventory () {
        return mInventory;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E9D63856-6000-446D-395B-2C1174CC91C9]
    // </editor-fold> 
    public void setInventory (Inventory val) {
        this.mInventory = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.000A540A-8801-43FC-A38D-2338D16A83E2]
    // </editor-fold> 
    public int getResistence () {
        return resistence;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.93C81367-6C3D-C0F6-F9FE-2755B6D583D1]
    // </editor-fold> 
    public void setResistence (int val) {
        this.resistence = val;
    }
   public boolean checkAtributes(int force, int resistence, int agility, int inteligence){
       return getForce()>=force && getResistence()>= resistence && getAgility()>= agility && getIntelligence() >= inteligence;
   }
}

