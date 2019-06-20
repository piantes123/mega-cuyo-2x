package com.mega.cuyo.actores;

import java.io.BufferedWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cuyo extends ObjetoJuego{


    
    @Override
    public void atacar() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mover() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void saltar() {
        // TODO Auto-generated method stub
        
    }

    
    static String timeConversion(String s) throws ParseException {
        /*
         * Write your code here.
         */
        

        SimpleDateFormat format12 = new SimpleDateFormat("hh:mm:ssa");
        SimpleDateFormat format24 = new SimpleDateFormat("HH:mm:ss");

        Date date = format12.parse(s);
        String date24 = format24.format(date);    
        return date24;
    



    }
    
    

    public static void main(String[] args) throws IOException {
            String result = null;
        try{
            result = timeConversion("07:05:45pm");
        }catch(ParseException e){
            result = "";
        }
        
        System.out.println(result);
    }
}
