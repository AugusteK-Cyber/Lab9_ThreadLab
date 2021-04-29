import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class CarQueue {

	// Variables
	private Queue<Integer> queue = new PriorityQueue<>();;
	private Random random = new Random();
	private int valueRemoved = 0;
	private static int val1 = 6, val2 = 17;

	/**
	 * Constructor
	 */
	public CarQueue() {
		for (int i = 0; i < val1; i++) {
			queue.add(random.nextInt(4));
		}
	}

	/**
	 * Add to the queue
	 */
	public void addToQueue() {
		class Runner implements Runnable{

			@Override
			public void run() {
				try {
					for (int i = 0; i < val2; i++) {
						queue.add(random.nextInt(4));
					}

				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
				try {
					Thread.sleep(1000);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}

		}
		Runnable runner = new Runner();
		Thread thread = new Thread(runner);
		thread.start();

	}

	/**
	 * Delete from the queue and return an integer
	 * @return valueRemoved the value deleted from the queue
	 */
	public int deleteQueue() {
		class Runner implements Runnable{

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e) {
					System.out.println(e.getMessage());
				}

				try {
					if (queue.size() < val2) {
						queue.add(random.nextInt(4));
					}
					else if (!queue.isEmpty()) {
						valueRemoved = queue.remove();
					}
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}

		}
		Runnable runner = new Runner();
		Thread thread = new Thread(runner);
		thread.start();
		return valueRemoved;
	}

}
