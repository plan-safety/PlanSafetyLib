package org.plansafety.lib.dialogue;

import org.plansafety.lib.dialogue.criteria.DialogueTreeCriteria;

public class DialogueTreeVertex {

	private DialogueTreeCriteria criteria;
	private DialogueTreeNode node;

	public DialogueTreeVertex(DialogueTreeCriteria criteria, DialogueTreeNode node) {
		this.criteria = criteria;
		this.node = node;
	}

	public DialogueTreeCriteria getCriteria() {
		return this.criteria;
	}

	public void setCriteria(DialogueTreeCriteria criteria) {
		this.criteria = criteria;
	}

	public DialogueTreeNode getNode() {
		return this.node;
	}

	public void setNode(DialogueTreeNode node) {
		this.node = node;
	}

}
