package org.plansafety.lib.dialogue.criteria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.plansafety.lib.conversation.Message;

class DialogueTreeCriteriaTest {

	private static class MyTestCriteria extends DialogueTreeCriteria {
		public MyTestCriteria() {
			super();
		}

		@Override
		public boolean evaluate(Message message) {
			return false;
		}
	}
	
	@Test
	void testSetPriority() {
		MyTestCriteria criteria = new MyTestCriteria();
		criteria.evaluate(null); // Just for coverage
		
		assertEquals(DialogueTreeCriteria.DEFAULT_PRIORITY, criteria.getPriority());
	
		criteria.setPriority(11);
		
		assertEquals(11, criteria.getPriority());
	}

}
