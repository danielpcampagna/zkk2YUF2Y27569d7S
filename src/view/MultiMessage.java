/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Daniel
 */
public final class MultiMessage implements IView {

    public static final String CENTER = " ";
    public static final String NO = "   ";
    public static final String ALERT = "/!\\";
    public static final String ERRO = "/X\\";
    public static final String QUESTION = "/?\\";

    public static final String HASH = "#";
    public static final String BAR = "-";
    public static final String PIPE = "|";
    public static final String NONE = " ";

    public static final int MAX_W = 60;
    public static final int MIN_W = 20;
    public static final int MID_W = (MAX_W + MIN_W) /2;
    
    private String horizontal = HASH;
    private String vertical = HASH;
    private int width = 52;

    private boolean hasTitle = true;
    private String symbol;
    private String title;
    private String[] message;
    private String formatedTitle;
    private String formatedMessage;

    public MultiMessage(String[] message) throws IllegalArgumentException {
        this("", message);
        this.hasTitle = false;
    }
    
    public MultiMessage(String[] message, int width) throws IllegalArgumentException {
        this("", message, width);
        this.hasTitle = false;
    }

    public MultiMessage(String title, String[] message) throws IllegalArgumentException {
        this(NO, title, message);
    }
    
    public MultiMessage(String title, String[] message, int width) throws IllegalArgumentException {
        this(NO, title, message, width);
    }

    public MultiMessage(String symbol, String title, String[] message) throws IllegalArgumentException {
        this(symbol, title, message, 52);
    }

    public MultiMessage(String symbol, String title, String[] message, int width) throws IllegalArgumentException {
        this(symbol, title, message, width, HASH, HASH);
    }

    public MultiMessage(String symbol, String title, String[] message, int width, String vertical, String horizontal) throws IllegalArgumentException {
        this.setTitle(title);
        this.setMessage(message);

        this.setSymbol(symbol);
        this.setWidth(width);
        this.setVertical(vertical);
        this.setHorizontal(horizontal);
        this.formatTittle();
        this.formatMessage();
    }

    /**
     * Define qual caracter será usado nas margens horizontais das telas de
     * mensagem. Deve ser uma das constantes definidas na classe, sendo elas:
     * <br>HASH = "#"</br>
     * <br>BAR = "-"</br>
     * <br>NONE = " "</br>
     *
     * @param horizontal
     */
    public void setHorizontal(String horizontal) throws IllegalArgumentException {
        if (horizontal == null
                || horizontal.length() != 1) {
            throw new IllegalArgumentException("[ERRO]: \n"
                    + SimpleMessage.class.getCanonicalName() + ".horizontal\n"
                    + " tamanho diferente de 1 (um)");
        }
        switch (horizontal) {
            case SimpleMessage.HASH:
                break;
            case SimpleMessage.BAR:
                break;
            default:
                horizontal = NONE;
                break;
        }
        this.horizontal = horizontal;
    }

    /**
     * Define qual caracter será usado nas margens verticais das telas de
     * mensagem. Deve ser uma das constantes definidas na classe, sendo elas:
     * <br>HASH = "#"</br>
     * <br>PIPE = "|"</br>
     * <br>NONE = " "</br>
     *
     * @param vertical
     */
    public void setVertical(String vertical) throws IllegalArgumentException {
        if (vertical == null
                || vertical.length() != 1) {
            throw new IllegalArgumentException("[ERRO]: \n"
                    + SimpleMessage.class.getCanonicalName() + ".horizontal\n"
                    + " tamanho diferente de 1 (um)");
        }
        switch (vertical) {
            case SimpleMessage.HASH:
                break;
            case SimpleMessage.PIPE:
                break;
            default:
                vertical = NONE;
                break;
        }
        this.vertical = vertical;
    }

