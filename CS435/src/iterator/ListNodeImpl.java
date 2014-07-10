package iterator;

public class ListNodeImpl<T> implements IList<T>, IIterator<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private Node<T> current = null;  //this is the guy that moves
    private int count = 0;

    @Override
    public T remove() {

        //boundary condition
        if (current == null) {
            return null;
        }

        T theItem = current.getItem();

        //list with 1 node
        if (count == 1) {
            //then the head is the tail
            head = null;
            tail = null;
            count = 0;
        }

        //all other lists
        if (count > 1) {

            //move the head forward one
            if (current == head) {
                head = head.getNext();
                current.setNext(null);
                current = head;
                current.setPrevious(null);

                count = (count - 1);

                //move the tail back one
            } else if (current == tail) {
                tail = tail.getPrevious();
                current.setPrevious(null);
                current = tail;
                current.setNext(null);

                count = (count - 1);

            } else {
                //current's previous will now point to the one AHEAD of current
                current.getPrevious().setNext(current.getNext());

                //current's next will now point to the one BEHIND current
                current.getNext().setPrevious(current.getPrevious());

                //the list is one shorter
                count = (count - 1);
            }

        }
        //returns the removed item
        return theItem;
    }

    
    
    
    enum ohNo {BEFORE, AFTER, NOPE}
    private ohNo state = ohNo.NOPE;
    
    
    @Override
    public void insert(T item) {

        //creates our new node 
        Node<T> node = new Node<T>();
        node.setItem(item);
        
        
        
        if (current == head){
            node.setNext(current);
            current.setPrevious(node);
            current = node;
            head = node;
        } else if (current == tail){
            node.setNext(current);
            node.setPrevious(current.getPrevious());
            current.setPrevious(node);
            current = node;
        } else if (current != null) {
            node.setNext(current);
            node.setPrevious(current.getPrevious());
            current.setPrevious(node);
            current = node;   
        } if (current == null){
            //empty or beyond the tail or before the head
            if (head == null){
                head = node;
                tail = node;
                current = node;
            }
        }
        
        count++;

    }

    @Override
    public void reset() {
        current = head;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public IIterator<T> getIterator() {
        current = head; //initialize the iterator
        return this;    //return "me" because I am the iterator!

    }

    @Override
    public boolean hasNext() {
        if (current != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T next() {
        //check boundary condition 
        if (current == null) {
            return null;
        }

        T theItem = current.getItem();
        current = current.getNext(); // advancing current through

        return theItem;
    }

    @Override
    public boolean hasPrevious() {


        if (current.getPrevious() != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T previous() {

        if (current == null) {
            return null;
        }

        Node<T> previous = current.getPrevious();
        //check boundary condition
        if (previous == null) {
            return null;
        }

        //move pointer back, pop out item of the new node we're pointing at
        current = previous;
        T theItem = current.getItem();

        return theItem;
    }

    @Override
    public T add(T item) {
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
    public int getCount() {
        return count;
    }

    @Override
    public T getItem(int position) {

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
