package am3View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import am3Controller.EastPanC;


public class GameVEastPan extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel [][]eastBoard;

	public GameVEastPan(){
				
		this.setBackground(new Color(157,238,11));
		this.setBorder(BorderFactory.createLineBorder(new Color(99,55,119)));
		
		eastBoard=new JLabel[10][4];

		this.layComponents();
	}
	
	private void layComponents(){
		this.setLayout(new GridLayout(10,4));
				
		for(int i=0;i<10;i++){			
			for(int j=0;j<4;j++){
				eastBoard[i][j]=new JLabel(new ImageIcon("images/caseVide.jpg"));
				eastBoard[i][j].setEnabled(false);
				this.add(eastBoard[i][j]);
			}
		}
	}
	
	public void updateComponents(int lines, int squaresPerLine){
		
		this.removeAll();
		eastBoard=new JLabel[lines][squaresPerLine];

		this.setLayout(new GridLayout(lines,squaresPerLine));
				
		for(int i=0;i<lines;i++){			
			for(int j=0;j<squaresPerLine;j++){
				eastBoard[i][j]=new JLabel(new ImageIcon("images/caseVide.jpg"));
				eastBoard[i][j].setEnabled(false);
				this.add(eastBoard[i][j]);
			}
		}
		
		this.revalidate(); this.repaint();

	}
	
	public void inputMouseListener(int lines, int squaresPerLine, EastPanC eastPanC){
		for(int i=0;i<this.getEastBoard().length;i++){
			for(int j=0;j<this.getEastBoard()[i].length;j++){
				this.getEastBoard()[lines-1][j].addMouseListener(eastPanC);
			}
		}
	}
	
/*	public void outputMouseListener(CenterPanC eastrPanC){
		for(int i=0;i<this.getEastBoard().length;i++){
			for(int j=0;j<this.getEastBoard()[i].length;j++){
				this.getEastBoard()[i][j].removeMouseListener(eastPanC);
			}
		}
	}*/

	public JLabel[][] getEastBoard() {
		return eastBoard;
	}

	public void setEastBoard(JLabel[][] eastBoard) {
		this.eastBoard = eastBoard;
	}
}
