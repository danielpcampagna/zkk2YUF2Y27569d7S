/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.IDao.writer;
import db.DirectoriesManager;
import exception.IODataExistingException;
import exception.IOEmptyTableException;
import exception.IONotFoundDataException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.object.ObjectFactory;
import model.object.TAObject;

/**
 *
 * @author Daniel
 */
public class ObjectTXTDao extends IDao<TAObject> {

    @Override
    public TAObject last() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TAObject first() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TAObject find(String id) throws IOEmptyTableException {
        TAObject result = ObjectFactory.getInstance().create(id);
        return result;
    }

    @Override
    public List loadAll() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean save(TAObject obj) throws IODataExistingException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(TAObject obj) throws IONotFoundDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws IONotFoundDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        try {
            writer = new BufferedWriter(new FileWriter(DirectoriesManager.getObjectFile()));
            writer.write("");
            writer.close();
        } catch (IOException ex) {
        }
    }

}
