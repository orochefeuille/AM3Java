package am3Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import am3View.GameV;
import am3View.MenuV;
import am3View.WhoPlayV;


public class MenuC implements ActionListener{
	
	private MenuV menu;
	private GameV mainFrame;
	private WhoPlayV whoPlay;
		
	public MenuC(MenuV menu, GameV mainFrame, WhoPlayV whoPlay){
		 this.menu=menu;
		 this.mainFrame=mainFrame;
		 this.whoPlay=whoPlay;
		 
	}
	
	public void actionPerformed(ActionEvent ae) {
		JButton source = (JButton)ae.getSource();
		
		if(source == menu.getSolo()){
			
			mainFrame.getSameGame().setEnabled(false);
			menu.setGameChoice(0);
			
			mainFrame.getSouthPan().getOkEast().setVisible(false);
			mainFrame.getSouthPan().getOkCenter().setEnabled(false);
			
			mainFrame.getWestPan().getWpIndications().setVisible(false);
			mainFrame.getWestPan().getSelectedIndication().setVisible(false);
			mainFrame.getWestPan().getSep1().setVisible(false);
			
			mainFrame.getNorthPan().getHideSolution().setVisible(false);
			mainFrame.getNorthPan().getWinLost().setVisible(false);
			mainFrame.getNorthPan().getxPlay().setVisible(false);
						
			mainFrame.setVisible(true);
			menu.setVisible(false);

		}
		
		if(source == menu.getTwoPc()){
			mainFrame.getSameGame().setEnabled(false);
			menu.setGameChoice(1);		
			
			mainFrame.getSouthPan().getOkEast().setEnabled(false);
			mainFrame.getSouthPan().getOkEast().setVisible(true);
			mainFrame.getSouthPan().getOkCenter().setEnabled(false);
			
			mainFrame.getWestPan().getWpIndications().setVisible(true);
			mainFrame.getWestPan().getSelectedIndication().setVisible(true);
			mainFrame.getWestPan().getSep1().setVisible(true);
			
			mainFrame.getNorthPan().getWinLost().setVisible(false);
			mainFrame.getNorthPan().getxPlay().setVisible(false);
			
			mainFrame.setVisible(true);
			
			whoPlay.getCreateGame().setVisible(false);
			whoPlay.getJoinGame().setVisible(false);
			whoPlay.getPlayer1IP().setVisible(false);
			whoPlay.getP1IP().setVisible(false);
			whoPlay.getPlayer1Gate().setVisible(false);
			whoPlay.getP1Gate().setVisible(false);
			whoPlay.getPlayer2IP().setVisible(false);
			whoPlay.getPlayer2Gate().setVisible(false);
			whoPlay.getP2IP().setVisible(false);
			whoPlay.getP2Gate().setVisible(false);
			whoPlay.getJs1().setVisible(false);
			whoPlay.setVisible(true);

			menu.setVisible(false);

		}

		if(source == menu.getTwoLan()){
			menu.setGameChoice(2);
			
			mainFrame.getSameGame().setEnabled(false);

			mainFrame.getNorthPan().getWinLost().setVisible(false);
			mainFrame.getNorthPan().getxPlay().setVisible(false);
			
			mainFrame.setVisible(true);
			
			whoPlay.getPlayer1Surname().setVisible(false);
			whoPlay.getP1Surname().setVisible(false);
			whoPlay.getPlayer2Surname().setVisible(false);
			whoPlay.getP2Surname().setVisible(false);
			whoPlay.getPlayer1IP().setVisible(false);
			whoPlay.getP1IP().setVisible(false);
			whoPlay.getPlayer1Gate().setVisible(false);
			whoPlay.getP1Gate().setVisible(false);
			whoPlay.getPlayer2IP().setVisible(false);
			whoPlay.getPlayer2Gate().setVisible(false);
			whoPlay.getP2IP().setVisible(false);
			whoPlay.getP2Gate().setVisible(false);
			whoPlay.getJs0().setVisible(false);
			whoPlay.getJs1().setVisible(false);
			whoPlay.setVisible(true);

		}

		if(source == menu.getTwoNet()){
			menu.setGameChoice(3);
			
			mainFrame.getSameGame().setEnabled(false);

			mainFrame.getNorthPan().getWinLost().setVisible(false);
			mainFrame.getNorthPan().getxPlay().setVisible(false);
			
			mainFrame.setVisible(true);
			
			whoPlay.getPlayer1Surname().setVisible(false);
			whoPlay.getP1Surname().setVisible(false);
			whoPlay.getPlayer2Surname().setVisible(false);
			whoPlay.getP2Surname().setVisible(false);
			whoPlay.getPlayer1IP().setVisible(false);
			whoPlay.getP1IP().setVisible(false);
			whoPlay.getPlayer1Gate().setVisible(false);
			whoPlay.getP1Gate().setVisible(false);
			whoPlay.getPlayer2IP().setVisible(false);
			whoPlay.getPlayer2Gate().setVisible(false);
			whoPlay.getP2IP().setVisible(false);
			whoPlay.getP2Gate().setVisible(false);
			whoPlay.getJs0().setVisible(false);
			whoPlay.getJs1().setVisible(false);		
			whoPlay.setVisible(true);
		}
	}
}
