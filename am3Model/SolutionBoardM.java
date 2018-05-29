package am3Model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SolutionBoardM {
	
	private JLabel solution[];
	
	public SolutionBoardM(){
		
		this.initSolution();
	}
	
	public void initSolution(){
		solution= new JLabel[4];
		for(int i=0; i<4;i++){
			solution[i]= new JLabel(new ImageIcon("images/caseVide.jpg"));
		}
	}
	
	public void reInitSolution(int lines){
		solution= new JLabel[lines];
		for(int i=0; i<lines;i++){
			solution[i]= new JLabel(new ImageIcon("images/caseVide.jpg"));
		}
	}
	

	public JLabel[] getSolution() {
		return solution;
	}

	public void setSolution(JLabel[] solution) {
		this.solution = solution;
	}
}
