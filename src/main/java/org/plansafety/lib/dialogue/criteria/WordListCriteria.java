package org.plansafety.lib.dialogue.criteria;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.plansafety.lib.conversation.Message;
import org.plansafety.lib.utils.MathsUtils;

public class WordListCriteria implements IDialogueTreeCriteria {

	protected Map<List<String>, Float> wordLists;

	public WordListCriteria() {
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

	protected float evaluateWord(String word) {
		return wordLists.keySet().stream()
				.map(list -> list.contains(word) ? wordLists.get(list) : 0f)
				.reduce(0f, (a,b) -> a + b);
	}

	@Override
	public float evaluate(Message message) {

		float val = Arrays.stream(message.getWords()).map(this::evaluateWord).reduce(0f, (a, b) -> a + b);

		return MathsUtils.clamp(val, 0f, 1f);
	}

}
