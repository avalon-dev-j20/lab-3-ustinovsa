/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3.Calculator;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Home
 */
public class CalcFrame extends JFrame {
    protected static JLabel display;
    private JPanel keysPanel;
    private JPanel displayPanel;
    private JButton key1 = new JButton("1");
    private JButton key2 = new JButton("2");
    private JButton key3 = new JButton("3");
    private JButton key4 = new JButton("4");
    private JButton key5 = new JButton("5");
    private JButton key6 = new JButton("6");
    private JButton key7 = new JButton("7");
    private JButton key8 = new JButton("8");
    private JButton key9 = new JButton("9");
    private JButton key0 = new JButton("0");
    private JButton keyDot = new JButton(".");
    private JButton keyCE = new JButton("CE");
    private JButton keyDiv = new JButton("/");
    private JButton keyMult = new JButton("*");
    private JButton keySubs = new JButton("-");
    private JButton keyAdd = new JButton("+");
    private JButton keyRes = new JButton("=");
    private Dimension min = new Dimension(300, 300);
    private Dimension max = new Dimension(500,500);
    private Rectangle maxBounds = new Rectangle(500, 500);
    
    public CalcFrame() {
        super("Calculator");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(min);
        setMaximumSize(max);
        setPreferredSize(min);
        setResizable(true);
                
        displayPanel = new JPanel(new BorderLayout());
        display = new JLabel("0", JLabel.RIGHT);
        displayPanel.setBackground(Color.WHITE);
        getContentPane().add(display, BorderLayout.NORTH);
        
        keysPanel = new JPanel();
        GridBagLayout grblay = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        keysPanel.setLayout(grblay);
        
        Insets ins = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.BOTH;
        c.insets = ins;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 0;
        c.weighty = 0;
        
        InputListener input = new InputListener();
        CommandListener command = new CommandListener();
        
        keysPanel.add(keyCE, c);
        keyCE.addActionListener(command);
        c.gridx = 1;
        keysPanel.add(keyDiv, c);
        keyDiv.addActionListener(command);
        c.gridx = 2;
        keysPanel.add(keyMult, c);
        keyMult.addActionListener(command);
        c.gridx = 3;
        keysPanel.add(keySubs, c);
        keySubs.addActionListener(command);
        c.gridx = 0;
        c.gridy = 1;
        keysPanel.add(key7, c);
        key7.addActionListener(input);
        c.gridx = 1;
        keysPanel.add(key8, c);
        key8.addActionListener(input);
        c.gridx = 2;
        keysPanel.add(key9, c);
        key9.addActionListener(input);
        c.gridx = 3;
        c.gridheight = 2;
        keysPanel.add(keyAdd, c);
        keyAdd.addActionListener(command);
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        keysPanel.add(key4, c);
        key4.addActionListener(input);
        c.gridx = 1;
        keysPanel.add(key5, c);
        key5.addActionListener(input);
        c.gridx = 2;
        keysPanel.add(key6, c);
        key6.addActionListener(input);
        c.gridx = 0;
        c.gridy = 3;
        keysPanel.add(key1, c);
        key1.addActionListener(input);
        c.gridx = 1;
        keysPanel.add(key2, c);
        key2.addActionListener(input);
        c.gridx = 2;
        keysPanel.add(key3, c);
        key3.addActionListener(input);
        c.gridx = 3;
        c.gridheight = 2;
        keysPanel.add(keyRes, c);
        keyRes.addActionListener(command);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.gridheight = 1;
        keysPanel.add(key0, c);
        key0.addActionListener(input);
        c.gridx = 2;
        c.gridwidth = 1;
        keysPanel.add(keyDot, c);
        keyDot.addActionListener(input);
        
        getContentPane().add(keysPanel, BoxLayout.Y_AXIS);
    }
    
    
}
