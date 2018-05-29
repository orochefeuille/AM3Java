package am3View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import am3Model.IndicationsM;

public class WestPanIndicationsV extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private IndicationsM indications;

	public WestPanIndicationsV(IndicationsM indications){
		
		this.indications=indications;
		
		this.setLayout(new GridLayout(1,3));
		this.setBackground(new Color(157,238,11));
		
		this.initwPIndications();
	}
	
	public void initwPIndications(){
		indications.getIndicBoard()[0].setBorder(BorderFactory.createLineBorder(new Color(99,55,119)));
		indications.getIndicBoard()[1].setBorder(BorderFactory.createLineBorder(new Color(99,55,119)));
		indications.getIndicBoard()[2].setBorder(BorderFactory.createLineBorder(new Color(99,55,119)));

		for(JLabel jl:indications.getIndicBoard()){
			this.add(jl);
		}
	}

	public IndicationsM getIndications() {
		return indications;
	}

	public void setIndications(IndicationsM indications) {
		this.indications = indications;
	}
}
