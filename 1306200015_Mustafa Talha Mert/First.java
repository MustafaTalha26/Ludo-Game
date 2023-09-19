/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileorg;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mustafa
 */
public class First {
    JFrame frame;
    JPanel panel;
    JButton button;
    JButton button2;
    JTextField r1;
    JTextField r2;
    JTextField r3;
    JTextField r4;
    JLabel e1;
    JLabel e2;
    JLabel e3;
    JLabel e4;
    
    First() {
    frame = new JFrame();
        panel = new JPanel();
        button = new JButton("Yeni Oyun");
        button2 = new JButton("Devam Et");
        
        r1 = new JTextField();
        r1.setBounds(60,40,100,30);
        r2 = new JTextField();
        r2.setBounds(60,80,100,30);
        r3 = new JTextField();
        r3.setBounds(60,120,100,30);
        r4 = new JTextField();
        r4.setBounds(60,160,100,30);
        
        e1 = new JLabel(" ");
        e1.setBounds(20, 40, 40, 30);
        e1.setBackground(Color.red);
        e1.setOpaque(true);
        
        e2 = new JLabel(" ");
        e2.setBounds(20, 80, 40, 30);
        e2.setBackground(Color.blue);
        e2.setOpaque(true);
        
        e3 = new JLabel(" ");
        e3.setBounds(20, 120, 40, 30);
        e3.setBackground(Color.yellow);
        e3.setOpaque(true);
        
        e4 = new JLabel(" ");
        e4.setBounds(20, 160, 40, 30);
        e4.setBackground(Color.green);
        e4.setOpaque(true);
        
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Ludo Game");
        
        class AL implements ActionListener {
                  
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if(e.getSource() == button) {
                    int count = 0;
                    String[][] oyuncu;
                    if(!r1.getText().equals("")) {
                        count++;
                    }
                    if(!r2.getText().equals("")) {
                        count++;
                    }
                    if(!r3.getText().equals("")) {
                        count++;
                    }
                    if(!r4.getText().equals("")) {
                        count++;
                    }
                    oyuncu = new String[count][2];
                    if(count > 1) {
                        count = 0;
                        if(!r1.getText().equals("")) {
                            oyuncu[count][0] = r1.getText();
                            oyuncu[count][1] = "K";
                            count++;
                        }
                        if(!r2.getText().equals("")) {
                            oyuncu[count][0] = r2.getText();
                            oyuncu[count][1] = "M";
                            count++;
                        }
                        if(!r3.getText().equals("")) {
                            oyuncu[count][0] = r3.getText();
                            oyuncu[count][1] = "S";
                            count++;
                        }
                        if(!r4.getText().equals("")) {
                            oyuncu[count][0] = r4.getText();
                            oyuncu[count][1] = "Y";
                            count++;
                        }
                        try {
                            Write xx = new Write("");
                            xx.sil();
                        }
                        catch (IOException ex) {
                            System.out.println("hata");
                        }
                        new Second(oyuncu,0);
                        frame.dispose();
                    }
                    else {
                        System.out.println("Yeterli oyuncu sayısına ulaşılmadı");
                    }
                }
                if(e.getSource() == button2) {
                    try {
                        new Write("");
                    } catch (IOException ex) {
                        System.out.println("hata");
                    }
                    Reading xd = new Reading();
                    String[][] list = xd.getString();
                    String[][] oyuncu;
                    Second savedGame;
                    int oyuncuCount = 0;
                    for (int i = 0; i < list.length; i++) {
                        if(list[i][0].equals("Start")) {
                            oyuncuCount = Integer.parseInt(list[i][1]);
                        }
                    }
                    oyuncu = new String[oyuncuCount][2];
                    for (int i = 0; i < list.length; i++) {
                        if(list[i][0].equals("Start")) {
                            int co = 0;
                            for (int j = 0; j < oyuncu.length; j++) {
                                oyuncu[co][1] = list[i+1][0];
                                oyuncu[co][0] = list[i+1][1];
                                co++;
                                i++;
                            }
                        }
                    }
                    savedGame = new Second(oyuncu,1);
                    String[] pawnNames = new String[16];
                    int[][] safe = new int[4][4];
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            safe[i][j] = -1;
                        }
                    }
                    pawnNames[0] =  "K1";
                    pawnNames[1] =  "K2";
                    pawnNames[2] =  "K3";
                    pawnNames[3] =  "K4";
                    pawnNames[4] =  "M1";
                    pawnNames[5] =  "M2";
                    pawnNames[6] =  "M3";
                    pawnNames[7] =  "M4";
                    pawnNames[8] =  "S1";
                    pawnNames[9] =  "S2";
                    pawnNames[10] = "S3";
                    pawnNames[11] = "S4";
                    pawnNames[12] = "Y1";
                    pawnNames[13] = "Y2";
                    pawnNames[14] = "Y3";
                    pawnNames[15] = "Y4";
                    int[] pawnIndex = new int[16];
                    for (int i = 0; i < 16; i++) {
                        pawnIndex[i] = -1;
                    }
                    int[] road = new int[16];
                    for (int i = 0; i < 16; i++) {
                        road[i] = 0;
                    }
                    for (int i = 0; i < list.length; i++) {
                        if(list[i][0].equals("MOV")) {
                            for (int j = 0; j < 16; j++) {
                                if(list[i][1].equals(pawnNames[j])) {
                                    pawnIndex[j] = Integer.parseInt(list[i][2]);
                                }
                            }
                        }
                        else if(list[i][0].equals("EAT")) {
                            for (int j = 0; j < 16; j++) {
                                for (int k = 0; k < 16; k++) {
                                    if(list[i][1].equals(pawnNames[j]) && list[i][2].equals(pawnNames[k])) {
                                        pawnIndex[j] = pawnIndex[k];
                                        pawnIndex[k] = -1;
                                        road[k] = 0;
                                    }
                                }
                            }
                        }
                        else if(list[i][0].equals("SFE")) {
                            for (int j = 0; j < 16; j++) {
                                if(list[i][1].equals(pawnNames[j])) {
                                    safe[j/4][Integer.parseInt(list[i][2])-1] = j;
                                    pawnIndex[j] = -2;
                                    road[j] = 100;
                                }
                            }
                        }
                    }
                    for (int i = 0; i < 4; i++) {
                        if(pawnIndex[i] != -1 && pawnIndex[i] != -2) {
                            road[i] = pawnIndex[i];
                        }
                    }
                    for (int i = 4; i < 8; i++) {
                        if(pawnIndex[i] != -1 && pawnIndex[i] != -2) {
                            if(pawnIndex[i] > 10) {
                                road[i] = pawnIndex[i] -10;
                            }
                            else {
                                road[i] = pawnIndex[i] +30;
                            }
                        }
                    }
                    for (int i = 8; i < 12; i++) {
                        if(pawnIndex[i] != -1 && pawnIndex[i] != -2) {
                            if(pawnIndex[i] > 20) {
                                road[i] = pawnIndex[i] -20;
                            }
                            else {
                                road[i] = pawnIndex[i] +20;
                            }
                        }
                    }
                    for (int i = 12; i < 16; i++) {
                        if(pawnIndex[i] != -1 && pawnIndex[i] != -2) {
                            if(pawnIndex[i] > 30) {
                                road[i] = pawnIndex[i] -30;
                            }
                            else {
                                road[i] = pawnIndex[i] +10;
                            }
                        }
                    }
                    for (int i = 0; i < 16; i++) {
                        savedGame.pawns[i].index = pawnIndex[i];
                        if(pawnIndex[i] != -1 && pawnIndex[i] != -2) {
                            savedGame.pieces[savedGame.pawns[i].index].setIcon(savedGame.anon[i]);
                        }
                        System.out.println(pawnIndex[i]);
                    }
                    System.out.println("xxxxx");
                    for (int i = 0; i < 16; i++) {
                        savedGame.pawns[i].road = road[i];
                        System.out.println(road[i]);
                    }
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if(safe[i][j] != -1) {
                                savedGame.safes[i*4+j].setIcon(savedGame.anon[safe[i][j]]);
                            }
                            System.out.println(safe[i][j]);
                        }
                        System.out.println("xxx");
                    }
                }
            }
        }
        AL actionlistener = new AL();
        button.setBounds(200, 50, 120, 60);
        button.setFocusable(false);
        button.addActionListener(actionlistener);
        button2.setBounds(200, 120, 120, 60);
        button2.setFocusable(false);
        button2.addActionListener(actionlistener);
        
        panel.setLayout(null);
        panel.add(button);
        panel.add(button2);
        panel.add(r1);
        panel.add(r2);
        panel.add(r3);
        panel.add(r4);
        panel.add(e1);
        panel.add(e2);
        panel.add(e3);
        panel.add(e4);
        panel.setBackground(new Color(180,180,220));
        
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
