// Bernales, Gian
// Mendoza, Kyran
// ICS 2605
// Section X
// Lab Exercise 4

public class BST<T extends Comparable<T>> extends BT {
    public BST() {
        super();
    }

    public void insert(T k) {
        BTNode<T> newNode = new BTNode<>(k);
        int currentLevel = 0;

        if (root == null) {
            root = newNode;
            height = 0;
            newNode.setLevel(currentLevel);
        } else {
            BTNode<T> temp = root;
            BTNode<T> parent;

            while (true) {
                parent = temp;
                currentLevel++;
                int comp = k.compareTo((T)temp.info);
                if (comp < 0) {
                    temp = temp.left;
                    if (temp == null) {
                        parent.left = newNode;
                        newNode.setLevel(currentLevel);
                        break;
                    }
                } else if (comp > 0) {
                    temp = temp.right;
                    if (temp == null) {
                        parent.right = newNode;
                        newNode.setLevel(currentLevel);
                        break;
                    }
                } else {
                    // Assume no duplicates allowed
                    return;
                }
            }

            if (currentLevel > height) {
                height = currentLevel;
            }
        }
    }

    public BTNode<T> search(T k) {
        BTNode<T> temp = root;
        while (temp != null) {
            int comp = k.compareTo((T)temp.info);
            if (comp < 0) {
                temp = temp.left;
            } else if (comp > 0) {
                temp = temp.right;
            } else {
                return temp; // found
            }
        }
        return null; // not found
    }
}
