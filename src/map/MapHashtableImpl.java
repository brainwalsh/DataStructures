package map;

/**
 *
 * @author bwalsh
 */
public class MapHashtableImpl<K,V> implements IMap<K,V>, IIterator<K,V>{

    private int size = 0;
    private KVPair[] hashtable = null;
    private ListNodeImpl<K> listOfKeys = new ListNodeImpl();
    private IIterator iterator;

    //nested inner class "KVPair"
    private class KVPair<K,V> 
    {

        private K key;
        private V value;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    //our defined "default" constructor
    public MapHashtableImpl() 
    {
        hashtable = new KVPair[100];
    }

    public MapHashtableImpl(int size) 
    {
        hashtable = new KVPair[size];
    }

    @Override
    public void put(K key, V value) 
    {
        //1. create and populate the entity
        //2. calculate hashcode of key
        //3. store the entity in hashtable using hashcode

        //note: the hashcode is an INT, and it points to the value
        //O(c) => fast and constant
        KVPair p = new KVPair();
        p.setKey(key);
        p.setValue(value);

        int hashcode = key.hashCode();
        int phashcode = (hashcode < 0) ? -hashcode : hashcode;
        int index = (phashcode % hashtable.length);

        //add the pair to the array at the index point
        hashtable[index] = p;//assuming there is no collision
        listOfKeys.add(key); //add the key to our running list
        size++;//increment
    }

    @Override
    public V get(K key) 
    {

        //give it the gey, generate the hashcode, find it in the hashtable
        int hashcode = key.hashCode();

        int phashcode = (hashcode < 0) ? -hashcode : hashcode;
        int index = phashcode % hashtable.length;

        KVPair p = hashtable[index];

        if (p != null) {
            return (V) p.getValue();//cast it to a V
        }

        return null;
    }

    @Override
    public int size() 
    {
        return size;
    }

    @Override
    public IIterator<K,V> keys() 
    {
        iterator = listOfKeys.getIterator();
        return this;
    }

    @Override
    public boolean hasNext() 
    {
        //boundary condition
        if (listOfKeys == null) {
            return false;
        }
        //check if there is another entry
        if (iterator.hasNext()) {
            return true;
        }
        //if not, return false
        return false;
    }
    
    @Override
    public V next() 
    {
        
        if(iterator==null){
            return null;
        }
        if(iterator.hasNext()){
            return get((K) iterator.next());
        }
        return null;
    }
}
