package am3View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AboutMe extends JFrame{

	private static final long serialVersionUID = 1L;
	private int gameVHeight, gameVWidth;
	
	private Container container;
	private GridBagLayout gbl;
	private JLabel label;
	private Font font;
	
	
	public AboutMe(){
		
		gameVHeight=this.makeScreenHeightSize();
		gameVWidth=this.makeScreenWidthSize();
		this.setSize(gameVWidth, gameVHeight);
		this.setLocationRelativeTo(this.getParent());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("AM3-Oliviryajo");

		container=this.getContentPane();
		gbl = new GridBagLayout();
		container.setLayout(gbl);
		font = new Font("Arial",Font.BOLD,24);
		label = new JLabel("Oliviryajo's Prod.");
		label.setFont(font);
		
		container.setBackground(new Color(157,238,11));
		label.setForeground(new Color(90,55,119));
		container.add (label, new GridBagConstraints (0,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE, new Insets(0,0,0,0),0,0));
	}

	private int makeScreenHeightSize(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = (int)(screenSize.getHeight()*0.2);		
		return screenHeight;
	}
	
	private int makeScreenWidthSize(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)(screenSize.getWidth()*0.27);		
		return screenWidth;
	}
}
