package org.plansafety.lib.dialogue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.plansafety.lib.dialogue.criteria.WordListCriteria;

class DialogueTreeNodeTest {

	@Test
	void testMessageContent() {

		DialogueTreeNode node = new DialogueTreeNode(null);

		node.setMessageContent("Hello, World!");
		assertEquals("Hello, World!", node.getMessageContent());
	}

	@Test
	void testRemove() {
		DialogueTreeVertex vertex = new DialogueTreeVertex(new WordListCriteria.Builder().withWordList("Hi").build(),
				new DialogueTreeNode("A"));
		DialogueTreeVertex vertex2 = new DialogueTreeVertex(new WordListCriteria.Builder().build(),
				new DialogueTreeNode("B"));
		DialogueTreeNode node = new DialogueTreeNode(null, vertex, vertex2);

		assertEquals(2, node.getVerticies().size());

		node.remove(vertex);

		assertEquals(1, node.getVerticies().size());
		assertEquals(vertex2, node.getVerticies().get(0));
	}

	@Test
	void testRemoveVertexAt() {
		DialogueTreeVertex vertex = new DialogueTreeVertex(new WordListCriteria.Builder().withWordList("Hi").build(),
				new DialogueTreeNode("A"));
		DialogueTreeVertex vertex2 = new DialogueTreeVertex(
				new WordListCriteria.Builder().withWordList("Hello").build(), new DialogueTreeNode("B"));
		DialogueTreeVertex vertex3 = new DialogueTreeVertex(new WordListCriteria.Builder().build(),
				new DialogueTreeNode("C"));
		DialogueTreeNode node = new DialogueTreeNode(null, vertex, vertex2, vertex3);

		assertEquals(vertex2, node.getVerticies().get(1));

		node.removeVertexAt(1);

		assertEquals(vertex3, node.getVerticies().get(1));
	}

	@Test
	void testAppend() {
		DialogueTreeNode node = new DialogueTreeNode(null);

		assertEquals(0, node.getVerticies().size());

		node.append(new DialogueTreeVertex(null, null));

		assertEquals(1, node.getVerticies().size());
	}

}
