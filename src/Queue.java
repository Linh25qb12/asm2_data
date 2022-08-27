public class Queue<E> {
    private static final int DEFAULT_CAPACITY=10;
    private  int  rear;
    private  E[] queue;
    public Queue(){
        rear = -1;
        queue = (E[]) new Object[DEFAULT_CAPACITY];
    }
    public void enQueue(E element) {
        if (rear == queue.length-1){
            throw new IllegalStateException("Queue Overflow!!");
        }
        queue[++rear] = element;
    }

    public E deQueue() {
        ensureNonEmpty();
        E element = queue[0];
        for (int i=0;i<rear;i++){
            queue[i] = queue[i+1];
        }
        rear--;
        return element;
    }

    private void ensureNonEmpty() {
        if (rear==-1){
            throw new IllegalStateException("Queue is Empty");
        }

    }

    public boolean isEmpty() {
        return rear==-1;
    }

}
