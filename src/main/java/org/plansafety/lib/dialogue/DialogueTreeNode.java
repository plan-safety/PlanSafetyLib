package org.plansafety.lib.dialogue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DialogueTreeNode implements Serializable {

	private static final long serialVersionUID = 1L;

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

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DialogueTreeNode))
			return super.equals(obj);

		DialogueTreeNode other = (DialogueTreeNode) obj;

		return other.getMessageContent().equals(messageContent) && other.getVerticies().equals(verticies);
	}

}
