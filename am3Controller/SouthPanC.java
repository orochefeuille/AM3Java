package am3Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import am3Model.IndicationsM;
import am3Model.SolutionBoardM;
import am3Utils.CheckProposalsU;
import am3View.GameVCenterPan;
import am3View.GameVEastPan;
import am3View.GameVNorthPan;
import am3View.GameVSouthPan;
import am3View.MenuV;
import am3View.WhoGuessV;

public class SouthPanC implements ActionListener{
	
	private MenuV menu;
	private GameVSouthPan southPan;
	private GameVCenterPan centerPan;
	private GameVEastPan eastPan;
	private GameVNorthPan northPan;

	private CenterPanC centerPanC;
	private EastPanC eastPanC;
	private SolutionBoardM solution;
	private IndicationsM indications;
	private CheckProposalsU checkProposals;
	private WhoGuessV whoGuess;
		
	private int counter;
	
	public SouthPanC(MenuV menu, GameVSouthPan southPan, GameVCenterPan centerPan, GameVEastPan eastPan, GameVNorthPan norhtPan, CenterPanC centerPanC, EastPanC eastPanC, SolutionBoardM solution,IndicationsM indications, CheckProposalsU checkProposals,WhoGuessV whoGuess){
		
		this.menu=menu;
		this.southPan=southPan;
		this.centerPan=centerPan;
		this.eastPan=eastPan;
		this.northPan=norhtPan;

		this.centerPanC=centerPanC;
		this.eastPanC=eastPanC;
		this.solution=solution;
		this.indications=indications;
		this.checkProposals=checkProposals;
		this.whoGuess=whoGuess;
		
		counter=1;
	}

