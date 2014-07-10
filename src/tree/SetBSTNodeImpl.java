package tree;

public class SetBSTNodeImpl<T extends IComparable<T>> implements ISet<T> {

    private BNode<T> root = null;
    private int count = 0;

    @Override
    public T add(T item) {
        if (root == null) {
            BNode<T> node = new BNode<T>();
            node.setItem(item);
            root = node;
            count = 1;
            return item;

        }
        //return addItemUsingIteration(item);
        return addUsingRecursion(item, root);
    }

    private T addItemUsingIteration(T item) {
        BNode<T> current = root;
        int result = item.compareTo(current.getItem());
        while (current != null) {

            if (result == 0) {
                return null;
            } else {
                if (result < 0) {
                    BNode<T> left = current.getLeft();
                    if (left == null) {
                        BNode<T> now = new BNode<T>();
                        now.setItem(item);
                        now.setParent(current);
                        current.setLeft(now);
                        count++;
                        return item;

                    } else {
                        current = left;
                    }

                } else {
                    if (result > 0) {
                        BNode<T> right = current.getRight();
                        if (right == null) {
                            BNode<T> now = new BNode<T>();
                            now.setItem(item);
                            now.setParent(current);
                            current.setRight(now);
                            count++;
                            return item;

                        } else {
                            current = right;
                        }

                    }
                }
            }
        }
        return item;
    }

    private T addUsingRecursion(T item, BNode<T> node) {

        if (node == null) {
            return null;
        }
        int result = item.compareTo(node.getItem());
        if (result == 0) {
            return null;
        } else if (result < 0) {
            if (node.getLeft() == null) {//add item to the left
                BNode<T> newNode = new BNode<T>();
                newNode.setItem(item);
                newNode.setParent(node);
                node.setLeft(newNode);
                count++;
                return item;
            } else {
                return addUsingRecursion(item, node.getLeft());
            }

        } else if (result > 0) {
            if (node.getRight() == null) {
                BNode<T> newNode = new BNode<T>();
                newNode.setItem(item);
                newNode.setParent(node);
                node.setRight(newNode);
                count++;
                return item;
            } else {
                return addUsingRecursion(item, node.getRight());
            }
        }
        return item;
    }

    @Override
    public int length() {
        return count;
    }

    @Override
    public T getItem(int index) {
        return null;
    }

}
