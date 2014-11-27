/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.GameController;
import db.DirectoriesManager;
import exception.IOEmptyTableException;
import exception.IODataExistingException;
import exception.IONotFoundDataException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.player.Game;
import model.player.Player;
import sun.security.x509.AlgorithmId;
import util.RegexRules;

/**
 *
 * @author Daniel
 */
public class PlayerTXTDao extends IDao<Player> {

    @Override
    public Player last() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Player first() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Player find(String id) throws IOEmptyTableException {
        Player result = null;
        try {
            reader = new BufferedReader(new FileReader(DirectoriesManager.getPlayerFile()));
            String line = reader.readLine();
            while (line != null) {
                String[] comp = RegexRules.split(line, RegexRules.GETPLAYER);
                if (comp.length == 3
                        && comp[0].equals(id)) {
                    result = new Player();
                    result.setLogin(comp[0]);
                    result.setPassword(comp[1]);
                    result.setGame(new GameController(Game.getInstance()).load());
                    break;
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            throw new IOEmptyTableException();
        } catch (IOException ex) {
            throw new IOEmptyTableException();
        }
        return result;
    }

    @Override
    public List<Player> loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(Player obj) throws IODataExistingException {
        try {
            writer = new BufferedWriter(new FileWriter(DirectoriesManager.getPlayerFile()));
            String newRecord = "";
            newRecord = obj.getLogin() + "#" + obj.getPassword() + "#" + obj.getGame().getName();
            writer.write(newRecord);
            return true;
        } catch (IOException ex) {
            throw new IODataExistingException("Arquivo inexistente");
        }finally{
            try {
                writer.close();
            } catch (IOException ex) {
                throw new IODataExistingException("Falha ao fechar o arquivo");
            }
        }
    }

    @Override
    public boolean update(Player obj) throws IONotFoundDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws IONotFoundDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
