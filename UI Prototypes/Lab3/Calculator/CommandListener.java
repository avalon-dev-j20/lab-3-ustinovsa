/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3.Calculator;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

/**
 *
 * @author Home
 */
public class CommandListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String act = e.getActionCommand();
        if ((Pattern.matches("\\d+\\.{0,1}\\d*",
                CalcPanel.display.getText()))) {
            switch (act) {
                case "/":
                    calculate(Double.parseDouble(CalcPanel.display.getText()));
                    CalcPanel.history.setText(CalcPanel.display.getText());
                    CalcPanel.display.setText(act);
                    CalcPanel.lastAct = act;
                    break;
                case "*":
                    calculate(Double.parseDouble(CalcPanel.display.getText()));
                    CalcPanel.history.setText(CalcPanel.display.getText());
                    CalcPanel.display.setText(act);
                    CalcPanel.lastAct = act;
                    break;
                case "-":
                    calculate(Double.parseDouble(CalcPanel.display.getText()));
                    CalcPanel.history.setText(CalcPanel.display.getText());
                    CalcPanel.display.setText(act);
                    CalcPanel.lastAct = act;
                    break;
                case "+":
                    calculate(Double.parseDouble(CalcPanel.display.getText()));
                    CalcPanel.history.setText(CalcPanel.display.getText());
                    CalcPanel.display.setText(act);
                    CalcPanel.lastAct = act;
                    break;
                case "=": //result = Double.parseDouble(CalcPanel.history.getText());
                    calculate(Double.parseDouble(CalcPanel.display.getText()));
                    CalcPanel.history.setText("");
                    CalcPanel.lastAct = act;
                    break;
                case "CE":
                    CalcPanel.display.setText("0");
                    break;
            }
            copyToClipboard(CalcPanel.history.getText());
        } else {
            switch (act) {
                case "/":
                    CalcPanel.display.setText(act);
                    break;
                case "*":
                    CalcPanel.display.setText(act);
                    break;
                case "-":
                    CalcPanel.display.setText(act);
                    break;
                case "+":
                    CalcPanel.display.setText(act);
                    break;
                case "=": //result = Double.parseDouble(CalcPanel.history.getText());
                    calculate(CalcPanel.result);
                    CalcPanel.history.setText("");
                    break;
                case "CE":
                    CalcPanel.display.setText("0");
                    break;
            }
            CalcPanel.lastAct = act;
            copyToClipboard(CalcPanel.history.getText());
        }
    }
    
    public void calculate(double x) {
        switch (CalcPanel.lastAct) {
            case "/":
                CalcPanel.result /= x;
                CalcPanel.display.setText(Double.toString(CalcPanel.result));
                break;
            case "*":
                CalcPanel.result *= x;
                CalcPanel.display.setText(Double.toString(CalcPanel.result));
                break;
            case "-":
                CalcPanel.result -= x;
                CalcPanel.display.setText(Double.toString(CalcPanel.result));
                break;
            case "+":
                CalcPanel.result += x;
                CalcPanel.display.setText(Double.toString(CalcPanel.result));
                break;
            case "=":
                CalcPanel.result = x;
                CalcPanel.display.setText(Double.toString(CalcPanel.result));
                break;
            case "CE":
                CalcPanel.display.setText("0");
                break;
        }
    }
    
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Clipboard clipboard = toolkit.getSystemClipboard();

    private void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, selection);
    }
}
