package main.java.sort;

/**
 * Created by root on 8/11/17.
 */
public class HeapSort {
    public static void main(String[] args){
        int[] input = AllSort.generate(10);
        AllSort.printArray(input);
        heapSort(input,input.length);
        AllSort.printArray(input);
    }

    public static void minHeapFixdown(int a[],int i, int n){
        for(int j = (2*i+2<n && a[2*i+1]>a[2*i+2])? (2*i+2) : (2*i+1) ;a[j] < a[(j-1)/2];j = (2*j+2<n && a[2*j+1]>a[2*j+2])? (2*j+2) : (2*j+1)  ){
            AllSort.swap(a,j,(j-1)/2);
            if(2*j+1 >= n)
                break;
        }
    }

    public static void makeMinHdap(int[] a, int n){
        for(int i = n/2 - 1; i >= 0; i--){
            minHeapFixdown(a,i,n);
        }
    }

    public static void heapSort(int a[], int n){
        makeMinHdap(a,n);
        for(int i = n - 1; i >=1; i--){
            AllSort.swap(a,i,0);
            minHeapFixdown(a,0,i);
        }
    }



//    public static void minHeapFixup(int[] input, int i){
//        for(int j = i; j > 0 && input[(j-1)/2] > input[j]; j = (j-1)/2){
//            AllSort.swap(input,(j-1)/2,j);
//        }
//    }
//
//    public static void minHeapAddNumber(int a[], int n, int nNum){
//        a[n] = nNum;
//        minHeapFixup(a,n);
////        minHeapFixUp(a,n);
////        minHeapFixup(a,n);
//    }
//
//    public static void minHeapDeleteNumber(int a[], int n){
//        AllSort.swap(a,0,n-1);
//        minHeapFixdown(a,0,n-1);
//    }
}
