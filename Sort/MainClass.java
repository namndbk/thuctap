/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

/**
 *
 * @author Admin
 */
public class MainClass {

    public static void BubleSort(int[] A, int size) {//sap xep rat cham, cai dat don gian
        for(int i=size-1;i>=0;i--){
            for(int j=1;j<=i;j++){
                if(A[j-1]>A[j]){
                    int temp = A[j-1];
                    A[j-1] = A[j];
                    A[j] = temp;
                }
            }
        }
    }

    public static void InsertSort(int[] A, int size) {
        for (int i = 0; i < size; i++) {
            int j = i;
            while (j > 0 && A[i] < A[j - 1]) {
                --j;
            }
            int temp = A[i];
            for (int k = i; k > j; k--) {
                A[k] = A[k - 1];
            }
            A[j] = temp;
        }
    }

    
    public static void SelectionSort(int[] A,int size){
        int i,min;
        for(i=0;i<size-1;i++){
            min = i;
            for(int j=i+1;j<size;j++){
                if(A[j] < A[min])
                    min = j;
            }
            int temp = A[i];
            A[i] = A[min];
            A[min] = temp;
        }
    }
    
    public static void Merge(int[] A,int left,int mid,int right){
        int index = left;
        int[] B = new int[10000000];
        int f1=left,f2=mid+1;
        int l1=mid,l2=right;
        for(;(f1<=l1)&&(f2<=l2);++index){
            if(A[f1]<A[f2]){
                B[index] = A[f1];
                ++f1;
            }else{
                B[index] = A[f2];
                ++f2;
            }
        }
        for(;f1<=l1;++f1,++index){
            B[index] = A[f1];
        }
        for(;f2<=l2;++f2,++index){
            B[index] = A[f2];
        }
        for(index=left;index<=right;++index){
            A[index] = B[index];  
        }
    }
    
    public static void MergeSort(int[] A,int left,int right){//sap xep nhanh, on dinh nhung ton bo nho phu
        if(left<right){
            int mid = (left+right)/2;
            MergeSort(A, left, mid);
            MergeSort(A, mid+1, right);
            Merge(A, left, mid, right);
        }
    }
    
    public static void QuickSort(int[] A, int left, int right) {//sap xep rat nhanh, khong ton bo nho phu, nhung khong on dinh do phu thuoc vao cach chon pivot
        int pivot;
        int i = left, j = right;
        pivot = A[left + (int) (Math.random() * 1000000) % (right - left)];
        while (i <= j) {
            while (A[i] < pivot) {
                ++i;
            }
            while (A[j] > pivot) {
                --j;
            }
            if (i <= j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                ++i;
                --j;
            }
        }
        if (left < j) {
            QuickSort(A, left, j);
        }
        if (i < right) {
            QuickSort(A, i, right);
        }
    }
    
    public static void Heapity(int[] A,int n,int i){
        int left = 2*(i+1)-1;
        int right = 2*(i+1);
        int largest;
        if(left<n&&A[left]>A[i]){
            largest = left;
        }else{
            largest = i;
        }
        if(right<n&&A[right]>A[largest]){
            largest = right;
        }
        if(i!=largest){
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            MainClass.Heapity(A, n, largest);
        }
    }
    
    public static void BuildHeap(int[] A,int n){
        for(int i=n/2-1;i>=0;i--){
            MainClass.Heapity(A, n, i);
        }
    }
    
    public static void HeapSort(int[] A,int n){// sap xep nhanh nhung khong to ra hieu qua khi tap du lieu co 10^8
        MainClass.BuildHeap(A, n);
        for(int i =n-1;i>0;i--){
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            Heapity(A, i, 0);
        }
    }
    
    
    public static void CountSort(int A[],int k,int n){//sap xep rat nhanh nhung ton bo nho phu
        int B[] = new int[k];
        int C[] = new int[n+1];
        for(int i=0;i<=k;i++){
            B[i] = 0;
        }
        for(int i=0;i<n;i++){
            B[A[i]]++;
        }
        for(int i=1;i<=k;i++){
            B[i]+=B[i-1];
        }
        for(int i=n-1;i>=0;i--){
            C[B[A[i]]-1] = A[i];
            B[A[i]] = B[A[i]]-1;
        }
        /*for(int i=0;i<n;i++){
            System.out.println(""+C[i]);;
        }*/
    }

    public static void main(String[] args) {
        int[] A = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            A[i] = (int)(Math.random()*10000000);
        }
        MainClass.QuickSort(A, 0,10000000-1);
        /*for(int i=0;i<1000000;i++){
            System.out.println(""+A[i]);
        }*/
    }
    
}
