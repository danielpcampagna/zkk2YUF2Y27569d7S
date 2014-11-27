/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DirectoriesManager;
import exception.IOEmptyTableException;
import exception.IODataExistingException;
import exception.IONotFoundDataException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.player.Game;

/**
 *
 * @author Daniel
 */
class GameTXTDao extends IDao<Game> {

    public GameTXTDao() {

    }

    @Override
    public Game last() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Game first() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Game find(String id) throws IOEmptyTableException {
        Game result = null;
        try {
            reader = new BufferedReader(new FileReader(new File(DirectoriesManager.getGameFile())));

            String[] line = reader.readLine().split(":");
            if (line == null) {
                throw new IOEmptyTableException();
            }
            while (line != null && line.length == 2 && !line[0].equals(id)) {
                line = reader.readLine().split(":");
            }
            if (line != null && line.length == 2) {

                // implementar o caso que existe um game
                // 1 - pegar o character que pertence a ele (implementar o find do char)
                // 2 - pegar a room
                // 2.1 - pegar cada item que a room usa
                // 3 - formar um game e retornar
//                result = Game.getInstance();
//                Character character = new Character(value);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
            }
        }
        return result;
    }

    @Override
    public List<Game> loadAll() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(Game obj) throws IODataExistingException {
        try {
            writer = new BufferedWriter(new FileWriter(new File(DirectoriesManager.getGameFile())));
            try {
                Game test = find(obj.getCharacter().getName());
                if (test != null) {
                    throw new IODataExistingException();
                }
            } catch (IOEmptyTableException ex) {
            }
            writer.write(obj.getCharacter().getName() + ":" + obj.getLocal().getName() + "\n");

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
            Logger.getLogger(GameTXTDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
            }
        }
        return false;
    }

    @Override
    public boolean update(Game obj) throws IONotFoundDataException {
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
