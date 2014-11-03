package model.observer;

import java.util.ArrayList;
import java.util.List;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.F0256C05-B1E8-2CDD-81BF-B2E328F2B030]
// </editor-fold> 
public class IObservable {
    private int type;
   

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.01B230C5-DA36-F721-4870-807DBD3464C6]
    // </editor-fold> 
    public IObservable () {
    }
     //Lista de Observadores
    // OS OBSERVADORES SAO AS JANELAS
    private List<IObserver> list = new ArrayList<>();
   //Adiciona um observador para o observar esta classe
    public void add(IObserver o) {
        list.add(o);
    }
    //Remove um observador da lista
    public void remove(IObserver o) {
        list.remove(o);
    }
   //Notifica todos os observadores
       public void notificar() {
        for (IObserver o : list) {
            o.update(this);
        }
    }
}

