/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.DaoFactory;
import dao.IDao;
import exception.IODataExistingException;
import exception.IOEmptyTableException;
import exception.IONotFoundDataException;
import java.util.ArrayList;
import java.util.List;
import model.room.Door;

/**
 *
 * @author Daniel
 */
public class DoorController extends IController<Door>{

    @Override
    public Door last() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Door first() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Door find(Door id) throws IOEmptyTableException, IONotFoundDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Door> loadAll() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save() throws IODataExistingException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Door obj) throws IONotFoundDataException {
        IDao door = DaoFactory.getDoorDao(DaoFactory.TXT);
        return door.update(obj);
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
