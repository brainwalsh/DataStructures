package listnode;

import java.util.*;
import domain.*;

/**
 * @author bwalsh
 */
public interface IList<T> {

    public T add(T item);

    public int getCount();

    public T getItem(int index);
}
