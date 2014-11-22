/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.player;

/**
 *
 * @author fabio
 */
public class CharacterAtributes {
    private int force;

    private int resistence;

    private int agility;

    private int inteligence;

    public CharacterAtributes(int force, int resistence, int agility, int inteligence) {
        this.force = force;
        this.resistence = resistence;
        this.agility = agility;
        this.inteligence = inteligence;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getResistence() {
        return resistence;
    }

    public void setResistence(int resistence) {
        this.resistence = resistence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getInteligence() {
        return inteligence;
    }

    public void setInteligence(int inteligence) {
        this.inteligence = inteligence;
    }
    
    public boolean checkAtributes(CharacterAtributes atb){
       return atb.getForce()<=force && atb.getResistence()<= resistence && atb.getAgility()<= agility && atb.getInteligence() <= inteligence;
   }
}
