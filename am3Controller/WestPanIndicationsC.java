package am3Controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import am3Model.IndicationsM;
import am3View.GameVWestPan;

public class WestPanIndicationsC implements MouseListener{
	
		
		private IndicationsM indications;
		private GameVWestPan gwPan;
		
		public WestPanIndicationsC(IndicationsM indications, GameVWestPan gwPan){
			this.indications=indications;
			this.gwPan=gwPan;
		}

		public void mouseClicked(MouseEvent me) {
			JLabel source=(JLabel)me.getSource();
			
			for(JLabel jl:indications.getIndicBoard()){
				if(source==jl){
					gwPan.getSelectedIndication().setIcon(jl.getIcon());
					gwPan.getSelectedIndication().setBorder(BorderFactory.createLineBorder(new Color(99,55,119)));
				
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
