/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Home
 */
public class CommandListener implements ActionListener{
String command;
    @Override
    public void actionPerformed(ActionEvent event) {
        command = event.getActionCommand();
            if(command.equals("-")){
		CalcFrame.display.setText(command);
		}
			else {
		calculate(Double.parseDouble(CalcFrame.display.getText()));
    }
    }
    
    public void calculate(double x){
        double calculate = Double.parseDouble(CalcFrame.display.getText());
        switch (command){
                case "/": calculate /= x;
                    break;
                case "*": calculate *= x;
                    break;
                case "-": calculate -= x;
                    break;
                case "+": calculate += x;
                    break;
                case "=": calculate = x;
                case "CE": CalcFrame.display.setName("");
        }               
		CalcFrame.display.setText("" + calculate);
}
}
