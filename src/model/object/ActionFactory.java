/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

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
        try {
            if (!actions.contains(action)) {
                return null;
            }
            Scanner arq;
            arq = new Scanner(new File("actions.txt"));
            while (arq.hasNext()) {
                String name = arq.next();
                String condition = "";
                String itemDrop = "";
                if (!objectName.equals(name)) {
                    arq.nextLine();
                } else {
                    for (int i = 0; i <= actions.indexOf(action); i++) {
                        condition = arq.next();
                        itemDrop = arq.next();
                    }
                }
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
            return null;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjectFactory.class.getName()).log(Level.SEVERE, null, ex);
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
