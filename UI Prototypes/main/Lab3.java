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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

/**
 *
 * @author Home
 */
public class Lab3 {

    public static void main(String[] args) {
        CalcFrame calc = new CalcFrame();
        calc.setLocationByPlatform(true);
        calc.setVisible(true);

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setLocationByPlatform(true);
        colorPicker.setVisible(true);
    }
}
