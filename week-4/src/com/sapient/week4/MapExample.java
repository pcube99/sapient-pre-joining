package com.sapient.week4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapExample {
	Map<String, Set<String>> mp = new HashMap<> ();

	public void populateMap() {
		Set<String> st1 = new HashSet<>();
		st1.add("Good Morning");
		st1.add("Shubhodaya");
		st1.add("Shubhohday");
		st1.add("Bonjour");

		Set<String> st2 = new HashSet<>();
		st2.add("Good Evening");
		st2.add("Shubha sange");
		st2.add("Susandhya");
		st2.add("Bonsoir");

		this.mp.put("GoodMorning",st1);
		this.mp.put("GoodEvening",st2);

	}
}
