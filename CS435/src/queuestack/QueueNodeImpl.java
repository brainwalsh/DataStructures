package queuestack;

public class QueueNodeImpl<T> implements IQueue<T> {

    private Node<T> front = null;
    private Node<T> back = null;
    private int count = 0;

    @Override
    public void enqueue(T item) {
        Node<T> node = new Node<T>();
        node.setItem(item);
        
        if (front == null) {
            front = node;
            back = node;
        } else {
            back.setNext(node);
            node.setPrevious(back);
            back = node;

        }
        
        count++;
    }

    @Override
    public T dequeue() {
        if (front == null) {
            return null;
        } else if (back == front) {
            T item = front.getItem();
            front = null;
            back = null;

            count--;
            return item;
        } else {
            Node<T> node = front.getNext();
            T item = front.getItem();
            front.setNext(null);
            node.setPrevious(null);
            front = node;

            count--;
            return item;
        }


    }

    @Override
    public int size() {
        return count;
    }
}
