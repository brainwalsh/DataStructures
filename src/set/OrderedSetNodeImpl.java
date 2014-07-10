package set;

public class OrderedSetNodeImpl<T extends IComparable<T>> implements ISet<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int length = 0;

    @Override
    public T add(T item) {


        //create a node
        Node<T> n = new Node();
        n.setItem(item);

        //Recall that compareTo...
        //returns -1 if "item" comes before next
        //returns 0 if "item" == next
        //returns 1 if "item" comes after next


        if (head == null) {
            head = n;
            tail = n;
            length++;
            return item;
        } else {
            Node<T> next = head;
            while (next != null) {
                int difference = item.compareMeTo(next.getItem());
                if (difference == 0) {
                    return null;
                }



                if (difference < 0) {
                    if (next.getPrevious() != null) {
                        next.getPrevious().setNext(n);
                        n.setPrevious(next.getPrevious());
                    }
                    n.setNext(next);
                    next.setPrevious(n);
                    if (next == head) {
                        head = n;
                    }
                    length++;
                    return item;

                }

                next = next.getNext();

            }
        }
        tail.setNext(n);
        n.setPrevious(tail);
        tail = n;
        length++;
        return item;

    }
    @Override
    public T getItem(int index) {
        if (index <= 0 || index > length) {
            return null;
        }

        Node<T> node = head;
        for (int i = 1; i <= index; i++) {
            if (i == index) {
                return node.getItem();
            } else {
                node = node.getNext();
            }
        }
        return node.getItem();

    }

   
    @Override
    public T remove(int index) {
       if(index>length||index<1)
        {
            return null;
        } else 
        {
            //get the node
            Node<T> node = head;
            for(int i = 1; i<index; i++){
                node = node.getNext();
            } 
            
            T item = node.getItem();
            
            //test the node
            if(node==head && node==tail)
            {
                head=null;
                tail=null;
            } else if(node==head)
            {
                node = node.getNext();
                head.setNext(null);
                node.setPrevious(null);
                head = node; 
            } else if(node==tail)
            {
                tail.setPrevious(null);
                node.setNext(null);
                tail = node;
            }else
            {
                Node<T> next = node.getNext();
                Node<T> previous = node.getPrevious();
                next.setPrevious(previous);
                previous.setNext(next);
                node.setNext(null);
                node.setPrevious(null);
            } 
            length--;
            return item;
        } 
        
    }

    @Override
    public int length() {
        return length;
    }
}
