package am3View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameVSouthPan extends JPanel {

	private static final long serialVersionUID = 1L;
		
	private GridBagLayout gbl;
	
	private JButton okCenter, okEast;
	
	private JPanel pan1, okCenterP, okEastP;
			
	public GameVSouthPan(){
				
		this.setBackground(new Color(90,55,119));
		
		gbl = new GridBagLayout();
		this.setLayout(gbl);
		
		this.layComponents();
	}

		private void layComponents(){
			
		pan1=new JPanel(); pan1.setBackground(new Color(90,55,119));
		okCenterP= new JPanel(); okCenterP.setBackground(new Color(90,55,119));
		okEastP=new JPanel(); okEastP.setBackground(new Color(90,55,119));
		this.add(pan1, new GridBagConstraints (0,0,1,1,20,0,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));

		okCenter=new JButton("VALIDER");
		okCenter.setBackground(new Color(157,238,11)); okCenter.setForeground(new Color(90,55,119));
		okCenterP.setLayout(gbl);
		okCenterP.add (okCenter, new GridBagConstraints (0, 0, 1, 1, 0, 0,GridBagConstraints.CENTER,GridBagConstraints.CENTER,new Insets (0,0,0,0), 0, 0));
		this.add(okCenterP, new GridBagConstraints (1,0,1,1,40,0,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		okEast=new JButton("VALIDER");
		okEast.setBackground(new Color(157,238,11)); okEast.setForeground(new Color(90,55,119));
		okEastP.setLayout(gbl);
		okEastP.add (okEast, new GridBagConstraints (0, 0, 1, 1, 0, 0,GridBagConstraints.CENTER,GridBagConstraints.CENTER,new Insets (0,0,0,0), 0, 0));
		this.add(okEastP, new GridBagConstraints (2,0,1,1,40,0,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
	}

	public JButton getOkCenter() {
		return okCenter;
	}

	public JButton getOkEast() {
		return okEast;
	}

	public JPanel getPan1() {
		return pan1;
	}

	public JPanel getOkCenterP() {
		return okCenterP;
	}

	public JPanel getOkEastP() {
		return okEastP;
	}
}
