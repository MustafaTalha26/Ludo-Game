/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileorg;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mustafa
 */
public class Second {
    JFrame frame;
    JPanel panel;
    
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    
    public int SavedGame;
    
    ImageIcon[] anon;
    ImageIcon[] zarke;
    public JLabel[] pieces;
    public JLabel[] safes;
    JLabel[] deeps;
    JLabel turn;
    JLabel zar;
    
    public Pawns[] pawns;
    Second(String[][] oyuncu,int SavedGame) {
        this.SavedGame = SavedGame;
        frame = new JFrame();
        panel = new JPanel();
        button1 = new JButton("1. Piyonu oynat");
        button2 = new JButton("2. Piyonu oynat");
        button3 = new JButton("3. Piyonu oynat");
        button4 = new JButton("4. Piyonu oynat");
        button5 = new JButton("Pas geç");
        zar = new JLabel();
        pieces = new JLabel[40];
        
        zar.setBounds(40, 40, 160, 160);
        zarke = new ImageIcon[6];
        zarke[0] = new ImageIcon("1.jpg");
        zarke[1] = new ImageIcon("2.jpg");
        zarke[2] = new ImageIcon("3.jpg");
        zarke[3] = new ImageIcon("4.jpg");
        zarke[4] = new ImageIcon("5.jpg");
        zarke[5] = new ImageIcon("6.jpg");
        
        
        pawns = new Pawns[16];
        for (int i = 0; i < 16; i++) {
            pawns[i] = new Pawns();
            pawns[i].index = -1;
        }
        int counter = 1;
        for (int i = 0; i < 4; i++) {
            pawns[i].color = "K";
            pawns[i].number = counter++;
            pawns[i].level = 0;
        }
        counter = 1;
        for (int i = 4; i < 8; i++) {
            pawns[i].color = "M";
            pawns[i].number = counter++;
            pawns[i].level = 10;
        }
        counter = 1;
        for (int i = 8; i < 12; i++) {
            pawns[i].color = "S";
            pawns[i].number = counter++;
            pawns[i].level = 20;
        }
        counter = 1;
        for (int i = 12; i < 16; i++) {
            pawns[i].color = "Y";
            pawns[i].number = counter++;
            pawns[i].level = 30;
        }
        
        LineBorder border = new LineBorder(Color.black, 2);
        LineBorder redborder = new LineBorder(Color.red, 2);
        LineBorder blueborder = new LineBorder(Color.blue, 2);
        LineBorder yellowborder = new LineBorder(Color.yellow, 2);
        LineBorder greenborder = new LineBorder(Color.green, 2);
        
        Random sıralama = new Random();
        if(oyuncu.length == 2) {
            int x = sıralama.nextInt(2);
            x += 1;
            String temp;
            if(x == 1) {
                temp = oyuncu[0][0];
                oyuncu[0][0] = oyuncu[1][0];
                oyuncu[1][0] = temp;
                temp = oyuncu[0][1];
                oyuncu[0][1] = oyuncu[1][1];
                oyuncu[1][1] = temp;
            }
        }
        if(oyuncu.length == 3) {
            int x = sıralama.nextInt(6);
            x += 1;
            String temp;
            int d = 0;
            for (int i = 0; i < x; i++) {
                if(d == 0) {
                    temp = oyuncu[0][0];
                    oyuncu[0][0] = oyuncu[1][0];
                    oyuncu[1][0] = temp;
                    temp = oyuncu[0][1];
                    oyuncu[0][1] = oyuncu[1][1];
                    oyuncu[1][1] = temp;
                    d = 1;
                }
                else {
                    temp = oyuncu[1][0];
                    oyuncu[1][0] = oyuncu[2][0];
                    oyuncu[2][0] = temp;
                    temp = oyuncu[1][1];
                    oyuncu[1][1] = oyuncu[2][1];
                    oyuncu[2][1] = temp;
                    d = 0;
                }
            }
        }
        if(oyuncu.length == 4) {
            int x = sıralama.nextInt(24);
            x += 1;
            String temp;
            int d = 0;
            for (int i = 0; i < x; i++) {
                if(d == 0) {
                    temp = oyuncu[0][0];
                    oyuncu[0][0] = oyuncu[1][0];
                    oyuncu[1][0] = temp;
                    temp = oyuncu[0][1];
                    oyuncu[0][1] = oyuncu[1][1];
                    oyuncu[1][1] = temp;
                    d = 1;
                }
                else if(d == 1){
                    temp = oyuncu[1][0];
                    oyuncu[1][0] = oyuncu[2][0];
                    oyuncu[2][0] = temp;
                    temp = oyuncu[1][1];
                    oyuncu[1][1] = oyuncu[2][1];
                    oyuncu[2][1] = temp;
                    d = 2;
                }
                else if(d == 2){
                    temp = oyuncu[2][0];
                    oyuncu[2][0] = oyuncu[3][0];
                    oyuncu[3][0] = temp;
                    temp = oyuncu[2][1];
                    oyuncu[2][1] = oyuncu[3][1];
                    oyuncu[3][1] = temp;
                    d = 0;
                }
            }
        }
        for (int i = 0; i < 40; i++) {
            pieces[i] = new JLabel();
            pieces[i].setBackground(Color.white);
            pieces[i].setBorder(border);
        }
        pieces[0].setBorder(redborder);
        pieces[10].setBorder(blueborder);
        pieces[20].setBorder(yellowborder);
        pieces[30].setBorder(greenborder);
        pieces[0].setBounds(640,20,40,40);
        pieces[1].setBounds(640,70,40,40);
        pieces[2].setBounds(640,120,40,40);
        pieces[3].setBounds(640,170,40,40);
        pieces[4].setBounds(640,220,40,40);
        pieces[5].setBounds(690,220,40,40);
        pieces[6].setBounds(740,220,40,40);
        pieces[7].setBounds(790,220,40,40);
        pieces[8].setBounds(840,220,40,40);
        pieces[9].setBounds(840,270,40,40);
        pieces[10].setBounds(840,320,40,40);
        pieces[11].setBounds(790,320,40,40);
        pieces[12].setBounds(740,320,40,40);
        pieces[13].setBounds(690,320,40,40);
        pieces[14].setBounds(640,320,40,40);
        pieces[15].setBounds(640,370,40,40);
        pieces[16].setBounds(640,420,40,40);
        pieces[17].setBounds(640,470,40,40);
        pieces[18].setBounds(640,520,40,40);
        pieces[19].setBounds(590,520,40,40);
        pieces[20].setBounds(540,520,40,40);
        pieces[21].setBounds(540,470,40,40);
        pieces[22].setBounds(540,420,40,40);
        pieces[23].setBounds(540,370,40,40);
        pieces[24].setBounds(540,320,40,40);
        pieces[25].setBounds(490,320,40,40);
        pieces[26].setBounds(440,320,40,40);
        pieces[27].setBounds(390,320,40,40);
        pieces[28].setBounds(340,320,40,40);
        pieces[29].setBounds(340,270,40,40);
        pieces[30].setBounds(340,220,40,40);
        pieces[31].setBounds(390,220,40,40);
        pieces[32].setBounds(440,220,40,40);
        pieces[33].setBounds(490,220,40,40);
        pieces[34].setBounds(540,220,40,40);
        pieces[35].setBounds(540,170,40,40);
        pieces[36].setBounds(540,120,40,40);
        pieces[37].setBounds(540,70,40,40);
        pieces[38].setBounds(540,20,40,40);
        pieces[39].setBounds(590,20,40,40);
        safes= new JLabel[16];
        for (int i = 0; i < 16; i++) {
            safes[i] = new JLabel();
        }
        safes[0].setBounds(590,70,40,40);
        safes[1].setBounds(590,120,40,40);
        safes[2].setBounds(590,170,40,40);
        safes[3].setBounds(590,220,40,40);
        for (int i = 0; i < 4; i++) {
            safes[i].setBackground(Color.red);
            safes[i].setBorder(redborder);
        }
        safes[4].setBounds(790,270,40,40);
        safes[5].setBounds(740,270,40,40);
        safes[6].setBounds(690,270,40,40);
        safes[7].setBounds(640,270,40,40);
        for (int i = 4; i < 8; i++) {
            safes[i].setBackground(Color.blue);
            safes[i].setBorder(blueborder);
        }
        safes[8].setBounds(590,470,40,40);
        safes[9].setBounds(590,420,40,40);
        safes[10].setBounds(590,370,40,40);
        safes[11].setBounds(590,320,40,40);
        for (int i = 8; i < 12; i++) {
            safes[i].setBackground(Color.yellow);
            safes[i].setBorder(yellowborder);
        }
        safes[12].setBounds(390,270,40,40);
        safes[13].setBounds(440,270,40,40);
        safes[14].setBounds(490,270,40,40);
        safes[15].setBounds(540,270,40,40);
        for (int i = 12; i < 16; i++) {
            safes[i].setBackground(Color.green);
            safes[i].setBorder(greenborder);
        }
        deeps = new JLabel[16];
        for (int i = 0; i < 4; i++) {
            deeps[i] = new JLabel();
            deeps[i].setBackground(Color.white);
            deeps[i].setBorder(redborder);
        }
        for (int i = 4; i < 8; i++) {
            deeps[i] = new JLabel();
            deeps[i].setBackground(Color.white);
            deeps[i].setBorder(blueborder);
        }
        for (int i = 8; i < 12; i++) {
            deeps[i] = new JLabel();
            deeps[i].setBackground(Color.white);
            deeps[i].setBorder(yellowborder);
        }
        for (int i = 12; i < 16; i++) {
            deeps[i] = new JLabel();
            deeps[i].setBackground(Color.white);
            deeps[i].setBorder(greenborder);
        }
        deeps[1].setBounds(840,20,40,40);
        deeps[0].setBounds(790,20,40,40);
        deeps[3].setBounds(840,70,40,40);
        deeps[2].setBounds(790,70,40,40);
        
        deeps[7].setBounds(840, 520, 40, 40);
        deeps[5].setBounds(840, 470, 40, 40);
        deeps[6].setBounds(790, 520, 40, 40);
        deeps[4].setBounds(790, 470, 40, 40);
        
        deeps[10].setBounds(340, 520, 40, 40);
        deeps[11].setBounds(390, 520, 40, 40);
        deeps[8].setBounds(340, 470, 40, 40);
        deeps[9].setBounds(390, 470, 40, 40);
        
        deeps[12].setBounds(340, 20, 40, 40);
        deeps[13].setBounds(390, 20, 40, 40);
        deeps[14].setBounds(340, 70, 40, 40);
        deeps[15].setBounds(390, 70, 40, 40);
        
        anon = new ImageIcon[16];  
        anon[0] = new ImageIcon("K1.png");
        anon[1] = new ImageIcon("K2.png");
        anon[2] = new ImageIcon("K3.png");
        anon[3] = new ImageIcon("K4.png");
        anon[4] = new ImageIcon("M1.png");
        anon[5] = new ImageIcon("M2.png");
        anon[6] = new ImageIcon("M3.png");
        anon[7] = new ImageIcon("M4.png");
        anon[8] = new ImageIcon("S1.png");
        anon[9] = new ImageIcon("S2.png");
        anon[10] = new ImageIcon("S3.png");
        anon[11] = new ImageIcon("S4.png");
        anon[12] = new ImageIcon("Y1.png");
        anon[13] = new ImageIcon("Y2.png");
        anon[14] = new ImageIcon("Y3.png");
        anon[15] = new ImageIcon("Y4.png");
        for (int i = 0; i < 16; i++) {
            Image image = anon[i].getImage().getScaledInstance(38, 40, Image.SCALE_SMOOTH);
            anon[i] = new ImageIcon(image);
        }
        for (int i = 0; i < 16; i++) {
            deeps[i].setIcon(anon[i]);
        }
        
        turn = new JLabel();
        turn.setBounds(40, 200, 250, 30);
        turn.setText(oyuncu[0][0] + " ile başlıyoruz");
        
        frame.setSize(1200, 620);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Ludo Game");
        
        Random zarsayi = new Random();
        zar.setIcon(zarke[0]);
        if(SavedGame == 0) {
            try {
                new Write("Start " + oyuncu.length);
                for (int i = 0; i < oyuncu.length; i++) {
                    new Write(oyuncu[i][1] + " "+ oyuncu[i][0]);
                }
            }
            catch (IOException ex) {
                System.out.println("hata");
            } 
        }
        class AL implements ActionListener {
            int zarnum = 0;
            int status = 0;
            int faul = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == button1) {
                    for (int i = 0; i < 4; i++) {
                        if(oyuncu[status][1].equals(pawns[i*4].color)) {
                            if(zarnum+1==6 && pawns[i*4].index == -1) {
                                if(pieces[pawns[i*4].level].getIcon() != null) {
                                    for (int j = 0; j < 16; j++) {
                                        if(pawns[j].index == pawns[i*4].level && pawns[i*4].color.equals(pawns[j].color)) {
                                            faul = 1;
                                        }
                                        else if(pawns[j].index == pawns[i*4].level && !pawns[i*4].color.equals(pawns[j].color)) {
                                            pieces[pawns[i*4].level].setIcon(anon[i*4]);
                                            pawns[j].index = -1;
                                            pawns[i*4].index = pawns[i*4].level;
                                            pawns[i*4].road = 0;
                                            System.out.println("EAT " + pawns[i*4].color + "1 " + pawns[j].color + (j%4+1));
                                            try {
                                                new Write("EAT " + pawns[i*4].color + "1 " + pawns[j].color + (j%4+1));
                                            }
                                            catch (IOException ex) {
                                                System.out.println("hata");
                                            }
                                        }
                                    }
                                }
                                else {
                                    pieces[pawns[i*4].level].setIcon(anon[i*4]);
                                    pawns[i*4].index = pawns[i*4].level;
                                    pawns[i*4].road = 0;
                                    try {
                                        new Write("MOV " + pawns[i*4].color + "1 " + pawns[i*4].index);
                                    }
                                    catch (IOException ex) {
                                        System.out.println("hata");
                                    }
                                    System.out.println("MOV " + pawns[i*4].color + "1 " + pawns[i*4].index);
                                }
                            }
                            else if(zarnum+1!=6 && pawns[i*4].index == -1) {
                                faul = 1;
                            }
                            else if(pawns[i*4].index != -1) {
                                if(pawns[i*4].road + zarnum+1 >= 40) {
                                    if(pawns[i*4].road + zarnum-39 > 3) {
                                        faul = 1;
                                    }
                                    else if(pawns[i*4].road + zarnum-39 <= 3){
                                        if(safes[i*4 + pawns[i*4].road + zarnum-39].getIcon() == null) {
                                            pieces[pawns[i*4].index].setIcon(null);
                                            safes[i*4 + pawns[i*4].road + zarnum-39].setIcon(anon[i*4]);
                                            pawns[i*4].index = -2;
                                            try {
                                                new Write("SFE " + pawns[i*4].color + "1 " + (pawns[i*4].road + zarnum - 38));
                                            }
                                            catch (IOException ex) {
                                                System.out.println("hata");
                                            }
                                            System.out.println("SFE " + pawns[i*4].color + "1 " + (pawns[i*4].road + zarnum - 38));
                                            pawns[i*4].road = 100;
                                        }
                                        else {
                                            faul = 1;
                                        }
                                    }       
                                }
                                else if(zarnum+1+pawns[i*4].index >= 40) {
                                    if(pieces[zarnum-39+pawns[i*4].index].getIcon() != null) {
                                        for (int j = 0; j < 16; j++) {
                                            if(pawns[j].color.equals(pawns[i*4].color) && zarnum-39+pawns[i*4].index == pawns[j].index){
                                                faul = 1;
                                            }
                                            else if(!pawns[j].color.equals(pawns[i*4].color) && zarnum-39+pawns[i*4].index == pawns[j].index){
                                                pieces[pawns[j].index].setIcon(null);
                                                pawns[j].index = -1;
                                                pieces[pawns[i*4].index].setIcon(null);
                                                pieces[pawns[i*4].index+zarnum-39].setIcon(anon[i*4]);
                                                pawns[i*4].index = pawns[i*4].index+zarnum-39;
                                                pawns[i*4].road += zarnum+1;
                                                try {
                                                    new Write("EAT " + pawns[i*4].color + "1 " + pawns[j].color + (j%4+1));
                                                }
                                                catch (IOException ex) {
                                                    System.out.println("hata");
                                                }
                                                System.out.println("EAT " + pawns[i*4].color + "1 " + pawns[j].color + (j%4+1));
                                            }
                                        }
                                    }
                                    else {
                                        pieces[pawns[i*4].index].setIcon(null);
                                        pieces[pawns[i*4].index+zarnum-39].setIcon(anon[i*4]);
                                        pawns[i*4].index = pawns[i*4].index+zarnum-39;
                                        pawns[i*4].road += zarnum+1;
                                        try {
                                            new Write("MOV " + pawns[i*4].color + "1 " + pawns[i*4].index);
                                        }
                                        catch (IOException ex) {
                                            System.out.println("hata");
                                        }
                                        System.out.println("MOV " + pawns[i*4].color + "1 " + pawns[i*4].index);
                                    }
                                }
                                else if(zarnum+1+pawns[i*4].index < 40) {
                                    if(pieces[zarnum+1+pawns[i*4].index].getIcon() != null) {
                                        for (int j = 0; j < 16; j++) {
                                            if(pawns[j].color.equals(pawns[i*4].color) && zarnum+1+pawns[i*4].index == pawns[j].index){
                                                faul = 1;
                                            }
                                            else if(!pawns[j].color.equals(pawns[i*4].color) && zarnum+1+pawns[i*4].index == pawns[j].index){
                                                pieces[pawns[j].index].setIcon(null);
                                                pawns[j].index = -1;
                                                pieces[pawns[i*4].index].setIcon(null);
                                                pieces[pawns[i*4].index+zarnum+1].setIcon(anon[i*4]);
                                                pawns[i*4].index = pawns[i*4].index+zarnum+1;
                                                pawns[i*4].road += zarnum+1;
                                                try {
                                                    new Write("EAT " + pawns[i*4].color + "1 " + pawns[j].color + (j%4+1));
                                                }
                                                catch (IOException ex) {
                                                    System.out.println("hata");
                                                }
                                                System.out.println("EAT " + pawns[i*4].color + "1 " + pawns[j].color + (j%4+1));
                                            }
                                        }
                                    }
                                    else {
                                        pieces[pawns[i*4].index].setIcon(null);
                                        pieces[pawns[i*4].index+zarnum+1].setIcon(anon[i*4]);
                                        pawns[i*4].index = pawns[i*4].index+zarnum+1;
                                        pawns[i*4].road += zarnum+1;
                                        try {
                                            new Write("MOV " + pawns[i*4].color + "1 " + pawns[i*4].index);
                                        }
                                        catch (IOException ex) {
                                            System.out.println("hata");
                                        }
                                        System.out.println("MOV " + pawns[i*4].color + "1 " + pawns[i*4].index);
                                    }
                                }
                            }
                        }
                    }
                }
                /////////////////////////////////////////////////////////////////////////////////////////////
                if(e.getSource() == button2) {
                    for (int i = 0; i < 4; i++) {
                        if(oyuncu[status][1].equals(pawns[i*4+1].color)) {
                            if(zarnum+1==6 && pawns[i*4+1].index == -1) {
                                if(pieces[pawns[i*4+1].level].getIcon() != null) {
                                    for (int j = 0; j < 16; j++) {
                                        if(pawns[j].index == pawns[i*4+1].level && pawns[i*4+1].color.equals(pawns[j].color)) {
                                            faul = 1;
                                        }
                                        else if(pawns[j].index == pawns[i*4+1].level && !pawns[i*4+1].color.equals(pawns[j].color)) {
                                            pieces[pawns[i*4+1].level].setIcon(anon[i*4+1]);
                                            pawns[j].index = -1;
                                            pawns[i*4+1].index = pawns[i*4+1].level;
                                            pawns[i*4+1].road = 0;
                                            try {
                                                new Write("EAT " + pawns[i*4+1].color + "2 " + pawns[j].color + (j%4+1));
                                            } catch (IOException ex) {
                                                System.out.println("hata");
                                            }
                                            System.out.println("EAT " + pawns[i*4+1].color + "2 " + pawns[j].color + (j%4+1));
                                        }
                                    }
                                }
                                else {
                                    pieces[pawns[i*4+1].level].setIcon(anon[i*4+1]);
                                    pawns[i*4+1].index = pawns[i*4+1].level;
                                    pawns[i*4+1].road = 0;
                                    try {
                                        new Write("MOV " + pawns[i*4+1].color + "2 " + pawns[i*4+1].index);
                                    } catch (IOException ex) {
                                        System.out.println("hata");
                                    }
                                    System.out.println("MOV " + pawns[i*4+1].color + "2 " + pawns[i*4+1].index);
                                }
                            }
                            else if(zarnum+1!=6 && pawns[i*4+1].index == -1) {
                                faul = 1;
                            }
                            else if(pawns[i*4+1].index != -1) {
                                if(pawns[i*4+1].road + zarnum+1 >= 40) {
                                    if(pawns[i*4+1].road + zarnum-39 > 3) {
                                        faul = 1;
                                    }
                                    else if(pawns[i*4+1].road + zarnum-39 <= 3){
                                        if(safes[i*4 + pawns[i*4+1].road + zarnum-39].getIcon() == null) {
                                            pieces[pawns[i*4+1].index].setIcon(null);
                                            safes[i*4 + pawns[i*4+1].road + zarnum-39].setIcon(anon[i*4+1]);
                                            pawns[i*4+1].index = -2;
                                            try {
                                                new Write("SFE " + pawns[i*4+1].color + "2 " + (pawns[i*4+1].road + zarnum - 38));
                                            } catch (IOException ex) {
                                                System.out.println("hata");
                                            }
                                            System.out.println("SFE " + pawns[i*4+1].color + "2 " + (pawns[i*4+1].road + zarnum - 38));
                                            pawns[i*4+1].road = 100;
                                        }
                                        else {
                                            faul = 1;
                                        }
                                    }       
                                }
                                else if(zarnum+1+pawns[i*4+1].index >= 40) {
                                    if(pieces[zarnum-39+pawns[i*4+1].index].getIcon() != null) {
                                        for (int j = 0; j < 16; j++) {
                                            if(pawns[j].color.equals(pawns[i*4+1].color) && zarnum-39+pawns[i*4+1].index == pawns[j].index){
                                                faul = 1;
                                            }
                                            else if(!pawns[j].color.equals(pawns[i*4+1].color) && zarnum-39+pawns[i*4+1].index == pawns[j].index){
                                                pieces[pawns[j].index].setIcon(null);
                                                pawns[j].index = -1;
                                                pieces[pawns[i*4+1].index].setIcon(null);
                                                pieces[pawns[i*4+1].index+zarnum-39].setIcon(anon[i*4+1]);
                                                pawns[i*4+1].index = pawns[i*4+1].index+zarnum-39;
                                                pawns[i*4+1].road += zarnum+1;
                                                try {
                                                    new Write("EAT " + pawns[i*4+1].color + "2 " + pawns[j].color + (j%4+1));
                                                } catch (IOException ex) {
                                                    System.out.println("hata");
                                                }
                                                System.out.println("EAT " + pawns[i*4+1].color + "2 " + pawns[j].color + (j%4+1));
                                            }
                                        }
                                    }
                                    else {
                                        pieces[pawns[i*4+1].index].setIcon(null);
                                        pieces[pawns[i*4+1].index+zarnum-39].setIcon(anon[i*4+1]);
                                        pawns[i*4+1].index = pawns[i*4+1].index+zarnum-39;
                                        pawns[i*4+1].road += zarnum+1;
                                        try {
                                            new Write("MOV " + pawns[i*4+1].color + "2 " + pawns[i*4+1].index);
                                        } catch (IOException ex) {
                                            System.out.println("hata");
                                        }
                                        System.out.println("MOV " + pawns[i*4+1].color + "2 " + pawns[i*4+1].index);
                                    }
                                }
                                else if(zarnum+1+pawns[i*4+1].index < 40) {
                                    if(pieces[zarnum+1+pawns[i*4+1].index].getIcon() != null) {
                                        for (int j = 0; j < 16; j++) {
                                            if(pawns[j].color.equals(pawns[i*4+1].color) && zarnum+1+pawns[i*4+1].index == pawns[j].index){
                                                faul = 1;
                                            }
                                            else if(!pawns[j].color.equals(pawns[i*4+1].color) && zarnum+1+pawns[i*4+1].index == pawns[j].index){
                                                pieces[pawns[j].index].setIcon(null);
                                                pawns[j].index = -1;
                                                pieces[pawns[i*4+1].index].setIcon(null);
                                                pieces[pawns[i*4+1].index+zarnum+1].setIcon(anon[i*4+1]);
                                                pawns[i*4+1].index = pawns[i*4+1].index+zarnum+1;
                                                pawns[i*4+1].road += zarnum+1;
                                                try {
                                                    new Write("EAT " + pawns[i*4+1].color + "2 " + pawns[j].color + (j%4+1));
                                                } catch (IOException ex) {
                                                    System.out.println("hata");
                                                }
                                                System.out.println("EAT " + pawns[i*4+1].color + "2 " + pawns[j].color + (j%4+1));
                                            }
                                        }
                                    }
                                    else {
                                        pieces[pawns[i*4+1].index].setIcon(null);
                                        pieces[pawns[i*4+1].index+zarnum+1].setIcon(anon[i*4+1]);
                                        pawns[i*4+1].index = pawns[i*4+1].index+zarnum+1;
                                        pawns[i*4+1].road += zarnum+1;
                                        try {
                                            new Write("MOV " + pawns[i*4+1].color + "2 " + pawns[i*4+1].index);
                                        } catch (IOException ex) {
                                            System.out.println("hata");
                                        }
                                        System.out.println("MOV " + pawns[i*4+1].color + "2 " + pawns[i*4+1].index);
                                    }
                                }
                            }
                        }
                    }
                }
                /////////////////////////////////////////////////////////////////////////////////////////////
                if(e.getSource() == button3) {
                    for (int i = 0; i < 4; i++) {
                        if(oyuncu[status][1].equals(pawns[i*4+2].color)) {
                            if(zarnum+1==6 && pawns[i*4+2].index == -1) {
                                if(pieces[pawns[i*4+2].level].getIcon() != null) {
                                    for (int j = 0; j < 16; j++) {
                                        if(pawns[j].index == pawns[i*4+2].level && pawns[i*4+2].color.equals(pawns[j].color)) {
                                            faul = 1;
                                        }
                                        else if(pawns[j].index == pawns[i*4+2].level && !pawns[i*4+2].color.equals(pawns[j].color)) {
                                            pieces[pawns[i*4+2].level].setIcon(anon[i*4+2]);
                                            pawns[j].index = -1;
                                            pawns[i*4+2].index = pawns[i*4+2].level;
                                            pawns[i*4+2].road = 0;
                                            try {
                                                new Write("EAT " + pawns[i*4+2].color + "3 " + pawns[j].color + (j%4+1));
                                            } catch (IOException ex) {
                                                System.out.println("hata");
                                            }
                                            System.out.println("EAT " + pawns[i*4+2].color + "3 " + pawns[j].color + (j%4+1));
                                        }
                                    }
                                }
                                else {
                                    pieces[pawns[i*4+2].level].setIcon(anon[i*4+2]);
                                    pawns[i*4+2].index = pawns[i*4+2].level;
                                    pawns[i*4+2].road = 0;
                                    try {
                                        new Write("MOV " + pawns[i*4+2].color + "3 " + pawns[i*4+2].index);
                                    } catch (IOException ex) {
                                        System.out.println("hata");
                                    }
                                    System.out.println("MOV " + pawns[i*4+2].color + "3 " + pawns[i*4+2].index);
                                }
                            }
                            else if(zarnum+1!=6 && pawns[i*4+2].index == -1) {
                                faul = 1;
                            }
                            else if(pawns[i*4+2].index != -1) {
                                if(pawns[i*4+2].road + zarnum+1 >= 40) {
                                    if(pawns[i*4+2].road + zarnum-39 > 3) {
                                        faul = 1;
                                    }
                                    else if(pawns[i*4+2].road + zarnum-39 <= 3){
                                        if(safes[i*4 + pawns[i*4+2].road + zarnum-39].getIcon() == null) {
                                            pieces[pawns[i*4+2].index].setIcon(null);
                                            safes[i*4 + pawns[i*4+2].road + zarnum-39].setIcon(anon[i*4+2]);
                                            pawns[i*4+2].index = -2;
                                            try {
                                                new Write("SFE " + pawns[i*4+2].color + "3 " + (pawns[i*4+2].road + zarnum - 38));
                                            } catch (IOException ex) {
                                                System.out.println("hata");
                                            }
                                            System.out.println("SFE " + pawns[i*4+2].color + "3 " + (pawns[i*4+2].road + zarnum - 38));
                                            pawns[i*4+2].road = 100;
                                        }
                                        else {
                                            faul = 1;
                                        }
                                    }       
                                }
                                else if(zarnum+1+pawns[i*4+2].index >= 40) {
                                    if(pieces[zarnum-39+pawns[i*4+2].index].getIcon() != null) {
                                        for (int j = 0; j < 16; j++) {
                                            if(pawns[j].color.equals(pawns[i*4+2].color) && zarnum-39+pawns[i*4+2].index == pawns[j].index){
                                                faul = 1;
                                            }
                                            else if(!pawns[j].color.equals(pawns[i*4+2].color) && zarnum-39+pawns[i*4+2].index == pawns[j].index){
                                                pieces[pawns[j].index].setIcon(null);
                                                pawns[j].index = -1;
                                                pieces[pawns[i*4+2].index].setIcon(null);
                                                pieces[pawns[i*4+2].index+zarnum-39].setIcon(anon[i*4+2]);
                                                pawns[i*4+2].index = pawns[i*4+2].index+zarnum-39;
                                                pawns[i*4+2].road += zarnum+1;
                                                try {
                                                    new Write("EAT " + pawns[i*4+2].color + "3 " + pawns[j].color + (j%4+1));
                                                } catch (IOException ex) {
                                                    System.out.println("hata");
                                                }
                                                System.out.println("EAT " + pawns[i*4+2].color + "3 " + pawns[j].color + (j%4+1));
                                            }
                                        }
                                    }
                                    else {
                                        pieces[pawns[i*4+2].index].setIcon(null);
                                        pieces[pawns[i*4+2].index+zarnum-39].setIcon(anon[i*4+2]);
                                        pawns[i*4+2].index = pawns[i*4+2].index+zarnum-39;
                                        pawns[i*4+2].road += zarnum+1;
                                        try {
                                            new Write("MOV " + pawns[i*4+2].color + "3 " + pawns[i*4+2].index);
                                        } catch (IOException ex) {
                                            System.out.println("hata");
                                        }
                                        System.out.println("MOV " + pawns[i*4+2].color + "3 " + pawns[i*4+2].index);
                                    }
                                }
                                else if(zarnum+1+pawns[i*4+2].index < 40) {
                                    if(pieces[zarnum+1+pawns[i*4+2].index].getIcon() != null) {
                                        for (int j = 0; j < 16; j++) {
                                            if(pawns[j].color.equals(pawns[i*4+2].color) && zarnum+1+pawns[i*4+2].index == pawns[j].index){
                                                faul = 1;
                                            }
                                            else if(!pawns[j].color.equals(pawns[i*4+2].color) && zarnum+1+pawns[i*4+2].index == pawns[j].index){
                                                pieces[pawns[j].index].setIcon(null);
                                                pawns[j].index = -1;
                                                pieces[pawns[i*4+2].index].setIcon(null);
                                                pieces[pawns[i*4+2].index+zarnum+1].setIcon(anon[i*4+2]);
                                                pawns[i*4+2].index = pawns[i*4+2].index+zarnum+1;
                                                pawns[i*4+2].road += zarnum+1;
                                                try {
                                                    new Write("EAT " + pawns[i*4+2].color + "3 " + pawns[j].color + (j%4+1));
                                                } catch (IOException ex) {
                                                    System.out.println("hata");
                                                }
                                                System.out.println("EAT " + pawns[i*4+2].color + "3 " + pawns[j].color + (j%4+1));
                                            }
                                        }
                                    }
                                    else {
                                        pieces[pawns[i*4+2].index].setIcon(null);
                                        pieces[pawns[i*4+2].index+zarnum+1].setIcon(anon[i*4+2]);
                                        pawns[i*4+2].index = pawns[i*4+2].index+zarnum+1;
                                        pawns[i*4+2].road += zarnum+1;
                                        try {
                                            new Write("MOV " + pawns[i*4+2].color + "3 " + pawns[i*4+2].index);
                                        } catch (IOException ex) {
                                            System.out.println("hata");
                                        }
                                        System.out.println("MOV " + pawns[i*4+2].color + "3 " + pawns[i*4+2].index);
                                    }
                                }
                            }
                        }
                    }
                }
                /////////////////////////////////////////////////////////////////////////////////////////////
                if(e.getSource() == button4) {
                    for (int i = 0; i < 4; i++) {
                        if(oyuncu[status][1].equals(pawns[i*4+3].color)) {
                            if(zarnum+1==6 && pawns[i*4+3].index == -1) {
                                if(pieces[pawns[i*4+3].level].getIcon() != null) {
                                    for (int j = 0; j < 16; j++) {
                                        if(pawns[j].index == pawns[i*4+3].level && pawns[i*4+3].color.equals(pawns[j].color)) {
                                            faul = 1;
                                        }
                                        else if(pawns[j].index == pawns[i*4+3].level && !pawns[i*4+3].color.equals(pawns[j].color)) {
                                            pieces[pawns[i*4+3].level].setIcon(anon[i*4+3]);
                                            pawns[j].index = -1;
                                            pawns[i*4+3].index = pawns[i*4+3].level;
                                            pawns[i*4+3].road = 0;
                                            try {
                                                new Write("EAT " + pawns[i*4+3].color + "4 " + pawns[j].color + (j%4+1));
                                            } catch (IOException ex) {
                                                System.out.println("hata");
                                            }
                                            System.out.println("EAT " + pawns[i*4+3].color + "4 " + pawns[j].color + (j%4+1));
                                        }
                                    }
                                }
                                else {
                                    pieces[pawns[i*4+3].level].setIcon(anon[i*4+3]);
                                    pawns[i*4+3].index = pawns[i*4+3].level;
                                    pawns[i*4+3].road = 0;
                                    try {
                                        new Write("MOV " + pawns[i*4+3].color + "4 " + pawns[i*4+3].index);
                                    } catch (IOException ex) {
                                        System.out.println("hata");
                                    }
                                    System.out.println("MOV " + pawns[i*4+3].color + "4 " + pawns[i*4+3].index);
                                }
                            }
                            else if(zarnum+1!=6 && pawns[i*4+3].index == -1) {
                                faul = 1;
                            }
                            else if(pawns[i*4+3].index != -1) {
                                if(pawns[i*4+3].road + zarnum+1 >= 40) {
                                    if(pawns[i*4+3].road + zarnum-39 > 3) {
                                        faul = 1;
                                    }
                                    else if(pawns[i*4+3].road + zarnum-39 <= 3){
                                        if(safes[i*4 + pawns[i*4+3].road + zarnum-39].getIcon() == null) {
                                            pieces[pawns[i*4+3].index].setIcon(null);
                                            safes[i*4 + pawns[i*4+3].road + zarnum-39].setIcon(anon[i*4+3]);
                                            pawns[i*4+3].index = -2;
                                            try {
                                                new Write("SFE " + pawns[i*4+3].color + "4 " + (pawns[i*4+3].road + zarnum - 38));
                                            } catch (IOException ex) {
                                                System.out.println("hata");
                                            }
                                            System.out.println("SFE " + pawns[i*4+3].color + "4 " + (pawns[i*4+3].road + zarnum - 38));
                                            pawns[i*4+3].road = 100;
                                        }
                                        else {
                                            faul = 1;
                                        }
                                    }       
                                }
                                else if(zarnum+1+pawns[i*4+3].index >= 40) {
                                    if(pieces[zarnum-39+pawns[i*4+3].index].getIcon() != null) {
                                        for (int j = 0; j < 16; j++) {
                                            if(pawns[j].color.equals(pawns[i*4+3].color) && zarnum-39+pawns[i*4+3].index == pawns[j].index){
                                                faul = 1;
                                            }
                                            else if(!pawns[j].color.equals(pawns[i*4+3].color) && zarnum-39+pawns[i*4+3].index == pawns[j].index){
                                                pieces[pawns[j].index].setIcon(null);
                                                pawns[j].index = -1;
                                                pieces[pawns[i*4+3].index].setIcon(null);
                                                pieces[pawns[i*4+3].index+zarnum-39].setIcon(anon[i*4+3]);
                                                pawns[i*4+3].index = pawns[i*4+3].index+zarnum-39;
                                                pawns[i*4+3].road += zarnum+1;
                                                try {
                                                    new Write("EAT " + pawns[i*4+3].color + "4 " + pawns[j].color + (j%4+1));
                                                } catch (IOException ex) {
                                                    System.out.println("hata");
                                                }
                                                System.out.println("EAT " + pawns[i*4+3].color + "4 " + pawns[j].color + (j%4+1));
                                            }
                                        }
                                    }
                                    else {
                                        pieces[pawns[i*4+3].index].setIcon(null);
                                        pieces[pawns[i*4+3].index+zarnum-39].setIcon(anon[i*4+3]);
                                        pawns[i*4+3].index = pawns[i*4+3].index+zarnum-39;
                                        pawns[i*4+3].road += zarnum+1;
                                        try {
                                            new Write("MOV " + pawns[i*4+3].color + "4 " + pawns[i*4+3].index);
                                        } catch (IOException ex) {
                                            System.out.println("hata");
                                        }
                                        System.out.println("MOV " + pawns[i*4+3].color + "4 " + pawns[i*4+3].index);
                                    }
                                }
                                else if(zarnum+1+pawns[i*4+3].index < 40) {
                                    if(pieces[zarnum+1+pawns[i*4+3].index].getIcon() != null) {
                                        for (int j = 0; j < 16; j++) {
                                            if(pawns[j].color.equals(pawns[i*4+3].color) && zarnum+1+pawns[i*4+3].index == pawns[j].index){
                                                faul = 1;
                                            }
                                            else if(!pawns[j].color.equals(pawns[i*4+3].color) && zarnum+1+pawns[i*4+3].index == pawns[j].index){
                                                pieces[pawns[j].index].setIcon(null);
                                                pawns[j].index = -1;
                                                pieces[pawns[i*4+3].index].setIcon(null);
                                                pieces[pawns[i*4+3].index+zarnum+1].setIcon(anon[i*4+3]);
                                                pawns[i*4+3].index = pawns[i*4+3].index+zarnum+1;
                                                pawns[i*4+3].road += zarnum+1;
                                                try {
                                                    new Write("EAT " + pawns[i*4+3].color + "4 " + pawns[j].color + (j%4+1));
                                                } catch (IOException ex) {
                                                    System.out.println("hata");
                                                }
                                                System.out.println("EAT " + pawns[i*4+3].color + "4 " + pawns[j].color + (j%4+1));
                                            }
                                        }
                                    }
                                    else {
                                        pieces[pawns[i*4+3].index].setIcon(null);
                                        pieces[pawns[i*4+3].index+zarnum+1].setIcon(anon[i*4+3]);
                                        pawns[i*4+3].index = pawns[i*4+3].index+zarnum+1;
                                        pawns[i*4+3].road += zarnum+1;
                                        try {
                                            new Write("MOV " + pawns[i*4+3].color + "4 " + pawns[i*4+3].index);
                                        } catch (IOException ex) {
                                            System.out.println("hata");
                                        }
                                        System.out.println("MOV " + pawns[i*4+3].color + "4 " + pawns[i*4+3].index);
                                    }
                                }
                            }
                        }
                    }
                }
                if(faul == 0) {
                    if(zarnum+1 != 6) {
                        status++;
                    } 
                    if(status == oyuncu.length) {
                        status = 0;
                    }
                    zarnum = zarsayi.nextInt(6);
                    zar.setIcon(zarke[zarnum]);
                    turn.setText("Sıra " + oyuncu[status][0] + " adlı oyuncuda");
                    if(oyuncu[status][1].equals("K")) {
                        zar.setBorder(redborder);
                    }
                    if(oyuncu[status][1].equals("M")) {
                        zar.setBorder(blueborder);
                    }
                    if(oyuncu[status][1].equals("S")) {
                        zar.setBorder(yellowborder);
                    }
                    if(oyuncu[status][1].equals("Y")) {
                        zar.setBorder(greenborder);
                    }
                    System.out.println(oyuncu[status][0] + " adlı oyuncu oynadı");
                }
                else {
                    System.out.println("olmaz öyle");
                }
                faul = 0;
                int top = 0;
                for (int i = 0; i < 4; i++) {
                    if(pawns[i*4].index == -2) {
                        top++;
                    }
                    if(pawns[i*4+1].index == -2) {
                        top++;
                    }
                    if(pawns[i*4+2].index == -2) {
                        top++;
                    }
                    if(pawns[i*4+3].index == -2) {
                        top++;
                    }
                    if(top == 4) {
                        for (int j = 0; j < oyuncu.length; j++) {
                            if(oyuncu[j][1].equals(pawns[i*4].color)){
                                System.out.println(oyuncu[j][0] + " kazandı");
                                button1.setEnabled(false);
                                button2.setEnabled(false);
                                button3.setEnabled(false);
                                button4.setEnabled(false);
                                button5.setEnabled(false);
                                try {
                                    Write x = new Write("");
                                    x.sil();
                                } catch (IOException ex) {
                                    System.out.println("hata");
                                }
                            }
                        }
                    }
                    top =0;
                }
            }      
        }
        AL actionlistener = new AL();
        button1.setBounds(40, 240, 160, 50);
        button1.setFocusable(false);
        button1.addActionListener(actionlistener);
        
        button2.setBounds(40, 300, 160, 50);
        button2.setFocusable(false);
        button2.addActionListener(actionlistener);
        
        button3.setBounds(40, 360, 160, 50);
        button3.setFocusable(false);
        button3.addActionListener(actionlistener);
        
        button4.setBounds(40, 420, 160, 50);
        button4.setFocusable(false);
        button4.addActionListener(actionlistener);
        
        button5.setBounds(40, 480, 160, 50);
        button5.setFocusable(false);
        button5.addActionListener(actionlistener);
        
        panel.setLayout(null);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(turn);
        panel.add(zar);
        for (int i = 0; i < 40; i++) {
            panel.add(pieces[i]);
        }
        for (int i = 0; i < 16; i++) {
            panel.add(safes[i]);
        }
        for (int i = 0; i < 16; i++) {
            panel.add(deeps[i]);
        }
        panel.setBackground(new Color(220,220,240));
        
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
