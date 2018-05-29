package am3View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import am3Controller.NorthPanC;
import am3Model.SolutionBoardM;

public class GameVNorthPan extends JPanel {

	private static final long serialVersionUID = 1L;
	
	
	private GridBagLayout gbl;
	
	private JLabel xPlay, winLost;
	private JButton hideSolution;
	private boolean hideSolutionSide, xPlaySide;
	
	private SolutionBoardM solution;
	
	private JPanel xPlayP, solutionP, hideP, winLostP;
	
	
	public GameVNorthPan(SolutionBoardM solution){
		
		this.solution=solution;
		
		this.setBackground(new Color(90,55,119));
		
		gbl = new GridBagLayout();
		this.setLayout(gbl);
		
		hideSolutionSide=true;
		xPlaySide=true;
		
		this.layComponents();
	}
	
	private void layComponents(){
		
		xPlayP=new JPanel(); xPlayP.setBackground(new Color(90,55,119));
		solutionP= new JPanel(); solutionP.setBackground(new Color(90,55,119));
		hideP=new JPanel(); hideP.setBackground(new Color(90,55,119));
		winLostP=new JPanel(); winLostP.setBackground(new Color(90,55,119));
		
		xPlay=new JLabel(" joue !");
		xPlay.setBackground(new Color(90,55,119)); xPlay.setForeground(new Color(157,238,11));
		xPlayP.setLayout(gbl);
		xPlayP.add(xPlay, new GridBagConstraints (0, 0, 1, 1, 0, 0,GridBagConstraints.CENTER,GridBagConstraints.CENTER,new Insets (0,0,0,0), 0, 0));
		this.add(xPlayP, new GridBagConstraints (0,0,1,0,20,0,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		for(int i=0;i<solution.getSolution().length;i++){	
			solutionP.add(solution.getSolution()[i]);
		}
		this.add(solutionP, new GridBagConstraints (1,0,1,1,40,0,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		hideSolution=new JButton("Valider la solution");
		hideSolution.setBackground(new Color(157,238,11)); hideSolution.setForeground(new Color(90,55,119));
		hideP.setLayout(gbl);
		hideP.add (hideSolution, new GridBagConstraints (0, 0, 1, 1, 0, 0,GridBagConstraints.CENTER,GridBagConstraints.CENTER,new Insets (0,0,0,0), 0, 0));
		this.add (hideP, new GridBagConstraints (2,0,1,1,20,0,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		winLost=new JLabel("UNTEL GAGNE !");
		winLost.setBackground(new Color(90,55,119)); winLost.setForeground(new Color(157,238,11));
		winLostP.setLayout(gbl);
		winLostP.add (winLost, new GridBagConstraints (0, 0, 1, 1, 0, 0,GridBagConstraints.CENTER,GridBagConstraints.CENTER,new Insets (0,0,0,0), 0, 0));
		this.add(winLostP, new GridBagConstraints (3,0,1,1,20,0,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
	}
	
	public void updateSolution(){
		
		solutionP.removeAll();
		
		for(int i=0;i<solution.getSolution().length;i++){	
			solutionP.add(solution.getSolution()[i]);
		}
		this.add(solutionP, new GridBagConstraints (1,0,1,1,40,0,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
		
		solutionP.revalidate(); solutionP.repaint();
	}
	
	public void createSolution(int numColors,  ArrayList<JLabel> chosenColors){
			
		for (int i=0;i<solution.getSolution().length;i++){
			int alea=(int) (Math.random()*numColors);
			solution.getSolution()[i].setIcon(chosenColors.get(alea).getIcon());
			solution.getSolution()[i].setVisible(false);
		}		
	}
	
	public boolean switchHideSolutionButton(){
		if(hideSolutionSide){
			for(int i=0;i<solution.getSolution().length;i++){
				solution.getSolution()[i].setVisible(false);
			}
			hideSolution.setText("Montrer la soultion");
			hideSolutionSide=false;
		}
		else if(!hideSolutionSide){
			for(int i=0;i<solution.getSolution().length;i++){
				solution.getSolution()[i].setVisible(true);
		}
			hideSolution.setText("Cacher la soultion");
			hideSolutionSide=true;
		}
		return hideSolutionSide;
	}
	
	public void inputMouseListener(int lines, int squaresPerLine, NorthPanC northPanC){
		for(int i=0;i<solution.getSolution().length;i++){
				solution.getSolution()[i].addMouseListener(northPanC);
			}
	}
	
	public JLabel getxPlay() {
		return xPlay;
	}

	public JLabel getWinLost() {
		return winLost;
	}

	public JButton getHideSolution() {
		return hideSolution;
	}

	public SolutionBoardM getSolution() {
		return solution;
	}

	public JPanel getxPlayP() {
		return xPlayP;
	}

	public JPanel getSolutionP() {
		return solutionP;
	}

	public JPanel getHideP() {
		return hideP;
	}

	public JPanel getWinLostP() {
		return winLostP;
	}

	public boolean isxPlaySide() {
		return xPlaySide;
	}

	public void setxPlaySide(boolean xPlaySide) {
		this.xPlaySide = xPlaySide;
	}

	public boolean isHideSolutionSide() {
		return hideSolutionSide;
	}

	public void setHideSolutionSide(boolean hideSolutionSide) {
		this.hideSolutionSide = hideSolutionSide;
	}
}
