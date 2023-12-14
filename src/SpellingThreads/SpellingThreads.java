package SpellingThreads;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SpellingThreads extends Thread {
	
	private List<Character> names;
	private String message;
	private static Lock verrou = new ReentrantLock();
	
	public SpellingThreads(List<Character> names, String message) {
		super();
		this.names = names;
		this.message = message;
	}

	@Override
	public void run() {
		verrou.lock();
		try {
			System.out.println("locked by " + Thread.currentThread().getName());

			for (int i = 0; i < message.length(); i++) {
				names.add(message.charAt(i));
				try {
					sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			System.out.println(names);
		} finally {
			verrou.unlock();
			System.out.println("unlocked by " + Thread.currentThread().getName());
		}
	}
	
	

}



