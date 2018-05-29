package am3Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import am3View.AboutMe;
import am3View.GameV;


public class GameVAboutC  implements ActionListener{

	private GameV mainFrame;
	private AboutMe aboutMe;
	
	public GameVAboutC(GameV mainFrame, AboutMe aboutMe){
		this.mainFrame = mainFrame;
		this.aboutMe=aboutMe;
	}

	public void actionPerformed(ActionEvent ae) {
		JMenuItem source = (JMenuItem) ae.getSource();
		
		if(source == mainFrame.getAboutMe()){
			aboutMe.setVisible(true);			
		}
	}
}

