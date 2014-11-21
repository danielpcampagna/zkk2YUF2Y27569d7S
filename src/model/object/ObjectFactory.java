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
        Scanner arq = null;
        try {

            arq = new Scanner(new File("objects.txt"));
            while (arq.hasNextLine()) {
                String infos = arq.nextLine();
                String[] cut = infos.split(":");
                int visibility = Integer.parseInt(cut[0]);
                int iluminity = Integer.parseInt(cut[1]);
                int weight = Integer.parseInt(cut[2]);
                int size = Integer.parseInt(cut[3]);
                String nameO = cut[4];
                String description = cut[5];
                String analysis = cut[6];
                TAObject obj = new TAObject(visibility, iluminity, weight, size, nameO, description, analysis);

                if (obj.getName()
                        .equals(name)) {
                    return obj;
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
