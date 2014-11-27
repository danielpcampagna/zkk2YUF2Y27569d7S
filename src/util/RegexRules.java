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
     * Arquivo dicionário:</p>
     * <blockquote>
     * <code>
     * <br>atacar|bater [objeto]</br>
     * <br>combinar|fundir|misturar [objeto] [objeto]</br>
     * <br>ir|ir para [local]</br>
     * </code>
     * </blockquote>
     * O uso desta expressão regular resulta:
     * <p>
     * Na linha 1:</p>
     * <blockquote>
     * <code>
     * <br>Grupo 1 -> atacar|bater</br>
     * <br>Grupo 2 -> objeto</br>
     * </code>
     * </blockquote>
     * <p>
     * Na linha 2:</p>
     * <blockquote>
     * <code>
     * <br>Grupo 1 -> combinar|fundir|misturar</br>
     * <br>Grupo 2 -> objeto</br>
     * <br>Grupo 3 -> objeto</br>
     * </code>
     * </blockquote>
     * <p>
     * Na linha 3:</p>
     * <blockquote>
     * <code>
     * <br>Grupo 1 -> ir|ir para</br>
     * <br>Grupo 2 -> local</br>
     * </code>
     * </blockquote>
     */
    public static final String GETCOMMAND = "([^<]+?) ?<(.+?)>(?: ?<(.+?)>)?";
    
    /**
     * Pegar informações dos jogadores. Considere o exemplo:
     * <p>
     * Arquivo players:</p>
     * <blockquote>
     * <code>
     * <br>maria#123#game_1</br>
     * <br>jose#senha321#game_2</br>
     * <br>carlos#senhasenha#game_3</br>
     * </code>
     * </blockquote>
     * O uso desta expressão regular resulta:
     * <p>
     * Na linha 1:</p>
     * <blockquote>
     * <code>
     * <br>Grupo 1 -> maria</br>
     * <br>Grupo 2 -> 123</br>
     * <br>Grupo 3 -> game_1</br>
     * </code>
     * </blockquote>
     * <p>
     * Na linha 2:</p>
     * <blockquote>
     * <code>
     * <br>Grupo 1 -> jose</br>
     * <br>Grupo 2 -> senha321</br>
     * <br>Grupo 3 -> game_2</br>
     * </code>
     * </blockquote>
     * <p>
     * Na linha 3:</p>
     * <blockquote>
     * <code>
     * <br>Grupo 1 -> carlos</br>
     * <br>Grupo 2 -> senhasenha</br>
     * <br>Grupo 3 -> game_3</br>
     * </code>
     * </blockquote>
     */
    public static final String GETPLAYER = "([\\w]*)#([\\w]*)#([\\w]*)";

    
    public static final String[] split(String text, String pattern) {
        String[] result = null;
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        result = new String[matcher.groupCount()];
        for (int i = 0; i < result.length && matcher.find(); i++) {
            result[i] = matcher.group();
        }

        return result;
    }
    
}
