package org.plansafety.lib.dialogue.criteria;

import java.io.Serializable;

import org.plansafety.lib.conversation.Message;

public abstract class DialogueTreeCriteria implements Serializable {

	private static final long serialVersionUID = 1L;

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

	public abstract boolean equalsIgnorePriority(Object object);

	@Override
	public boolean equals(Object obj) {
		return obj instanceof DialogueTreeCriteria && this.equalsIgnorePriority(obj)
				&& priority == ((DialogueTreeCriteria) obj).priority;
	}

}
