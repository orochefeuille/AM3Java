package am3Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import am3Model.SolutionBoardM;
import am3View.GameVNorthPan;
import am3View.GameVWestPan;
import am3View.WhoGuessV;

public class NorthPanC implements MouseListener, ActionListener{
	
	private GameVNorthPan northPan;
	private GameVWestPan westPan;
	private SolutionBoardM solution;
	private WhoGuessV whoGuess;
	
	private boolean firstHide;
	
	public NorthPanC(GameVNorthPan northPan, GameVWestPan westPan, SolutionBoardM solution, WhoGuessV whoGuess){
		this.northPan=northPan;
		this.westPan=westPan;
		this.solution=solution;
		this.whoGuess=whoGuess;
		
		firstHide=true;
	}

	public void mouseClicked(MouseEvent me) {
		JLabel source=(JLabel)me.getSource();
		
		for(int i=0;i<solution.getSolution().length;i++){
			if(source==solution.getSolution()[i]){
				solution.getSolution()[i].setIcon(westPan.getSelectedColor().getIcon());
			}
		}
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {		
	}

	public void actionPerformed(ActionEvent ae) {
		JButton source=(JButton)ae.getSource();
		
		if(source==northPan.getHideSolution()){
			northPan.switchHideSolutionButton();
			if(firstHide){
				westPan.getSelectedColor().setIcon(new ImageIcon("images/caseVide.jpg"));
				if(whoGuess.isP1Guess()){
					northPan.getxPlay().setText(whoGuess.getP1().getText()+" joue");
					northPan.setxPlaySide(true);
				}
				else if(!whoGuess.isP1Guess()){
					northPan.getxPlay().setText(whoGuess.getP2().getText()+" joue");
					northPan.setxPlaySide(false);
				}
				firstHide=false;
			}
		}
	}

	public boolean isFirstHide() {
		return firstHide;
	}

	public void setFirstHide(boolean firstHide) {
		this.firstHide = firstHide;
	}
}
