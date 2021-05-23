package org.plansafety.lib.dialogue;

import org.plansafety.lib.dialogue.criteria.IDialogueTreeCriteria;

public class DialogueTreeVertex {

	private IDialogueTreeCriteria criteria;
	private DialogueTreeNode node;

	public DialogueTreeVertex(IDialogueTreeCriteria criteria, DialogueTreeNode node) {
		this.criteria = criteria;
		this.node = node;
	}

	public IDialogueTreeCriteria getCriteria() {
		return this.criteria;
	}

	public void setCriteria(IDialogueTreeCriteria criteria) {
		this.criteria = criteria;
	}

	public DialogueTreeNode getNode() {
		return this.node;
	}

	public void setNode(DialogueTreeNode node) {
		this.node = node;
	}

}
