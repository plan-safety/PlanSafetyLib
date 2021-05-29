package org.plansafety.lib.dialogue;

import java.io.Serializable;

import org.plansafety.lib.dialogue.criteria.DialogueTreeCriteria;

public class DialogueTree implements Serializable {

	private static final long serialVersionUID = 1L;

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
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DialogueTree))
			return false;
		
		DialogueTree other = (DialogueTree) obj;
		
		return root.equals(other.getRoot());
	}

}
