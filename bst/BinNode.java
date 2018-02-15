package bst;

/**
 * Source code example for "A Practical Introduction to Data Structures and
 * Algorithm Analysis, 3rd Edition (Java)" by Clifford A. Shaffer Copyright
 * 2008-2011 by Clifford A. Shaffer
 */
/**
 * ADT for binary tree nodes
 * @param <E> -- any type E
 */
public interface BinNode<E> {

    /**
     * Get and set the element value
     * @return the element as type E
     */
    public E element();

    public void setElement(E v);

    /**
     * @return The left child
     */
    public BinNode<E> left();

    /**
     * @return The right child
     */
    public BinNode<E> right();

    public BinNode<E> parent();
    /**
     * @return True if a leaf node, false otherwise
     */
    public boolean isLeaf();
}
