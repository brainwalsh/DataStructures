
package map;


public class Node<K> {
    private K item = null;
    private Node<K> next = null;
    private Node<K> previous = null;

    
    public K getItem() {
        return item;
    }

    public void setItem(K item) {
        this.item = item;
    }

    public Node<K> getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node<K> getPrevious() {
        return previous;
    }
    
    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    
    
}
