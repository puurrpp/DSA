//Richard Earl T. Gaffud
    //Kyran Xandre Mendoza
    // ICS 2605
    //1CSA
    //Lab Exercise 3
    public class Stack<T> {

        private Object[] stk;
        private int top;
        private int maxSize = 100;

        public Stack() {
            stk = new Object[maxSize];
        }

        public Stack(int capacity) {
            maxSize = capacity;
            stk = new Object[maxSize];
            top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == maxSize - 1;
        }

        public void push(T item) {
            if (!isFull()) {
                stk[++top] = item;
            } else {
                System.out.println("Stack Overflow");
            }
        }

        public T pop() {
            if (!isEmpty()) {
                T item = (T) stk[top--];
                return item;
            } else {
                System.out.println("Stack Underflow");
            }
            return null;
        }

        public T peek() {
            if (!isEmpty()) {
                return (T) stk[top];
            } else {
                System.out.println("Stack is empty");
                return null;
            }
        }
    }
