
package queuestack;

public interface IStack<T> {

    public T push(T item);
    
    public T pop();
    
    public int size();
}
