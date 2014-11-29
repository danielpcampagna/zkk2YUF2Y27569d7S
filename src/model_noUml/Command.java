package model_noUml;

import db.Dictionary;
import exception.NotFoundCommandException;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Daniel
 */
public class Command {
    
    public static final String OBJECT = "object";
    public static final String ROOM = "room";
    public static final String NULL = "null";
    
    private String verb;
    private String[] objects;
    private String objectType;

    public Command(Command command) {
        this(command.getVerb(), command.getObjects(), command.objectType);
    }
    
    public Command(String verb, String type) {
        this(verb, null, type);
    }
    
    public Command(String verb, String[] object, String type) {
//        if(verb == null)throw new IllegalArgumentException("o verbo não pode ser nulo");
//        if(type == null)throw new IllegalArgumentException("o tipo não pode ser nulo");
        this.verb = verb;
        this.objects = object;
        this.objectType = type;
    }
    
    public Command(String command) throws IOException, NotFoundCommandException {
        this(Dictionary.getCommand(command));
    }

    public String getVerb() {
        return verb;
    }

    public String[] getObjects() {
        return objects;
    }

    public String getObjectType() {
        return objectType;
    }
    
    
        
}
