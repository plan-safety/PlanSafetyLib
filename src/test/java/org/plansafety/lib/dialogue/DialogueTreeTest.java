package org.plansafety.lib.dialogue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class DialogueTreeTest {

	@Test
	void testPrepend() {

		DialogueTreeNode originalRoot = new DialogueTreeNode("World");
		DialogueTreeNode newRoot = new DialogueTreeNode("Hello");

		DialogueTree tree = new DialogueTree(originalRoot);

		assertEquals(originalRoot, tree.getRoot());

		tree.prepend(newRoot, null);

		assertEquals(newRoot, tree.getRoot());

	}

	@Test
	void testSetRoot() {
		DialogueTree tree = new DialogueTree(null);

		assertNull(tree.getRoot());

		tree.setRoot(new DialogueTreeNode(null));

		assertNotNull(tree.getRoot());
	}

}
