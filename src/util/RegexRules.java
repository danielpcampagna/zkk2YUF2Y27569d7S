/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Daniel
 */
public class RegexRules {

    /**
     * Pegar informações do dicionário. Considere o exemplo:
     * <p>
     * Exemplo 1:</p>
     * <blockquote>
     * <code>
     * <p>
     * atacar|bater [objeto]</p>
     * <br>Grupo 1 -> atacar|bater</br>
     * <br>Grupo 2 -> objeto</br>
     * </code>
     * </blockquote>
     * <p>
     * Exemplo 2:</p>
     * <blockquote>
     * <code>
     * <p>
     * combinar|fundir|misturar [objeto] [objeto]</p>
     * <br>Grupo 1 -> combinar|fundir|misturar</br>
     * <br>Grupo 2 -> objeto</br>
     * <br>Grupo 3 -> objeto</br>
     * </code>
     * </blockquote>
     * <p>
     * Na linha 3:</p>
     * <blockquote>
     * <code>
     * <p>
     * ir|ir para [local]</p>
     * <br>Grupo 1 -> ir|ir para</br>
     * <br>Grupo 2 -> local</br>
     * </code>
     * </blockquote>
     */
    public static final String GETCOMMAND = "(\\S*)#([\\S\\s]+)#([\\S\\s]+)";
//    public static final String GETCOMMAND = "([^<]+?) ?<(.+?)>(?: ?<(.+?)>)?";

    /**
     * Pegar informações dos jogadores. Considere os exemplos:
     * <p>
     * Exemplo 1:</p>
     * <blockquote>
     * <code>
     * <p>
     * maria#123#game_1</p>
     * <br>Grupo 1 -> maria</br>
     * <br>Grupo 2 -> 123</br>
     * <br>Grupo 3 -> game_1</br>
     * </code>
     * </blockquote>
     * <p>
     * Exemplo 2:</p>
     * <blockquote>
     * <code>
     * <p>
     * jose#senha321#game_2</p>
     * <br>Grupo 1 -> jose</br>
     * <br>Grupo 2 -> senha321</br>
     * <br>Grupo 3 -> game_2</br>
     * </code>
     * </blockquote>
     * <p>
     * Exemplo 3:</p>
     * <blockquote>
     * <code>
     * <p>
     * carlos#senhasenha#game_3</p>
     * <br>Grupo 1 -> carlos</br>
     * <br>Grupo 2 -> senhasenha</br>
     * <br>Grupo 3 -> game_3</br>
     * </code>
     * </blockquote>
     */
    public static final String GETPLAYER = "([\\w]*)#([\\w]*)#([\\w]*)";

    /**
     * Pegar informações dos personagens. Considere o exemplo:
     * <p>
     * Exemplo 1:</p>
     * <blockquote>
     * <code>
     * <p>
     * palavra#11#22#33#44#55:aa:bb:cc:dd:ee:ff#66:gg:hh:ii</p>
     * <br>Grupo 1 -> palavra</br>
     * <br>Grupo 2 -> 11</br>
     * <br>Grupo 3 -> 22</br>
     * <br>Grupo 4 -> 33</br>
     * <br>Grupo 5 -> 44</br>
     * <br>Grupo 6 -> 55</br>
     * <br>Grupo 7 -> aa:bb:cc:dd:ee:ff</br>
     * <br>Grupo 8 -> 66</br>
     * <br>Grupo 9 -> hh:ii:jj</br>
     *
     * </code>
     * </blockquote>
     */
    public static final String GETCHARACTER = "(\\w*)#(\\d*)#(\\d*)#(\\d*)#(\\d*)#(\\d*):(\\S*)#(\\d*):(\\S*)";

    /**
     * Pegar informações das salas. Considere o exemplo:
     * <p>
     * Exemplo 1:</p>
     * <blockquote>
     * <code>
     * <p>
     * name#aa:bb:cc#dd:ee:ff#description description</p>
     * <br>Grupo 1 -> name</br>
     * <br>Grupo 2 -> aa:bb:cc</br>
     * <br>Grupo 3 -> dd:ee:ff</br>
     * <br>Grupo 4 -> description description</br>
     * </code>
     * </blockquote>
     */
    public static final String GETROOM = "([\\S*|\\s*]*)#([\\S*|\\s*&]*)#([\\S*|\\s*]*)#([\\S*\\s*]*)";

    /**
     * Pegar informações dos jogos. Considere o exemplo:
     * <p>
     * Exemplo 1:</p>
     * <blockquote>
     * <code>
     * <p>
     * game name#begin room#character name</p>
     * <br>Grupo 1 -> game name</br>
     * <br>Grupo 2 -> begin room</br>
     * <br>Grupo 3 -> character name</br>
     * </code>
     * </blockquote>
     */
    public static String GETGAME = "([\\S*|\\s*]*)#([\\S*|\\s*&]*)#([\\S*|\\s*]*)";

    public static final String GETNUMBER = "^[a-zA-Z]+([0-9]*)[a-zA-Z]+$";
    public static final String GETJUSTNUMBER = "^([0-9]*)$";
    public static final String GETYESORNO = "^([Yy][Ee][Ss]|[Nn][Oo]|[Ss][Ii][Mm]|[Nn][Aa][Oo]|[Nn][Ãã][Oo]|[Ss]|[Nn]|[Yy])$";
    public static final String GETYES = "^([Yy][Ee][Ss]|[Ss][Ii][Mm]|[Ss]|[Yy])$";
    public static final String GETNO = "^([Nn][Oo]|[Nn][Aa][Oo]|[Nn][Ãã][Oo]|[Nn])$";

    public static final String[] split(String text, String pattern) {
        String[] result = null;
        text = text.toLowerCase();
        Matcher matcher = Pattern.compile(pattern).matcher(text);
//        Matcher matcher = Pattern.compile(pattern).matcher(text);
        if (matcher.find()) {
            result = new String[matcher.groupCount()];
            for (int i = 0; i < result.length; i++) {
                result[i] = matcher.group();
            }
        }

        return result;
    }

    public static boolean like(String text, String pattern) {
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        while (matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean isNumber(String text) {
        Matcher matcher = Pattern.compile(GETJUSTNUMBER).matcher(text);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        Matcher m = Pattern.compile("^(andar|viajar|caminhar|ir|correr) ?(para|para a|para o)? (\\w*|\\s) ?(\\w*|\\s)?").matcher("ir para teste asd");
//        while(m.find()){
//            System.out.println(m.group());
//        }
        String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";

//        Pattern pattern = Pattern.compile("^(andar|viajar|caminhar|ir|correr) ?(para|para a|para o)? (\\w*|\\s) ?(\\w*|\\s)?");
//        Pattern pattern = Pattern.compile("(andar|viajar|caminhar|ir|correr)");
//        Pattern pattern2 = Pattern.compile("(\\w*)\\s(\\w*)$");
    // in case you would like to ignore case sensitivity,
        // you could use this statement:
        // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
//        String text = "eu vou ir para o lugar lugar2 lugar3";
        String text = "ver";
        Matcher matcher = Pattern.compile("(ver|olhar|observar)").matcher(text);
        Matcher matcher2 = Pattern.compile("(\\w*)\\s(\\w*)$").matcher(text);
        // check all occurance
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        while (matcher2.find()) {
            System.out.println(matcher2.group());
        }
    }
}
