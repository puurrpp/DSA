import java.util.Arrays;

public class Queue<T> {
	Object[] q;
	private int front = -1;
	private int rear = -1;

	private int maxSize = 1000;

	Queue() {
		q = new Object[maxSize];
	}
	Queue(int size) {
		if (size > 0) maxSize = size;
		q = new Object[maxSize];
	}

	void enqueue(T el) {
		if (isEmpty())
			front = 0;

		rear = (++rear) % maxSize;
		q[rear] = el;
	}

	T dequeue() {
		T el = (T) q[front];
		front = ++front % maxSize;
		return el;
	}

	T peek() {
		return (T) q[front];
	}

	boolean isEmpty() {
		return front == -1 && front == rear;
	}

	boolean isFull() {
		return ((rear + 1) % maxSize) == front;
	}

	void clear() {
		front = rear = -1;
	}

	@Override
	public String toString() {
		return "Queue [max="+maxSize+"] {" +
				"\nq= " + Arrays.toString(q) +
				"\nfront= " + front + ", rear= " + rear +
				"\nisFull= " + isFull() +
				"\nisEmpty= " + isEmpty() +
				"\n}";
	}
}
