//Richard Earl T. Gaffud
//Kyran Xandre Mendoza
// ICS 2605
//1CSA
//Lab Exercise 3
public class SLLNode<T> implements Comparable<T> {
	T info;
	SLLNode<T> next;

	SLLNode(T el) {
		info = el;
		next = null;
	}

	SLLNode(T el, SLLNode<T> ptr) {
		info = el;
		next = ptr;
	}

	public String toString() {
		return info.toString();
	}

	public int compareTo(T t) {
		int f1 = Integer.parseInt(info.toString());
		int f2 = Integer.parseInt(t.toString());

		return Integer.compare(f1, f2);
	}
}
