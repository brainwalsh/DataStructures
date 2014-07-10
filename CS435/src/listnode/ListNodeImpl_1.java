package listnode;



public class ListNodeImpl<T> implements IList<T> {

    private Node head = null;
    private Node tail = null;
    private int count = 0;

    @Override
    public T add(T item) {
        //we create a new node whenever we add an item
        Node<T> n = new Node<T>();
        n.setItem(item);
        
        if(head == null){ //first one
            head = n;
            tail = n;
        }else{  
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
        
        if(position <=0 || position > count){
            return null;
        }
             
        Node<T> node = head;
        
        for (int i = 1; i <= position; i++){
            if(i == position){
                return node.getItem();//we're done
            }else{
                node = node.getNext();
            }
            
        }
    
        return node.getItem();
    }
}
