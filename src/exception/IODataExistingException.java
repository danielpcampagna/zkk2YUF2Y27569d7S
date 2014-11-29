/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;

import java.io.IOException;

/**
 *
 * @author Daniel
 */
public class IODataExistingException extends IOException{

    public IODataExistingException(String msg) {
        super(msg);
    }

    public IODataExistingException() {
        super();
    }
    
    
}
