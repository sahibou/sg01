package com.kata01.doucoure.DFA.game;

import java.util.HashMap;
import java.util.Map;

public class GameHelper {

	private static Map<Integer, String> normalGameFormat = new HashMap<Integer, String>();
	static {
		normalGameFormat.put(0, "0");
		normalGameFormat.put(1, "15");
		normalGameFormat.put(2, "30");
		normalGameFormat.put(3, "40");
		normalGameFormat.put(4, "WIN");
	}
	public static String NormalGameFormatOf(Integer intvalue) {
		return normalGameFormat.get(intvalue);
	}
}
