package am3Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import am3Model.AvailableColorsM;
import am3Model.ChosenColorsM;
import am3View.AvailablePanV;
import am3View.ChosenPanV;
import am3View.OptionsV;

public class OptionsBoardsC implements MouseListener{
	
	private AvailableColorsM aColors;
	private ChosenColorsM cColors;
	private AvailablePanV aPan;
	private ChosenPanV cPan;
	private OptionsJTFieldsC optionsF;
	private OptionsV options;
	
	private int chipsCount, left, numColors;
	
	public OptionsBoardsC(AvailableColorsM aColors, ChosenColorsM cColors, AvailablePanV aPan, ChosenPanV cPan, OptionsV options, OptionsJTFieldsC optionsF){
		
		this.aColors=aColors;
		this.cColors=cColors;
		this.aPan=aPan;
		this.cPan=cPan;
		this.options=options;
		this.optionsF=optionsF;
		
		chipsCount=0;
		left=optionsF.getCheckColors();
		
	}
	
	private void aColorsClicked(MouseEvent me){
		JLabel source=(JLabel)me.getSource();
		JLabel temp;
		
		if(left>0){
			for(int i=0; i<aColors.getAvailableColors().size();i++){
				if(source==aColors.getAvailableColors().get(i)){
					temp=new JLabel(aColors.getAvailableColors().get(i).getIcon());
					temp.addMouseListener(this);
					cColors.getChosenColors().remove(19);
					cColors.getChosenColors().add(0,temp);
					aColors.getAvailableColors().remove(i);
					aColors.getAvailableColors().add(new JLabel(new ImageIcon("images/caseVide.jpg")));
					aPan.changeIcon(aColors);
					cPan.changeIcon(cColors);
				
					chipsCount++;
				}
			}
		}
	}
	
	private void cColorsClicked(MouseEvent me){
		JLabel source=(JLabel)me.getSource();
		JLabel temp;
		
			for(int i=0; i<cColors.getChosenColors().size();i++){
				if(source==cColors.getChosenColors().get(i)){
					temp=new JLabel(cColors.getChosenColors().get(i).getIcon());
					temp.addMouseListener(this);
					aColors.getAvailableColors().remove(19);
					aColors.getAvailableColors().add(0,temp);
					cColors.getChosenColors().remove(i);
					cColors.getChosenColors().add(new JLabel(new ImageIcon("images/caseVide.jpg")));
					aPan.changeIcon(aColors);
					cPan.changeIcon(cColors);
				
					chipsCount--;
				}
			}
	}
	
	public void mouseClicked(MouseEvent me) {
		numColors=optionsF.getCheckColors();
		
		this.aColorsClicked(me);
		this.cColorsClicked(me);
		left=numColors-chipsCount;
		
		if(left==optionsF.getCheckColors()){
			options.getMinus().setVisible(false);
			options.getValidate().setEnabled(false);
		}
		else if(left<optionsF.getCheckColors() & left>0){
			options.getMinus().setVisible(true);
			options.getValidate().setEnabled(false);
		}
		
		else if(left<0){
			options.getMinus().setVisible(true);
			options.getPlus().setVisible(false);
			options.getValidate().setEnabled(false);
		}
		
		if(left==0){
			options.getPlus().setVisible(false);
			options.getValidate().setEnabled(true);
		}
		
		if(left>0){
			options.getPlus().setVisible(true);
			options.getValidate().setEnabled(false);
		}
		
		
		options.getColorsLeft().setText("Reste "+ left+" couleur(s) à choisir.");
	}

	public void mouseEntered(MouseEvent me) {	
		JLabel source=(JLabel)me.getSource();

		for(JLabel jl:aColors.getAvailableColors()){
			if(source==jl){
				jl.requestFocus();
			}
		}
		
		for(JLabel jl:cColors.getChosenColors()){
			if(source==jl){
				jl.requestFocus();
			}
		}
	}
	public void mouseExited(MouseEvent me) {	
	}

	public void mousePressed(MouseEvent arg0) {		
	}

	public void mouseReleased(MouseEvent arg0) {		
	}

	public int getChipsCount() {
		return chipsCount;
	}

	public void setChipsCount(int chipsCount) {
		this.chipsCount = chipsCount;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getNumColors() {
		return numColors;
	}

	public void setNumColors(int numColors) {
		this.numColors = numColors;
	}

	public OptionsJTFieldsC getOptionsF() {
		return optionsF;
	}
}

