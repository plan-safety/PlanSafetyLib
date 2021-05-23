package org.plansafety.lib.dialogue.criteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.plansafety.lib.conversation.Message;
import org.plansafety.lib.utils.MathsUtils;

public class WordListCriteria implements IDialogueTreeCriteria {

	private List<String> allowed;
	private List<String> disallowed;

	private float allowedWeighting;
	private float disallowedWeighting;

	public WordListCriteria(float allowedWeighting, float disallowedWeighting) {
		this.allowed = new ArrayList<>();
		this.disallowed = new ArrayList<>();
		
		this.allowedWeighting = allowedWeighting;
		this.disallowedWeighting = disallowedWeighting;
	}
	
	public WordListCriteria() {
		this(1f, 0f);
	}
	
	public void allow(String word) {
		allowed.add(word);
	}

	public void allowAll(String... words) {
		allowed.addAll(Arrays.asList(words));
	}

	public void disallow(String word) {
		disallowed.add(word);
	}

	public void disallowAll(String... words) {
		disallowed.addAll(Arrays.asList(words));
	}

	protected float evaluateWord(String word) {
		return disallowed.contains(word) ? disallowedWeighting : allowed.contains(word) ? allowedWeighting : 0f;
	}

	@Override
	public float evaluate(Message message) {

		float val = Arrays.stream(message.getWords()).map(this::evaluateWord).reduce(0f, (a, b) -> a + b);

		return MathsUtils.clamp(val, 0f, 1f);
	}

}
