package am3Controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import am3View.OptionsV;

public class OptionsJTFieldsC implements FocusListener{

	private OptionsV options;
	private int checkLines, checkSquares, checkColors;
	
	public OptionsJTFieldsC(OptionsV options){
		this.options=options;
		checkColors=(int)(Integer.parseInt(options.getTheNumberColors().getText()));
	}
	
	public void focusLost(FocusEvent fe) {
		JTextField sourceF=(JTextField)fe.getSource();
		
		if(sourceF==options.getTheLines()){
			checkLines=(int)(Integer.parseInt(options.getTheLines().getText()));
			if(checkLines<5 || checkLines>15){
				JOptionPane.showMessageDialog(null, "Choisir entre 5 et 15 lignes inclus !","Hors limites !", JOptionPane.ERROR_MESSAGE);
				options.getTheLines().setText("10");
			}
		}
		
		if(sourceF==options.getTheSquaresPerLine()){
			checkSquares=(int)(Integer.parseInt(options.getTheSquaresPerLine().getText()));
			if(checkSquares<3 || checkSquares>6){
				JOptionPane.showMessageDialog(null, "Choisir entre 3 et 6 cases par lignes inclus !","Hors limites !", JOptionPane.ERROR_MESSAGE);
				options.getTheSquaresPerLine().setText("4");
			}		
		}

		if(sourceF==options.getTheNumberColors()){
			checkColors=(int)(Integer.parseInt(options.getTheNumberColors().getText()));
			if(checkColors<5 || checkColors>20){
				JOptionPane.showMessageDialog(null, "Choisir entre 5 et 20 pions de couleur inclus !","Hors limites !", JOptionPane.ERROR_MESSAGE);
				options.getTheNumberColors().setText("8");
			}
			else{
				options.getColorsLeft().setText("Reste "+checkColors+" couleur(s) à choisir.");
			}
		}
		
	}

	public void focusGained(FocusEvent e) {		
	}

	public int getCheckColors() {
		return checkColors;
	}

	public void setCheckColors(int checkColors) {
		this.checkColors = checkColors;
	}
}
