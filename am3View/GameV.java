package am3View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class GameV extends JFrame{

	private static final long serialVersionUID = 1L;

	private int gameVHeight, gameVWidth;
	private JMenuBar menuBar;
	private JMenu files, game, about;
	private JMenuItem menu, quit, newGame, sameGame, aboutMe;
	
	private GameVNorthPan northPan;
	private GameVSouthPan southPan;
	private GameVWestPan westPan;
	private GameVCenterPan centerPan;
	private GameVEastPan eastPan;
	
	public GameV(GameVNorthPan northPan, GameVSouthPan southPan, GameVWestPan westPan, GameVCenterPan centerPan, GameVEastPan eastPan){
		
		this.northPan=northPan;
		this.southPan=southPan;
		this.westPan=westPan;
		this.centerPan=centerPan;
		this.eastPan=eastPan;
		
		gameVHeight=this.makeScreenHeightSize();
		gameVWidth=this.makeScreenWidthSize();
		this.setBounds(gameVWidth*1/5,gameVHeight*1/20,gameVWidth, gameVHeight/2);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("AM3");
		
		this.setLayout(new BorderLayout());
		
		this.createMenuBar();
		this.inputPans();
		
	}
	
	private void createMenuBar(){
		menuBar = new JMenuBar();
		
		files= new JMenu("Fichier"); files.setMnemonic('F');
		game = new JMenu("Jeu"); game.setMnemonic('J');
		about = new JMenu("Crédits"); about.setMnemonic('C');
		
		menu = new JMenuItem("Menu"); menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK)); menu.setMnemonic('M');
		newGame = new JMenuItem("Nouvelle partie"); newGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK)); newGame.setMnemonic('N');
		sameGame = new JMenuItem("Rejouer la même partie"); sameGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK)); sameGame.setMnemonic('R');
		sameGame.setEnabled(false);
		quit = new JMenuItem("Quitter"); quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK)); quit.setMnemonic('Q');
		aboutMe = new JMenuItem("A propos"); aboutMe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK)); aboutMe.setMnemonic('A');
		
		files.add(menu); files.add(quit);
		game.add(newGame); game.add(sameGame);
		about.add(aboutMe);
		
		menuBar.add(files); menuBar.add(game); menuBar.add(about);
		this.setJMenuBar(menuBar);
	}
	
	private void inputPans(){
		
		northPan.getxPlayP().setPreferredSize(new Dimension(gameVWidth*1/6,gameVHeight*1/15));
		northPan.getSolutionP().setPreferredSize(new Dimension(gameVWidth*2/6,gameVHeight*1/15));
		northPan.getHideP().setPreferredSize(new Dimension(gameVWidth*1/6,gameVHeight*1/15));
		northPan.getWinLostP().setPreferredSize(new Dimension(gameVWidth*1/6,gameVHeight*1/15));
		northPan.setPreferredSize(new Dimension(gameVWidth,gameVHeight*1/15));
		this.add(northPan,"North");
		
		southPan.getPan1().setPreferredSize(new Dimension(gameVWidth*1/6,gameVHeight*1/25));
		southPan.getOkCenterP().setPreferredSize(new Dimension(gameVWidth*2/6,gameVHeight*1/25));
		southPan.getOkEastP().setPreferredSize(new Dimension(gameVWidth*2/6,gameVHeight*1/25));
		southPan.setPreferredSize(new Dimension(gameVWidth,gameVHeight*1/18));
		this.add(southPan,"South");
		
		westPan.setPreferredSize(new Dimension(gameVWidth*1/5,gameVHeight));
		this.add(westPan,"West");
		
		centerPan.setPreferredSize(new Dimension(gameVWidth*2/5,gameVHeight));
		this.add(centerPan,"Center");
		
		eastPan.setPreferredSize(new Dimension(gameVWidth*2/5,gameVHeight));
		this.add(eastPan,"East");
	}
	
	private int makeScreenHeightSize(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = (int)(screenSize.getHeight()*0.9);		
		return screenHeight;
	}
	
	private int makeScreenWidthSize(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)(screenSize.getWidth()*0.6);	
		return screenWidth;
	}

	public int getGameVHeight() {
		return gameVHeight;
	}

	public void setGameVHeight(int gameVHeight) {
		this.gameVHeight = gameVHeight;
	}

	public int getGameVWidth() {
		return gameVWidth;
	}

	public void setGameVWidth(int gameVWidth) {
		this.gameVWidth = gameVWidth;
	}

	public JMenuItem getMenu() {
		return menu;
	}

	public JMenuItem getQuit() {
		return quit;
	}

	public JMenuItem getNewGame() {
		return newGame;
	}

	public JMenuItem getSameGame() {
		return sameGame;
	}

	public JMenuItem getAboutMe() {
		return aboutMe;
	}

	public GameVNorthPan getNorthPan() {
		return northPan;
	}

	public GameVSouthPan getSouthPan() {
		return southPan;
	}

	public GameVWestPan getWestPan() {
		return westPan;
	}

	public GameVCenterPan getCenterPan() {
		return centerPan;
	}

	public GameVEastPan getEastPan() {
		return eastPan;
	}
	
}
