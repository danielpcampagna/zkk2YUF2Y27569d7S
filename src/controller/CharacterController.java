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
import model.player.Character;

/**
 *
 * @author Daniel
 */
class CharacterController extends IController<Character> {

    
    public CharacterController(Character character) {
        model = character;
    }

    @Override
    public Character last() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Character first() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Character find(Character id) throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Character> loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save() throws IODataExistingException {
        IDao dao = FactoryDao.getCharacterDao(FactoryDao.TXT);
        dao.save(this.model);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
