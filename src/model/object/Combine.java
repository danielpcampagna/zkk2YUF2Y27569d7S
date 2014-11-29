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
import model.player.Game;

/**
 *
 * @author fabio
 */
public class Combine extends Action {

    public Combine(String itemDrop, String condition) {
        super(itemDrop, condition);
    }

    @Override
    public void process() {
        Scanner arq = null;
        String drop = null;
        try {
            arq = new Scanner(new File("combinations.txt"));

            while (arq.hasNextLine()) {
                String line = arq.nextLine();
                String[] cut = line.split("#");
                if ((cut[0].equals(getObj().getName()) && cut[1].equals(getAffectedObject().getName()))
                        || (cut[1].equals(getObj().getName()) && cut[0].equals(getAffectedObject().getName()))) {
                    drop = cut[2];
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjectFactory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            arq.close();
        }
        if (drop != null) {
            getGameText().concat(" combinar o objeto " + getObj().getName() + " com o objeto " + getAffectedObject().getName() + " gerou o item ");
            getGameText().concat(drop);
            //adiciona na sala atual o objeto encontrado.
            Game.getInstance().getLocal().putRoom(ObjectFactory.getInstance().create(drop));
            Game.getInstance().getLocal().getObject(drop).add(Game.getInstance().getLocal());

            if (Game.getInstance().getCharacter().getInventory().containsKey(getObj().getName())) {
                Game.getInstance().getCharacter().getInventory().removeInventory(getObj());
            } else {
                Game.getInstance().getLocal().removeRoom(getObj());
            }
            if (Game.getInstance().getCharacter().getInventory().containsKey(getAffectedObject().getName())) {
                Game.getInstance().getCharacter().getInventory().removeInventory(getAffectedObject());
            } else {
                Game.getInstance().getLocal().removeRoom(getAffectedObject());
            }

        }
    }

}
