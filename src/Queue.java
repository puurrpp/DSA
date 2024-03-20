// Mendoza, Kyran Xandre O.
// ICS2605 1CSA
// Lab Exercise 3

public class Queue<T> {
	Object[] q;
	private int front = -1;
	private int rear = -1;
	private int count = 0;
	private int maxSize = 100;

	Queue() {
		q = new Object[maxSize];
	}
	Queue(int size) {
		if (size > 0) maxSize = size;
		q = new Object[maxSize];
	}
	Queue(Queue<T> source) {
		maxSize = source.maxSize;
		q = source.q;
		front = source.front;
		rear = source.rear;
	}

	void enqueue(T el) {
		if (isFull())
			throw new IndexOutOfBoundsException("enqueue on full queue");

		if (isEmpty())
			front = 0;
		rear = (++rear) % maxSize;
		count++;
		q[rear] = el;
	}

	T dequeue() {
		if (isEmpty())
			throw new IndexOutOfBoundsException("dequeue from empty queue");

		T el = (T) q[front];
		front = ++front % maxSize;
		count--;
		if (isEmpty()) clear();
		return el;
	}

	T peek() {
		if (isEmpty())
			return null;
		return (T) q[front];
	}

	boolean isEmpty() {
		return count == 0;
	}

	boolean isFull() {
		return count == maxSize;
	}

	void clear() {
		front = rear = -1;
		count = 0;
	}

	public String debug() {
		StringBuilder output = new StringBuilder("Queue [max=" + maxSize + "] {" +
				"\nq: [");

		for (int i = 0; i < maxSize; i++)
			output.append(q[i]).append(",");

		output
				.append("]\nfront: ").append(front)
				.append(", rear: ").append(rear)
				.append("\ncount: ").append(count)
				.append("\nisFull: ").append(isFull())
				.append("\nisEmpty: ").append(isEmpty())
				.append("\n}");

		return output.toString();
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("Queue [");

		int i = front;
		if (!isEmpty())
			do {
				output.append(q[i]).append(",");
				i = ++i % maxSize;
			} while (i != rear);

		return output.append("]").toString();
	}
}
