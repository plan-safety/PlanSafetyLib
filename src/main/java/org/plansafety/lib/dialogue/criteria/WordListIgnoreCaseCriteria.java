package org.plansafety.lib.dialogue.criteria;

public class WordListIgnoreCaseCriteria extends WordListCriteria {

	protected WordListIgnoreCaseCriteria() {
		super();
	}

	public static class Builder {
		protected WordListIgnoreCaseCriteria criteria;

		public Builder() {
			criteria = new WordListIgnoreCaseCriteria();
		}

		public Builder wordList(float weight, String... words) {
			criteria.createWordList(weight, words);
			return this;
		}

		public WordListIgnoreCaseCriteria build() {
			return criteria;
		}
	}

	@Override
	protected boolean evaluateWord(String word) {
		return wordLists.keySet().stream()
				.anyMatch(list -> list.stream().anyMatch(other -> word.equalsIgnoreCase(other)));
	}

}