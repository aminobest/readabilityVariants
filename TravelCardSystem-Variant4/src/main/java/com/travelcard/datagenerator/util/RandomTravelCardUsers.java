package com.travelcard.datagenerator.util;

import java.util.ArrayList;
import java.util.List;

import com.travelcard.core.TravelCard;

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

	public List<TravelCard> generate(int howMany) {
		List<TravelCard> users = new ArrayList<TravelCard>();

		for (int i = 0; i < howMany; i++) {
			users.add(randomTC());
		}

		return users;
	}

	private TravelCard randomTC() {
		return new TravelCard(randomCPR(), randomBalance(), false);
	}

}