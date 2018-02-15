/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

import static java.lang.Math.abs;

/**
 *
 * @author hannah.goett
 */
    class AVLTree<Key extends Comparable<? super Key>, E>
        implements Dictionary<Key, E> {
    
    public BSTNode<Key, E> root;
    int nodecount; 
    
    AVLTree() {
        root = null;
        nodecount = 0;
    }
    
    @Override
    public void clear(){
        root = null;
        nodecount = 0;
    }

    @Override
    public void insert(Key k, E e) {
        BSTNode<Key, E> newNode = new BSTNode<>(k, e);
        inserthelp(root, newNode);
        nodecount++;
        BSTNode pivot = findPivot(newNode);
        if(pivot != null){
            if(newNode.key().compareTo(root.key())>0 && newNode.key().compareTo(
                    root.left.key())>0){
                singleRotateRight(pivot);
            }else if(newNode.key().compareTo(root.key())>0 && 
                    newNode.key().compareTo(root.left.key())<0){
                doubleRightRotation(pivot);
            }else if(newNode.key().compareTo(root.key())<0 && 
                    newNode.key().compareTo(root.left.key())>0){
                doubleLeftRotation(pivot);
            }else{
                singleRotateLeft(pivot);
            }
        }
    }
    
    private void inserthelp(BSTNode<Key, E> rt,
            BSTNode<Key, E> newNode) {
        if (rt == null) {
            this.root=newNode;
            return;
        }
       
        if (rt.key().compareTo(newNode.key()) > 0) {
            if(rt.left == null){
                rt.left = newNode;
                newNode.parent = rt;
            }else { 
                inserthelp(rt.left, newNode);
            }
        } else if (rt.key().compareTo(newNode.key()) < 0) {
            if(rt.right==null) {
            rt.right = newNode;
            newNode.parent = rt;
            }else{
                inserthelp(rt.right, newNode);
            }
        }
    }

    @Override
    public E remove(Key k){
        throw new UnsupportedOperationException("Invalid operation");
    }

    @Override
    public E removeAny(){
        throw new UnsupportedOperationException("Invalid operation");
    }

    @Override
    public E find(Key k) {
        return findhelp(root, k);
    }

    /**
     * @return The number of records in the dictionary.
     */
    @Override
    public int size() {
        return nodecount;
    }
   

    private E findhelp(BSTNode<Key, E> rt, Key k) {
        if (rt == null) {
            return null;
        }
        if (rt.key().compareTo(k) > 0) {
            return findhelp(rt.left(), k);
        } else if (rt.key().compareTo(k) == 0) {
            return rt.element();
        } else {
            return findhelp(rt.right(), k);
        }
    }
    
    public void singleRotateLeft(BSTNode<Key, E> pivot){
          BSTNode<Key, E> pivotChild = pivot.right;
          BSTNode<Key, E> pivotGrandchild = pivotChild.right;
          if(pivot == root){
              pivotChild.left = pivot;
              pivot.rightHeight = pivot.rightHeight-2;
              this.root = pivotChild;
              pivot.parent = pivotChild;
              pivotChild.parent = null;  
          }else{
              pivotChild.left = pivot;
              pivot.rightHeight = pivotChild.rightHeight-2;
              pivotChild.parent = pivot.parent;
              pivot.parent = pivotChild;
          }
   }

    public void singleRotateRight(BSTNode pivot){
        BSTNode<Key, E> pivotChild = pivot.left;
        BSTNode<Key, E> pivotGrandchild = pivotChild.left;
        if(pivot == root){
              pivotChild.right = pivot;
              pivot.leftHeight = pivot.leftHeight-2;
              this.root = pivotChild;
              pivot.parent = pivotChild;
              pivotChild.parent = null;  
          }else{
              pivotChild.right = pivot;
              pivot.leftHeight = pivotChild.leftHeight-2;
              pivotChild.parent = pivot.parent;
              pivot.parent = pivotChild;
          }
    }
    public void doubleLeftRotation(BSTNode pivot) {
        BSTNode<Key, E> pivotChild = pivot.right;
        BSTNode<Key, E> pivotGrandchild = pivotChild.right;
        pivotGrandchild.right = pivotChild;
        pivotChild.parent = pivotGrandchild;
        pivot.right = pivotGrandchild;
        singleRotateLeft(pivot);
        
    }
    
    public void doubleRightRotation(BSTNode pivot) {
        BSTNode<Key, E> pivotChild = pivot.right;
        BSTNode<Key, E> pivotGrandchild = pivotChild.right;
        pivotGrandchild.left = pivotChild;
        pivotChild.parent = pivotGrandchild;
        pivot.left = pivotGrandchild;
        singleRotateRight(pivot);
        
 }
    
    private BSTNode findPivot(BSTNode<Key, E> n){
        BSTNode<Key, E> currentNode = n.parent();
        Key currentValue = n.key();
        BSTNode<Key, E> pivotNode = null;
        while(currentNode != null){
            if(currentValue.compareTo(currentNode.key())<= 0){
                currentNode.leftHeight++;
            }else{
                currentNode.rightHeight++; 
            }
            if(abs(currentNode.rightHeight - currentNode.leftHeight)>1 && 
                    pivotNode == null){
                pivotNode = currentNode;
                return pivotNode;
            }
            currentNode = currentNode.parent();
        }
        return pivotNode;
    }
    
    
    public void preorder(BSTNode<Key, E> r)
     {
         if (r != null)
         {
             System.out.print(r.key() +"["+r.leftHeight+","+r.rightHeight+"] ");
             preorder(r.left());             
             preorder(r.right());
         }
     }
    
    public void inorder(BSTNode<Key, E> r){
        if(r != null){
            inorder(r.left());
            System.out.print(r.key() +"["+r.leftHeight+","+r.rightHeight+"] ");
            inorder(r.right());
        }
    }
     public void postorder(BSTNode<Key, E> r)
     {
         if (r != null)
         {
             postorder(r.left());             
             postorder(r.right());
             System.out.print(r.key() +"["+r.leftHeight+","+r.rightHeight+"] ");
         }
     }     
}
    

