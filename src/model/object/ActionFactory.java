/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

import db.DirectoriesManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class ActionFactory {

    private static ActionFactory instance;
    private List<String> actions;

    private ActionFactory() {
        actions = new ArrayList<String>();
        actions.add("atack");
        actions.add("check");
        actions.add("combine");
        actions.add("drop");
        actions.add("get");
        actions.add("open");
        actions.add("throw");
    }
    /*
     * ordem do banco de dados de um action 
     *nome do objeto,atack,check,combine,drop,get,open , throw
     */

    public Action create(String action, String objectName) {
        Scanner arq = null;

        try {
            if (!actions.contains(action)) {
                return null;
            }
//            arq = new Scanner(new File("actions.txt"));
            arq = new Scanner(new File(DirectoriesManager.getActionFile()));
            while (arq.hasNextLine()) {
                String line = arq.nextLine();
                if (line != null
                        && !line.trim().equals("")) {
                    String[] cut = line.split("#");

                    String condition = "";
                    String itemDrop = "";
                    if (objectName.equals(cut[0])) {
                        condition = cut[actions.indexOf(action) * 2 + 1];
                        itemDrop = cut[actions.indexOf(action) * 2 + 2];

                        switch (action) {
                            case "atack":
                                return new Atack(itemDrop, condition);
                            case "check":
                                return new Check(itemDrop, condition);
                            case "combine":
                                return new Combine(itemDrop, condition);
                            case "drop":
                                return new Drop(itemDrop, condition);
                            case "get":
                                return new Get(itemDrop, condition);
                            case "open":
                                return new Open(itemDrop, condition);
                            case "throw":
                                return new Throw(itemDrop, condition);

                        }
                    }
                }
            }
            return null;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjectFactory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            arq.close();

        }
        return null;
    }

    public static synchronized ActionFactory getInstance() {
        if (instance == null) {
            instance = new ActionFactory();
        }
        return instance;
    }

}
