/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

import db.DirectoriesManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.player.Game;

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
        Scanner arq = null;
        try {

//            arq = new Scanner(new File("objects.txt"));
            arq = new Scanner(new File(DirectoriesManager.getObjectFile()));
            while (arq.hasNextLine()) {
                String infos = arq.nextLine();
                if (infos != null
                        && !infos.trim().equals("")) {
                    String[] cut = infos.split("#");
                    String[] attributes = cut[0].split(":");
                    int visibility = Integer.parseInt(attributes[0]);
                    int iluminity = Integer.parseInt(attributes[1]);
                    int weight = Integer.parseInt(attributes[2]);
                    int size = Integer.parseInt(attributes[3]);
                    String nameO = cut[1];
                    String description = cut[2];
                    String analysis = cut[3];

                    TAObject obj = new TAObject(visibility, iluminity, weight, size, nameO, description, analysis);

                    if (obj.getName().equals(name)) {
                        return obj;
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjectFactory.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            arq.close();
        }
        return null;
    }
}
