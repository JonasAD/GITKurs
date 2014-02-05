package oving1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;


public class ButtonsNText extends JPanel implements ActionListener, KeyListener {
	
	private JTextField TextLine = new JTextField();
	private JToggleButton UpperCaseButton;
	private JToggleButton LowerCaseButton;
	private JCheckBox ContinousButton;
	private ButtonGroup UpperLowerCase;
	String first;
	String after;
	String textAfter;
	String textBefore;
	int caretPosition;
	
	
	public ButtonsNText(){
		
		TextLine = new JTextField(10);
		add(TextLine);
		TextLine.addKeyListener(this);
		
	
		UpperCaseButton = new JToggleButton("UpperCase");
		add(UpperCaseButton);
		UpperCaseButton.addActionListener(this);
		
		LowerCaseButton = new JToggleButton("LowerCase");
		add(LowerCaseButton);
		LowerCaseButton.addActionListener(this);
		
		ContinousButton = new JCheckBox("Gunnar");
		ContinousButton.setName("Continous button");
		add(ContinousButton);
		ContinousButton.addActionListener(this);
		
		UpperLowerCase = new ButtonGroup();
		UpperLowerCase.add(UpperCaseButton);
		UpperLowerCase.add(LowerCaseButton);	
		
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JPanel panel = new ButtonsNText();
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(450,70);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String text = TextLine.getText();
		
		if(arg0.getSource() == UpperCaseButton){
			TextLine.setText(text.toUpperCase());
		}
		
		if(arg0.getSource() == LowerCaseButton){
			TextLine.setText(text.toLowerCase());
		}
	
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		textAfter = TextLine.getText();
		caretPosition = TextLine.getCaretPosition();
		/*first = textAfter.substring(0, caretPosition);
		after = " " + textAfter.substring(caretPosition);
		*/
		
		if (arg0.getKeyCode() == 10){
			if(UpperCaseButton.isSelected()){
				TextLine.setText(textBefore.toUpperCase());
				TextLine.setCaretPosition(caretPosition);
				
			}
			if(LowerCaseButton.isSelected()){
				TextLine.setText(textBefore.toLowerCase());
				TextLine.setCaretPosition(caretPosition);
			}
			
		}
		
		String input = Character.toString(arg0.getKeyChar());
		if (!arg0.isActionKey()){
			if (ContinousButton.isSelected()){
				if(UpperCaseButton.isSelected()){
					input = input.toUpperCase();
					String total =  first + after.replaceFirst(" ", input);
					System.out.println(total);
					TextLine.setText(total);
					TextLine.setCaretPosition(caretPosition);
				}
				else if (LowerCaseButton.isSelected()){
					input = input.toLowerCase();
					String total =  first + after.replaceFirst(" ", input);
					System.out.println(total);
					TextLine.setText(total);
					TextLine.setCaretPosition(caretPosition);
					System.out.println(total.toLowerCase());
				}
			}
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		/*String text = TextLine.getText();
		int caretPosition = TextLine.getCaretPosition();
		if (arg0.getKeyCode() == 10){
			if(UpperCaseButton.isSelected()){
				TextLine.setText(text.toUpperCase());
				TextLine.setCaretPosition(caretPosition);
				
			}
			if(LowerCaseButton.isSelected()){
				TextLine.setText(text.toLowerCase());
				TextLine.setCaretPosition(caretPosition);
			}
			
		}*/	
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		textBefore = TextLine.getText();
		first = textBefore.substring(0, caretPosition);
		after = " " + textBefore.substring(caretPosition);
		/*String textBefore = TextLine.getText();
		String input = Character.toString(arg0.getKeyChar());
		

		System.out.println("first: " + first);
		System.out.println("after: " + after);
	
		if (!arg0.isActionKey()){
		if (ContinousButton.isSelected()){
			if(UpperCaseButton.isSelected()){
				input = input.toUpperCase();
				String total =  first + after.replaceFirst(" ", input);
				System.out.println(total);
				TextLine.setText(total);
				TextLine.setCaretPosition(caretPosition);
			}
			else if (LowerCaseButton.isSelected()){
				input = input.toLowerCase();
				String total =  first + after.replaceFirst(" ", input);
				System.out.println(total);
				TextLine.setText(total);
				TextLine.setCaretPosition(caretPosition);
				System.out.println(total.toLowerCase());
			}
		}
		}*/
	}
	
	
}



/*Questions about implementation
 * Lexical event = keyEvent. Always listening
 * Syntaktisk = Mens et lexikalsk event lytter til enhver tid, er et syntaktisk 
 * event noe som endrer seg når det gjøres noe med det, og holder seg sånn til det blir interagert med igjen. eks: ActionListener, ford
 * Vi kunne ikke håndtert lexikalske hendelser som syntaktiske, da vi ikke kan håndtere tekstinput på samme måte syntaktisk
 * Fordel med syntaktiske vs lexikalske events er at du kan lagre verdier/tilstander for i knapper osv.
 */