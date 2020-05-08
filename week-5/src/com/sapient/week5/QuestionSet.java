package com.sapient.week5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InputThread implements Runnable {
	public static int count = 0;
	Questions question;
	Scanner scanner;

	InputThread(Questions question) {
		this.question = question;
	}

	@Override
	public void run() {
		System.out.println(this.question.getQuestion());
		System.out.println(this.question.getA());
		System.out.println(this.question.getB());
		System.out.println(this.question.getC());
		System.out.println(this.question.getD());
		System.out.print("Enter your choice : ");
		scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		if (input.equalsIgnoreCase(this.question.getCorrectAnswer().split("ans: ")[1])) {
			System.out.println("Correct answer, you got 1 point !\n");
			count++;
		} else {
			System.out.println("Sorry, wrong answer !\n");
		}
	}

}

public class QuestionSet {
	List<Questions> quizQuestions = new ArrayList<>();
	
	public void generateQuestions() {
	 try {
	      File myObj = new File("src/questions.txt");
	      Scanner myReader = new Scanner(myObj);
	      Questions q = new Questions();
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        if(!data.equals("")) {
	        	if(data.indexOf('?') != -1 ) {
	        		q.setQuestion(data);
	        	} else if(data.contains("a)")) {
	        		q.setA(data);
	        	} else if(data.contains("b)")) {
	        		q.setB(data);
	        	} else if(data.contains("c)")) {
	        		q.setC(data);
	        	} else if(data.contains("d)")) {
	        		q.setD(data);
	        	} else if(data.contains("ans")) {
	        		q.setCorrectAnswer(data);
	        	}
	        } else {
	        	quizQuestions.add(q);
	        	q = new Questions();
	        }
//	        System.out.println(data);
	      }
      	  quizQuestions.add(q);
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
	
	public void printQuestions() {
		for(Questions question: this.quizQuestions) {
			System.out.println(question);

		}
	}
	
	public Boolean startTimeout(Questions q) {
		Scanner scanner = null;
		Thread takeInput = new Thread(new InputThread(q));
		takeInput.setDaemon(true);
		takeInput.start();
		Boolean timeout = false;
		try {
			takeInput.join(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (takeInput.isAlive()) {
			timeout = true;
		}

		takeInput.interrupt();

		return timeout;
	}
}


