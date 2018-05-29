package am3Model;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ColorsM {
	
	private JLabel 	colorsBoard[] ;
	private JLabel 	caseVide,bleu,cyan,degbleu,degcyan,degjaune,degmarron,degrose, degrouge,degvert,
					etoilebleu, etoilecyan,etoilejaune,etoilerose,etoilerouge,etoilevert,
					jaune, marron, rose,rouge,vert;
	
	public ColorsM(){
		colorsBoard = new JLabel[21];
		/*ImageIcon icon = new ImageIcon(new ImageIcon("images/caseVide.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		caseVide = new JLabel(icon);*/
		caseVide = new JLabel(new ImageIcon("images/caseVide.jpg"));
		bleu = new JLabel(new ImageIcon("images/bleu.jpg"));
		cyan = new JLabel(new ImageIcon("images/cyan.jpg"));
		degbleu = new JLabel(new ImageIcon("images/degbleu.jpg"));
		degcyan = new JLabel(new ImageIcon("images/degcyan.jpg"));
		degjaune = new JLabel(new ImageIcon("images/degjaune.jpg"));
		degmarron = new JLabel(new ImageIcon("images/degmarron.jpg"));
		degrose = new JLabel(new ImageIcon("images/degrose.jpg"));
		degrouge = new JLabel(new ImageIcon("images/degrouge.jpg"));
		degvert = new JLabel(new ImageIcon("images/degvert.jpg"));
		etoilebleu = new JLabel(new ImageIcon("images/etoilebleu.jpg"));
		etoilecyan = new JLabel(new ImageIcon("images/etoilecyan.jpg"));
		etoilejaune = new JLabel(new ImageIcon("images/etoilejaune.jpg"));
		etoilerose = new JLabel(new ImageIcon("images/etoilerose.jpg"));
		etoilerouge = new JLabel(new ImageIcon("images/etoilerouge.jpg"));
		etoilevert = new JLabel(new ImageIcon("images/etoilevert.jpg"));
		jaune = new JLabel(new ImageIcon("images/jaune.jpg"));
		marron = new JLabel(new ImageIcon("images/marron.jpg"));
		rose = new JLabel(new ImageIcon("images/rose.jpg"));
		rouge = new JLabel(new ImageIcon("images/rouge.jpg"));
		vert = new JLabel(new ImageIcon("images/vert.jpg"));
		
		colorsBoard[0]=caseVide;	
		colorsBoard[1]=bleu;
		colorsBoard[2]=cyan;
		colorsBoard[3]=degbleu;
		colorsBoard[4]=degcyan;
		colorsBoard[5]=degjaune;
		colorsBoard[6]=degmarron;
		colorsBoard[7]=degrose;
		colorsBoard[8]=degrouge;
		colorsBoard[9]=degvert;
		colorsBoard[10]=etoilebleu;
		colorsBoard[11]=etoilecyan;
		colorsBoard[12]=etoilejaune;
		colorsBoard[13]=etoilerose;
		colorsBoard[14]=etoilerouge;
		colorsBoard[15]=etoilevert;
		colorsBoard[16]=jaune;
		colorsBoard[17]=marron;
		colorsBoard[18]=rose;
		colorsBoard[19]=rouge;
		colorsBoard[20]=vert;
	}

	public JLabel[] getColorsBoard() {
		return colorsBoard;
	}

	public void setColorsBoard(JLabel[] colorsBoard) {
		this.colorsBoard = colorsBoard;
	}
}
