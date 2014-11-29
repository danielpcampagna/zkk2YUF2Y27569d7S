/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.CharacterController;
import controller.ObjectController;
import static dao.IDao.reader;
import db.DirectoriesManager;
import exception.IOEmptyTableException;
import exception.IODataExistingException;
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
import model.object.TAObject;
import model.player.Character;
import model.player.Inventory;
import model.player.Memory;
import model.room.Room;
import model.room.RoomFactory;
import util.RegexRules;

/**
 *
 * @author Daniel
 */
class CharacterTXTDao extends IDao<model.player.Character> {

    public CharacterTXTDao() {
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
    public Character find(String id) throws IOEmptyTableException {
        model.player.Character result = null;
        try {

            String name = null;
            int force;
            int resitence;
            int agility;
            int inteligence;
            reader = new BufferedReader(new FileReader(DirectoriesManager.getCharacterFile()));
            String line = reader.readLine();
            while (line != null) {
//                String[] resp = RegexRules.split(line, RegexRules.GETCHARACTER);
                String[] split = line.split("#");
                if (split != null
                        && (split.length == 8
                        || split.length == 9)
                        && split[0].trim().equals(id.trim())
                        && RegexRules.isNumber(split[1])
                        && RegexRules.isNumber(split[2])
                        && RegexRules.isNumber(split[3])
                        && RegexRules.isNumber(split[4])
                        && RegexRules.isNumber(split[5])
                        && RegexRules.isNumber(split[7])) {
                    result = new Character(split[0],
                            Integer.parseInt(split[1]),
                            Integer.parseInt(split[2]),
                            Integer.parseInt(split[3]),
                            Integer.parseInt(split[4]));
                    Inventory inventory = new Inventory(Integer.parseInt(split[5]));

                    for (int i = 0; !split[6].trim().equals("") && i < split[6].split(":").length; i++) {
                        String objectName = split[6].split(":")[i];
                        TAObject ob = new TAObject();
                        ob.setName(objectName);
                        ObjectController object = new ObjectController(ob);
                        inventory.putInventory(object.load());
                    }

                    Memory memory = new Memory(Integer.parseInt(split[7]));
                    if (split.length == 9) {
                        for (int i = 0; !split[8].trim().equals("") && i < split[8].split(":").length; i++) {
                            String analysis = split[8].split(":")[i];
                            memory.add(analysis);
                        }
                    }

                    result.setInventory(inventory);
                    result.setMemory(memory);
                    return result;
                }
                line = reader.readLine();
            }
            return null;
        } catch (FileNotFoundException ex) {
            throw new IOEmptyTableException();
        } catch (IOException ex) {
            throw new IOEmptyTableException();
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
            }
        }
    }

    @Override
    public List<Character> loadAll() throws IOEmptyTableException {
        List<Character> result = null;
        try {
            reader = new BufferedReader(new FileReader(new File(DirectoriesManager.getDoorFile())));
            String line = reader.readLine();
            result = new ArrayList<>();
            while (line != null) {
                String[] split = line.split("#");
                if (split != null
                        && (split.length == 8
                        || split.length == 9)
                        && RegexRules.isNumber(split[1])
                        && RegexRules.isNumber(split[2])
                        && RegexRules.isNumber(split[3])
                        && RegexRules.isNumber(split[4])
                        && RegexRules.isNumber(split[5])
                        && RegexRules.isNumber(split[7])) {

                    Character character = new Character(split[0],
                            Integer.parseInt(split[1]),
                            Integer.parseInt(split[2]),
                            Integer.parseInt(split[3]),
                            Integer.parseInt(split[4]));

                    Inventory inventory = new Inventory(Integer.parseInt(split[5]));
                    String[] objects = split[6].split(":");
                    if (objects != null
                            && objects.length > 0) {
                        for (int i = 0; i < objects.length; i++) {
                            if (objects[i] != null) {
                                TAObject o = new ObjectTXTDao().find(objects[i]);
                                if (o != null) {
                                    inventory.putInventory(o);
                                }
                            }
                        }

                    }
                    character.setInventory(inventory);

                    Memory memory = new Memory(Integer.parseInt(split[7]));
                    String[] memories = split[8].split(":");
                    if (memories != null
                            && memories.length > 0) {
                        for (int i = 0; i < memories.length; i++) {
                            if (memories[i] != null) {
                                memory.add(memories[i]);
                            }
                        }

                    }
                    character.setMemory(memory);
                    result.add(character);
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
    public boolean save(Character obj) throws IODataExistingException {
        try {
            if (find(obj.getName()) != null) {
                return update(obj);
            }
            String resp = "";
            writer = new BufferedWriter(new FileWriter(DirectoriesManager.getCharacterFile(), true));
            resp += obj.getName();
            resp += "#";
            resp += obj.getForce();
            resp += "#";
            resp += obj.getResistence();
            resp += "#";
            resp += obj.getAgility();
            resp += "#";
            resp += obj.getIntelligence();
            resp += "#";
            resp += obj.getInventory().getCapacity();
            resp += "#";
            for (String key : obj.getInventory().getObjects().keySet()) {
                resp += ":";
                resp += key;
                resp += ",";
                resp += obj.getInventory().getObject(key);
            }
            resp += "#";
            resp += obj.getMemory().getCapacity();
            resp += "#";
            for (String val : obj.getMemory().getAnalysis()) {
                resp += ":";
                resp += val;
            }
            writer.write(resp + "\n");
            return true;
        } catch (IOException ex) {
            throw new IODataExistingException();
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                throw new IODataExistingException();
            }
        }

    }

    @Override
    public boolean update(Character obj) throws IONotFoundDataException {
        try {
            List<Character> characters = loadAll();
            clear();
            for (Character character : characters) {
                if (character.getName().trim().equals(obj.getName().trim())) {
                    character.setName(obj.getName());
                    character.setForce(obj.getForce());
                    character.setResistence(obj.getResistence());
                    character.setAgility(obj.getAgility());
                    character.setInteligence(obj.getIntelligence());
                    character.setInventory(obj.getInventory());
                    character.setMemory(obj.getMemory());
                }
                save(character);
            }
        } catch (IOException ex) {
            throw new IONotFoundDataException("Arquivo não encontrado");
        } finally {
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
            writer = new BufferedWriter(new FileWriter(DirectoriesManager.getCharacterFile()));
            writer.write("");
            writer.close();
        } catch (IOException ex) {
        }
    }

}
