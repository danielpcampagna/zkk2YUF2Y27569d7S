package model.player;

import model.local.ILocal;


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
    private ILocal local;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4DEB66D4-9996-43B8-7E5B-215A4286261C]
    // </editor-fold> 
    private Character mCharacter;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9A9423B8-0B76-8AEA-733C-0EC00BD1DBD5]
    // </editor-fold> 
    public void exit () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.316400F2-F46B-2722-86B8-010BD35602BB]
    // </editor-fold> 
    public void save () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.34CB7F92-2467-FD0E-29A1-15618EBB57B3]
    // </editor-fold> 
    public Character getCharacter () {
        return mCharacter;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D0FF3A71-438E-0782-A8BA-6A220DC03E34]
    // </editor-fold> 
    public void setCharacter (Character val) {
        this.mCharacter = val;
    }

}

