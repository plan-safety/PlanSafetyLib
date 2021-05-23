package org.plansafety.lib.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathsUtilsTest {

	@Test
	void testClamp() {
		// Normal 
		assertEquals(MathsUtils.clamp(0.5f, 0f, 1f), 0.5f);
		
		// Boundary 
		assertEquals(MathsUtils.clamp(0f, 0f, 1f), 0f);
		assertEquals(MathsUtils.clamp(1f, 0f, 1f), 1f);
		
		// Extreme
		assertEquals(MathsUtils.clamp(-1f, 0f, 1f), 0f);
		assertEquals(MathsUtils.clamp(2f, 0f, 1f), 1f);
	}

}
