import java.util.Arrays;

public class Stack<T> {
	Object[] _stack;
	private int top = -1;
	private int maxSize = 1000;

	Stack() {
		_stack = new Object[maxSize];
	}
	Stack(int size) {
		if (size > 0) maxSize = size;
		_stack = new Object[maxSize];
	}

	void push(T el) {
		_stack[++top] = el;
	}

	T pop() {
		return (T) _stack[top--];
	}

	T peek() {
		return (T) _stack[top];
	}

	boolean isEmpty() {
		return top == -1;
	}

	boolean isFull() {
		return top == (maxSize - 1);
	}

	void clear() {
		top = -1;
	}

	@Override
	public String toString() {
		return "Stack {" +
				"_stack=" + Arrays.toString(_stack) +
				", top=" + top +
				", maxSize=" + maxSize +
				'}';
	}
}
