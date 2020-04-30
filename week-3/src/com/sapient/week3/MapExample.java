package com.sapient.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapExample {
	ArrayList<Integer> primeNumbers = new ArrayList<>();
	Boolean[] primeCheck = new Boolean[1000];
	Map<Character,Integer> alphabetMap = new HashMap<Character,Integer>();
	public void generatePrimeNumbers() {
		Arrays.fill(primeCheck, Boolean.TRUE);
		for(int i=2;i<1000;i++) {
			for(int j=2;j<i;j++) {
				if(i%j == 0) {
					this.primeCheck[i] = false;
					break;
				}
			}
		}
		for(int i=2;i<1000;i++) {
			if(this.primeCheck[i] == true) {
				this.primeNumbers.add(i);

			}
		}
	}
	
	public void mapAlphabets() {
		for(int i=0;i<26;i++) {
			this.alphabetMap.put((char) ('A'+i), Integer.valueOf(this.primeNumbers.get(i)));
		}
	}
}
