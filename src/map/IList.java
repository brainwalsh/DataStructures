package map;

public interface IList<V> extends IIterator {

    public V add(V value);
    public V getItem(int index);
    public int size();
}
