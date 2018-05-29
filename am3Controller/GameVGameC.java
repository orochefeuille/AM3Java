package am3Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import am3Model.AvailableColorsM;
import am3Model.ChosenColorsM;
import am3Model.ColorsM;
import am3View.GameV;
import am3View.MenuV;
import am3View.OptionsV;
import am3View.WhoGuessV;


public class GameVGameC  implements ActionListener{

	private MenuV menu;
	private GameV mainFrame;
	private OptionsV options;
	private SouthPanC southPanC;
	private NorthPanC northPanC;
	private AvailableColorsM aColors;
	private ChosenColorsM cColors;
	private ColorsM colors;
	private OptionsBoardsC obC;
	private CenterPanC centerPanC;
	private WhoGuessV whoGuess;
	
	private boolean firstClick;
	
	public GameVGameC(MenuV menu, GameV mainFrame, OptionsV options, SouthPanC southPanC,NorthPanC northPanC, AvailableColorsM aColors, ChosenColorsM cColors, ColorsM colors,OptionsBoardsC obC, CenterPanC centerPanC, WhoGuessV whoGuess){
		
		this.menu=menu;
		this.mainFrame = mainFrame;
		this.options=options;
		this.southPanC=southPanC;
		this.northPanC=northPanC;
		this.aColors=aColors;
		this.cColors=cColors;
		this.colors=colors;
		this.obC=obC;
		this.centerPanC=centerPanC;
		this.whoGuess=whoGuess;
		
		firstClick=true;
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		JMenuItem source = (JMenuItem) ae.getSource();
		
		if(source == mainFrame.getNewGame()){
			
			mainFrame.getSameGame().setEnabled(true);
			
			if(firstClick){
				southPanC.setCounter(1);
				northPanC.setFirstHide(true);
				options.setVisible(true);	
				
				firstClick=false;
				
				if((menu.getGameChoice()!=0)){
					whoGuess.setVisible(true);
				}
				
			}
			else if(!firstClick){
				southPanC.setCounter(1);
				northPanC.setFirstHide(true);
				
				obC.setChipsCount(0);
				obC.getOptionsF().setCheckColors(8);
				options.removeBoards();
				options.reinitFields();
				aColors.reinitAvailableColors(colors, obC);
				cColors.reinitChosenColors(colors, obC);				
				options.relayComponents();
				options.setVisible(true);
				
				mainFrame.getNorthPan().getWinLost().setVisible(false);
				mainFrame.getNorthPan().getSolutionP().setVisible(false);
				
				
				mainFrame.getWestPan().getSelectedColor().setIcon(new ImageIcon("images/caseVide.jpg"));
				mainFrame.getWestPan().getSelectedIndication().setIcon(new ImageIcon("images/caseVide.jpg"));
				mainFrame.getWestPan().removeWestPans();
				mainFrame.getWestPan().getWpColors().reinitwPColors();
				mainFrame.getWestPan().reinitWestPans();
				
				mainFrame.getCenterPan().updateComponents(10, 4);
				mainFrame.getEastPan().updateComponents(10,4);
				
				if((menu.getGameChoice()!=0)){
					mainFrame.getNorthPan().getxPlay().setVisible(false);
					whoGuess.setVisible(true);
				}
			}
		}
		
		if (source == mainFrame.getSameGame()){
			int lines=(int)(Integer.parseInt(options.getTheLines().getText()));
			int squaresPerLine=(int)(Integer.parseInt(options.getTheSquaresPerLine().getText()));
			int numColors=(int)(Integer.parseInt(options.getTheNumberColors().getText()));
			
			southPanC.setCounter(1);
			mainFrame.getSouthPan().getOkCenter().setEnabled(true);
			
			mainFrame.getCenterPan().updateComponents(lines, squaresPerLine);
			mainFrame.getCenterPan().inputMouseListener(lines, squaresPerLine, centerPanC);
			
			mainFrame.getEastPan().updateComponents(lines, squaresPerLine);
			
			mainFrame.getNorthPan().getSolution().reInitSolution(squaresPerLine);
			mainFrame.getNorthPan().updateSolution();
			
			mainFrame.getNorthPan().getWinLost().setVisible(false);
			mainFrame.getNorthPan().getSolutionP().setVisible(false);
			mainFrame.getNorthPan().getxPlay().setVisible(false);
						
			mainFrame.getWestPan().getSelectedColor().setIcon(new ImageIcon("images/caseVide.jpg"));
			
			if(menu.getGameChoice()==0){
				mainFrame.getNorthPan().createSolution(numColors, cColors.getChosenColors());
			}
			else if(menu.getGameChoice()!=0){
				northPanC.setFirstHide(true);
				whoGuess.setVisible(true);
				mainFrame.getNorthPan().getxPlay().setVisible(true);
				mainFrame.getNorthPan().getSolutionP().setVisible(true);
				mainFrame.getNorthPan().inputMouseListener(lines, squaresPerLine, northPanC);
				mainFrame.getNorthPan().setHideSolutionSide(true);
				mainFrame.getNorthPan().getHideSolution().setText("Valider la solution");
			}
		}			
	}

	public boolean isFirstClick() {
		return firstClick;
	}

	public void setFirstClick(boolean firstClick) {
		this.firstClick = firstClick;
	}
}

