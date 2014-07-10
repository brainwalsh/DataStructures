package iterator;

public interface IIterator<T> {

    public boolean hasNext();

    public T next();

    public boolean hasPrevious();

    public T previous();
    
    public void reset();
    
    public void insert(T item);
    
    public T remove();
    
}
