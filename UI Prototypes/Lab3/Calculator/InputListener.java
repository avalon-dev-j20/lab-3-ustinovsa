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
public class InputListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent event) {
	String input = event.getActionCommand();
		if(CalcFrame.display.getText()=="0"){
                    CalcFrame.display.setName("");
                    CalcFrame.display.setName(input);
                }
                CalcFrame.display.setText(CalcFrame.display.getText() + input);
    }
    
}
