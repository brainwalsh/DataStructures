package listarray;

import domain.*;

/**
 * @author bwalsh
 */
public class ListArrayImpl<T> implements IList<T> {

    private int nextSlot = 0;
    private T[] items;

    public ListArrayImpl(int size) {
        items = (T[]) new Object[size];
    }

    @Override
    public T add(T item) {

        //if there's no room, reallocate  it
        if (nextSlot >= (items.length)) {

            //run out of space, going to create a new array temporarily

            T[] temp = (T[]) new Object[2 * items.length];

            //copy old array into the new array
            //could be replaced with:
            //System.arraycopy(items, 0, temp, 0, items.length);
            for (int i = 0; i < items.length; i++) {
                temp[i] = items[i];
            }
            items = temp;
        }
        items[nextSlot++] = item;
        return item;

    }

    @Override
    public int count() {
        return nextSlot;
    }

    @Override
    public T getItem(int index) {
        return items[index];
    }
}
