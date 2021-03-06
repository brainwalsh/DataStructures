
package set;


public class SetNodeImpl<T extends IComparable<T>> implements ISet<T> 
{

    private Node<T> head = null;
    private Node<T> tail = null;
    private int length = 0;
    
    private boolean isUnique(T item)
    {
        
        if(head!=null){
            
            Node<T> node = head;
            Node<T> next = new Node();
            
            while(node!=null)
            {
                
                next = node.getNext();
                if(node.getItem().equals(item))
                {
                    return false;
                } else 
                {
                    node = next;
                } 
                
            }  
            
        } 
        
        return true;
        
    }
    
    @Override
    public T add(T item) 
    {
        
        Node<T> node = new Node();
        node.setItem(item);
        
        if(head==null)
        {
            head=node;
            tail=node;
            length++;
        }else
        {
            if(isUnique(item))
            {
                tail.setNext(node);
                node.setPrevious(tail);
                tail=node;
                length++;
            }
        }
        
        return item;
        
    } 

    @Override
    public T remove(int index) 
    {
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
    public int length() 
    {
        return length;
    } 
    
} 
