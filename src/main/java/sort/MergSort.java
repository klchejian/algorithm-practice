package main.java.sort;

/**
 * Created by root on 8/10/17.
 */
public class MergSort {
    public static void main(String[] args){
        int[] input = AllSort.generate(10);
        int[] temp = new int[input.length];
        AllSort.printArray(input);
        mergesort(input,0,input.length-1,temp);
        AllSort.printArray(input);
    }


    public static void memoryArray(int[] a, int n, int[] b, int m, int c[]){
        int i,j,k;
        i = j = k = 0;
        while(i < n && j < m){
            if(a[i] < b[j])
                c[k++] = a[i++];
            else
                c[k++] = b[j++];

        }
        while(i < n)
            c[k++] = a[i++];
        while(j < m)
            c[k++] = b[j++];
    }

    public static void mergearray(int a[], int first, int mid, int last, int temp[]){
        int i = first, j = mid + 1;
        int m = mid, n = last;
        int k = 0;

        while(i <= m && j <= n){
            if(a[i] < a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        while(i <= m)
            temp[k++] = a[i++];
        while(j < n)
            temp[k++] = a[j++];

        for(i = 0; i < k; i++)
            a[first+i] = temp[i];

    }

    public static void mergesort(int a[], int first, int last, int temp[]){
        if(first < last){
            int mid = (first+last) / 2;
            mergesort(a,first,mid,temp); //ordered in left
            mergesort(a,mid+1,last,temp);// order it in right
            mergearray(a,first,mid,last,temp);
        }
    }

}
