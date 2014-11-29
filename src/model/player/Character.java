package model.player;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.C688E0AE-7C3B-D8BA-8BAA-65F7B3001AE3]
// </editor-fold> 
public class Character  {
    /**
     * 20 pontos são distribuidos entre force,resistence,agility,intelligence;
     * force
     */
     
    private String name;
    
    private CharacterAtributes atb;
    
    private Inventory mInventory;
    
    private Memory memory;

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0CEACD44-6C4F-7001-B836-3721ECE58057]
    // </editor-fold> 
    public Character (String name, int force, int resistence, int agility, int inteligence) {
        atb = new CharacterAtributes(force,  resistence,  agility, inteligence);
        memory = new Memory(10);
        mInventory = new Inventory();
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getAgility () {
        return atb.getAgility();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.BC98F887-C650-E69C-DB6D-70BE9ADCCA0E]
    // </editor-fold> 
    public void setAgility (int val) {
        atb.setAgility( val);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.2299765F-EC9B-692A-7AE9-EE1BCFD598C8]
    // </editor-fold> 
    public int getForce () {
        return atb.getForce();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C433E5C3-823F-17D5-7759-291B167D3E84]
    // </editor-fold> 
    public void setForce (int val) {
        atb.setForce(val); 
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.EB15A25C-FC67-11E3-9E1C-B030ACAF53FD]
    // </editor-fold> 
    public int getIntelligence () {
        return atb.getInteligence();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.2FFC15F9-5A1C-71C8-9705-3C962EF199C0]
    // </editor-fold> 
    public void setInteligence (int val) {
        atb.setInteligence(val);
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
        return atb.getResistence();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.93C81367-6C3D-C0F6-F9FE-2755B6D583D1]
    // </editor-fold> 
    public void setResistence (int val) {
        atb.setResistence(val);
    }
   public boolean checkAtributes(CharacterAtributes at){
       return atb.checkAtributes(at);
   }
}