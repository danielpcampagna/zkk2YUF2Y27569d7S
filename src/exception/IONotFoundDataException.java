/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;

/**
 *
 * @author Daniel
 */
public class IONotFoundDataException extends IODataExistingException{

    public IONotFoundDataException(String msg) {
        super(msg);
    }
}
