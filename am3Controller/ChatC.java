package am3Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import am3View.ChatV;

public class ChatC implements ActionListener{

	private ChatV chat;
	
	public ChatC(ChatV chat){
		this.chat=chat;
	}
	public void actionPerformed(ActionEvent ae) {
		Object source=ae.getSource();
		
		if(source==chat.getReader()){
			
		}
		
		if(source==chat.getWriteIn()){
			
		}
		
		if (source==chat.getSmiley()){
			
		}
	}

	
}
