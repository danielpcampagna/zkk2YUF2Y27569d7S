/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author fabio
 */
public class ObjectFactory {
    private static ObjectFactory instance;

    private ObjectFactory() {
    }

    public static synchronized ObjectFactory getInstance() {
        if (instance == null) {
            instance = new ObjectFactory();
        }
        return instance;
    }

    public TAObject create(String name) {
        try {
            Scanner arq;
            arq = new Scanner(new File("objetos.bin"));
            TAObject obj =  new TAObject(arq.nextInt(),arq.nextInt(),arq.nextInt(),arq.nextInt(),arq.next(),arq.next(),arq.next());
            if(obj.getName().equals(name))
                return obj;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjectFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
