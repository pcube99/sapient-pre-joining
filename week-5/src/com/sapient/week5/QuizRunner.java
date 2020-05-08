package com.sapient.week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizRunner {
	public static void main(String[] args) {
		int count = 0;
		QuestionSet qs = new QuestionSet();
		InputThread i = new InputThread(null);
		qs.generateQuestions();
//		qs.printQuestions();
		System.out.println("Welcome to KBC !!!");
		System.out.println("There are 10 questions in this game."); 
		System.out.println("You have 10 seconds to answer a question. \n");
		for(Questions question: qs.quizQuestions) {
			Boolean result = qs.startTimeout(question);
			if (result == true) {
				System.out.println("Timeout, Game exited");
				break;
			}
			
//			System.out.println(question.getQuestion());
//			System.out.println(question.getA());
//			System.out.println(question.getB());
//			System.out.println(question.getC());
//			System.out.println(question.getD());
//			System.out.println(question.getCorrectAnswer());
		}
		System.out.println("Your score is " + i.count + " out of 10");

		
	}

}
