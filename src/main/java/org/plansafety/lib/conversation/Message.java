package org.plansafety.lib.conversation;

// Temporary implementation 
public class Message {

	private final String content;
	
	private String[] words;
	
	public Message(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
	
	public String[] getWords() {
		if (words == null) 
			words = content.split("\\s+");
		
		return words;
	}
	
}
