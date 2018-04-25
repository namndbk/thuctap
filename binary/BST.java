/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary;

/**
 *
 * @author Admin
 */
public class BST {

    public Node root;

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        insertRoot(root, node);
    }

    private void insertRoot(Node currRoot, Node node) {
        if (currRoot.getValue() > node.getValue()) {
            if (currRoot.getLeft() == null) {
                currRoot.setLeft(node);
            } else {
                insertRoot(currRoot.getLeft(), node);
            }
        } else {
            if (currRoot.getRight() == null) {
                currRoot.setRight(node);
            } else {
                insertRoot(currRoot.getRight(), node);
            }
        }
    }

    public void printInorder() {
        printInorderRoot(root);
    }

    private void printInorderRoot(Node currRoot) {
        if (currRoot == null) {
            return;
        }
        printInorderRoot(currRoot.getLeft());
        System.out.printf("%d\t", currRoot.getValue());
        printInorderRoot(currRoot.getRight());
    }

    public void printPreorder() {
        printPreorderRoot(root);
    }

    private void printPreorderRoot(Node currRoot) {
        if (currRoot == null) {
            return;
        }
        System.out.printf("%d\t", currRoot.getValue());
        printPreorderRoot(currRoot.getLeft());
        printPreorderRoot(currRoot.getRight());
    }

    public void printPostorder() {
        printPostorderRoot(root);
    }

    private void printPostorderRoot(Node currRoot) {
        if (currRoot == null) {
            return;
        }
        printPostorderRoot(currRoot.getLeft());
        printPostorderRoot(currRoot.getRight());
        System.out.printf("%d\t", currRoot.getValue());
    }

    public int depth() {
        return depthRoot(root);
    }

    private int depthRoot(Node currRoot) {
        if (currRoot == null) {
            return 0;
        } else {
            if (depthRoot(currRoot.getLeft()) > depthRoot(currRoot.getRight())) {
                return depthRoot(currRoot.getLeft()) + 1;
            } else {
                return depthRoot(currRoot.getRight()) + 1;
            }
        }
    }

    public int count() {
        return countRoot(this.root);
    }

    private int countRoot(Node currRoot) {
        if (currRoot == null) {
            return 0;
        } else {
            return countRoot(currRoot.getLeft()) + countRoot(currRoot.getRight()) + 1;
        }
    }
    
    public int findMaxValueOfBST(){
        if(this.root==null)
            return 0;
        Node currRoot = this.root;
        while(currRoot.getRight()!=null){
            currRoot = currRoot.getRight();
        }
        return currRoot.getValue();
    }
   
    public int findMinValueOfBST(){
        if(this.root==null)
            return 0;
        Node currRoot = this.root;
        while(currRoot.getLeft()!=null){
            currRoot = currRoot.getLeft();
        }
        return currRoot.getValue();
    }
    
    public Node findNodeByValue(int value){
        return findNodeByValueRoot(this.root,value);
    }
    
    private Node findNodeByValueRoot(Node currRoot,int value){
        if(currRoot==null)
            return null;
        else if(currRoot.getValue()==value)
            return currRoot;
        else if(currRoot.getValue()>value)
            return findNodeByValueRoot(currRoot.getLeft(), value);
        else if(currRoot.getValue()<value)
            return findNodeByValueRoot(currRoot.getRight(), value);
        return null;
    }
    
    public void deleteByValue(int value){
        this.root=deleteRoot(this.root,value);
    }
    
    private Node deleteRoot(Node currRoot,int value){
        Node temp;
        if(currRoot==null){
            System.out.println("Not found!");
            return null;
        }else if(value<currRoot.getValue()){
            currRoot.setLeft(deleteRoot(currRoot.getLeft(), value));
        }else if(value>currRoot.getValue()){
            currRoot.setRight(deleteRoot(currRoot.getRight(), value));
        }else if((currRoot.getLeft()!=null)&&(currRoot.getRight()!=null)){
            temp = currRoot.getRight();
            while(temp.getLeft()!=null)
                temp = temp.getLeft();
            currRoot.setValue(temp.getValue());
            currRoot.setRight(deleteRoot(currRoot.getRight(), temp.getValue()));
        }else{
            temp = currRoot;
            if(currRoot.getLeft()==null)
                currRoot = currRoot.getRight();
            else if(currRoot.getRight()==null)
                currRoot = currRoot.getLeft();
            temp = null;
        }
        return currRoot;
    }
}
