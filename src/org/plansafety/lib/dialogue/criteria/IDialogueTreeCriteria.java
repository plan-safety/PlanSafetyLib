package org.plansafety.lib.dialogue.criteria;

import org.plansafety.lib.conversation.Message;

public interface IDialogueTreeCriteria {

	float evaluateMessage(Message message);
	
}
