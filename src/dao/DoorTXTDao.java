/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DirectoriesManager;
import exception.IODataExistingException;
import exception.IOEmptyTableException;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.object.Controler;
import model.room.Door;
import model.room.DoorFactory;

/**
 *
 * @author Daniel
 */
public class DoorTXTDao extends IDao<Door> {

    @Override
    public Door last() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Door first() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Door find(String id) throws IOEmptyTableException {
        return DoorFactory.getInstance().create(id);
    }

    @Override
    public List<Door> loadAll() throws IOEmptyTableException {
        List<Door> result = null;
        try {
            reader = new BufferedReader(new FileReader(new File(DirectoriesManager.getDoorFile())));
            String line = reader.readLine();
            result = new ArrayList<>();
            while (line != null) {
                String[] split = line.split("#");
                if (split != null
                        && split.length == 2) {
                    String[] names = split[0].split(":");
                    if (names != null
                            && names.length == 2) {
                        result.add(new Door(names[0], names[1], split[1]));
                    }
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            throw new IOEmptyTableException();
        } catch (IOException ex) {
            throw new IOEmptyTableException();
        }finally{
            try {
                writer.close();
            } catch (IOException ex) {
            }
        }
        return result;
    }

    @Override
    public boolean save(Door obj) throws IODataExistingException {
        try {
            if(find(obj.getRoomNameA() + ":" + obj.getRoomNameB()) != null) return update(obj);
            writer = new BufferedWriter(new FileWriter(new File(DirectoriesManager.getDoorFile()), true));
            writer.write(obj.getRoomNameA() + ":" + obj.getRoomNameB() + "#" + obj.getControler().getCode() + "\n");
            return true;
        } catch (IOException ex) {
            throw new IODataExistingException("Arquivo não encontrado");
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
            }
        }
    }

    @Override
    public boolean update(Door obj) throws IONotFoundDataException {
        try {
            List<Door> doors = loadAll();
            this.clear();

            for (Door b : doors) {
                if (b.getRoomNameA().trim().equals(obj.getRoomNameB().trim())
                        && b.getRoomNameB().trim().equals(obj.getRoomNameA().trim())) {
                    if (b.getControler().getCode().trim().equals(obj.getControler().getCode().trim())) {
                        b.setControler(Controler.ON);
                    }
                    break;
                }
            }
            for (Door a : doors) {
                if (a.getRoomNameA().trim().equals(obj.getRoomNameA().trim())
                        && a.getRoomNameB().trim().equals(obj.getRoomNameB().trim())) {
                    a.setControler(Controler.ON);
                }
                this.save(a);
            }

        } catch (IOEmptyTableException ex) {
            throw new IONotFoundDataException("Arquivo não encontrado");
        } catch (IOException ex) {
            throw new IONotFoundDataException("Arquivo não encontrado");
        } finally {
            return true;
        }

    }

    @Override
    public boolean delete(String id) throws IONotFoundDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        try {
            writer = new BufferedWriter(new FileWriter(DirectoriesManager.getDoorFile()));
            writer.write("");
            writer.close();
        } catch (IOException ex) {
        }
    }

}
