package com.sapient.week3;

import java.util.Scanner;

public class MapExampleRunner {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MapExample mp = new MapExample();
		mp.generatePrimeNumbers();
		mp.mapAlphabets();
		System.out.println("Enter a string to map it to prime numbers");
		String s = input.nextLine();
		System.out.println("----------------------------");
		for(int i=0; i< s.length();i++) {
			char character = s.charAt(i);
			if(character == ' ') {
				continue;
			}
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ) {
				character = (char) (character - 32);
			}
		System.out.print(Integer.toHexString(
				mp.alphabetMap.get(character)) + " ");
		}
	}

}
