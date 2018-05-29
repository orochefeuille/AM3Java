package am3Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import am3View.GameVNorthPan;
import am3View.WhoGuessV;

public class WhoGuessC implements ActionListener{

	private WhoGuessV whoGuess;
	private GameVNorthPan northPan;

	public WhoGuessC(WhoGuessV whoGuess,GameVNorthPan northPan){
		
		this.whoGuess=whoGuess;
		this.northPan=northPan;
		
		this.pAddListeners();
	}
	
	private void pAddListeners(){
		whoGuess.getP1().addActionListener(this);
		whoGuess.getP2().addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Object source=ae.getSource();
		
		if(source==whoGuess.getP1()){
			whoGuess.getWhoMake().setText(whoGuess.getP2().getText()+"  choisit le code,");
			whoGuess.getWhoGuess().setText(whoGuess.getP1().getText()+"  le devine.");
			whoGuess.setP1Guess(true);
		}
		
		if(source==whoGuess.getP2()){
			whoGuess.getWhoMake().setText(whoGuess.getP1().getText()+"  choisit le code,");
			whoGuess.getWhoGuess().setText(whoGuess.getP2().getText()+"  le devine.");
			whoGuess.setP1Guess(false);
		}
		
		if(source==whoGuess.getValidate()){
			if(whoGuess.isP1Guess()){
				northPan.getxPlay().setText(whoGuess.getP2().getText()+" joue");
			}
			else if(!whoGuess.isP1Guess()){
				northPan.getxPlay().setText(whoGuess.getP1().getText()+" joue");
			}
			whoGuess.setVisible(false);
		}
		
		if(source==whoGuess.getCancel()){
			whoGuess.setVisible(false);
		}
	}

}
