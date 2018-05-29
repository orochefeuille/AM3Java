package am3Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import am3View.WhoGuessV;
import am3View.WhoPlayV;

	public class WhoPlayC implements ActionListener{

		private WhoPlayV whoPlay;
		private  WhoGuessV whoGuess;

		public WhoPlayC(WhoPlayV whoPlay, WhoGuessV whoGuess){
			
			this.whoPlay=whoPlay;
			this.whoGuess=whoGuess;

		}
		
		public void actionPerformed(ActionEvent ae) {
			Object source=ae.getSource();
			
			if(source==whoPlay.getCreateGame()){
				whoPlay.getPlayer1Surname().setVisible(true);
				whoPlay.getP1Surname().setVisible(true);
				whoPlay.getPlayer1IP().setVisible(true);
				whoPlay.getP1IP().setVisible(true);
				whoPlay.getPlayer1IP().setVisible(true);
			}
			
			if(source==whoPlay.getJoinGame()){
				
			}
			
			if(source==whoPlay.getValidate()){
				whoGuess.getP1().setText(whoPlay.getP1Surname().getText());
				whoGuess.getP2().setText(whoPlay.getP2Surname().getText());
				whoGuess.getWhoMake().setText(whoGuess.getP2().getText()+"  choisit le code,");
				whoGuess.getWhoGuess().setText(whoGuess.getP1().getText()+"  le devine.");
				whoPlay.setVisible(false);
			}
			
			if(source==whoPlay.getCancel()){
				whoPlay.setVisible(false);
			}
		}
}
