/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

/**
 *
 * @author Home
 */
public class InputListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();
        if ((Pattern.matches("\\/|\\*|\\-|\\+|0|(0.0)", CalcPanel.display.getText()))) {
            CalcPanel.display.setText("");
            CalcPanel.display.setText(CalcPanel.display.getText() + input);
        } else {
            CalcPanel.display.setText(CalcPanel.display.getText() + input);
        }
    }
}
