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
public class CommandListener implements ActionListener{
    double result;
    String lastAct = "=";
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String act = e.getActionCommand();
        if ((Pattern.matches("\\d+\\.{0,1}\\d*", 
                    CalcPanel.display.getText()))){
                switch(act){ 
            case "/": calculate(Double.parseDouble(CalcPanel.display.getText()));
                      CalcPanel.history.setText(CalcPanel.display.getText());
                      CalcPanel.display.setText(act);
                break;
            case "*": calculate(Double.parseDouble(CalcPanel.display.getText()));
                      CalcPanel.history.setText(CalcPanel.display.getText());
                      CalcPanel.display.setText(act);
               break;
            case "-": calculate(Double.parseDouble(CalcPanel.display.getText()));
                      CalcPanel.history.setText(CalcPanel.display.getText());
                      CalcPanel.display.setText(act);
               break;
            case "+": calculate(Double.parseDouble(CalcPanel.display.getText()));
                      CalcPanel.history.setText(CalcPanel.display.getText());
                      CalcPanel.display.setText(act);
                break;
            case "=": //result = Double.parseDouble(CalcPanel.history.getText());
                      calculate(Double.parseDouble(CalcPanel.display.getText()));
                      CalcPanel.history.setText(""); 
                break;
            case "CE": CalcPanel.display.setText("0");
                break;
            } lastAct = act;} else { 
            switch(act){
            case "/": CalcPanel.display.setText(act);
                break;
            case "*": CalcPanel.display.setText(act);
               break;
            case "-": CalcPanel.display.setText(act);
               break;
            case "+": CalcPanel.display.setText(act);
                break;
            case "=": //result = Double.parseDouble(CalcPanel.history.getText());
                      calculate(result);
                      CalcPanel.history.setText("");
                break;
            case "CE": CalcPanel.display.setText("0");
                break;
            }
            lastAct = act;
        } 
            
    };
        
    
    public void calculate(double x){
        switch(lastAct){
            case "/": result /= x;
                break;
            case "*": result *= x;
                break;
            case "-": result -= x;
                break;
            case "+": result += x;
                break;
            case "=": result = x ;
                CalcPanel.display.setText(Double.toString(result));
                break;
            case "CE": CalcPanel.display.setText("0"); 
                break;
        } CalcPanel.display.setText(Double.toString(result));
        
    }
}
