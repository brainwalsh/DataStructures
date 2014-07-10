package queuestack;

public class StackNodeImpl<T> implements IStack<T> {

    private Node<T> top = null;
    private Node<T> bottom = null;
    private int count = 0;

    @Override
    public T push(T item) {
        //we create a new node whenever we add an item
        Node<T> node = new Node<T>();
        node.setItem(item);
        
        if (bottom == null){
            bottom = node;
            top = node;
        } else  { 
            top.setNext(node);
            node.setPrevious(top);
            top = node;
        }
        
        count++;
        
        return item;
    }

    @Override
    public T pop() {

        if (top == null) {
            return null;
        } else if (top == bottom) {
            T item = bottom.getItem();
            bottom = null;
            top = null;
            count = count - 1;
            return item;
        } else {
            Node<T> node = top.getPrevious();
            T item = top.getItem();
            top.setPrevious(null);
            node.setNext(null);
            top = node;
            count = count - 1;
            return item;
        }

    }

    @Override
    public int size() {
        return count;
    }
}
