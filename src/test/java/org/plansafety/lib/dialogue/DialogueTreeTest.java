package org.plansafety.lib.dialogue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;
import org.plansafety.lib.dialogue.criteria.WordListCriteria;

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

	@Test
	void testSerialisation() throws IOException {

		DialogueTree tree = new DialogueTree(new DialogueTreeNode("Hello, World!",
				new DialogueTreeVertex(
						new WordListCriteria.Builder().withWordList("A", "B", "C").ignoringCase().build(),
						new DialogueTreeNode("ABC")),
				new DialogueTreeVertex(
						new WordListCriteria.Builder().withWordList("1", "2", "3").withPriority(11).build(),
						new DialogueTreeNode("123"))));

		// Serialise

		ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(byteArrayStream);

		out.writeObject(tree);
		
		// Deserialise
		
		
	}

}
