/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoFactory;
import dao.IDao;
import exception.IOEmptyTableException;
import exception.IODataExistingException;
import exception.IONotFoundDataException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        IDao gameDao = DaoFactory.getGameDao(DaoFactory.TXT);
        return (Game) gameDao.find(id.getName());
    }

    @Override
    public List<Game> loadAll() throws IOEmptyTableException {
        IDao gameDao = DaoFactory.getGameDao(DaoFactory.TXT);
        return (List<Game>) (Game) gameDao.loadAll();
    }

    @Override
    public boolean save() throws IODataExistingException {
        // 1 - salvar o character
        // 2 - salvar a sala
//        CharacterController character = new CharacterController(this.model.getCharacter());
//        character.save();
//        RoomController room = new RoomController(this.model.getLocal());
//        room.save();
        IDao game = DaoFactory.getGameDao(DaoFactory.TXT);
        return game.save(this.model);

    }

    @Override
    public boolean update(Game obj) throws IONotFoundDataException {
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
