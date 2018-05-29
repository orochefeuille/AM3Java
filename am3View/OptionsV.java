package am3View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class OptionsV extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private int gameVHeight, gameVWidth;
	
	private Container container;
	
	private GridBagLayout gbl;
		
	private JLabel lines, squaresPerLine, numberOfColors,plus, minus, colorsLeft;
	private JTextField theLines,theSquaresPerLine, theNumberColors;
	private JButton cancel, validate;
	private JSeparator js1, js2;
	private int left = 8;
	
	private AvailablePanV availablePan;
	private ChosenPanV chosenPan;
	
	public OptionsV(AvailablePanV availablePan, ChosenPanV chosenPan){
		
		this.availablePan=availablePan;
		this.chosenPan=chosenPan;
				
		gameVHeight=this.makeScreenHeightSize();
		gameVWidth=this.makeScreenWidthSize();
		this.setSize(gameVWidth, gameVHeight);
		this.setLocationRelativeTo(this.getParent());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("AM3-Options");
		
		gbl = new GridBagLayout();
		this.setLayout(gbl);
		
		container=this.getContentPane();
		container.setBackground(new Color(157,238,11));
		
		this.layComponents();
	}
	
	private void layComponents(){
		
		lines=new JLabel("Nombre de lignes (de 5 à 15 inclus) : ");
		lines.setForeground(new Color(90,55,119));
		container.add(lines, new GridBagConstraints (0,0,15,1,70,3,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));

		theLines=new JTextField("10");
		container.add(theLines, new GridBagConstraints (11,0,1,1,20,0,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));

		squaresPerLine=new JLabel("Nombre de cases par lignes (de 3 à 6 inclus) : ");
		squaresPerLine.setForeground(new Color(90,55,119));
		container.add(squaresPerLine, new GridBagConstraints (0,2,15,1,80,3,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));

		theSquaresPerLine=new JTextField("4");
		container.add(theSquaresPerLine, new GridBagConstraints (11,2,1,1,20,0,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));

		numberOfColors=new JLabel("Nombre de pions de couleur (de 5 à 20 inclus) : ");
		numberOfColors.setForeground(new Color(90,55,119));
		container.add(numberOfColors, new GridBagConstraints (0,4,15,1,80,3,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));

		theNumberColors=new JTextField("8");
		container.add(theNumberColors, new GridBagConstraints (11,4,1,1,20,0,GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));
		
		js1=new JSeparator();
		js1.setForeground(new Color(90,55,119));
		container.add(js1, new GridBagConstraints (0,6,13,1,0,26,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));

		container.add(availablePan, new GridBagConstraints (0,8,4,5,35,0,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));

		plus=new JLabel(">>>");
		plus.setForeground(new Color(90,55,119));
		container.add(plus, new GridBagConstraints (6,9,1,1,20,30,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));

		minus=new JLabel("<<<");
		minus.setVisible(false);
		minus.setForeground(new Color(90,55,119));
		container.add(minus, new GridBagConstraints (6,11,1,1,20,30,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		container.add(chosenPan, new GridBagConstraints (8,8,4,5,35,0,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		js2=new JSeparator();
		js2.setForeground(new Color(90,55,119));
		container.add(js2, new GridBagConstraints (0,13,13,1,0,26,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));
		
		colorsLeft=new JLabel("Reste "+left+" couleur(s) à choisir.");
		colorsLeft.setForeground(new Color(90,55,119));
		container.add(colorsLeft, new GridBagConstraints (1,15,9,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));

		cancel=new JButton("ANNULER");
		cancel.setBackground(new Color(90,55,119)); cancel.setForeground(new Color(157,238,11));
		container.add(cancel, new GridBagConstraints (8,15,3,1,0,9,GridBagConstraints.LINE_START,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));

		validate=new JButton("VALIDER");
		validate.setBackground(new Color(90,55,119)); validate.setForeground(new Color(157,238,11));
		validate.setEnabled(false);
		container.add(validate, new GridBagConstraints (11,15,3,1,0,0,GridBagConstraints.LINE_END,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
				
	}
	
	public void reinitFields(){
		theLines.setText("10");
		theSquaresPerLine.setText("4");
		theNumberColors.setText("8");
		plus.setVisible(true);
		minus.setVisible(false);
		validate.setEnabled(false);
	}
	
	public void removeBoards(){
		container.remove(availablePan);
		container.remove(chosenPan);
		container.validate(); container.repaint();
	}
	
	public void relayComponents(){		
		container.add(availablePan, new GridBagConstraints (0,8,4,5,35,0,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		container.add(chosenPan, new GridBagConstraints (8,8,4,5,35,0,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		container.validate(); container.repaint();
	}

	private int makeScreenHeightSize(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = (int)(screenSize.getHeight()*0.4);		
		return screenHeight;
	}
	
	private int makeScreenWidthSize(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)(screenSize.getWidth()*0.27);		
		return screenWidth;
	}

	public JTextField getTheLines() {
		return theLines;
	}

	public JTextField getTheSquaresPerLine() {
		return theSquaresPerLine;
	}

	public JTextField getTheNumberColors() {
		return theNumberColors;
	}

	public JButton getCancel() {
		return cancel;
	}

	public JButton getValidate() {
		return validate;
	}

	public JLabel getPlus() {
		return plus;
	}

	public JLabel getMinus() {
		return minus;
	}

	public JLabel getColorsLeft() {
		return colorsLeft;
	}

	public AvailablePanV getAvailablePan() {
		return availablePan;
	}

	public ChosenPanV getChosenPan() {
		return chosenPan;
	}
}
