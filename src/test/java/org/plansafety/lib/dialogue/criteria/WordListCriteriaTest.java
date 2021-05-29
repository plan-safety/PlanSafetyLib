package org.plansafety.lib.dialogue.criteria;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.plansafety.lib.conversation.Message;

class WordListCriteriaTest {

	@Test
	void testEvaluate() {

		Message message = new Message("Apple");
		WordListCriteria criteria = new WordListCriteria.Builder().withWordList("APPLE").build();

		assertFalse(criteria.evaluate(message));

		criteria.setIgnoreCase(true);

		assertTrue(criteria.evaluate(message));

	}

	@Test
	void testBuilder() {

		WordListCriteria criteria = new WordListCriteria.Builder().withWordList("Hi", "Hello", "Hey").ignoringCase()
				.build();

		assertEquals("Hi", criteria.getWordList().get(0));
		assertEquals("Hello", criteria.getWordList().get(1));
		assertEquals("Hey", criteria.getWordList().get(2));
		assertTrue(criteria.getIgnoreCase());

		WordListCriteria criteria2 = new WordListCriteria.Builder().withWordList(Arrays.asList("Hi", "Hello", "Hey"))
				.withPriority(12).build();

		assertEquals("Hi", criteria2.getWordList().get(0));
		assertEquals("Hello", criteria2.getWordList().get(1));
		assertEquals("Hey", criteria2.getWordList().get(2));
		assertEquals(12, criteria2.getPriority());
	}

	@Test
	void testSetWordList() {

		WordListCriteria criteria = new WordListCriteria.Builder().build();
		List<String> fruits = Arrays.asList("Pear", "Apple", "Orange");

		assertEquals(0, criteria.getWordList().size());

		criteria.setWordList(fruits);

		assertEquals(fruits, criteria.getWordList());
	}

	@Test
	void testSetIgnoreCase() {
		WordListCriteria criteria = new WordListCriteria.Builder().build();

		assertFalse(criteria.getIgnoreCase());

		criteria.setIgnoreCase(true);

		assertTrue(criteria.getIgnoreCase());

	}

	@Test
	void testEquals() {

		WordListCriteria a = new WordListCriteria.Builder().ignoringCase().withWordList("A", "B", "C").build();
		WordListCriteria a1 = new WordListCriteria.Builder().ignoringCase().withWordList("A", "B", "C").build();
		WordListCriteria b = new WordListCriteria.Builder().withWordList("D").build();

		assertEquals(a, a);
		assertEquals(a, a1);
		assertNotEquals(a, b);
	}

}
