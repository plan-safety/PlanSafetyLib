package org.plansafety.lib.dialogue;

import org.plansafety.lib.dialogue.criteria.IDialogueTreeCriteria;

public class DialogueTreeVertex {

	private IDialogueTreeCriteria criteria;
	private DialogueTreeNode node;

	public DialogueTreeVertex(IDialogueTreeCriteria criteria, DialogueTreeNode node) {
		this.criteria = criteria;
		this.node = node;
	}

}
