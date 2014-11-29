/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoFactory;
import dao.IDao;
import db.DirectoriesManager;
import exception.IODataExistingException;
import exception.IOEmptyTableException;
import exception.IONotFoundDataException;
import java.io.IOException;
import java.util.List;
import model.player.Game;
import model.player.Character;
import model.player.Player;

/**
 *
 * @author Daniel
 */
public class PlayerController extends IController<Player> {

    public PlayerController(Player player) throws IllegalArgumentException {
        if (player == null) {
            throw new IllegalArgumentException(PlayerController.class.getCanonicalName()
                    + ".player é nulo");
        }
        this.model = player;
    }

    public void setLogin(String login) {
        this.model.setLogin(login);
    }

    public void setSenha(String senha) {
        this.model.setPassword(senha);
    }

    public String getLogin() {
        return model.getLogin();
    }

    public List<Game> getGame() {
        return model.getGame();
    }

    public void setGame(List<Game> games) {
        this.model.setGame(games);
    }

    public String getSenha() {
        return model.getPassword();
    }

    @Override
    public Player last() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Player first() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Player find(Player id) throws IOEmptyTableException {
        IDao Player = DaoFactory.getPlayerDao(DaoFactory.TXT);
        Player p = (Player) Player.find(id.getLogin());
        if (p != null
                && p.getLogin().trim().equals(id.getLogin().trim())
                && id.getPassword() != null
                && p.getPassword().equals(id.getPassword())) {
            return p;
        }
        return null;

    }

    @Override
    public List<Player> loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save() throws IODataExistingException {
        try {
            IDao player = DaoFactory.getPlayerDao(DaoFactory.TXT);
            if (player.find(this.model.getLogin()) != null && DirectoriesManager.changeInstace(this.model) != null) {
                throw new IODataExistingException("Já existe um Jogador com essas características");
            }
            DirectoriesManager.newInstace(this.model);

            return player.save(this.model);
        } catch (IOException ex) {
            return false;
        }
    }

    @Override
    public boolean update(Player obj) throws IONotFoundDataException {
        try {
            if (DirectoriesManager.changeInstace(obj) == null) {
                throw new IONotFoundDataException("Já existe um Jogador com essas características");
            }
//            if (obj.getGame() != null) {
//                for (Game g : obj.getGame()) {
//                    IController game = new GameController(g);
//                    game.save();
//                }

//                IDao gameDao = DaoFactory.getGameDao(DaoFactory.TXT);
//                gameDao.save(this.model);
//            }
            IDao playerDao = DaoFactory.getPlayerDao(DaoFactory.TXT);
            return playerDao.update(obj);
        } catch (IOException ex) {
            return false;
        }
    }

    @Override
    public boolean delete() throws IONotFoundDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
    }

    public void addGame(Game game) {
        this.model.getGame().add(game);
    }

}
