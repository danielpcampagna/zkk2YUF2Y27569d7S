/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.File;
import java.io.IOException;
import model.player.Player;

/**
 *
 * @author Daniel
 */
public class DirectoriesManager {

    /**
     * rootDefault = "src/db/data/"
     */
    private static final String rootDefault = "src/db/data/";
    /**
     * rootPlayer = "saves/"
     */
    private static final String rootPlayer = "saves/";
    
    private static final String action = "actions";
    private static final String character = "characters";
    private static final String dictionary = "dictionary";
    private static final String doors = "doors";
    private static final String players = "players";
    private static final String game = "games";
    private static final String object = "objects";
    private static final String room = "roons";
    

    private static String currentPlayer;
    private static DirectoriesManager instance = null;
    private static String rootCurrentPlayer;

    public static DirectoriesManager newInstace(Player player) throws IOException {
        if (!new File(rootCurrentPlayer = rootPlayer + player.getLogin() + "/").exists()) {
            createNewSave();
        }
        return changeInstace(player);
    }

    public static DirectoriesManager changeInstace(Player player) throws IOException {
        if (new File(rootCurrentPlayer = rootPlayer + player.getLogin() + "/").exists()) {
            if(currentPlayer != null && currentPlayer.trim().equals(player.getLogin())){
                return instance;
            }
            instance = new DirectoriesManager(player);
            return instance;
        }
        return null;
    }

    public static DirectoriesManager getInstance() {
        return instance;
    }

    static String getDictionary() {
        return rootDefault + dictionary;
    }

    public static String getDoorFile() {
        return rootCurrentPlayer + doors;
    }

    private DirectoriesManager(Player player) throws IOException {
        currentPlayer = player.getLogin();
        rootCurrentPlayer = rootPlayer + currentPlayer + "/";
    }

    /**
     * Copia todos os arquivos na pasta <code>src/bd/data</code> para a pasta
     * <code>saves/Player</code>
     */
    private static void createNewSave() throws IOException {
        File source = new File(rootDefault);
        File destination = new File(rootCurrentPlayer);
        CopyDirectory.copyDirectory(source, destination);
    }

    public static String getPlayerFile() {
        return rootDefault + players;
    }

    public static String getGameFile() {
        return rootCurrentPlayer + game;
    }
    
    public static String getActionFile() {
        return rootCurrentPlayer + action;
//        return rootDefault + action;
    }

    public static String getObjectFile() {
        return rootCurrentPlayer + object;
//        return rootDefault + object;
    }

    public static String getRoomFile() {
        return rootCurrentPlayer + room;
    }

    public static String getCharacterFile() {
        return rootCurrentPlayer + character;
    }
}
