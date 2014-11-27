package model.player;

import model.room.Room;




// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.5C5C8579-74C7-7E75-C6F4-F77CB4B93C5D]
// </editor-fold> 
public class Game {

    private static Game instance;
    private Game(){}
    public static synchronized Game getInstance(){
        if(instance==null)
            instance = new Game();
        return instance;
    }
    private String name;
    private Room local;
    private Character mCharacter;

   
    public void exit () {
    }

    public void save () {
    }

    public Character getCharacter () {
        return mCharacter;
    }

    public void setCharacter (Character val) {
        this.mCharacter = val;
    }

    public Room getLocal() {
        return local;
    }

    public void setLocal(Room local) {
        this.local = local;
    }

    public Character getmCharacter() {
        return mCharacter;
    }

    public void setmCharacter(Character mCharacter) {
        this.mCharacter = mCharacter;
    }
    
    public String getName() {
        return name;
    }
    
}