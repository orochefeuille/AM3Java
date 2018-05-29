package am3Main;

import javax.swing.JLabel;

import am3Controller.CenterPanC;
import am3Controller.ChatC;
import am3Controller.EastPanC;
import am3Controller.GameVAboutC;
import am3Controller.GameVFilesC;
import am3Controller.GameVGameC;
import am3Controller.MenuC;
import am3Controller.NorthPanC;
import am3Controller.OptionsBoardsC;
import am3Controller.OptionsJButtonsC;
import am3Controller.OptionsJTFieldsC;
import am3Controller.SouthPanC;
import am3Controller.WestPanColorsC;
import am3Controller.WestPanIndicationsC;
import am3Controller.WhoGuessC;
import am3Controller.WhoPlayC;
import am3Model.AvailableColorsM;
import am3Model.ChosenColorsM;
import am3Model.ColorsM;
import am3Model.IndicationsM;
import am3Model.SolutionBoardM;
import am3Utils.CheckProposalsU;
import am3Utils.ConnexionsU;
import am3View.AboutMe;
import am3View.AvailablePanV;
import am3View.ChatV;
import am3View.ChosenPanV;
import am3View.GameV;
import am3View.GameVCenterPan;
import am3View.GameVEastPan;
import am3View.GameVNorthPan;
import am3View.GameVSouthPan;
import am3View.GameVWestPan;
import am3View.MenuV;
import am3View.OptionsV;
import am3View.WestPanColorsV;
import am3View.WestPanIndicationsV;
import am3View.WhoGuessV;
import am3View.WhoPlayV;

public class Main {
		
	public static void main(String[] args) {
		
		//les outils
		CheckProposalsU checkProposals=new CheckProposalsU();
		ConnexionsU connexions=new ConnexionsU();
		
		// les objets
		ColorsM colors = new ColorsM();
		IndicationsM indications = new IndicationsM();
		
		AvailableColorsM colorsBoard = new AvailableColorsM(colors);
		ChosenColorsM chosenBoard = new ChosenColorsM(colors);
		
		SolutionBoardM solution = new SolutionBoardM();
		
		// les vues	
		MenuV menu = new MenuV();
		menu.setVisible(true);
		
		GameVNorthPan northPan=new GameVNorthPan(solution);
		GameVSouthPan southPan=new GameVSouthPan();
		
		WestPanColorsV wpColors = new WestPanColorsV();
		WestPanIndicationsV wpIndications = new WestPanIndicationsV(indications);
		GameVWestPan westPan=new GameVWestPan(wpColors, wpIndications);
		GameVCenterPan centerPan=new GameVCenterPan();
		GameVEastPan eastPan=new GameVEastPan();
		
		GameV mainFrame = new GameV(northPan, southPan, westPan, centerPan, eastPan);
		
		AvailablePanV availablePan = new AvailablePanV(colorsBoard);
		ChosenPanV chosenPan = new ChosenPanV(chosenBoard);		
		OptionsV options=new OptionsV(availablePan, chosenPan);
		
		WhoGuessV whoGuess=new WhoGuessV();
		
		WhoPlayV whoPlay=new WhoPlayV();
		
		ChatV chat=new ChatV();
		//chat.setVisible(true);
		
		// les contrôleurs
		
		MenuC menuC = new MenuC(menu, mainFrame, whoPlay);
		
		WestPanColorsC wpColorsC = new WestPanColorsC(wpColors, westPan);
		WestPanIndicationsC wpIndicationsC = new WestPanIndicationsC(indications, westPan);
		
		CenterPanC centerPanC = new CenterPanC(centerPan, westPan);
		EastPanC eastPanC = new EastPanC(eastPan, westPan);
		
		SouthPanC southPanC=new SouthPanC(menu, southPan, centerPan, eastPan, northPan, centerPanC, eastPanC, solution,indications, checkProposals, whoGuess);
		
		NorthPanC northPanC=new NorthPanC(northPan, westPan, solution, whoGuess);
		
		OptionsJTFieldsC optionsFieldsC = new OptionsJTFieldsC(options);
		OptionsJButtonsC optionsButtonsC = new OptionsJButtonsC(menu, options,northPan,northPanC, centerPan, centerPanC, eastPan, wpColors,wpColorsC, chosenBoard, southPan);
		
		OptionsBoardsC colorBoardsC=new OptionsBoardsC(colorsBoard, chosenBoard, availablePan, chosenPan, options, optionsFieldsC);
		WhoGuessC whoGuessC=new WhoGuessC(whoGuess,northPan);
		WhoPlayC whoPlayC=new WhoPlayC(whoPlay, whoGuess);
		
		AboutMe aboutMe= new AboutMe();
		
		GameVFilesC filesC = new GameVFilesC(menu, mainFrame);
		GameVGameC gameC = new GameVGameC(menu, mainFrame, options, southPanC,northPanC, colorsBoard, chosenBoard, colors, colorBoardsC, centerPanC, whoGuess);
		GameVAboutC aboutC = new GameVAboutC(mainFrame, aboutMe);
		
		ChatC chatC=new ChatC(chat);
		
		// ajout des écouteurs
		mainFrame.getMenu().addActionListener(filesC);
		mainFrame.getQuit().addActionListener(filesC);
		mainFrame.getNewGame().addActionListener(gameC);
		mainFrame.getSameGame().addActionListener(gameC);
		mainFrame.getAboutMe().addActionListener(aboutC);
		
		menu.getSolo().addActionListener(menuC);
		menu.getTwoPc().addActionListener(menuC);
		menu.getTwoLan().addActionListener(menuC);
		menu.getTwoNet().addActionListener(menuC);
		
		for (int i=0;i<3;i++){
			indications.getIndicBoard()[i].addMouseListener(wpIndicationsC);
		}
		
		for(JLabel jl: colorsBoard.getAvailableColors()){
			jl.addMouseListener(colorBoardsC);
		}
		
		southPan.getOkCenter().addActionListener(southPanC);
		southPan.getOkEast().addActionListener(southPanC);
		
		northPan.getHideSolution().addActionListener(northPanC);
		
		options.getTheLines().addFocusListener(optionsFieldsC);
		options.getTheSquaresPerLine().addFocusListener(optionsFieldsC);
		options.getTheNumberColors().addFocusListener(optionsFieldsC);
		options.getValidate().addActionListener(optionsButtonsC);
		options.getCancel().addActionListener(optionsButtonsC);
		
		whoGuess.getP1().addActionListener(whoGuessC);
		whoGuess.getP1().addActionListener(whoGuessC);
		whoGuess.getValidate().addActionListener(whoGuessC);
		whoGuess.getCancel().addActionListener(whoGuessC);
		
		whoPlay.getP1Surname().addActionListener(whoPlayC);
		whoPlay.getP1IP().addActionListener(whoPlayC);
		whoPlay.getP1Gate().addActionListener(whoPlayC);
		whoPlay.getP2Surname().addActionListener(whoPlayC);
		whoPlay.getP2IP().addActionListener(whoPlayC);
		whoPlay.getP2Gate().addActionListener(whoPlayC);
		whoPlay.getCreateGame().addActionListener(whoPlayC);
		whoPlay.getJoinGame().addActionListener(whoPlayC);
		whoPlay.getCancel().addActionListener(whoPlayC);
		whoPlay.getValidate().addActionListener(whoPlayC);	
	}
}
