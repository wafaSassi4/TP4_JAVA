package threadwaitnotify;

public class Consume extends Thread{
	
	private Producer producer;

	public Consume(Producer producer) {
		this.producer = producer;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true)
			{
				String data = producer.consume();
				System.out.println("consumed by "+Thread.currentThread().getName()+" data : "+data);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
