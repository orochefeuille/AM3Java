package am3View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import am3Controller.CenterPanC;

public class GameVCenterPan extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel [][]centerBoard;
		
	public GameVCenterPan(){
				
		this.setBackground(new Color(157,238,11));
		this.setBorder(BorderFactory.createLineBorder(new Color(99,55,119)));
		 
		centerBoard=new JLabel[10][4];
		
		this.layComponents();
	}
	
	private void layComponents(){
		this.setLayout(new GridLayout(10,4));
				
		for(int i=0;i<10;i++){			
			for(int j=0;j<4;j++){
				centerBoard[i][j]=new JLabel(new ImageIcon("images/caseVide.jpg"));
				centerBoard[i][j].setEnabled(false);
				this.add(centerBoard[i][j]);
			}
		}
	}
	
	public void updateComponents(int lines, int squaresPerLine){
		
		this.removeAll();
		
		this.setLayout(new GridLayout(lines,squaresPerLine));
		centerBoard=new JLabel[lines][squaresPerLine];
	
		for(int i=0;i<lines;i++){			
			for(int j=0;j<squaresPerLine;j++){
				centerBoard[i][j]=new JLabel(new ImageIcon("images/caseVide.jpg"));	
				centerBoard[i][j].setEnabled(false);
				this.add(centerBoard[i][j]);
			}
		}
		for(int j=0;j<squaresPerLine;j++){
			centerBoard[lines-1][j].setEnabled(true);
		}
		this.revalidate(); this.repaint();
	}

	public void inputMouseListener(int lines, int squaresPerLine, CenterPanC centerPanC){
		for(int i=0;i<this.getCenterBoard().length;i++){
			for(int j=0;j<this.getCenterBoard()[i].length;j++){
				this.getCenterBoard()[lines-1][j].addMouseListener(centerPanC);
			}
		}
	}
	
	public JLabel[][] getCenterBoard() {
		return centerBoard;
	}

	public void setCenterBoard(JLabel[][] centerBoard) {
		this.centerBoard = centerBoard;
	}
}
