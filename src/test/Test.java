/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author fabio
 */
public class Test {
    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar();
        long tempo = calendar.get(Calendar.HOUR)*360 + calendar.get(Calendar.MINUTE)*60 + calendar.get(Calendar.SECOND);
        System.out.println(calendar.get(Calendar.HOUR)*360 + calendar.get(Calendar.MINUTE)*60 + calendar.get(Calendar.SECOND)); 
    }
}
