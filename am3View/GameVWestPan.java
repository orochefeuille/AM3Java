package am3View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class GameVWestPan extends JPanel {

	private static final long serialVersionUID = 1L;
		
	private GridBagLayout gbl;
	
	private JLabel selectedColor, selectedIndication, isBlack, isWhite, wellDone, wrong;
	private WestPanColorsV wpColors;
	private WestPanIndicationsV wpIndications;
	private JSeparator sep1,sep2;
	
	public GameVWestPan(WestPanColorsV wpColors, WestPanIndicationsV wpIndications){
		
		this.wpColors=wpColors;
		this.wpIndications=wpIndications;
		
		this.setBackground(new Color(157,238,11));
		this.setBorder(BorderFactory.createLineBorder(new Color(99,55,119)));
		
		gbl = new GridBagLayout();
		this.setLayout(gbl);
		
		this.layComponents();
		
	}

		private void layComponents(){
		selectedColor=new JLabel(new ImageIcon("images/caseVide.jpg"));
		selectedColor.setBackground(new Color(90,55,119)); 
		this.add(selectedColor, new GridBagConstraints (0,3,5,1,0,40,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		this.add(wpColors, new GridBagConstraints (0,5,4,5,0,10,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));	

		sep1=new JSeparator();
		sep1.setForeground(new Color(90,55,119)); 
		this.add(sep1, new GridBagConstraints (0,11,15,1,0,10,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));
		
		selectedIndication=new JLabel(new ImageIcon("images/caseVide.jpg"));
		selectedIndication.setBackground(new Color(90,55,119)); 
		this.add(selectedIndication, new GridBagConstraints (0,15,5,1,0,10,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));		

		this.add(wpIndications, new GridBagConstraints (0,17,4,5,0,20,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));

		sep2=new JSeparator();
		sep2.setForeground(new Color(90,55,119));
		this.add(sep2, new GridBagConstraints (0,23,15,1,0,10,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));

		isBlack=new JLabel(new ImageIcon("images/indiceNoir.jpg"));
		this.add(isBlack, new GridBagConstraints (0,25,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));

		wellDone=new JLabel(" : pion BIEN placé."); 
		wellDone.setBackground(new Color(90,55,119));
		this.add(wellDone, new GridBagConstraints (1,25,5,1,0,0,GridBagConstraints.LINE_START,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		isWhite=new JLabel(new ImageIcon("images/indiceBlanc.jpg"));
		this.add(isWhite, new GridBagConstraints (0,26,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));

		wrong=new JLabel(" : pion MAL placé.");
		wrong.setBackground(new Color(90,55,119));
		this.add(wrong, new GridBagConstraints (1,26,5,1,0,0,GridBagConstraints.LINE_START,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));

	}
		
	public void removeWestPans(){
		this.remove(wpColors);		
		this.remove(wpIndications);
		this.revalidate(); this.repaint();
	}
	
	public void reinitWestPans(){
		this.add(wpColors, new GridBagConstraints (0,5,4,5,0,10,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));	
		this.add(wpIndications, new GridBagConstraints (0,17,4,5,0,20,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		this.revalidate(); this.repaint();
	}

	public JLabel getSelectedColor() {
		return selectedColor;
	}

	public JLabel getSelectedIndication() {
		return selectedIndication;
	}

	public WestPanIndicationsV getWpIndications() {
		return wpIndications;
	}

	public JSeparator getSep1() {
		return sep1;
	}

	public void setSelectedColor(JLabel selectedColor) {
		this.selectedColor = selectedColor;
	}

	public void setSelectedIndication(JLabel selectedIndication) {
		this.selectedIndication = selectedIndication;
	}

	public WestPanColorsV getWpColors() {
		return wpColors;
	}
}
