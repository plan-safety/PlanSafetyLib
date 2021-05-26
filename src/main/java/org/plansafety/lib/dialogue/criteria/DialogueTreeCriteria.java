package org.plansafety.lib.dialogue.criteria;

import org.plansafety.lib.conversation.Message;

public abstract class DialogueTreeCriteria {

	public static int DEFAULT_PRIORITY = 1;

	private int priority;

	public DialogueTreeCriteria(int priority) {
		this.priority = priority;
	}

	public DialogueTreeCriteria() {
		this(DEFAULT_PRIORITY);
	}

	public abstract boolean evaluate(Message message);

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
