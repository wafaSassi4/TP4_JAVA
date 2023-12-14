package threadwaitnotify;

public class ProducerConsumerProblem {

	public static void main(String[] args) throws InterruptedException {
		Producer producer = new Producer();
		producer.setName("producer 1");
		Consume consumer1 = new Consume(producer);
		consumer1.setName("consume 1");
		consumer1.start();
		Consume consumer2 = new Consume(producer);
		consumer2.setName("consume 2");
		consumer2.start();
		Consume consumer3 = new Consume(producer);
		consumer3.setName("consume 3");
		consumer3.start();
		
		producer.start();

	}

}