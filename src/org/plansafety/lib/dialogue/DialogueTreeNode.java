package org.plansafety.lib.dialogue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DialogueTreeNode {

	private String messageContent;
	private final List<DialogueTreeVertex> verticies;

	public DialogueTreeNode(String messageContent, DialogueTreeVertex... verticies) {
		this.messageContent = messageContent;
		this.verticies = new ArrayList<>(Arrays.asList(verticies));
	}

	public String getMessageContent() {
		return this.messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public List<DialogueTreeVertex> getVerticies() {
		return this.verticies;
	}

	public void remove(DialogueTreeVertex vertex) {
		verticies.remove(vertex);
	}

	public void removeVertexAt(int i) {
		verticies.remove(i);
	}

	public void append(DialogueTreeVertex vertex) {
		verticies.add(vertex);
	}

}
