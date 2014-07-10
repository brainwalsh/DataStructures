
package queuestack;

public interface IQueue<T> {
    
    public void enqueue(T item);
    
    public T dequeue();
    
    public int size();
}