    /**
     * Usado para definir a largura da tela. Exige um reprocessamento para o
     * formato da mensagem e do título.
     *
     * @param width
     */
    public void setWidth(int width) throws IllegalArgumentException {
        if (width < 20 || width > 60) {
            throw new IllegalArgumentException("[ERRO]: \n"
                    + SimpleMessage.class.getCanonicalName() + ".width valor fora do domínio"
                    + " [20, 60]");
        }
        this.width = width;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.setMessage(new String[]{message});
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    /**
     * Esta função é usada para definir qual símbolo será usado, ao lado
     * esquerdo do título, na hora da exibição. Deve ser uma das constantes
     * definidas na classe, sendo elas:
     * <br>CENTER = " " * ((width / 2) - (title.length() / 2))</br>
     * <br>NO = " "</br>
     * <br>ALERT = "/!\\"</br>
     * <br>ERRO = "/X\\"</br>
     * <br>QUESTION = "/?\\"</br>
     *
     * @param symbol
     */
    public void setSymbol(String symbol) {
        switch (symbol) {
            case SimpleMessage.ALERT:
                break;
            case SimpleMessage.ERRO:
                break;
            case SimpleMessage.QUESTION:
                break;
            case SimpleMessage.CENTER:
                break;
            default:
                symbol = NO;
                break;
        }
        this.symbol = symbol;
    }

    /**
     * Esta função recebe o título e o formata a fim de que possa caber na caixa
     * de mensagem, com largura pré definida, onde será exibida. A diferença,
     * porém, é que não acrescenta linhas, caso o título seja maior do que a
     * caixa largura de mensagem.
     * <p>
     * Exemplo 01 de formato:</p>
     * <blockquote>
     * <code>
     * <br>Parametro: "Olá Mundo"</br>
     * <br>Tamanho da caixa: 12</br>
     * <br>Caracter de borda: "#"</br>
     * <br>Resultado:</br>
     * <blockquote>
     * <br>#Olá_mundo__#</br>
     * </blockquote>
     * </code>
     * </blockquote>
     *
     * <p>
     * Exemplo 02 de formato:</p>
     * <blockquote>
     * <code>
     * <br>Parametro: "Olá Mundo"</br>
     * <br>Tamanho da caixa: 10</br>
     * <br>Caracter de borda: "#"</br>
     * <br>Resultado:</br>
     * <blockquote>
     * <br>#Olá_mund#</br>
     * </blockquote>
     * </code>
     * </blockquote>
     * <br><i>Observação: Nos exemplos, entenda "_" (sublinhado) como " "
     * (espaço em branco)</i><br>
     *
     * @param title O título a ser formatado
     */
    private void formatTittle() {
        if (title == null) {
            title = "";
        }
        String resp = vertical;
        if (symbol.equals(CENTER)) {
            for (int i = 0; i < ((width / 2) - (title.length() / 2)); i++) {
                resp = resp + symbol;
            }
        } else {
            resp = resp + symbol;
        }

        for (int i = 0; i < title.length(); i++) {
            if (resp.length() % width == width - 1) {
                resp = resp + vertical;
                this.formatedTitle = resp;
                return;
            }
            resp = resp + title.toCharArray()[i];
        }

        while (resp.length() % (width - 1) != 0) {
            resp += " ";
        }
        resp = resp + vertical;
        this.formatedTitle = resp;
    }

    /**
     * Esta função recebe a mensage e a formata para que possa caber na caixa de
     * mensagem, com largura pré definida, onde será exibida.
     * <p>
     * Exemplo 01 de formato:</p>
     * <blockquote>
     * <code>
     * <br>Parametro: "Olá Mundo"</br>
     * <br>Tamanho da caixa: 12</br>
     * <br>Caracter de borda: "#"</br>
     * <br>Resultado:</br>
     * <blockquote>
     * <br>#Olá_mundo__#</br>
     * </blockquote>
     * </code>
     * </blockquote>
     *
     * <p>
     * Exemplo 02 de formato:</p>
     * <blockquote>
     * <code>
     * <br>Parametro: "Olá Mundo"</br>
     * <br>Tamanho da caixa: 10</br>
     * <br>Caracter de borda: "#"</br>
     * <br>Resultado:</br>
     * <blockquote>
     * <br>#Olá_mund#</br>
     * <br>#o_______#</br>
     * </blockquote>
     * </code>
     * </blockquote>
     * <br><i>Observação: Nos exemplos, entenda "_" (sublinhado) como " "
     * (espaço em branco)</i><br>
     *
     * @param message A mensagem a ser formatada
     */
    private void formatMessage() {
        if (message == null) {
            message = new String[]{""};
        }
        this.formatedMessage = "";
        for (int i = 0; i < this.message.length; i++) {
            String message = this.message[i];
            
            String resp = vertical;
            for (int j = 0; j < message.length(); j++) {
                if (resp.length() % width == (width - 1)) {
                    this.formatedMessage += resp + vertical + "\n";
                    resp = vertical;
                }
                if (message.toCharArray()[j] == '\n') {
                    while (resp.length() % (width - 1) != 0) {
                        resp += " ";
                    }
                    resp = resp + vertical + "\n";
                    this.formatedMessage += resp;
                    resp = vertical;
                } else {
                    resp = resp + message.toCharArray()[j];
                }
            }
            while (resp.length() % (width - 1) != 0) {
                resp += " ";
            }
            resp = resp + vertical;
            this.formatedMessage += resp;
            if(i < this.message.length - 1){
                this.formatedMessage += "\n" + this.line() + "\n";
            }
            
        }
    }

    private String line() {
        String line = vertical;
        for (int i = 0; i < width - 2; i++) {
            line += horizontal;
        }
        line += vertical;
        return line;
    }

    private String whiteLine() {
        String line = vertical;
        for (int i = 0; i < width - 2; i++) {
            line += " ";
        }
        line += vertical;
        return line;
    }

    @Override
    public void show() {
        if (hasTitle) {
            System.out.println(line());
            System.out.println(formatedTitle);
        }
        System.out.println(line());
        System.out.println(formatedMessage);
        System.out.println(line());

    }

}
