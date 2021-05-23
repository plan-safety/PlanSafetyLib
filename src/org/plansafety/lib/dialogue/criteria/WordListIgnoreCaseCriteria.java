package org.plansafety.lib.dialogue.criteria;

import java.util.Arrays;

public class WordListIgnoreCaseCriteria extends WordListCriteria {

	public WordListIgnoreCaseCriteria(float allowedWeighting, float disallowedWeighting) {
		super(allowedWeighting, disallowedWeighting);
	}
	
	public WordListIgnoreCaseCriteria() {
		super();
	}
	
	@Override
	public void allow(String word) {
		super.allow(word.toLowerCase());
	}

	@Override
	public void allowAll(String... words) {
		Arrays.stream(words).forEach(word -> allow(word));
	}

	@Override
	public void disallow(String word) {
		super.disallow(word.toLowerCase());
	}

	@Override
	public void disallowAll(String... words) {
		Arrays.stream(words).forEach(word -> disallow(word));
	}
	
	@Override
	protected float evaluateWord(String word) {
		return super.evaluateWord(word.toLowerCase());
	}

}
