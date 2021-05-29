package org.plansafety.lib.dialogue.criteria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.plansafety.lib.conversation.Message;

public class WordListCriteria extends DialogueTreeCriteria implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> wordList;
	private boolean ignoreCase;

	private WordListCriteria(List<String> wordList, boolean ignoreCase, int priority) {
		super(priority);
		this.wordList = wordList;
		this.ignoreCase = ignoreCase;
	}

	public List<String> getWordList() {
		return this.wordList;
	}

	public void setWordList(List<String> wordList) {
		this.wordList = wordList;
	}

	public boolean getIgnoreCase() {
		return this.ignoreCase;
	}

	public void setIgnoreCase(boolean ignoreCase) {
		this.ignoreCase = ignoreCase;
	}

	private boolean evaluateWord(String word) {
		return wordList.stream().anyMatch(other -> ignoreCase ? word.equalsIgnoreCase(other) : word.equals(other));
	}

	@Override
	public boolean evaluate(Message message) {
		return Arrays.stream(message.getWords()).anyMatch(this::evaluateWord);
	}

	public static class Builder {

		private List<String> wordList;
		private boolean ignoreCase;
		private int priority;

		public Builder() {
			this.wordList = new ArrayList<String>();
			this.ignoreCase = false;
			this.priority = DialogueTreeCriteria.DEFAULT_PRIORITY;
		}

		public WordListCriteria build() {
			return new WordListCriteria(wordList, ignoreCase, priority);
		}

		public Builder withWordList(List<String> wordList) {
			this.wordList = wordList;
			return this;
		}

		public Builder withWordList(String... words) {
			this.wordList = new ArrayList<>(Arrays.asList(words));
			return this;
		}

		public Builder withPriority(int priority) {
			this.priority = priority;
			return this;
		}

		public Builder withIgnoreCase(boolean ignoreCase) {
			this.ignoreCase = ignoreCase;
			return this;
		}

		public Builder ignoringCase() {
			return withIgnoreCase(true);
		}

	}

}
