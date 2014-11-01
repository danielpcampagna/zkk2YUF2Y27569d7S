package model;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.82E5B47C-B29E-0935-83AA-63ED3D47A19D]
// </editor-fold> 
public class Player {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D7BE20E7-A758-30BB-92B9-AD5B6C25D22A]
    // </editor-fold> 
    private String login;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F29A5DA7-8B6D-24CD-4DED-27B0AC301075]
    // </editor-fold> 
    private String password;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D68C0E2A-EF5C-4DA6-F77C-EBA0ED872EEE]
    // </editor-fold> 
    private Game mGame;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F2BC1CD5-8048-BCBA-BB72-B035DCB2873E]
    // </editor-fold> 
    public Player () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F70C6CF6-1DBA-950C-1D44-2FA7CA41428D]
    // </editor-fold> 
    public String getLogin () {
        return login;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.29F3BA06-1226-B674-DD89-B74E707BC0A0]
    // </editor-fold> 
    public void setLogin (String val) {
        this.login = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E564B1CA-F4E3-DEE3-466C-0179DEF0A108]
    // </editor-fold> 
    public String getPassword () {
        return password;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E62DC100-1EE7-5F1D-5790-37D943E103D4]
    // </editor-fold> 
    public void setPassword (String val) {
        this.password = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.95AF032F-778B-1D33-FBFA-9D97D99CDE3D]
    // </editor-fold> 
    public void login () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0CEA9634-2337-1377-BA87-194AD6B3DDFB]
    // </editor-fold> 
    public void newGame () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.30CF3B8F-6066-7312-C914-FF93E0710511]
    // </editor-fold> 
    public void continueGame () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.CF55409D-D69E-8619-1903-2F340792DE4F]
    // </editor-fold> 
    public Game getGame () {
        return mGame;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3160E393-64AE-E715-5BAB-CE8750374FD1]
    // </editor-fold> 
    public void setGame (Game val) {
        this.mGame = val;
    }

}

