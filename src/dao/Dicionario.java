/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model_noUml.Command;
import util.RegexRules;

/**
 *
 * @author Daniel
 */
public class Dicionario {

    private static final String PATH = "dicionario.txt";

    public static Command load(String name, String[] params) {
        BufferedReader input = null;
        Command result = null;
        boolean _break = false;

        try {
            input = new BufferedReader(new FileReader(PATH));
            String line = input.readLine();

            while (line != null && !_break) {
                
                line = input.readLine();

                String command;
                String[] paramters = RegexRules.split(line, name);
            }

            return result;
        } catch (IOException ex) {
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(Dicionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

}
