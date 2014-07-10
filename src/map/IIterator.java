package map;

public interface IIterator<K,V> {

    public boolean hasNext();
    public V next();

}
