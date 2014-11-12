package model.player;

import java.util.List;
import model.object.GameText;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.2F001250-4ADA-55A7-4BEC-54866F1E2AB9]
// </editor-fold> 
public class Memory {
    /**
    * armazena a analise dos N ultimos objetos checados.
    */
    private List<String> analysis;
    private int capacity;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0B5E34C8-9E9D-8E7B-DE72-2D13B812862A]
    // </editor-fold> 
    public Memory (int capacity) {
        this.capacity = capacity;
    }

    public List<String> getAnalysis() {
        return analysis;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setAnalysis(List<String> analysis) {
        this.analysis = analysis;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void add(String in){
        if(analysis.size()==capacity && !analysis.isEmpty()){
            analysis.remove(0);
        }
        analysis.add(in);
    }
    public GameText remenber(){
        GameText temp = new GameText();
        for (String analysi : analysis) {
            temp.concat(analysi);
        }
        return temp;
    }
}

