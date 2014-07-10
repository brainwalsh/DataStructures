
package map;

/**
 *
 * @author bwalsh
 * @param <K>
 * @param <V>
 */
public interface IMap<K,V> extends IIterator<K,V> {
    
    public void put(K key, V value);    
    public V get(K key);    
    public int size();    
    public IIterator keys(); //allows us to iterate through the keys
    
}
