package am3View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ChatV extends JFrame{

	private static final long serialVersionUID = 1L;

	private int chatVHeight, chatVWidth;
	private JPanel writer, reader;
	private JScrollPane scroll;
	private JTextField writeIn;
	private JButton smiley;
			
	private GridBagLayout gbl;
	private GridBagConstraints gbc;

	public ChatV(){
		
		chatVHeight=this.makeChatVHeightSize();
		chatVWidth=this.makeChatVWidthSize();
		this.setBounds(chatVWidth*29/10,chatVHeight*1/20,chatVWidth, chatVHeight);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("AM3-CHAT");
				
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		this.setLayout(gbl);
		
		this.initChat();
	}
	
public void inputGridBagConstraints(int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int anchor, int fill, Insets insets, int ipadx, int ipady, Component comp) {		
		
		gbc.gridx=gridx; gbc.gridy=gridy;
		gbc.gridwidth=gridwidth; gbc.gridheight=gridheight;
		gbc.weightx=weightx; gbc.weighty=weighty;
		gbc.anchor=anchor;
		gbc.fill=fill;
		gbc.insets=insets;
		gbc.ipadx=ipadx; gbc.ipady=ipady;
		this.add(comp,gbc);
	}
	
	private void initChat(){
		
		reader=new JPanel();
		reader.setBackground(new Color(157,238,11));
		reader.setPreferredSize(new Dimension(chatVWidth,chatVHeight*3));
		scroll=new JScrollPane(reader);
		scroll.getVerticalScrollBar().setBackground(new Color(90,55,119));scroll.getHorizontalScrollBar().setBackground(new Color(90,55,119));
		this.inputGridBagConstraints(0,1,1,1,100,99,GridBagConstraints.CENTER,GridBagConstraints.BOTH, new Insets(0,0,0,0),0,0,scroll);
		
		writer=new JPanel();
		writer.setBackground(new Color(90,55,119));
		this.inputGridBagConstraints(0,2,1,1,100,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH, new Insets(0,0,0,0),0,0,writer);
		
		writeIn= new JTextField(30);
		writer.add(writeIn);
		smiley=new JButton("cheese");
		writer.add(smiley);

	}
	
	private int makeChatVHeightSize(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = (int)(screenSize.getHeight()*0.9);		
		return screenHeight;
	}
	
	private int makeChatVWidthSize(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)(screenSize.getWidth()*0.25);		
		return screenWidth;
	}

	public JPanel getReader() {
		return reader;
	}

	public JTextField getWriteIn() {
		return writeIn;
	}

	public JButton getSmiley() {
		return smiley;
	}
}
