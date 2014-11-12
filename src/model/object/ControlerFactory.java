/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

/**
 *
 * @author fabio
 */
public class ControlerFactory {
    private static ControlerFactory instance;
    private ControlerFactory(){}
    public static synchronized ControlerFactory getInstance(){
        if(instance==null)
            instance = new ControlerFactory();
        return instance;
    } 
   public Controler create(){
       return null;
   }
}
