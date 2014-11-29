/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.IDao.reader;
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
import java.util.Iterator;
import java.util.List;
import model.player.Game;
import model.player.Player;
import model.room.Room;
import model.room.RoomFactory;

/**
 *
 * @author Daniel
 */
public class RoomTXTDao extends IDao<Room> {

    @Override
    public Room last() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Room first() throws IOEmptyTableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Room find(String id) throws IOEmptyTableException {
        return RoomFactory.getInstance().create(id);
        
    }

    @Override
    public List<Room> loadAll() throws IOEmptyTableException {
        List<Room> result = null;
        try {
            reader = new BufferedReader(new FileReader(new File(DirectoriesManager.getDoorFile())));
            String line = reader.readLine();
            result = new ArrayList<>();
            while (line != null) {
                String[] split = line.split("#");
                if (split != null
                        && split.length == 4) {
                    String[] objects = split[1].split(":");
                    String[] roons = split[2].split(":");
                    if (objects != null
                            && roons != null) {
                        result.add(RoomFactory.getInstance().create(split[0]));
                    }
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            throw new IOEmptyTableException();
        } catch (IOException ex) {
            throw new IOEmptyTableException();
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
            }
        }
        return result;
    }

    @Override
    public boolean save(Room obj) throws IODataExistingException {
        try {
            if(find(obj.getName()) != null) return update(obj);
            writer = new BufferedWriter(new FileWriter(new File(DirectoriesManager.getRoomFile()), true));
            writer.write(obj.getName() + "#");

            Iterator<String> it = obj.getObjects().keySet().iterator();
            if (it.hasNext()) {
                writer.write(it.next());
                while(it.hasNext()) {
                    writer.write(":" + it.next());
                }
            }
            writer.write("#");
            it = obj.getDoors().keySet().iterator();
            if (it.hasNext()) {
                writer.write(it.next());
                while(it.hasNext()) {
                    writer.write(":" + it.next());
                }
            }
            writer.write("#");
            writer.write(obj.getDescription());
            writer.write("\n");
            
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
    public boolean update(Room obj) throws IONotFoundDataException {
        try {
            List<Room> roons = loadAll();
            clear();
            writer = new BufferedWriter(new FileWriter(DirectoriesManager.getRoomFile()));
            for (Room room : roons) {
                if (room.getName().trim().equals(obj.getName().trim())) {
                    room.setName(obj.getName());
                    room.setDescription(obj.getDescription());
                    room.setObjects(obj.getObjects());
                    room.setDoors(obj.getDoors());
                }
                save(room);
            }
        } catch (IOException ex) {
            throw new IONotFoundDataException("Arquivo não encontrado");
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) throws IONotFoundDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        try {
            writer = new BufferedWriter(new FileWriter(DirectoriesManager.getRoomFile()));
            writer.write("");
            writer.close();
        } catch (IOException ex) {
        }
    }

}
