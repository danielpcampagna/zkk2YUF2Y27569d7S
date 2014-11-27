/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FactoryDao;
import dao.IDao;
import db.DirectoriesManager;
import exception.IOEmptyTableException;
import exception.IODataExistingException;
import exception.IONotFoundDataException;
import java.io.IOException;
import java.util.List;
import model.player.Game;
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
    
    public Game getGame(){
        return model.getGame();
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
        IDao Player = FactoryDao.getPlayerDao(FactoryDao.TXT);
        Player p = (Player)Player.find(id.getLogin());
        if(p.getLogin().equals(id.getLogin())
                && id.getPassword() != null
                && id.getPassword().equals("")
                && p.getPassword().equals(id.getPassword())){
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
            if (DirectoriesManager.changeInstace(this.model) != null) {
                throw new IODataExistingException("Já existe um Jogador com essas características");
            }
            DirectoriesManager.newInstace(this.model);
            IDao player = FactoryDao.getPlayerDao(FactoryDao.TXT);
            return player.save(this.model);
        } catch (IOException ex) {
            return false;
        }
    }

    @Override
    public boolean update() throws IONotFoundDataException {
        try {
            if (DirectoriesManager.changeInstace(this.model) == null) {
                throw new IONotFoundDataException("Já existe um Jogador com essas características");
            }
            if (this.model.getGame() != null) {
                IController game = new GameController(this.model.getGame());
                game.save();
                IDao gameDao = FactoryDao.getGameDao(FactoryDao.TXT);
                gameDao.save(this.model);
            }
            IDao playerDao = FactoryDao.getPlayerDao(FactoryDao.TXT);
            return playerDao.save(this.model);
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

}
