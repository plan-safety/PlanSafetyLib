package org.plansafety.lib.dialogue.criteria;

import java.util.List;
import java.util.Map.Entry;

public class WordListIgnoreCaseCriteria extends WordListCriteria {

	@Override
	protected float evaluateWord(String word) {
		float val = 0f;
		
		for (Entry<List<String>, Float> entry: wordLists.entrySet()) 
			for (String other: entry.getKey()) 
				if(word.equalsIgnoreCase(other))
					val += entry.getValue();
		
		
		return val;
		
	}

}