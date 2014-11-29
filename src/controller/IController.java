/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import exception.IOEmptyTableException;
import exception.IODataExistingException;
import exception.IONotFoundDataException;
import java.util.List;

/**
 *
 * @author Daniel
 */
public abstract class IController<T> {
    
    T model;

    public T getModel() {
        return model;
    }
    
    /**
     * This operation load the element with the highest id
     * 
     * @return the element with highest id
     * @throws IOEmptyTableException 
     */
    public abstract T last() throws IOEmptyTableException;

    /**
     * This operation load the element with lowest id
     *
     * @return the element with lowest id
     * @throws IOEmptyTableException 
     */
    public abstract T first() throws IOEmptyTableException;

    /**
     * This operation load this.model by id
     *
     * @param id
     * @return the element where id is equals the param val
     * @throws IOEmptyTableException 
     */
    public T load() throws IOEmptyTableException, IONotFoundDataException{
        this.model = find(model);
        return model;
        
    };
    
    /**
     * This operation load element by id
     *
     * @param id
     * @return the element where id is equals the param val
     * @throws IOEmptyTableException 
     */
    public abstract T find(T id) throws IOEmptyTableException, IONotFoundDataException;

    /**
     * This operation will load, to memory, all elements with a same type.
     *
     * @return the List with elements. If there isn't any element in database, 
     * will return null list
     */
    public abstract List<T> loadAll()throws IOEmptyTableException;

    /**
     * This operation will save this element in database.
     *
     * @return True, in positive case
     */
    public abstract boolean save() throws IODataExistingException;
    
    /**
     * This operation will update this element in database
     * 
     * @return True, in positive case
     * @throws IONotFoundDataException 
     */
    public boolean update() throws IONotFoundDataException{
        return update(this.model);
    }
    
    /**
     * This operation will update this element in database
     * 
     * @return True, in positive case
     * @throws IONotFoundDataException 
     */
    public abstract boolean update(T obj) throws IONotFoundDataException;

    /**
     * This operation will delete this element in database
     * @return True, in positive case
     * @throws IONotFoundDataException if there is not in database 
     */
    public abstract boolean delete() throws IONotFoundDataException;
    
    /**
     * This operation will delete all elements the database table
     */
    public abstract void clear();
    
}
