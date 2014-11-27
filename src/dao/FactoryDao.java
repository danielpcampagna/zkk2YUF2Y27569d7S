/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Daniel
 */
public class FactoryDao {

    public static final String TXT = "txt";

    public static IDao getPlayerDao(String type) {
        switch (type) {
            case TXT:
                return new PlayerTXTDao();
            default:
                throw new IllegalArgumentException(FactoryDao.class.getCanonicalName()
                        +".getPlayerDao o tipo " + type + " não está implementado nesta versão.");
        }
    }

    public static IDao getGameDao(String type) {
        switch (type) {
            case TXT:
                return new GameTXTDao();
            default:
                throw new IllegalArgumentException(FactoryDao.class.getCanonicalName()
                        +".getGameDao o tipo " + type + " não está implementado nesta versão.");
        }
    }
    
    public static IDao getCharacterDao(String type) {
        switch (type) {
            case TXT:
                return new CharacterTXTDao();
            default:
                throw new IllegalArgumentException(FactoryDao.class.getCanonicalName()
                        +".getGameDao o tipo " + type + " não está implementado nesta versão.");
        }
    }
}
