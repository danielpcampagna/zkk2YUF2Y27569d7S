package model.object;


import model.observer.IObservable;
import model.observer.IObserver;
import model.player.Character;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.EC3BFABA-A36E-F5CF-4486-FDF2640ADCAE]
// </editor-fold> 
public class TAObject extends IObservable  {
    /**
     * ID : identificardor unico do objeto; 
     * visibility: coeficiênte de visibilidade, 0 a 100 ,caso o coeficiênto do local for maior que do objeto o mesmo se torna visivel.
     * damaged: coeficiênte de danos , 0 a 10,ao receber um ataque,caso a força do personagem + damaged > 10 o objeto quebra.
     * weight: coeficiênte de peso,0 a 10,a força do personagem deve ser maior que o peso do objeto para pega-lo ou taca-lo.
     * size : coeficiênte de tamanho , 0 a 100, utilizado para verificar se o personagem podera colocar o item no inventario.
     * description : descrição comum do objeto ao ser visto pelo jogador.
     * analysis : descrição do objeto ao ser checado pelo jogador;
     */
    // <editor-fold defaultstate="collapsed" desc=" Atributos "> 
    private int visibility;
    private int iluminity;
    private int weight;
    private int size;
    private String name;
    private String description;
    private String analysis;
    private Action action;
     // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc=" Construtores "> 
    public TAObject () {
       
    }

    public TAObject(int visibility, int iluminity, int weight, int size, String name, String description, String analysis){
        this.iluminity = iluminity;
        this.weight = weight;
        this.size = size;
        this.name = name;
        this.description = description;
        this.analysis = analysis;
       
    }
    
   // </editor-fold> 

    public String getDescription() {
        return description;
    }

    // <editor-fold defaultstate="collapsed" desc=" Gets e Sets">
    public void setDescription(String description) {
        this.description = description;
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

    public String getName() {
        return name;
    }

    public String getAnalysis() {
        return analysis;
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

    public void setName(String description) {
        this.name = description;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }
    
   

    public int getIluminity() {
        return iluminity;
    }

    public void setIluminity(int iluminity) {
        this.iluminity = iluminity;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
    
      // </editor-fold> 
    public void run(String select){
        action = ActionFactory.getInstance().create(select, name);
        action.setObj(this);
        action.run();
    }
}

