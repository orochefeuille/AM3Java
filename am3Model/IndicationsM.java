package am3Model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class IndicationsM {
	
	private JLabel indicBoard[] ;
	private JLabel indiceBlanc, indiceNoir, caseVide;
	
	public IndicationsM(){
		indicBoard = new JLabel[3];
		
		indiceNoir = new JLabel(new ImageIcon("images/indiceNoir.jpg"));
		indiceBlanc = new JLabel(new ImageIcon("images/indiceBlanc.jpg"));
		caseVide = new JLabel(new ImageIcon("images/caseVide.jpg"));
		
		indicBoard[0] = indiceNoir;
		indicBoard[1] = indiceBlanc;
		indicBoard[2] = caseVide;
	}

	public JLabel[] getIndicBoard() {
		return indicBoard;
	}

	public void setIndicBoard(JLabel[] indicBoard) {
		this.indicBoard = indicBoard;
	}
	
}
