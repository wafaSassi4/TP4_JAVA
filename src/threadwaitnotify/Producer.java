package threadwaitnotify;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Producer extends Thread {

	private static final int MAX_SIZE = 3;
	private final List<String> messages = new ArrayList<String>();
	
	@Override
	public void run() {

		try {
			while (true) {
				produce();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private synchronized void produce() throws InterruptedException {
		
		while (messages.size() == MAX_SIZE) {
			System.out.println("Queue is full ");

			wait();
			System.out.println("producer got notification from consumer");

		}
		messages.add(LocalDateTime.now().toString());
		
		System.out.println("producer produces data by thread " + currentThread().getName());

		notify();
		// System.out.println("producer notify by thread " + currentThread().getName());
	}

	public synchronized String consume() throws InterruptedException {
		notify();
		// System.out.println("consumer notify by thread " + currentThread().getName());
		while (messages.isEmpty()) {
			wait();
			// System.out.println("consume wait by thread " + currentThread().getName());
		}
		String data = messages.get(0);
		messages.remove(data);
		

		System.out.println("data removed");
		return data;
	}

}
