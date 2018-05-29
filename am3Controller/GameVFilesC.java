package am3Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import am3View.GameV;
import am3View.MenuV;


public class GameVFilesC implements ActionListener{

	private MenuV menu;
	private GameV mainFrame;
	
	public GameVFilesC(MenuV menu, GameV mainFrame){
		
		
		this.menu=menu;
		this.mainFrame = mainFrame;
	}

	public void actionPerformed(ActionEvent ae) {
		JMenuItem source = (JMenuItem) ae.getSource();
		
		if(source == mainFrame.getMenu()){
			mainFrame.dispose();
			
			mainFrame.getNorthPan().getWinLost().setVisible(false);
			mainFrame.getNorthPan().getSolutionP().setVisible(false);

			mainFrame.getWestPan().getSelectedColor().setIcon(new ImageIcon("images/caseVide.jpg"));
			mainFrame.getWestPan().getSelectedIndication().setIcon(new ImageIcon("images/caseVide.jpg"));
			mainFrame.getWestPan().removeWestPans();
			mainFrame.getWestPan().getWpColors().reinitwPColors();
			mainFrame.getWestPan().reinitWestPans();
			
			mainFrame.getCenterPan().updateComponents(10, 4);
			mainFrame.getEastPan().updateComponents(10,4);
			
			menu.setVisible(true);
		}
		
		if (source == mainFrame.getQuit()){
			System.exit(0);
		}
	}
}
