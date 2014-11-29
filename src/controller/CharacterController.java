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
import model.player.Character;

/**
 *
 * @author Daniel
 */
public class CharacterController extends IController<Character> {

    
    public CharacterController(Character character) {
        if (character == null) {
            throw new IllegalArgumentException(CharacterController.class.getCanonicalName()
                    + ".Character é nulo");
        }
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
        IDao character = DaoFactory.getCharacterDao(DaoFactory.TXT);
        return (Character) character.find(id.getName());
    }

    @Override
    public List<Character> loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save() throws IODataExistingException {
        IDao dao = DaoFactory.getCharacterDao(DaoFactory.TXT);
        return dao.save(this.model);
    }

    @Override
    public boolean update(Character obj) throws IONotFoundDataException {
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
