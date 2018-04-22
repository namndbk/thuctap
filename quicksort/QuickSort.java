/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

import java.util.Stack;

/**
 *
 * @author Admin
 */
public class QuickSort {

    /**
     *
     * 
     * 
     */
    public int[] QuickSort(int[] A, int size) {
        Stack S = new Stack();
        Stack E = new Stack();
        int L, R, i, j;
        int x;
        S.push(0);
        E.push(size-1);
        do {
            L = (int) S.pop();
            R = (int) E.pop();
            do {
                i = L;
                j = R;
                x = A[(L + R) / 2];
                do {
                    while (A[i] < x) {
                        ++i;
                    }
                    while (A[j] > x) {
                        --j;
                    }
                    if (i <= j) {
                        int temp = A[i];
                        A[i] = A[j];
                        A[j] = temp;
                        ++i;
                        --j;
                    }
                } while (i <= j);
                if (i < R) {
                    S.push(i);
                    E.push(R);
                }
                R = j;
            } while (L < R);
        } while (!E.isEmpty());
        return A;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int[] A = new int[1000000];
        for(int i=0;i<1000000;i++){
            A[i] = (int)(Math.random()*1000000);
        }
        QuickSort qs = new QuickSort();
        A = qs.QuickSort(A, 1000000);
        for (int i : A) {
            System.out.println(""+A[i]);
        }
    }

}
