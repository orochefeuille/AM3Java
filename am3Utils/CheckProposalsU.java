package am3Utils;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import am3Model.IndicationsM;
import am3View.GameVCenterPan;
import am3View.GameVEastPan;

public class CheckProposalsU {
	
	private JLabel [] solutionBis;
	private JLabel [] centerPanLineBis;
	private JLabel [] result;
	private int [] points;
	
	private JLabel black, white, empty;
	
	public CheckProposalsU(){
		
		solutionBis=new JLabel[4];
		centerPanLineBis=new JLabel[4];
		result=new JLabel[4];
		points=new int [4];
		
		black=new JLabel(new ImageIcon("images/indiceNoir.jpg"));
		white=new JLabel(new ImageIcon("images/indiceBlanc.jpg"));
		empty=new JLabel(new ImageIcon("images/caseVide.jpg"));

	}
	
	public void checkSolution(JLabel [] solution, GameVCenterPan centerPan, int lines){
		
		solutionBis=new JLabel[solution.length];
		centerPanLineBis=new JLabel[solution.length];
		result=new JLabel[solution.length];
		
		for(int i=0; i<solution.length;i++){
			solutionBis[i]=new JLabel(new ImageIcon("images/caseVide.jpg"));
			solutionBis[i].setIcon(solution[i].getIcon());
			centerPanLineBis[i]=new JLabel(new ImageIcon("images/caseVide.jpg"));
			centerPanLineBis[i].setIcon(centerPan.getCenterBoard()[lines][i].getIcon());
			result[i]=new JLabel(new ImageIcon("images/caseVide.jpg"));
		}
		
		for(int i=0;i<solution.length;i++){
			for(int j=0;j<solution.length;j++){
				if(centerPanLineBis[i].getIcon()==solutionBis[i].getIcon()){
					solutionBis[i].setIcon(null);
					centerPanLineBis[i].setIcon(empty.getIcon());
					result[i].setIcon(black.getIcon());
				}
			}
		}
		
		for(int i=0;i<solution.length;i++){
			for(int j=0;j<solution.length;j++){
				if(centerPanLineBis[i].getIcon()==solutionBis[j].getIcon() & i!=j){
					solutionBis[j].setIcon(null);
					centerPanLineBis[i].setIcon(empty.getIcon());
					result[i].setIcon(white.getIcon());
				}
			}
		}
		
		for(int i=0; i<solution.length;i++){
			if(result[i].getIcon()!=white.getIcon() & result[i].getIcon()!=black.getIcon()){
				result[i].setIcon(empty.getIcon());
			}
		}
	}
	
	public void sortResult(JLabel []eastPanLine){
		JLabel temp=new JLabel(new ImageIcon(""));
		
		for(int i=0; i<eastPanLine.length;i++){
			for(int j=eastPanLine.length-1;j>i;j--)	{
				if(result[i].getIcon()==empty.getIcon() & result[j].getIcon()==white.getIcon()){
					temp.setIcon(result[i].getIcon());
					result[i].setIcon(result[j].getIcon());
					result[j].setIcon(temp.getIcon());
				}
				if(result[i].getIcon()==empty.getIcon() & result[j].getIcon()==black.getIcon()){
					temp.setIcon(result[i].getIcon());
					result[i].setIcon(result[j].getIcon());
					result[j].setIcon(temp.getIcon()); 
				}
				if(result[i].getIcon()==white.getIcon() & result[j].getIcon()==black.getIcon()){
					temp.setIcon(result[i].getIcon());
					result[i].setIcon(result[j].getIcon());
					result[j].setIcon(temp.getIcon());
				}
			}
		}

		for(int i=0; i<eastPanLine.length;i++){
			eastPanLine[i].setEnabled(true);
			eastPanLine[i].setIcon(result[i].getIcon());
		}
	}
	
	public boolean checkVictory(){
		boolean victory=false;
			if(result[0].getIcon()==black.getIcon() & result[result.length-1].getIcon()==black.getIcon()){
				victory=true;
			}
		return victory;
	}	
	
	public boolean checkVictory2P(IndicationsM indications,GameVEastPan eastPan, int lines){
		boolean victory=false;
		int sumPoints=0;
		
		points=new int [eastPan.getEastBoard()[lines].length];
		for (int i=0; i<points.length;i++){
			points[i]=1;
			sumPoints+=points[i];
		}
		for(int j=0; j<eastPan.getEastBoard()[lines].length;j++){
			if(eastPan.getEastBoard()[lines][j].getIcon()==indications.getIndicBoard()[0].getIcon()){
				points[j]=-1;
				sumPoints+=points[j];
			}
		}
		if (sumPoints==0){
			victory=true;
		}
		return victory;
	}
}
