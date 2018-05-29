package am3View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import am3Model.ChosenColorsM;

public class ChosenPanV extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private TitledBorder titledBorder;

	public ChosenPanV(ChosenColorsM chosenColors){
		
		this.setLayout(new GridLayout(5,4));
		this.setBackground(new Color(157,238,11));	
		titledBorder = BorderFactory.createTitledBorder("");
		this.setBorder(BorderFactory.createTitledBorder(titledBorder,"Couleurs choisies ",2,0,null, new Color(90,55,119)));
		
		this.inputIcon(chosenColors);
	}
	
	private void inputIcon(ChosenColorsM chosenColors ){
				
		for(JLabel jl:chosenColors.getChosenColors()){
			this.add(jl);
		}
	}
	
	public void changeIcon(ChosenColorsM chosenColors ){
		this.removeAll();		
		for(JLabel jl:chosenColors.getChosenColors()){
			this.add(jl);
		}
		this.revalidate();this.repaint();
	}
}
