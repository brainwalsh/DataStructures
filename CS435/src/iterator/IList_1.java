package iterator;

import java.util.*;
import domain.*;

public interface IList<T> extends IIterable<T> {

    public T add(T item);

    public int getCount();

    public T getItem(int index);
    
    public void clear();
}
