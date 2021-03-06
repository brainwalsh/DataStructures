
package set;


public interface ISet<T extends IComparable<T>> {
    public T add(T item);
    public T remove(int index);
    public int length();
}
