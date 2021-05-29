package org.plansafety.lib.dialogue;

import java.io.Serializable;

import org.plansafety.lib.dialogue.criteria.DialogueTreeCriteria;

public class DialogueTreeVertex implements Serializable {

	private static final long serialVersionUID = 1L;

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

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DialogueTreeVertex))
			return super.equals(obj);

		DialogueTreeVertex other = (DialogueTreeVertex) obj;

		return other.getCriteria().equals(criteria) && other.getNode().equals(node);
	}

}
