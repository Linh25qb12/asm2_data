public class Stack<E> {
    private Node<E> top;
    private int size;
    private static class Node<E>{
        E element;
        Node<E> previous;
        public Node( E element){
            this(element,null);
        }
        public Node(E element, Node<E> previous){
            this.element = element;
            this.previous = previous;
        }
    }
    public Stack(){

    }

    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.previous = top;
        top = newNode;
        size++;
    }

    public E pop() {
        ensureNonEmpty();
        E data = top.element;
        top = top.previous;
        size--;
        return data;
    }

    private void ensureNonEmpty() {
        if (size == 0) throw new IllegalStateException("Stack is Empty!!! Can not pop!");
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
