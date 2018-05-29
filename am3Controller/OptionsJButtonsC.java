package am3Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import am3Model.ChosenColorsM;
import am3View.GameVCenterPan;
import am3View.GameVEastPan;
import am3View.GameVNorthPan;
import am3View.GameVSouthPan;
import am3View.MenuV;
import am3View.OptionsV;
import am3View.WestPanColorsV;

public class OptionsJButtonsC implements ActionListener{
	
	private OptionsV options;
	
	private MenuV menu;
	private GameVNorthPan northPan;
	private NorthPanC northPanC;
	private GameVCenterPan centerPan;
	private CenterPanC centerPanC;
	private GameVEastPan eastPan;
	private WestPanColorsV westPanColors;
	private WestPanColorsC wpColorsC;
	private ChosenColorsM chosenColors;
	private GameVSouthPan southPan;
	
	public OptionsJButtonsC(MenuV menu, OptionsV options,GameVNorthPan northPan,NorthPanC northPanC, GameVCenterPan centerPan,CenterPanC centerPanC, GameVEastPan eastPan, WestPanColorsV westPanColors,WestPanColorsC wpColorsC, ChosenColorsM chosenColors, GameVSouthPan southPan){
		
		this.menu=menu;
		this.options=options;
		this.northPan=northPan;
		this.northPanC=northPanC;
		this.centerPan=centerPan;
		this.centerPanC=centerPanC;
		this.eastPan=eastPan;
		this.westPanColors=westPanColors;
		this.wpColorsC=wpColorsC;
		this.chosenColors=chosenColors;
		this.southPan=southPan;
	}
	
	public void actionPerformed(ActionEvent ae) {
		JButton source=(JButton)ae.getSource();
		
		if(source==options.getValidate()){
			int lines=(int)(Integer.parseInt(options.getTheLines().getText()));
			int squaresPerLine=(int)(Integer.parseInt(options.getTheSquaresPerLine().getText()));
			int numColors=(int)(Integer.parseInt(options.getTheNumberColors().getText()));
			
			centerPan.updateComponents(lines, squaresPerLine);
			centerPan.inputMouseListener(lines, squaresPerLine, centerPanC);
			
			eastPan.updateComponents(lines, squaresPerLine);
			
			northPan.getSolution().reInitSolution(squaresPerLine);
			northPan.updateSolution();
						
			westPanColors.updatewPColors(numColors, chosenColors.getChosenColors());
			westPanColors.inputMouseListerner(numColors, wpColorsC);
			
			southPan.getOkCenter().setEnabled(true);
			
			if(menu.getGameChoice()==0){
				northPan.createSolution(numColors, chosenColors.getChosenColors());
			}
			else if(menu.getGameChoice()!=0){
				northPan.getxPlay().setVisible(true);
				northPan.getSolutionP().setVisible(true);
				northPan.inputMouseListener(lines, squaresPerLine, northPanC);
				northPan.setHideSolutionSide(true);
				northPan.getHideSolution().setText("Valider la solution");
				northPan.getHideSolution().setVisible(true);
			}
			
			options.setVisible(false);
					
		}
		
		if(source==options.getCancel()){
			options.setVisible(false);
		}
	}

}
