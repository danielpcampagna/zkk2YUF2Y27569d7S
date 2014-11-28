/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.room;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author fabio
 */
public class DoorFactory {
     private static DoorFactory instance;

    
    public static synchronized DoorFactory getInstance() {
        if (instance == null) {
            instance = new DoorFactory();
        }
        return instance;
    }

    private DoorFactory() {
    }
    public Door create(String name){
         Scanner arq=null;
        Door door =null;
        try {
            
            arq = new Scanner(new File("doors.txt"));
           while(arq.hasNext()){
               String line = arq.nextLine();
               String[] components = line.split("#");
               if(components[0].equals(name)){
                   String[] roonsName = components[0].split(":");
                   door = new Door(roonsName[0],roonsName[1],components[1]);
                   return door;
               }
           }
           return null;
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }finally{
            arq.close();
        }
        return null;
    }
}
