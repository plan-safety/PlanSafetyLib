package org.plansafety.lib.dialogue.criteria;

import org.plansafety.lib.conversation.Message;

public interface IDialogueTreeCriteria {
	
	public float evaluate(Message message);
	
	default public boolean evaluateAsBoolean(Message message) {
		return evaluate(message) != 0f;
	}
}
