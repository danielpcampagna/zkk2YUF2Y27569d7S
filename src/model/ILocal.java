package model;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.6EA7E08B-A167-64D5-1782-E0C5A60CBE89]
// </editor-fold> 
public class ILocal extends IObservable implements IObserver {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D51AF2A4-3425-0953-EC9A-E75F1C09CC4E]
    // </editor-fold> 
    private IActionGoTo mIActionGoTo;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DDF72DEC-2BDA-2A6F-D3B3-669612311E23]
    // </editor-fold> 
    private IActionClimbing mAActionClimbing;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B054192B-A114-D91E-F252-21A02E8403AD]
    // </editor-fold> 
    private IActionJump mIActionJump;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F003DCDE-A7CD-7667-D4F3-EE7190B66624]
    // </editor-fold> 
    private IActionSee mAActionSee;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D2084DA1-9DB1-3D2C-B5C1-37992D988694]
    // </editor-fold> 
    private IActionDown mIActionDown;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AEF32435-18FA-8EEF-5B29-990B9C9951C1]
    // </editor-fold> 
    public ILocal () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.914BB17D-D21F-8B1E-020E-C0F8CBFF82D0]
    // </editor-fold> 
    public IActionClimbing getAActionClimbing () {
        return mAActionClimbing;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E12C5999-9C5E-320C-2D59-14135C5C4E78]
    // </editor-fold> 
    public void setAActionClimbing (IActionClimbing val) {
        this.mAActionClimbing = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F72641DB-DDDC-725C-54E4-57E8247CB44D]
    // </editor-fold> 
    public IActionSee getAActionSee () {
        return mAActionSee;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A364621C-1949-3170-3539-CE7CE17B0D64]
    // </editor-fold> 
    public void setAActionSee (IActionSee val) {
        this.mAActionSee = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C0242CCE-EF04-EC48-1136-614363158203]
    // </editor-fold> 
    public IActionDown getIActionDown () {
        return mIActionDown;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C91E2603-DC5E-A096-656A-282F216E8B6F]
    // </editor-fold> 
    public void setIActionDown (IActionDown val) {
        this.mIActionDown = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.AA6E9A6F-6A6E-C396-91CA-80D676CBF741]
    // </editor-fold> 
    public IActionGoTo getIActionGoTo () {
        return mIActionGoTo;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6944C041-CB7E-F343-4813-8F0C4112490B]
    // </editor-fold> 
    public void setIActionGoTo (IActionGoTo val) {
        this.mIActionGoTo = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.402C847F-9BB3-47B0-535E-FDA86F3B5990]
    // </editor-fold> 
    public IActionJump getIActionJump () {
        return mIActionJump;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B313391F-F4F1-1183-D960-E4EDDB01CD0F]
    // </editor-fold> 
    public void setIActionJump (IActionJump val) {
        this.mIActionJump = val;
    }

}

