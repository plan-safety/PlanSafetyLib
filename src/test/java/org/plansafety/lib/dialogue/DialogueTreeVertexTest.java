package org.plansafety.lib.dialogue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.plansafety.lib.dialogue.criteria.IDialogueTreeCriteria;
import org.plansafety.lib.dialogue.criteria.WordListCriteria;

class DialogueTreeVertexTest {

	@Test
	void testDialogueTreeVertex() {
		IDialogueTreeCriteria criteria = new WordListCriteria();
		DialogueTreeNode node = new DialogueTreeNode("Hello");
		DialogueTreeVertex vertex = new DialogueTreeVertex(criteria, node);

		assertEquals(criteria, vertex.getCriteria());
		assertEquals(node, vertex.getNode());
	}

	@Test
	void testSetCriteria() {
		DialogueTreeVertex vertex = new DialogueTreeVertex(null, null);

		IDialogueTreeCriteria criteria = new WordListCriteria();
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

}
