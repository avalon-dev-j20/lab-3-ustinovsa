/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3.Calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Home
 */
public class CalcPanel extends JPanel {
    static JLabel display;
    static JTextArea history;
    private JPanel numPad;
    private GridBagConstraints gbc;
    private Insets insets;
    private JButton button;
    static double result;
    
    
    
    String[] commandButtons = {"CE", "/", "*", "-", "+", "="};
    
    
    private int panelsWidth = 300;
    private int displayHeight = 50;
    private int numPadHeight = 450;
    
    
    
    
    public CalcPanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        createDisplay();
        add(display);
        createNumPad();
        add(numPad);
    }
    
    private JPanel createDisplay(){
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        history = new JTextArea();
        history.setEditable(false);
        add(history);
        display = new JLabel("0", JLabel.RIGHT);
        display.setVerticalAlignment(JLabel.CENTER);
        display.setMinimumSize(new Dimension(panelsWidth, displayHeight));
        display.setText("0");
        add(display);
        return displayPanel;
        }
    
    public JPanel createNumPad(){
        numPad = new JPanel(new GridBagLayout());
        insets = new Insets(5, 5, 5, 5);
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = insets;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        CommandListener cl = new CommandListener();
        InputListener il = new InputListener();
        DotListener dl = new DotListener();
        
        
        for(int i=0; i<11; i++){
            switch(i){
                case 0: gbc.gridx = 0;
                        gbc.gridy = 4;
                        gbc.gridwidth = 2;
                        break;
                case 1: gbc.gridx = 0;
                        gbc.gridy = 3;
                        gbc.gridwidth = 1;
                        break;
                case 2: gbc.gridx = 1;
                        gbc.gridy = 3;
                        break;
                case 3: gbc.gridx = 2;
                        gbc.gridy = 3;
                        break;
                case 4: gbc.gridx = 0;
                        gbc.gridy = 2;
                        break;
                case 5: gbc.gridx = 1;
                        gbc.gridy = 2;
                        break;
                case 6: gbc.gridx = 2;
                        gbc.gridy = 2;
                        break;
                case 7: gbc.gridx = 0;
                        gbc.gridy = 1;
                        break;
                case 8: gbc.gridx = 1;
                        gbc.gridy = 1;
                        break;
                case 9: gbc.gridx = 2;
                        gbc.gridy = 1;
                        break;
                        
            }
            button = new JButton(Integer.toString(i));
            button.addActionListener(il);
            numPad.add(button, gbc);            
            };
        
        for(String i:commandButtons){
            switch (i){
                case "CE": gbc.gridx = 0;
                           gbc.gridy = 0;
                    break;
                case "/": gbc.gridx = 1;
                          gbc.gridy = 0;
                    break;   
                case "*": gbc.gridx = 2;
                          gbc.gridy = 0;
                    break; 
                case "-": gbc.gridx = 3;
                          gbc.gridy = 0;
                    break;    
                case "+": gbc.gridx = 3;
                          gbc.gridy = 1;
                          gbc.gridheight = 2;
                    break;    
                case "=": gbc.gridx = 3;
                          gbc.gridy = 3;
                    break;    
            }
            button = new JButton(i);
            button.addActionListener(cl);
            numPad.add(button, gbc);
        }
        gbc.gridx = 2;
        gbc.gridy = 4;
        button = new JButton(".");
        button.addActionListener(dl);
        numPad.add(button, gbc);
         
        //createCommandButtons();
        //createNumButtons();
        return numPad;
    }
    
   
    
    
    
    public void createCommandButtons(){
        gbc = new GridBagConstraints(
                0, 0, 1, 1, .0, .0,
                GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, insets, 0, 0);
        
    }
    
    
    
    public void createNumButtons(){
        
    }
    
    
    
}
