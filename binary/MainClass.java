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
public class MainClass {
    
    public int binarySearch(int[] A,int size,int x){
        int first = 0;
        int last = size-1;
        while(first<=last){
            int mid = (first+last)/2;
            if(A[mid] == x)
                return mid;
            else if(A[mid]>x)
                last = mid;
            else
                first = mid+1;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        BST tree = new BST();
        int[] A = {42,435,121,-43,64,32,-13,434,5435,443,45,115,879,87,86,324};
        for (int i=0;i<A.length;i++) {
              tree.insert( A[i]);
        }
        tree.printPostorder();
    }
}
