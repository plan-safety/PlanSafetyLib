package org.plansafety.lib.dialogue.criteria;

import org.plansafety.lib.conversation.Message;

public interface IDialogueTreeCriteria {

	public boolean evaluate(Message message);

}
