package org.plansafety.lib.dialogue;

import org.plansafety.lib.dialogue.criteria.DialogueTreeCriteria;

public class DialogueTree {

	private DialogueTreeNode root;

	public DialogueTree(DialogueTreeNode root) {
		this.root = root;
	}

	public DialogueTreeNode getRoot() {
		return this.root;
	}

	public void setRoot(DialogueTreeNode root) {
		this.root = root;
	}

	public void prepend(DialogueTreeNode node, DialogueTreeCriteria oldRootCritiria) {
		DialogueTreeNode temp = root;

		root = node;
		root.append(new DialogueTreeVertex(oldRootCritiria, temp));
	}

}
