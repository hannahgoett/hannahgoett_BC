package bst;

/**
 * Source code example for "A Practical Introduction to Data Structures and
 * Algorithm Analysis, 3rd Edition (Java)" by Clifford A. Shaffer Copyright
 * 2008-2011 by Clifford A. Shaffer
 */
/**
 * Binary tree node implementation: Pointers to children
 *
 * @param E The data element
 * @param Key The associated key for the record
 */
class BSTNode<Key, E> implements BinNode<E> {

    private Key key;              // Key for this node
    private E element;            // Element for this node
    public BSTNode<Key, E> left;  // Pointer to left child
    public BSTNode<Key, E> right; // Pointer to right child
    public BSTNode<Key, E> parent;
    public int leftHeight;
    public int rightHeight;

    /**
     * Constructors
     */
    public BSTNode() {
        left = right = null;
    }

    public BSTNode(Key k, E val) {
        left = right = parent = null;
        leftHeight = rightHeight = 0;
        key = k;
        element = val;
    }

    public BSTNode(Key k, E val,
            BSTNode<Key, E> l, BSTNode<Key, E> r) {
        left = l;
        right = r;
        key = k;
        element = val;
    }

    /**
     * Get and set the key value
     */
    public Key key() {
        return key;
    }

    public void setKey(Key k) {
        key = k;
    }

    /**
     * Get and set the element value
     */
    @Override
    public E element() {
        return element;
    }

    @Override
    public void setElement(E v) {
        element = v;
    }

    @Override
    public BSTNode<Key, E> parent() {
        return parent;
    }
    
    /**
     * Get and set the left child
     */
    @Override
    public BSTNode<Key, E> left() {
        return left;
    }

    public void setLeft(BSTNode<Key, E> p) {
        left = p;
    }

    /**
     * Get and set the right child
     */
    @Override
    public BSTNode<Key, E> right() {
        return right;
    }

    public void setRight(BSTNode<Key, E> p) {
        right = p;
    }

    /**
     * @return True if a leaf node, false otherwise
     */
    @Override
    public boolean isLeaf() {
        return (left == null) && (right == null);
    }
}
