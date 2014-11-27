/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import model.player.Player;

/**
 *
 * @author Daniel
 */
public class DirectoriesManager {

    private static final String rootDefault = "src/bd/data/";
    private static final String rootPlayer = "saves/";
    private static final String players = "players";
    private static final String game = "games";
    private static final String action = "actions";
    private static final String object = "objects";
    private static final String room = "rooms";
    private static final String character = "character";

    private static String currentPlayer;
    private static DirectoriesManager instance = null;
    private static String rootCurrentPlayer;

    public static DirectoriesManager newInstace(Player player) throws IOException {
        instance = new DirectoriesManager(player);
        createNewSave();
        return instance;
    }
    public static DirectoriesManager changeInstace(Player player) throws IOException {
        if(!new File(rootPlayer + player.getLogin()).exists()) return null;
        instance = new DirectoriesManager(player);
        return instance;
    }
    public static DirectoriesManager getInstance() {
        return instance;
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
        if (destination.exists()) {
            destination.delete();
        }

        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;

        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destinationChannel = new FileOutputStream(destination).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(),
                    destinationChannel);
        } finally {
            if (sourceChannel != null && sourceChannel.isOpen()) {
                sourceChannel.close();
            }
            if (destinationChannel != null && destinationChannel.isOpen()) {
                destinationChannel.close();
            }
        }
    }

    public static String getPlayerFile(){
        return rootDefault + game;
    }
    
    public static String getGameFile(){
        return rootDefault + game;
    }
    
    public static String getActionFile(){
        return rootCurrentPlayer + action;
    }
    
    public static String getObjectFile(){
        return rootCurrentPlayer + object;
    }
    
    public static String getRoomFile(){
        return rootCurrentPlayer + room;
    }
    
    public static String getCharacterFile(){
        return rootCurrentPlayer + character;
    }
}
