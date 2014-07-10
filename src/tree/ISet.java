
package tree;

public interface ISet<T extends IComparable<T>> {
    public T add(T item);
    //public T remove(int index);
    public int length();
    public T getItem(int index);
}
