package org.plansafety.lib.dialogue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.plansafety.lib.dialogue.criteria.DialogueTreeCriteria;
import org.plansafety.lib.dialogue.criteria.WordListCriteria;

class DialogueTreeVertexTest {

	@Test
	void testDialogueTreeVertex() {
		DialogueTreeCriteria criteria = new WordListCriteria.Builder().build();
		DialogueTreeNode node = new DialogueTreeNode("Hello");
		DialogueTreeVertex vertex = new DialogueTreeVertex(criteria, node);

		assertEquals(criteria, vertex.getCriteria());
		assertEquals(node, vertex.getNode());
	}

	@Test
	void testSetCriteria() {
		DialogueTreeVertex vertex = new DialogueTreeVertex(null, null);

		DialogueTreeCriteria criteria = new WordListCriteria.Builder().build();
		vertex.setCriteria(criteria);

		assertEquals(criteria, vertex.getCriteria());
	}

	@Test
	void testSetNode() {
		DialogueTreeVertex vertex = new DialogueTreeVertex(null, null);

		DialogueTreeNode node = new DialogueTreeNode("Hello");
		vertex.setNode(node);

		assertEquals(node, vertex.getNode());
	}
	
	@Test
	void testEquals() {
		DialogueTreeVertex a = new DialogueTreeVertex(null, new DialogueTreeNode("A"));
		DialogueTreeVertex a1 = new DialogueTreeVertex(null, new DialogueTreeNode("A"));
		DialogueTreeVertex b = new DialogueTreeVertex(null, new DialogueTreeNode("B"));

		assertNotEquals(a, b);
		assertNotEquals(a, "Hello, World!");
		assertEquals(a, a);
		assertEquals(a, a1);
	}

}
