/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3.Calculator;

import java.awt.Dimension;
import java.awt.event.WindowStateListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

/**
 *
 * @author Home
 */
public class CalcFrame extends JFrame {

    private static int MINWIDTH = 300;
    private static int MINHEIGHT = 400;

    public CalcFrame() {
        setTitle("KALKULATORRRRR");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setMinimumSize(new Dimension(MINWIDTH, MINHEIGHT));
        setAlwaysOnTop(true);
        CalcPanel cp = new CalcPanel();
        add(cp);
        pack();
    }
}
