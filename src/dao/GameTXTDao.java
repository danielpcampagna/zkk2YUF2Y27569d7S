/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.CharacterController;
import controller.RoomController;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.player.Game;
import model.player.Character;
import model.room.Room;
import util.RegexRules;

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

            String line = reader.readLine();
            while (line != null) {
//                String[] resp = RegexRules.split(line, RegexRules.GETGAME);
                String[] resp = line.split("#");
                if (line != null
                        && resp.length == 3
                        && resp[0].trim().equals(id.trim())) {

                    Room room = new Room();
                    room.setName(resp[1]);
                    RoomController roomCtrl = new RoomController(room);
                    room = roomCtrl.load();

                    Character character = new Character(resp[2], -1, -1, -1, -1);
                    CharacterController characterCtrl = new CharacterController(character);
                    character = characterCtrl.load();
                    Game g = Game.newInstance();
                    g.setName(resp[0]);
                    g.setLocal(room);
                    g.setCharacter(character);

                    return g;
                }
                line = reader.readLine();
            }
            return result;
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
        List<Game> result = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(new File(DirectoriesManager.getGameFile())));

            String line = reader.readLine();
            while (line != null) {
                String[] resp = RegexRules.split(line, RegexRules.GETGAME);
                if (line != null
                        && resp.length == 3) {

                    Room room = new Room();
                    room.setName(resp[1]);
                    RoomController roomCtrl = new RoomController(room);
                    room = roomCtrl.load();

                    Character character = new Character(resp[2], -1, -1, -1, -1);
                    CharacterController characterCtrl = new CharacterController(character);
                    character = characterCtrl.load();
                    Game g = Game.newInstance();
                    g.setName(resp[0]);
                    g.setLocal(room);
                    g.setCharacter(character);

                    result.add(g);
                }
                line = reader.readLine();
            }
            return result;
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
    public boolean save(Game obj) throws IODataExistingException {
        try {
            if (find(obj.getName()) != null) {
                return update(obj);
            }
            writer = new BufferedWriter(new FileWriter(new File(DirectoriesManager.getGameFile()), true));

            writer.write(obj.getName() + "#" + obj.getLocal().getName() + "#" + obj.getCharacter().getName() + "\n");
            return true;
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
        List<Game> games;
        try {
            games = loadAll();
            clear();
            for (Game game : games) {
                if (game.getName().trim().equals(obj.getName().trim())) {
                    game.setName(obj.getName());
                    game.setLocal(obj.getLocal());
                    game.setCharacter(obj.getCharacter());
                }
                save(game);
            }
        } catch (IOEmptyTableException ex) {
            throw new IONotFoundDataException("Arquivo não encontrado");
        } catch (IODataExistingException ex) {
            throw new IONotFoundDataException("Arquivo não encontrado");
        }
        return true;
    }

    @Override
    public boolean delete(String id) throws IONotFoundDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        try {
            writer = new BufferedWriter(new FileWriter(DirectoriesManager.getGameFile()));
            writer.write("");
            writer.close();
        } catch (IOException ex) {
        }
    }

}
