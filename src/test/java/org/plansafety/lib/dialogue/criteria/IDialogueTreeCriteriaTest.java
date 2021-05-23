package org.plansafety.lib.dialogue.criteria;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.plansafety.lib.conversation.Message;

class IDialogueTreeCriteriaTest {

	@Test
	void testEvaluateAsBoolean() {

		IDialogueTreeCriteria criteria1 = new IDialogueTreeCriteria() {

			@Override
			public float evaluate(Message message) {
				return 1f;
			}
		};

		assertTrue(criteria1.evaluateAsBoolean(null));

		IDialogueTreeCriteria criteria2 = new IDialogueTreeCriteria() {

			@Override
			public float evaluate(Message message) {
				return 0.5f;
			}
		};

		assertTrue(criteria2.evaluateAsBoolean(null));

		IDialogueTreeCriteria criteria3 = new IDialogueTreeCriteria() {

			@Override
			public float evaluate(Message message) {
				return 0f;
			}
		};

		assertFalse(criteria3.evaluateAsBoolean(null));

	}

}
