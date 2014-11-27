/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FactoryDao;
import dao.IDao;
import exception.IOEmptyTableException;
import exception.IODataExistingException;
import exception.IONotFoundDataException;
import java.util.List;
import model.player.Game;

/**
 *
 * @author Daniel
 */
public class GameController extends IController<Game> {


    public GameController(Game game) {
        if (game == null) {
            throw new IllegalArgumentException(GameController.class.getCanonicalName()
                    + ".Game é nulo");
        }
        this.model = game;
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
    public Game find(Game id) throws IOEmptyTableException {
        IDao gameDao = FactoryDao.getGameDao(FactoryDao.TXT);
        return (Game)gameDao.find(id.getName());
    }

    @Override
    public List<Game> loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save() throws IODataExistingException {
        IController charc = new CharacterController(Game.getInstance().getCharacter());
        charc.save();
        // 1 - salvar o character
        // 2 - salvar a sala
        // 3 - salvar os itens em cada sala
        // 4 - salvar a sala
        return true;
    }

    @Override
    public boolean update() throws IONotFoundDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete() throws IONotFoundDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
