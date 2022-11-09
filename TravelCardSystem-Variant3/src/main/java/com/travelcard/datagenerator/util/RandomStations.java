package com.travelcard.datagenerator.util;

import java.util.ArrayList;
import java.util.List;

import com.travelcard.core.Station;

public class RandomStations {
	private static final String[] STATION_NAMES = { "Lyngby", "Virum", "Valby", "Vanlose", "amager", "oresund",
			"Gentofte", "Buddinge", "Vangede", "Hellerup" };

	private static Station randomStation() {

		Station station = new Station(RandomUtils.randomFromArray(STATION_NAMES));
		station.setCountCheckIn(RandomUtils.randBetween(0, 10));
		station.setCountCheckOut(RandomUtils.randBetween(0, 10));
		return station;
	}

	/**
	 * // * Generates multiple random users. // * @param howMany how many random
	 * users should the generator generate. // * @return a list that has as many
	 * users as the parameter howMany specifies. //
	 */

	public List<Station> generate(int howMany) {
		List<Station> stations = new ArrayList<Station>();

		for (int i = 0; i < howMany; i++) {
			stations.add(randomStation());
		}

		return stations;
	}

}
