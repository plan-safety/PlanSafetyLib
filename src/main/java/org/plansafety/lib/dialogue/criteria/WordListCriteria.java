package org.plansafety.lib.dialogue.criteria;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.plansafety.lib.conversation.Message;

public class WordListCriteria implements IDialogueTreeCriteria {

	private List<String> wordList;
	private boolean ignoreCase;

	private WordListCriteria(List<String> wordList, boolean ignoreCase) {
		this.wordList = wordList;
		this.ignoreCase = ignoreCase;
	}

	public List<String> getWordList() {
		return this.wordList;
	}

	public void setWordList(List<String> wordList) {
		this.wordList = wordList;
	}

	private boolean evaluateWord(String word) {
		return wordList.stream().anyMatch(other -> ignoreCase ? word.equalsIgnoreCase(other) : word.equals(other));
	}

	@Override
	public boolean evaluate(Message message) {
		return Arrays.stream(message.getWords()).anyMatch(this::evaluateWord);
	}

}
