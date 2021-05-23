package org.plansafety.lib.utils;

public final class MathsUtils {

	private MathsUtils() {
	}

	public static <T extends Comparable<T>> T clamp(T val, T min, T max) {
		return val.compareTo(min) < 0 ? min : val.compareTo(max) > 0 ? max : val;
	}

}
