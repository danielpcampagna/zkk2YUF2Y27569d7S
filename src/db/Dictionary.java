/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import exception.NotFoundCommandException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import model_noUml.Command;
import util.RegexRules;

/**
 *
 * @author Daniel
 */
public class Dictionary {

    private static BufferedReader reader;

    public static Command getCommand(String text) throws FileNotFoundException, IOException, NotFoundCommandException {
        Command result = null;
        /* 
         text vai está no formato:
         text = "cc ss"
         line = "nome#(aa|bb|cc|dd)#ee:ff"
        
         1o - pegar o verbo
         2o - pegar o(s) objeto(s)
         */
        String verb = null;
        String[] objects = null;
        reader = new BufferedReader(new FileReader(DirectoriesManager.getDictionary()));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split("#");
            if (split != null
                    && split.length >= 2) {
                /*
                 passando como parâmetro:
                 val = ["cc"] <- split("cc ss", "(aa|bb|cc|dd)")
                
                
                 */
                String[] val = RegexRules.split(text, split[1]);
                if (val != null
                        && val.length > 0
                        && val[0] != null) {
                    verb = val[0];
                    /*
                     Até este ponto, já temos o verbo, que está armazenada em
                     val[0]. Seguindo o exemplo: val[0] = "cc"
                    
                     Vamos obter, agora, o tipo do objeto e também o(s) objeto(s),
                     caso exista(m). Para isso, o tamanho de split deve ser igual a 3
                    
                     OB: Nem toda ação exige um objeto
                     */
                    if (split.length == 3) {
                        /*
                         Caso este verbo exija objeto(s), o tipo de objeto
                         (local ou objeto) estará armazenado em spli[2]
                         no seguite formato: "ee:ff" (sendo "ee" e "ff",
                         separadamente, cada tipo). Além disso, será obtido,
                         também, a quantidade de objetos que esse verbo exige
                        
                         E os objetos serão obtidos a partir de text
                         */
                        String[] objectsType = split[2].split(":");
                        if (objectsType != null
                                && objectsType.length > 0) {

                            /*
                             Para obter cada objeto da frase, a partir de text,
                             devemos criar o seguinte padrão regex:
                            
                             1 - Sabemos que, neste bloco, há pelo menos
                             um objeto, então pattern = "(\\w*)$".
                             Isso permite capturarmos ao menos o último objeto
                            
                             2 - Caso este verbo exija mais do que um objeto,
                             então pattern = "(\\w*)\\s" + pattern.
                             Isso permite que seja capturada o último objeto,
                             excluindo os que já foram capturados até então.
                             Repita até que todos os objetos sejam capturados.
                             */
                            String pattern = "(\\w*)$";
                            for (int i = 1; i < objectsType.length; i++) {
                                pattern = "(\\w*)\\s" + pattern;

                            }
                            objects = RegexRules.split(text, pattern);
                            switch (objectsType[0].trim()) {
                                case (Command.OBJECT):
                                    result = new Command(split[0], objects, Command.OBJECT);
                                    return result;
                                case (Command.ROOM):
                                    result = new Command(split[0], objects, Command.ROOM);
                                    return result;
                                default:
                                    throw new IllegalArgumentException(""
                                            + "O Dicionário está mal formulado "
                                            + "ou a versão deste programa está "
                                            + "numa versão diferente da versão "
                                            + "que o dicionário está preparado.");
                            }
                        }
                    } else if (split.length == 2) {
                        /*
                         Caso o verbo não exija nenhum objeto mas o jogador 
                         tenha passado um objeto, gera-se um erro.
                         */
                        if (text.split(" ").length > 1) {
                            throw new NotFoundCommandException(""
                                    + "Você queria dizer \"" + text.split(" ")[0] + "\"?");
                        }
                        result = new Command(split[0], Command.NULL);
                        return result;
                    }
                }
            }

            line = reader.readLine();
        }

        return result;
    }
}
