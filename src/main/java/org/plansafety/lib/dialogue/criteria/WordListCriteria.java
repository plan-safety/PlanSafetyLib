package org.plansafety.lib.dialogue.criteria;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.plansafety.lib.conversation.Message;

public class WordListCriteria implements IDialogueTreeCriteria {

	public static class Builder {

		protected WordListCriteria criteria;

		public Builder() {
			criteria = new WordListCriteria();
		}

		public Builder wordList(float weight, String... words) {
			criteria.createWordList(weight, words);
			return this;
		}

		public WordListCriteria build() {
			return criteria;
		}

	}

	protected Map<List<String>, Float> wordLists;

	protected WordListCriteria() {
		wordLists = new HashMap<>();
	}

	public void addWordList(float weight, List<String> wordList) {
		wordLists.put(wordList, weight);
	}

	public List<String> createWordList(float weight, String... words) {
		List<String> wordList = Arrays.asList(words);
		addWordList(weight, wordList);
		return wordList;
	}

	public void removeWordList(List<String> wordList) {
		wordLists.remove(wordList);
	}

	protected boolean evaluateWord(String word) {
		return wordLists.keySet().stream().anyMatch(list -> list.contains(word));
	}

	@Override
	public boolean evaluate(Message message) {
		return Arrays.stream(message.getWords()).anyMatch(this::evaluateWord);
	}

}
