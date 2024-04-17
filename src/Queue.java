//Richard Earl T. Gaffud
//Kyran Xandre Mendoza
// ICS 2605
//1CSA
//Lab Exercise 3

public class Queue<T> {
    private int maxQSize = 100;
    private int front = -1, rear = -1;
    private Object[] que;
    private int size;
    
    // Queue with empty size
    public Queue() {
        que = new Object[maxQSize];
    }
    
    // With assigned value
    public Queue(int n) {
        if (n > 0) 
            maxQSize = n;
        que = new Object[maxQSize];
    }
    
    public void clear() {
        front = -1;
        rear = -1;
        size = 0;
    }
    
    public boolean isEmpty() {
        return front == -1;
    }
    
    public boolean isFull() {
        return front == (rear + 1) % maxQSize;
    }
    
    public int enqueue(T value) {
        if (isFull())
            return -999; // Enqueue overflow error
        if (isEmpty()) 
            front = 0;
        
        rear = ++rear % maxQSize;
        que[rear] = value;
        size++;
        
        return 1;
    }
    
    public T dequeue() {
        if (isEmpty()) 
            return null;
        T value = (T) que[front];
        
        if (front == rear) 
            clear();
        else
            front = ++front % maxQSize;
        
        size--;
        
        return value;
    }
    
    public T peek() {
        if(isEmpty()) 
            return null;
        return (T) que[front];
    }
    
    public int size() {
         return size;
    }
    
}
