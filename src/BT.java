public class BT {
	BTNode root;
	int height;

	BT(BTNode root) {
		this.root = root;
	}
	BT() {}

	void setRoot(BTNode n) {
		root = n;
	}

	void computeLevels() {
		if (root == null) return;

		Queue<BTNode> nodes = new Queue<>();
		Queue<Integer> levels = new Queue<>();

		int currentLevel = 0;
		nodes.enqueue(root);
		levels.enqueue(currentLevel);

		while (!nodes.isEmpty()) {
			BTNode node = nodes.dequeue();
			int level = levels.dequeue();

			if (node.hasLeft()) {
				nodes.enqueue(node.left);
				levels.enqueue(level+1);
			}
			if (node.hasRight()) {
				nodes.enqueue(node.right);
				levels.enqueue(level+1);
			}

			node.setLevel(level);
			System.out.print("K = " + node.info);
			System.out.println(" level = " + level);

			// because BFS, last level visited is always deepest
			// therefore keep overwriting height
			height = level;
		}
	}

	public String toString() {
		return root == null
				? "height=null (tree is empty)"
				: "height=" + height + " " + root;

	}
}
