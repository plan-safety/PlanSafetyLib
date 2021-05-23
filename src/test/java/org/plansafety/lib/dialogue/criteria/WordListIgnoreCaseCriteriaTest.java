package org.plansafety.lib.dialogue.criteria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.plansafety.lib.conversation.Message;

class WordListIgnoreCaseCriteriaTest {

	@Test
	void testEvaluate() {
		Message message = new Message("Apples Pears Lemons Car Bike Plane Milk Ice_Cream");

		WordListIgnoreCaseCriteria criteria = new WordListIgnoreCaseCriteria();
		criteria.createWordList(0.15f, "apples", "PEARS", "Lemons");
		criteria.createWordList(-0.1f, "Milk", "Ice_Cream", "Cake");
		
		assertEquals(0.25f, criteria.evaluate(message), 0.001f);	
	}

}
