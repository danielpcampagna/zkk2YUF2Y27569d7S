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
import java.util.List;
import model.room.Room;

/**
 *
 * @author Daniel
 */
//implementar o update
public class RoomController extends IController<Room>{

    public RoomController(Room model) {
        if (model == null) {
            throw new IllegalArgumentException(RoomController.class.getCanonicalName()
                    + ".Room é nulo");
        }
        this.model = model;
    }
    
    @Override
    public Room last() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Room first() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Room find(Room id) throws IOEmptyTableException, IONotFoundDataException {
        IDao room = DaoFactory.getRoomDao(DaoFactory.TXT);
        return (Room) room.find(id.getName());
    }

    @Override
    public List<Room> loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save() throws IODataExistingException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Room obj) throws IONotFoundDataException {
        IDao room = DaoFactory.getRoomDao(DaoFactory.TXT);
        return room.update(obj);
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
