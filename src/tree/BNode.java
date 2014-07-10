
package tree;

public class BNode<T> {
    private BNode<T> parent;
    private BNode<T> left;
    private BNode<T> right;
    private T item;

    public BNode<T> getParent() {
        return parent;
    }

    public void setParent(BNode<T> parent) {
        this.parent = parent;
    }

    public BNode<T> getLeft() {
        return left;
    }

    public void setLeft(BNode<T> left) {
        this.left = left;
    }

    public BNode<T> getRight() {
        return right;
    }

    public void setRight(BNode<T> right) {
        this.right = right;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
    
}
