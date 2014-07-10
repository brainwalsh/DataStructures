package set;

public class OrderedSetNodeImpl<T extends IComparable<T>> implements ISet<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int length = 0;

    @Override
    public T add(T item) {


        //create a node
        Node<T> n = new Node<T>();
        n.setItem(item);

        //Recall that compareTo...
        //returns -1 if "item" comes before next
        //returns 0 if "item" == next
        //returns 1 if "item" comes after next


        if (head == null) {
            head = n;
            tail = n;
        } else //find the spot
        {
            Node<T> next = head;
            while (next != null) {

                //compare item with next.getItem()                
                int result = item.compareTo(next.getItem());

                if (result == 0) {
                    //then they're the "same"
                    return null;
                } 
                
                else if (result > 0) {
                    
                    //if there's another node, let's compare
                    if (next.getNext() != null) {
                        next = next.getNext();
                    } 
                    
                    //if not, then we should be past the tail
                    else {
                        n.setPrevious(tail);
                        n.setNext(null);
                        tail.setNext(n);
                        tail = n;
                        
                        length ++;
                    }

                } else {
                    //implies it should be added somewhere in the list
                    //right before next

                    //when next is the head
                    if (next == head) {
                        n.setNext(head);
                        head.setPrevious(n);
                        n.setPrevious(null);
                        head = n;

                        length++;
                    } else {
                        n.setNext(next);
                        n.setPrevious(next.getPrevious());

                        next.setPrevious(n);

                        length++;


                    }
                }


            }
        }

        return item;
    }

    //To Do... later
    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int length() {
        return length;
    }
}
