package am3Model;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import am3Controller.OptionsBoardsC;

public class AvailableColorsM {

	private ArrayList<JLabel> availableColors= new ArrayList<JLabel>(20);
	
	public AvailableColorsM(ColorsM colors){
		
		this.initAvailableColors(colors);
		
	}
	
	private void initAvailableColors(ColorsM colors){
		for(int i=1;i<colors.getColorsBoard().length;i++){
			 JLabel jl=new JLabel(new ImageIcon(" "));
			jl.setIcon(colors.getColorsBoard()[i].getIcon());
			availableColors.add(jl);
		}
	}
	
	public void reinitAvailableColors(ColorsM colors, OptionsBoardsC obC){
		for(int i=0;i<availableColors.size();i++){
			availableColors.get(i).setIcon(colors.getColorsBoard()[i+1].getIcon());
			availableColors.get(i).addMouseListener(obC);
		}
	}

	public ArrayList<JLabel> getAvailableColors() {
		return availableColors;
	}

	public void setAvailableColors(ArrayList<JLabel> availableColors) {
		this.availableColors = availableColors;
	}
}
