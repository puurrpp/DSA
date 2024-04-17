public class KStack<T> {
	Object[] _stack;
	private int top = -1;
	private int maxSize = 1000;

	KStack() {
		_stack = new Object[maxSize];
	}
	KStack(int size) {
		if (size > 0) maxSize = size;
		_stack = new Object[maxSize];
	}

	void push(T el) {
		if (isFull()) throw new IndexOutOfBoundsException("pushing to full stack");
		_stack[++top] = el;
	}

	T pop() {
		if (isEmpty()) throw new IndexOutOfBoundsException("popping on empty stack");
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
		StringBuilder outputBuilder = new StringBuilder("Stack {\n  _stack=[");
		for (int i = 0; i < top; i++)
			outputBuilder.append(_stack[i]).append(",");
		outputBuilder
				.append("],\n  top=").append(top)
				.append(",\n  maxSize=").append(maxSize)
				.append("\n}");

		return outputBuilder.toString();
	}
}
