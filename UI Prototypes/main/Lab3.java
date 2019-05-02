/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JFrame;
import Lab3.Calculator.*;
import Lab3.ColorPicker.*;
import java.awt.Dimension;
/**
 *
 * @author Home
 */
public class Lab3 {
    static int MINW = 400;
    static int MINH = 400;
    static int MAXW = 600;
    static int MAXH = 600;
    
    public static void main(String[] args) {
        CalcFrame calc = new CalcFrame();
        calc.setLocationByPlatform(true);
        calc.setVisible(false);
        
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setLocationByPlatform(true);
        colorPicker.setVisible(true);
    }
}
