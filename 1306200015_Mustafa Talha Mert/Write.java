/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileorg;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Mustafa
 */
public class Write {
    FileWriter fw = null;
    BufferedWriter bw = null;
    PrintWriter pw = null;
    String text;
    Write(String text) throws IOException{
        try {
            fw = new FileWriter("log.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(text);
            pw.flush();
        } 
        finally {
            try {
                pw.close();
                bw.close();
                fw.close();
            } 
            catch (IOException io) {
                System.out.println("hata");
            }
        }
    }
    public void sil() {
        try {
            FileWriter myWriter = new FileWriter("log.txt");
            myWriter.write("");
            myWriter.close();
            System.out.println("Successfully refreshed the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
