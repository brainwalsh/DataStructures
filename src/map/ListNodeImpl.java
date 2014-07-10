package map;


public class ListNodeImpl<T> implements IList<T>, IIterator {

    private Node<T> head = null;
    private Node<T> tail = null;
    private Node<T> current = null;  //this is the guy that moves
    private int count = 0;

    
    @Override
    public boolean hasNext() 
    {
        if (current != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T next() 
    {
        //check boundary condition 
        if (current == null) {
            return null;
        }

        T theItem = current.getItem();
        current = current.getNext(); // advancing current through

        return theItem;
    }

    public IIterator getIterator()
    {
        current = head;
        return this;
    }

    @Override
    public T add(T item) 
    {
        //we create a new node whenever we add an item
        Node<T> n = new Node<T>();
        n.setItem(item);

        if (head == null) { //first one
            head = n;
            tail = n;
        } else {
            tail.setNext(n);  //tail's next is the new node
            n.setPrevious(tail);  //points the new node backwards at the tail
            tail = n; //sets tail to the node we added
        }

        count++;

        return item;
    }

    @Override
    public int size() 
    {
        return count;
    }

    @Override
    public T getItem(int position) 
    {

        if (position <= 0 || position > count) {
            return null;
        }

        Node<T> node = head;

        for (int i = 1; i <= position; i++) {
            if (i == position) {
                return node.getItem();//we're done
            } else {
                node = node.getNext();
            }

        }

        return node.getItem();
    }
}
