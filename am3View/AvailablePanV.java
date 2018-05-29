package am3View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import am3Model.AvailableColorsM;

public class AvailablePanV extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private TitledBorder titledBorder;
	
	public AvailablePanV(AvailableColorsM aColors){
				
		this.setLayout(new GridLayout(5,4));
		this.setBackground(new Color(157,238,11));	
		titledBorder = BorderFactory.createTitledBorder("");
		this.setBorder(BorderFactory.createTitledBorder(titledBorder,"Couleurs possibles",2,0,null, new Color(90,55,119)));
		this.inputIcon(aColors);
	}
	
	private void inputIcon(AvailableColorsM aColors){
				
		for(JLabel jl:aColors.getAvailableColors()){
			this.add(jl);
		}
	}
	
	public void changeIcon(AvailableColorsM aColors){
		this.removeAll();		
		for(JLabel jl:aColors.getAvailableColors()){
			this.add(jl);
		}
		this.revalidate();this.repaint();
	}
}
