package queue;

/**
 * Source code example for "A Practical Introduction to Data Structures and
 * Algorithm Analysis, 3rd Edition (Java)" by Clifford A. Shaffer Copyright
 * 2008-2011 by Clifford A. Shaffer
 */
/**
 * Array-based queue implementation
 */
class AQueue<E extends Comparable> implements Queue<E> {

    private static final int defaultSize = 10;
    private int maxSize;         // Maximum size of queue
    private int front;           // Index of front element
    private int rear;            // Index of rear element
    private E[] listArray;       // Array holding queue elements

    /**
     * Constructors
     */
    AQueue() {
        this(defaultSize);
    }

    @SuppressWarnings("unchecked")  // For generic array
    AQueue(int size) {
        maxSize = size + 1;          // One extra space is allocated
        rear = 0;
        front = 1;
        listArray = (E[]) new Comparable[maxSize];  // Create listArray
    }

    /**
     * Reinitialize
     */
    public void clear() {
        rear = 0;
        front = 1;
    }

    /**
     * Put "it" in queue
     */
    @Override
    public void enqueue(E it) {
        assert ((rear + 2) % maxSize) != front : "Queue is full";
        rear = (rear + 1) % maxSize; // Circular increment
        listArray[rear] = it;
    }

    /**
     * Remove and return front value
     */
    @Override
    public E dequeue() {
        assert length() != 0 : "Queue is empty";
        E it = listArray[front];
        front = (front + 1) % maxSize; // Circular increment
        return it;
    }

    /**
     * @return Front value
     */
    @Override
    public E frontValue() {
        assert length() != 0 : "Queue is empty";
        return listArray[front];
    }
    
    /**
     * @return Queue size
     */
    @Override
    public int length() {
        return ((rear + maxSize) - front + 1) % maxSize;
    }
    
    @Override
    public E maxValue(){
        assert length() != 0 : "Queue is empty";
        //for(int x = 0;x<listArray.;x++)
        return listArray[front];   
    }

// Extra stuff not printed in the book.
    /**
     * Generate a human-readable representation of this queue's contents that
     * looks something like this: < 1 2 3 >. This method uses toString() on the
     * individual elements.
     *
     * @return The string representation of this queue
     */
    @Override
    public String toString() {
        StringBuffer out = new StringBuffer((length() + 1) * 4);
        out.append("< ");
        for (int i = front; i != (rear + 1) % maxSize; i++) {
            out.append(listArray[i]);
            out.append(" ");
        }
        out.append(">");
        return out.toString();
    }
}
