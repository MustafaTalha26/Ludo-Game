/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileorg;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mustafa
 */
public class Reading {
    String filename = "log.txt";
    int count = 0;
    public Reading() {
        try{
            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null)   { 
                count++;              
            }
        }
        catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
    public String[][] getString() {
        String[][] list = new String[this.count][3];
        int top = 0;
        try{
            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null)   {
                strLine = strLine + ' ';
                String word = "";
                int tetris = 0;
                for(int z = 0; z < strLine.length(); z++) {
                    if(strLine.charAt(z) != ' ') {
                        word += strLine.charAt(z);
                    }
                    if(strLine.charAt(z) == ' ') {
                        list[top][tetris] = word;
                        tetris++;
                        word = "";
                    }
                }
                top++;
            }
        }
        catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }
        return list;
    }
}
