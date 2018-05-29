package am3Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import am3View.GameVEastPan;
import am3View.GameVWestPan;

public class EastPanC  implements MouseListener{
	
	private GameVEastPan eastPan;
	private GameVWestPan westPan;
	
	public EastPanC(GameVEastPan eastPan, GameVWestPan westPan){
		this.eastPan=eastPan;
		this.westPan=westPan;
	}

	public void mouseClicked(MouseEvent me) {		
		JLabel source=(JLabel)me.getSource();

		for(int i=0;i<eastPan.getEastBoard().length;i++){
			for(int j=0;j<eastPan.getEastBoard()[i].length;j++){
				if(source==eastPan.getEastBoard()[i][j]){
					eastPan.getEastBoard()[i][j].setIcon(westPan.getSelectedIndication().getIcon());
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


