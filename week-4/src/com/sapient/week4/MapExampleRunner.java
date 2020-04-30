package com.sapient.week4;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapExampleRunner {

	public static void main(String[] args) {
		MapExample example = new MapExample();
		example.populateMap();
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Set<String> findInMap= example.mp.get(input);
		Set<String> inputSet = new HashSet<>();
		String line;
		if(findInMap == null) {
			System.out.println("This key is not present in map.");
			System.out.println("Do you want to add this key in map ?");
			System.out.println("Y/N");
			String choice = sc.nextLine();
			if(choice.equals("Y") || choice.equals("y")) {

			    while (sc.hasNextLine()){   // test for new input
			       line=sc.nextLine();  // get input
			       if(line.isEmpty()){      // see if empty
			           break;
			       }           
			       inputSet.add(line);
			    }
				example.mp.put(input, inputSet);
			} else if(choice.equals("N") || choice.equals("n")) {
				System.out.println("----------BYE----------");
			} else {
				System.out.println("Enter valid input and try again !!!");
			}
			if(choice.equals("Y") || choice.equals("y")) {
				System.out.println("\nUpdated value of map is \n");
				for(String i : example.mp.keySet()) {
					System.out.println("key is " + i + " ,value is "+ example.mp.get(i));
				}
			}
		} else {
			System.out.println(findInMap);
		}
	}

}
