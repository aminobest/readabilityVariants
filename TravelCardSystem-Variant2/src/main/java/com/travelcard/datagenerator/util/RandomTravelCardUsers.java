package com.travelcard.datagenerator.util;

import java.util.ArrayList;
import java.util.List;

import com.travelcard.core.Object;

public class RandomTravelCardUsers {
	private static final String[] CPR_NUMBERS = { "1012921234", "1012921234", "1012921234", "1012921234", "1012921234",
			"1012921234", "1012921234", "1012921234", "1012921234", "1012921234", "1012921234", "1012921234" };

	private static int randomBalance() {
		return RandomUtils.randBetween(150, 312);
	}

	private static String randomCPR() {
		return RandomUtils.randomFromArray(CPR_NUMBERS);
	}

	/**
	 * // * Generates multiple random users. // * @param howMany how many random
	 * users should the generator generate. // * @return a list that has as many
	 * users as the parameter howMany specifies. //
	 */

	public List<Object> generate(int howMany) {
		List<Object> users = new ArrayList<Object>();

		for (int i = 0; i < howMany; i++) {
			users.add(randomTC());
		}

		return users;
	}

	private Object randomTC() {
		return new Object(randomCPR(), randomBalance(), false);
	}

}