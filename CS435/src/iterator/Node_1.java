
package iterator;

import listnode.*;

public class Node<T> {
    private T item = null;
    private Node<T> next = null;
    private Node<T> previous = null;

    
    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }
    
    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    
    
}
