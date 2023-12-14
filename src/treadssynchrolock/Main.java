package treadssynchrolock;

import java.util.ArrayList;
import SpellingThreads.SpellingThreads;

import java.util.List;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		List<Character> list = new ArrayList<Character>();
		Thread thread1 = new SpellingThreads(list, "Hello");
		Thread thread2 = new SpellingThreads(list, "world");

		thread1.start();
		thread2.start();
		
		thread1.join();
	    thread2.join();

	    System.out.println("Final List: " + list);
	}
}
