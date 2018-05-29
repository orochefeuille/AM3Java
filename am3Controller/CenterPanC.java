package am3Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import am3View.GameVCenterPan;
import am3View.GameVWestPan;

public class CenterPanC implements MouseListener{
	
	private GameVCenterPan centerPan;
	private GameVWestPan westPan;
	
	public CenterPanC(GameVCenterPan centerPan, GameVWestPan westPan){
		this.centerPan=centerPan;
		this.westPan=westPan;
	}

	public void mouseClicked(MouseEvent me) {		
		JLabel source=(JLabel)me.getSource();
		
		for(int i=0;i<centerPan.getCenterBoard().length;i++){
			for(int j=0;j<centerPan.getCenterBoard()[i].length;j++){
				if(source==centerPan.getCenterBoard()[i][j]){
					centerPan.getCenterBoard()[i][j].setIcon(westPan.getSelectedColor().getIcon());
				}
			}			
		}
	}

	public void mouseEntered(MouseEvent arg0) {		
	}

	public void mouseExited(MouseEvent arg0) {	
	}

	public void mousePressed(MouseEvent arg0) {		
	}

	public void mouseReleased(MouseEvent arg0) {		
	}
}
