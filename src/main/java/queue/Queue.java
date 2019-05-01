package queue;

public class Queue {
	private int[] queue;

	public Queue() {
		this.queue = new int[0];
	}

	public void enqueue(int val) {
		int qLen = this.queue.length;
		int[] newQueue = new int[qLen + 1];
		System.arraycopy(this.queue, 0, newQueue, 0, qLen);
		newQueue[qLen] = val;
		this.queue = newQueue;
	}

	public void dequeue() {
		int qLen = this.queue.length;
		if (qLen == 0) {
			return;
		}

		int[] newQueue = new int[qLen - 1];
		System.arraycopy(this.queue, 1, newQueue, 0, qLen - 1);
		this.queue = newQueue;
	}

	public int peek() {
		return 0 < this.queue.length ? this.queue[0] : null;
	}

	public void printDescription() {
		String desc = "";
		for (int i = 0; i < this.queue.length; i++) {
			desc += this.queue[i];
			if (i < this.queue.length - 1) {
				desc += ", ";
			}
		}
		System.out.println("[" + desc + "]");
	}
}
