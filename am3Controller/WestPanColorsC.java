package am3Controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import am3View.GameVWestPan;
import am3View.WestPanColorsV;

public class WestPanColorsC implements MouseListener{
	
	private WestPanColorsV wpColors;
	private GameVWestPan gwPan;
	
	public WestPanColorsC(WestPanColorsV wpColors,GameVWestPan gwPan){
		this.wpColors=wpColors;
		this.gwPan=gwPan;
	}

	public void mouseClicked(MouseEvent me) {
		JLabel source=(JLabel)me.getSource();
		
		for(JLabel jl:wpColors.getwPColors()){
			if(source==jl){				
				gwPan.getSelectedColor().setIcon(jl.getIcon());
				gwPan.getSelectedColor().setBorder(BorderFactory.createLineBorder(new Color(99,55,119)));
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
