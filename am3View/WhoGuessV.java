package am3View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;

public class WhoGuessV extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private int gameVHeight, gameVWidth;
	
	private Container container;
	private GridBagLayout gbl;
	
	private JLabel whoMake, whoGuess, whoTitle;
	private JRadioButton p1,p2;
	private ButtonGroup group;
	private JButton cancel, validate;
	private JSeparator js;
	private boolean p1Guess;
	
	public WhoGuessV(){
		
		gameVHeight=this.makeScreenHeightSize();
		gameVWidth=this.makeScreenWidthSize();
		this.setSize(gameVWidth, gameVHeight);
		this.setLocationRelativeTo(this.getParent());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("AM3-Qui devine ?");
		
		container=getContentPane();
		gbl = new GridBagLayout();
		container.setLayout(gbl);
		container.setBackground(new Color(157,238,11));
		
		p1Guess=true;
		
		this.initWhoGuessV();
	}
	
	private void initWhoGuessV(){
		
		whoTitle=new JLabel("  QUI VA DEVINER LE CODE SECRET ?  ");
		whoTitle.setForeground(new Color(90,55,119));
		whoTitle.setBorder(BorderFactory.createEtchedBorder( Color.BLACK,new Color(90,55,119)));
		this.add(whoTitle, new GridBagConstraints (5,1,10,1,100,30,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));

		p1=new JRadioButton("joueur1",true);
		p1.setBackground(new Color(157,238,11));p1.setForeground(new Color(90,55,119));
		this.add(p1, new GridBagConstraints (5,4,5,1,100,20,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));

		p2=new JRadioButton("joueur2");
		p2.setBackground(new Color(157,238,11));p2.setForeground(new Color(90,55,119));
		this.add(p2, new GridBagConstraints (5,6,5,1,100,20,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));

		group=new ButtonGroup();
		group.add(p1); group.add(p2);
		
		whoMake=new JLabel(p1.getText()+"  choisit le code,");
		whoMake.setForeground(new Color(90,55,119));
		this.add(whoMake, new GridBagConstraints (5,10,5,1,50,20,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));

		whoGuess=new JLabel(p2.getText()+"  le devine.");
		whoGuess.setForeground(new Color(90,55,119));
		this.add(whoGuess, new GridBagConstraints (10,10,5,1,50,0,GridBagConstraints.LINE_START,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		js=new JSeparator();
		js.setForeground(new Color(90,55,119));
		this.add(js, new GridBagConstraints (0,11,15,1,0,10,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));
		
		cancel=new JButton("ANNULER");
		cancel.setBackground(new Color(90,55,119)); cancel.setForeground(new Color(157,238,11));
		this.add(cancel, new GridBagConstraints (10,12,2,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));

		validate=new JButton("VALIDER");
		validate.setBackground(new Color(90,55,119)); validate.setForeground(new Color(157,238,11));
		this.add(validate, new GridBagConstraints (13,12,2,1,0,0,GridBagConstraints.LINE_END,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));

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

	public JLabel getWhoMake() {
		return whoMake;
	}

	public JLabel getWhoGuess() {
		return whoGuess;
	}

	public JRadioButton getP1() {
		return p1;
	}

	public JRadioButton getP2() {
		return p2;
	}

	public JButton getCancel() {
		return cancel;
	}

	public JButton getValidate() {
		return validate;
	}

	public boolean isP1Guess() {
		return p1Guess;
	}

	public void setP1Guess(boolean p1Guess) {
		this.p1Guess = p1Guess;
	}
}
