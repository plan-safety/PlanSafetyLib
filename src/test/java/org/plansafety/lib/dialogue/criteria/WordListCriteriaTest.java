package org.plansafety.lib.dialogue.criteria;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.plansafety.lib.conversation.Message;

class WordListCriteriaTest {

	@Test
	void testRemoveWordList() {
		Message message = new Message("Apples Pears Lemons Car Bike Plane Milk Ice_Cream");

		WordListCriteria criteria = new WordListCriteria();
		criteria.createWordList(0.15f, "Apples", "Pears", "Lemons");
		List<String> dairy = criteria.createWordList(-0.1f, "Milk", "Ice_Cream", "Choclate");
		
		assertEquals(0.25f, criteria.evaluate(message), 0.001f);	
		
		criteria.removeWordList(dairy);
		
		assertEquals(0.45f, criteria.evaluate(message), 0.001f);	
		
	}
	
	@Test
	void testEvaluate() {
		Message message = new Message("Apples Pears Lemons Car Bike Plane Milk Ice_Cream");

		WordListCriteria criteria = new WordListCriteria();
		criteria.createWordList(0.15f, "Apples", "Pears", "Lemons");
		criteria.createWordList(-0.1f, "Milk", "Ice_Cream", "Cake");
		
		assertEquals(0.25f, criteria.evaluate(message), 0.001f);	
	}
	

}
