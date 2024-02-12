public class Stack<T> {
	Object[] _stack;
	private int _len = -1;

	Stack(int size) {
		_stack = new Object[size];
	}

	void push(T el) {
		_stack[++_len] = el;
	}

	T pop() {
		return (T) _stack[_len--];
	}

	boolean isEmpty() {
		return _len == -1;
	}
}
