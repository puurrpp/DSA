public class BTNode<T> {
	T info;
	int level;
	BTNode<T> left = null, right = null;

	BTNode(T info, BTNode<T> left, BTNode<T> right) {
		this.info = info;
		this.left = left;
		this.right = right;
	}
	BTNode(BTNode<T> ref, BTNode<T> left, BTNode<T> right) {
		this.info = ref.info;
		this.left = left;
		this.right = right;
	}

	BTNode(T info) {
		this.info = info;
	}
	BTNode(BTNode<T> ref) {
		this.info = ref.info;
		this.left = ref.left;
		this.right = ref.right;
		this.level = ref.level;
	}

	void setLevel(int level) {
		this.level = level;
	}

	boolean hasLeft() {
		return left != null;
	}

	boolean hasRight() {
		return right != null;
	}

	void setLeft(BTNode<T> left) {
		this.left = left;
	}

	void setRight(BTNode<T> right) {
		this.right = right;
	}

	public String toString() {
		return info == null
				? ""
				: "[K=" + info
					+ ((left != null) ? (" L=" + left) : "")
					+ ((right != null) ? (" R=" + right) : "")
					+ "]";
	}


}
