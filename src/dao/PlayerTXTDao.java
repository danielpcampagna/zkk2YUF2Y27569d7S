/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.GameController;
import static dao.IDao.reader;
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
import model.player.Game;
import model.player.Player;

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
//                String[] comp = RegexRules.split(line, RegexRules.GETPLAYER);
                String[] split = line.split("#");
                if (split.length >= 2
                        && split[0].equals(id)) {
                    result = new Player();
                    result.setLogin(split[0]);
                    result.setPassword(split[1]);
                    List<Game> games = new ArrayList<>();
                    if (split.length > 2) {
                        String[] gamesS = split[2].split(":");
                        for (int i = 0; gamesS != null && i < gamesS.length; i++) {
                            games.add(new GameTXTDao().find(gamesS[i]));
                        }
                    }
                    result.setGame(games);
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
        List<Player> result = null;
        try {
            reader = new BufferedReader(new FileReader(new File(DirectoriesManager.getPlayerFile())));
            String line = reader.readLine();
            result = new ArrayList<>();
            while (line != null) {
                String[] split = line.split("#");
                if (split != null
                        && split.length >= 2) {

                    Player p = new Player();
                    p.setLogin(split[0]);
                    p.setPassword(split[1]);
                    if (split.length == 3
                        && split[2] != null
                            && !split[2].trim().equals("")) {
                        List<Game> games = new ArrayList<>();
                        String[] gamesS = split[2].split(":");
                        for (int i = 0; gamesS != null && i < gamesS.length; i++) {
                            games.add(new GameTXTDao().find(gamesS[i]));
                        }
                        p.setGame(games);
                    } else {
                        p.setGame(null);
                    }
                    result.add(p);
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
            }
        }
        return result;
    }

    @Override
    public boolean save(Player obj) throws IODataExistingException {
        try {
            if (find(obj.getLogin()) != null) {
                return update(obj);
            }
            writer = new BufferedWriter(new FileWriter(DirectoriesManager.getPlayerFile(), true));
            String newRecord = "";
            String gameName = null;
            if (obj.getGame() == null
                    || obj.getGame().size() == 0) {
                gameName = "";
            } else {
                gameName = obj.getGame().get(0).getName();
                for (int i = 1; i < obj.getGame().size(); i++) {
                    gameName += ":" + obj.getGame().get(i).getName();

                }
            }
            newRecord = obj.getLogin() + "#" + obj.getPassword() + "#" + gameName + "\n";
            writer.write(newRecord);
            return true;
        } catch (IOException ex) {
            throw new IODataExistingException("Arquivo inexistente");
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                throw new IODataExistingException("Falha ao fechar o arquivo");
            }
        }
    }

    @Override
    public boolean update(Player obj) throws IONotFoundDataException {
        try {
            List<Player> players = loadAll();
            clear();
            for (Player player : players) {
                if (player.getLogin().trim().equals(obj.getLogin().trim())) {
                    player.setLogin(obj.getLogin());
                    player.setPassword(obj.getPassword());
                    player.setGame(obj.getGame());
                }
                save(player);
            }
            return true;
        } catch (IOException ex) {
            throw new IONotFoundDataException("Arquivo não encontrado");
        } finally {
        }
    }

    @Override
    public boolean delete(String id) throws IONotFoundDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        try {
            writer = new BufferedWriter(new FileWriter(DirectoriesManager.getPlayerFile()));
            writer.write("");
            writer.close();
        } catch (IOException ex) {
        }
    }

}
