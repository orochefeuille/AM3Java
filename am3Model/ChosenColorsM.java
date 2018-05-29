package am3Model;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import am3Controller.OptionsBoardsC;

public class ChosenColorsM {

	private ArrayList<JLabel> chosenColors= new ArrayList<JLabel>(20);
	
	public ChosenColorsM(ColorsM colors){
		
		this.initChosenColors(colors);
	}
	
	private void initChosenColors(ColorsM colors){
		for(int i=0;i<20;i++){
			 JLabel jl=new JLabel(new ImageIcon(" "));
			jl.setIcon(colors.getColorsBoard()[0].getIcon());
			chosenColors.add(jl);
		}
	}
	
	public void reinitChosenColors(ColorsM colors, OptionsBoardsC obC){
		for(int i=0;i<chosenColors.size();i++){
			chosenColors.get(i).setIcon(colors.getColorsBoard()[0].getIcon());
			chosenColors.get(i).removeMouseListener(obC);
		}
	}

	public ArrayList<JLabel> getChosenColors() {
		return chosenColors;
	}
}