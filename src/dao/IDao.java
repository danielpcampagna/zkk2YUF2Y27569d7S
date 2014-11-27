/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import exception.IODataExistingException;
import exception.IOEmptyTableException;
import exception.IONotFoundDataException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 *
 * @author Daniel
 */
public abstract class IDao<T> {
    
    protected static BufferedReader reader;
    protected static BufferedWriter writer;
    /**
     * This operation find the element with the highest id
     * 
     * @param id
     * @return the element with highest id
     * @throws IOEmptyTableException 
     */
    public abstract T last() throws IOEmptyTableException;

    /**
     * This operation find the element with lowest id
     *
     * @param id
     * @return the element with lowest id
     * @throws IOEmptyTableException 
     */
    public abstract T first() throws IOEmptyTableException;

    /**
     * This operation find element by id
     *
     * @param id
     * @return the element where id is equals the param val
     * @throws IOEmptyTableException 
     */
    public abstract T find(String id) throws IOEmptyTableException;

    /**
     * This operation will load, to memory, all elements with a same type.
     *
     * @return the List with elements. If there isn't any element in database, 
     * will return null list
     */
    public abstract List<T> loadAll() throws IOEmptyTableException;

    /**
     * This operation will save this element in database.
     *
     * @param obj
     * @return True, in positive case
     */
    public abstract boolean save(T obj) throws IODataExistingException;
    
    /**
     * This operation will update this element in database
     * 
     * @param obj
     * @return True, in positive case
     * @throws IONotFoundDataException 
     */
    public abstract boolean update(T obj) throws IONotFoundDataException;

    /**
     * This operation will delete this element in database
     * @param id
     * @return True, in positive case
     * @throws IONotFoundDataException if there is not in database 
     */
    public abstract boolean delete(String id) throws IONotFoundDataException;
    
    /**
     * This operation will delete all elements the database table
     */
    public abstract void clear();

}
