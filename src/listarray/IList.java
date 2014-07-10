package listarray;

import java.util.*;
import domain.*;

/**
 * @author bwalsh
 */
public interface IList<T> {

    public T add(T item);

    public int count();

    public T getItem(int index);
}