	public void actionPerformed(ActionEvent ae) {
		JButton source=(JButton)ae.getSource();
		int lines=centerPan.getCenterBoard().length;
		lines=lines-counter;
		
		if(source==southPan.getOkCenter()){
			
			 if(menu.getGameChoice()==0){
				if(lines<1){
				
				}
				if (lines==0){
					for(int j=0;j<centerPan.getCenterBoard()[0].length;j++){
						eastPan.getEastBoard()[lines][j].setEnabled(true);
						checkProposals.checkSolution(solution.getSolution(), centerPan, lines);
						checkProposals.sortResult(eastPan.getEastBoard()[lines]);
						if(checkProposals.checkVictory()){
							southPan.getOkCenter().setEnabled(false);
							for(int i=0;i<solution.getSolution().length;i++){
								solution.getSolution()[i].setVisible(true);
							}
							northPan.getSolutionP().setVisible(true);
							northPan.getWinLost().setText("BRAVO !!!");
							northPan.getWinLost().setVisible(true);
						}
						else if(!checkProposals.checkVictory()){
							northPan.getWinLost().setText("PERDU !");
							northPan.getWinLost().setVisible(true);
							southPan.getOkCenter().setEnabled(false);
							northPan.getSolutionP().setVisible(true);
							for(int i=0;i<solution.getSolution().length;i++){
								solution.getSolution()[i].setVisible(true);
							}
						}
					}
				}
				else {
					checkProposals.checkSolution(solution.getSolution(), centerPan, lines);
					checkProposals.sortResult(eastPan.getEastBoard()[lines]);
				
					if(checkProposals.checkVictory()){
						southPan.getOkCenter().setEnabled(false);
						for(int i=0;i<solution.getSolution().length;i++){
							solution.getSolution()[i].setVisible(true);
							centerPan.getCenterBoard()[lines-1][i].setEnabled(false);
						}
						northPan.getSolutionP().setVisible(true);
						northPan.getWinLost().setText("BRAVO !!!");
						northPan.getWinLost().setVisible(true);
					}
					else if(!checkProposals.checkVictory()){
						for(int j=0;j<centerPan.getCenterBoard()[0].length;j++){
							centerPan.getCenterBoard()[lines][j].setEnabled(false);
							centerPan.getCenterBoard()[lines][j].setDisabledIcon(centerPan.getCenterBoard()[lines][j].getIcon());
							centerPan.getCenterBoard()[lines-1][j].setEnabled(true);
							centerPan.getCenterBoard()[lines-1][j].addMouseListener(centerPanC);
						}
					}
				}
				counter++;	
			 }
			 
			 else if(menu.getGameChoice()!=0){
				if(lines<1){
						
				}
				if(lines>=0){
					southPan.getOkCenter().setEnabled(false);
					southPan.getOkEast().setEnabled(true);
					for(int j=0;j<centerPan.getCenterBoard()[0].length;j++){
						centerPan.getCenterBoard()[lines][j].setEnabled(false);
						centerPan.getCenterBoard()[lines][j].setDisabledIcon(centerPan.getCenterBoard()[lines][j].getIcon());
						eastPan.getEastBoard()[lines][j].setEnabled(true);
						eastPan.getEastBoard()[lines][j].addMouseListener(eastPanC);
					}
				}
			 }
			 this.switchXPlay();
		}
		
		if(source==southPan.getOkEast()){
			if(lines==0){
				for(int j=0;j<centerPan.getCenterBoard()[0].length;j++){
					eastPan.getEastBoard()[lines][j].setEnabled(false);
					eastPan.getEastBoard()[lines][j].setDisabledIcon(eastPan.getEastBoard()[lines][j].getIcon());
					solution.getSolution()[j].setVisible(true);
				}
				southPan.getOkEast().setEnabled(false);
				northPan.getxPlay().setVisible(false);
				northPan.getSolutionP().setVisible(true);
				if(checkProposals.checkVictory2P(indications, eastPan, lines)){
					if(whoGuess.isP1Guess()){
						northPan.getWinLost().setText(whoGuess.getP1().getText()+" GAGNE!");
						northPan.getWinLost().setVisible(true);
					}
					else if(!whoGuess.isP1Guess()){
						northPan.getWinLost().setText(whoGuess.getP2().getText()+" GAGNE!");
						northPan.getWinLost().setVisible(true);
					}
				}
				else if(!checkProposals.checkVictory2P(indications, eastPan, lines)){
					if(whoGuess.isP1Guess()){
						northPan.getWinLost().setText(whoGuess.getP2().getText()+" GAGNE!");
						northPan.getWinLost().setVisible(true);
					}
					else if(!whoGuess.isP1Guess()){
						northPan.getWinLost().setText(whoGuess.getP1().getText()+" GAGNE!");
						northPan.getWinLost().setVisible(true);
					}
				}
			}
			if(lines>0){
				if(checkProposals.checkVictory2P(indications, eastPan, lines)){	
					northPan.getxPlay().setVisible(false);
					for(int j=0;j<eastPan.getEastBoard()[0].length;j++){
						eastPan.getEastBoard()[lines][j].setEnabled(false);
						eastPan.getEastBoard()[lines][j].setDisabledIcon(eastPan.getEastBoard()[lines][j].getIcon());
					}
					southPan.getOkEast().setEnabled(false);
					for(int i=0;i<solution.getSolution().length;i++){
						solution.getSolution()[i].setVisible(true);
						centerPan.getCenterBoard()[lines][i].setEnabled(false);
						centerPan.getCenterBoard()[lines][i].setDisabledIcon(centerPan.getCenterBoard()[lines][i].getIcon());
					}
					northPan.getSolutionP().setVisible(true);
					if(whoGuess.isP1Guess()){
						northPan.getWinLost().setText(whoGuess.getP1().getText()+" GAGNE!");
						northPan.getWinLost().setVisible(true);
					}
					else if(!whoGuess.isP1Guess()){
						northPan.getWinLost().setText(whoGuess.getP2().getText()+" GAGNE!");
						northPan.getWinLost().setVisible(true);
					}
				}
				else if(!checkProposals.checkVictory2P(indications, eastPan, lines)){
					southPan.getOkCenter().setEnabled(true);
					southPan.getOkEast().setEnabled(false);
					for(int j=0;j<centerPan.getCenterBoard()[0].length;j++){
						eastPan.getEastBoard()[lines][j].setEnabled(false);
						eastPan.getEastBoard()[lines][j].setDisabledIcon(eastPan.getEastBoard()[lines][j].getIcon());
						centerPan.getCenterBoard()[lines-1][j].setEnabled(true);
						centerPan.getCenterBoard()[lines-1][j].addMouseListener(centerPanC);
					}
				}
			}
			counter++;	
			this.switchXPlay();
		}
	}
	
	public void switchXPlay(){
		if(northPan.isxPlaySide()){
			northPan.getxPlay().setText(whoGuess.getP2().getText()+" joue");
			northPan.setxPlaySide(false);
		}
		else if(!northPan.isxPlaySide()){
			northPan.getxPlay().setText(whoGuess.getP1().getText()+" joue");
			northPan.setxPlaySide(true);
		}
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}
