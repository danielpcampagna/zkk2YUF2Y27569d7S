package model.object;

import model.local.ILocal;
import model.observer.IObservable;
import model.observer.IObserver;
import model.player.Character;
import model.object.action_throw.IActionThrow;
import model.object.action_open.IActionOpen;
import model.object.action_get.IActionGet;
import model.object.action_drop.IActionDrop;
import model.object.action_check.IActionCheck;
import model.object.action_atack.IActionAttack;
import model.object.action_fusion.IActionFusion;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.EC3BFABA-A36E-F5CF-4486-FDF2640ADCAE]
// </editor-fold> 
public class IObject extends IObservable implements IObserver {
    /**
     * ID : identificardor unico do objeto; 
     * visibility: coeficiênte de visibilidade, 0 a 100 ,caso o coeficiênto do local for maior que do objeto o mesmo se torna visivel.
     * damaged: coeficiênte de danos , 0 a 10,ao receber um ataque,caso a força do personagem + damaged > 10 o objeto quebra.
     * weight: coeficiênte de peso,0 a 10,a força do personagem deve ser maior que o peso do objeto para pega-lo ou taca-lo.
     * size : coeficiênte de tamanho , 0 a 100, utilizado para verificar se o personagem podera colocar o item no inventario.
     * amount: quantidade de itens.
     * description : descrição comum do objeto ao ser visto pelo jogador.
     * analysis : descrição do objeto ao ser checado pelo jogador;
     */
    
    private int ID;
    private int visibility;
    private int weight;
    private int size;
    private int amount;
    private String description;
    private String analysis;
    private String state;
     public final static int TYPE = 1;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6AE0747D-9F06-1EF8-AF40-75214061060F]
    // </editor-fold> 
    private IActionOpen mTAActionOpen;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5221988C-E417-7354-B636-9FC160DD4A93]
    // </editor-fold> 
    private IActionThrow mTAActionThrow;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.708400A6-8C22-7DDC-C41E-B47590AD7767]
    // </editor-fold> 
    private IActionDrop mTAActionDrop;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0F0F86ED-3A36-0EB1-7F8D-6DF72544C530]
    // </editor-fold> 
    private IActionGet mTAActionGet;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4F8DB87D-DB9B-9EC6-A562-E835AC94B772]
    // </editor-fold> 
    private IActionAttack mTAActionAttack;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3515F2CD-DF1C-1765-94C5-854744826FCF]
    // </editor-fold> 
    private IActionFusion mTAActionFusion;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.29FE93FC-78A4-0496-F1A4-74AC9FE9C726]
    // </editor-fold> 
    private IActionCheck mTAActionCheck;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2DCA2ED0-ABAC-4AAA-BB70-2449E027BC00]
    // </editor-fold> 
    public IObject () {
        setType(0);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E8CD1833-82BB-ECE0-8213-D1D7EFDD7124]
    // </editor-fold> 
    public IActionAttack getTAActionAttack () {
        return mTAActionAttack;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0A8BE6E5-E98A-3AFC-1577-2708C59FFBEE]
    // </editor-fold> 
    public void setTAActionAttack (IActionAttack val) {
        this.mTAActionAttack = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1C65974F-9897-9913-7981-DD3E941F52AF]
    // </editor-fold> 
    public IActionCheck getTAActionCheck () {
        return mTAActionCheck;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B2139019-D90A-E8C7-4864-77AA7CAF8DAE]
    // </editor-fold> 
    public void setTAActionCheck (IActionCheck val) {
        this.mTAActionCheck = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D2768925-96B1-ED1D-A1CD-56BBFA479323]
    // </editor-fold> 
    public IActionDrop getTAActionDrop () {
        return mTAActionDrop;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.813B3AFE-FA03-911A-C969-8FDE04ABB3A9]
    // </editor-fold> 
    public void setTAActionDrop (IActionDrop val) {
        this.mTAActionDrop = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DE71940D-F5C5-72B6-92E6-D09BAF37700D]
    // </editor-fold> 
    public IActionFusion getTAActionFusion () {
        return mTAActionFusion;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.138CB9A2-7220-8D01-05CE-90DA46A006B3]
    // </editor-fold> 
    public void setTAActionFusion (IActionFusion val) {
        this.mTAActionFusion = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9F21F40C-C424-6243-F0D3-6AC813785344]
    // </editor-fold> 
    public IActionGet getTAActionGet () {
        return mTAActionGet;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B2100BD1-1447-BE12-B2EA-82D113B37507]
    // </editor-fold> 
    public void setTAActionGet (IActionGet val) {
        this.mTAActionGet = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.481B2E7B-4123-DB91-CE02-C64C6037443A]
    // </editor-fold> 
    public IActionOpen getTAActionOpen () {
        return mTAActionOpen;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.42A5C48B-00D5-B9BB-1155-4250FCE3A847]
    // </editor-fold> 
    public void setTAActionOpen (IActionOpen val) {
        this.mTAActionOpen = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.FD6A1054-59B4-93D2-82EF-DE396EC4A05A]
    // </editor-fold> 
    public IActionThrow getTAActionThrow () {
        return mTAActionThrow;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3AE12DB4-A18D-886E-5600-8F1423FC9BC0]
    // </editor-fold> 
    public void setTAActionThrow (IActionThrow val) {
        this.mTAActionThrow = val;
    }

    public int getID() {
        return ID;
    }

    public int getVisibility() {
        return visibility;
    }

    public int getWeight() {
        return weight;
    }

    public int getSize() {
        return size;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getAnalysis() {
        return analysis;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public IActionOpen getmTAActionOpen() {
        return mTAActionOpen;
    }

    public IActionThrow getmTAActionThrow() {
        return mTAActionThrow;
    }

    public IActionDrop getmTAActionDrop() {
        return mTAActionDrop;
    }

    public IActionGet getmTAActionGet() {
        return mTAActionGet;
    }

    public IActionAttack getmTAActionAttack() {
        return mTAActionAttack;
    }

    public IActionFusion getmTAActionFusion() {
        return mTAActionFusion;
    }

    public IActionCheck getmTAActionCheck() {
        return mTAActionCheck;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public void setmTAActionOpen(IActionOpen mTAActionOpen) {
        this.mTAActionOpen = mTAActionOpen;
    }

    public void setmTAActionThrow(IActionThrow mTAActionThrow) {
        this.mTAActionThrow = mTAActionThrow;
    }

    public void setmTAActionDrop(IActionDrop mTAActionDrop) {
        this.mTAActionDrop = mTAActionDrop;
    }

    public void setmTAActionGet(IActionGet mTAActionGet) {
        this.mTAActionGet = mTAActionGet;
    }

    public void setmTAActionAttack(IActionAttack mTAActionAttack) {
        this.mTAActionAttack = mTAActionAttack;
    }

    public void setmTAActionFusion(IActionFusion mTAActionFusion) {
        this.mTAActionFusion = mTAActionFusion;
    }

    public void setmTAActionCheck(IActionCheck mTAActionCheck) {
        this.mTAActionCheck = mTAActionCheck;
    }

    @Override
    public void update(IObservable ob) {
        switch (ob.getType()) {
            case ILocal.TYPE:
                ILocal local = (ILocal) ob;
                break;
            case IObject.TYPE:
                IObject obj = (IObject) ob;
                break;
            case Character.TYPE:
              Character character = (model.player.Character) ob;
                break;
        }
    }
    
}

