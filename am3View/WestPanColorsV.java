package am3View;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import am3Controller.WestPanColorsC;

public class WestPanColorsV extends JPanel{

	private static final long serialVersionUID = 1L;

	private JLabel wPColors[];

	public WestPanColorsV(){
	
		this.setLayout(new GridLayout(5,4));
		this.setBackground(new Color(157,238,11));
		this.initwPColors();
	}
	
	private void initwPColors(){
		wPColors= new JLabel[20];
		for(int i=0; i<20;i++){
			wPColors[i]= new JLabel(new ImageIcon("images/caseVide.jpg"));
			this.add(wPColors[i]);
		}
	}
	
	public void reinitwPColors(){
		for(int i=0; i<20;i++){
			wPColors[i].setIcon(new ImageIcon("images/caseVide.jpg"));
			//this.add(wPColors[i]);
		}
	}
	public void updatewPColors(int numColors, ArrayList<JLabel> chosenColors){
		this.removeAll();
		
		wPColors= new JLabel[20];
		
		for(int i=0;i<20;i++){
			if(i<numColors){			
				wPColors[i]= new JLabel((chosenColors.get(i).getIcon()));
				wPColors[i].setBorder(BorderFactory.createLineBorder(new Color(99,55,119)));
				this.add(wPColors[i]);
			}
			else if(i>=numColors){			
				wPColors[i]= new JLabel(new ImageIcon("images/caseVide.jpg"));
				this.add(wPColors[i]);
			}
		}
		this.revalidate(); this.repaint();
	}

	public void inputMouseListerner(int numColors, WestPanColorsC wpColorsC){
		
		for(int i=0; i<20;i++){		
			if(i<numColors){
			wPColors[i].addMouseListener(wpColorsC);
			}
		}
	}
	public JLabel[] getwPColors() {
		return wPColors;
	}
}


