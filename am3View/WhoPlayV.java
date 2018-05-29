package am3View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class WhoPlayV  extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private int gameVHeight, gameVWidth;
	
	private Container container;
	private GridBagLayout gbl;
	
	private JLabel player1Surname, player2Surname, player1IP, player2IP, player1Gate, player2Gate, whoPlayTitle;
	private JTextField p1Surname, p2Surname, p1IP, p2IP, p1Gate, p2Gate;
	private JButton createGame, joinGame, cancel, validate;
	private JSeparator js0, js1, js2;
	
	public WhoPlayV(){
		
		gameVHeight=this.makeScreenHeightSize();
		gameVWidth=this.makeScreenWidthSize();
		this.setSize(gameVWidth, gameVHeight);
		this.setLocationRelativeTo(this.getParent());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("AM3-Qui joue ?");
		
		container=getContentPane();
		gbl = new GridBagLayout();
		container.setLayout(gbl);
		container.setBackground(new Color(157,238,11));
		
		this.initWhoGuessV();
	}
	
	private void initWhoGuessV(){
		
		whoPlayTitle=new JLabel("  QUI JOUE ?  ");
		whoPlayTitle.setForeground(new Color(90,55,119));
		whoPlayTitle.setBorder(BorderFactory.createEtchedBorder( Color.BLACK,new Color(90,55,119)));
		this.add(whoPlayTitle, new GridBagConstraints (0,2,20,1,0,40,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		createGame=new JButton("Créer une partie");
		createGame.setBackground(new Color(90,55,119)); createGame.setForeground(new Color(157,238,11));
		this.add(createGame, new GridBagConstraints (3,4,8,1,50,10,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		joinGame=new JButton("Rejoindre une partie");
		joinGame.setBackground(new Color(90,55,119)); joinGame.setForeground(new Color(157,238,11));
		this.add(joinGame, new GridBagConstraints (12,4,8,1,50,0,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		js0=new JSeparator();
		js0.setForeground(new Color(90,55,119));
		this.add(js0, new GridBagConstraints (0,5,20,1,0,10,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));
		
		player1Surname=new JLabel("Joueur 1 : ");
		player1Surname.setForeground(new Color(90,55,119));
		this.add(player1Surname, new GridBagConstraints (2,6,3,1,50,10,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		p1Surname=new JTextField("Joueur 1");
		p1Surname.setForeground(new Color(90,55,119));
		this.add(p1Surname, new GridBagConstraints (9,6,10,1,50,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));
		
		player1IP=new JLabel("IP : ");
		player1IP.setForeground(new Color(90,55,119));
		this.add(player1IP, new GridBagConstraints (2,8,3,1,50,10,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		p1IP=new JTextField("");
		p1IP.setForeground(new Color(90,55,119));
		this.add(p1IP, new GridBagConstraints (9,8,10,1,50,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));
			
		player1Gate=new JLabel("Port : ");
		player1Gate.setForeground(new Color(90,55,119));
		this.add(player1Gate, new GridBagConstraints (2,10,3,1,50,10,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		p1Gate=new JTextField("7272");
		p1Gate.setForeground(new Color(90,55,119));
		this.add(p1Gate, new GridBagConstraints (9,10,1,1,50,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));
		
		js1=new JSeparator();
		js1.setForeground(new Color(90,55,119));
		this.add(js1, new GridBagConstraints (0,11,20,1,0,10,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));
				
		player2Surname=new JLabel("Joueur 2 : ");
		player2Surname.setForeground(new Color(90,55,119));
		this.add(player2Surname, new GridBagConstraints (2,12,3,1,50,10,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		p2Surname=new JTextField("Joueur 2");
		p2Surname.setForeground(new Color(90,55,119));
		this.add(p2Surname, new GridBagConstraints (9,12,10,1,50,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));

		player2IP=new JLabel("IP : ");
		player2IP.setForeground(new Color(90,55,119));
		this.add(player2IP, new GridBagConstraints (2,14,3,1,50,10,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		p2IP=new JTextField("");
		p2IP.setForeground(new Color(90,55,119));
		this.add(p2IP, new GridBagConstraints (5,14,10,1,100,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));
		
		player2Gate=new JLabel("Port : ");
		player2Gate.setForeground(new Color(90,55,119));
		this.add(player2Gate, new GridBagConstraints (2,16,3,1,50,10,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		p2Gate=new JTextField("7272");
		p2Gate.setForeground(new Color(90,55,119));
		this.add(p2Gate, new GridBagConstraints (9,16,1,1,50,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));
		
		js2=new JSeparator();
		js2.setForeground(new Color(90,55,119));
		this.add(js2, new GridBagConstraints (0,17,20,1,0,10,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));
		
		cancel=new JButton("ANNULER");
		cancel.setBackground(new Color(90,55,119)); cancel.setForeground(new Color(157,238,11));
		this.add(cancel, new GridBagConstraints (10,18,5,1,70,10,GridBagConstraints.LINE_END,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));

		validate=new JButton("VALIDER");
		validate.setBackground(new Color(90,55,119)); validate.setForeground(new Color(157,238,11));
		this.add(validate, new GridBagConstraints (15,18,5,1,40,0,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));

	}
		
	private int makeScreenHeightSize(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = (int)(screenSize.getHeight()*0.4);		
		return screenHeight;
	}
	
	private int makeScreenWidthSize(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)(screenSize.getWidth()*0.20);		
		return screenWidth;
	}

	public JTextField getP1Surname() {
		return p1Surname;
	}

	public JTextField getP2Surname() {
		return p2Surname;
	}

	public JTextField getP1IP() {
		return p1IP;
	}

	public JTextField getP2IP() {
		return p2IP;
	}

	public JTextField getP1Gate() {
		return p1Gate;
	}

	public JTextField getP2Gate() {
		return p2Gate;
	}

	public JButton getCreateGame() {
		return createGame;
	}

	public JButton getJoinGame() {
		return joinGame;
	}

	public JButton getCancel() {
		return cancel;
	}

	public JButton getValidate() {
		return validate;
	}

	public JSeparator getJs1() {
		return js1;
	}

	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}

	public JLabel getPlayer1IP() {
		return player1IP;
	}

	public JLabel getPlayer2IP() {
		return player2IP;
	}

	public JLabel getPlayer1Gate() {
		return player1Gate;
	}

	public JLabel getPlayer2Gate() {
		return player2Gate;
	}

	public JLabel getPlayer1Surname() {
		return player1Surname;
	}

	public JLabel getPlayer2Surname() {
		return player2Surname;
	}

	public JSeparator getJs0() {
		return js0;
	}

	
}
