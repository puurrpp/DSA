//Richard Earl T. Gaffud
//Kyran Xandre Mendoza
// ICS 2605
//1CSA
//Lab Exercise 3
public class SLL<T> {
	private SLLNode<T> head = null, tail = null;

	void insertAsc(T el) {
		if (isEmpty())
			addToHead(el);
		else if (head == tail) {
			if (((Comparable) head).compareTo(el) < 0)
				head.next = tail = new SLLNode<>(el);
			else {
				SLLNode<T> newHead = new SLLNode<>(el);
				SLLNode<T> oldTail = tail;

				head = newHead;
				head.next = oldTail;
			}
		} else {
			SLLNode<T> p;
			for (p = head; p.next != null; p = p.next)
				if (((Comparable<T>) p.next).compareTo(el) > 0)
					break;

			SLLNode<T> elNode = new SLLNode<>(el);

			if (p == head && head.compareTo(el) > 0) {
				elNode.next = p;
				head = elNode;
			} else {
				elNode.next = p.next;
				p.next = elNode;
			}

			if (elNode.next == null)
				tail = elNode;

		}

	}

	boolean isEmpty() {
		return head == null;
	}

	void addToHead(T el) {
		head = new SLLNode<T>(el, head);
		if (tail == null)
			tail = head;
	}

	T deleteFromTail() {
		if (isEmpty()) return null;

		T el = tail.info;
		if (head == tail)
			head = tail = null;
		else {
			SLLNode<T> p;
			for (p = head; p.next != tail; p = p.next) ;
			tail = p;
			tail.next = null;
		}

		return el;
	}

	void removeDups() {
		if (isEmpty() || head == tail)
			return;

		SLLNode<T> p = head;
		while (p != null) {
			while (p.next != null && p.info == p.next.info)
				p.next = p.next.next;

			p = p.next;
		}
	}

	public String toString() {
		SLLNode<T> p;
		String s = "";
		for (p = head; p != null; p = p.next)
			s = s + p.toString() + " ";
		return s;
	}


}
