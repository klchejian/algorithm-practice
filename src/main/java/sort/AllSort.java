package main.java.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * <???????>
 */
public class AllSort {

    /**
     * ????<br/>
     * unstable times :O(nlogn)
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    public static void quickSort(int[] a, int left, int right) {
        if (left >= right)
            return;

        int i, j, temp;
        i = left;
        j = right;
        temp = a[left];

        while (i != j) {
            while (a[j] >= temp && i < j)
                j--;

            while (a[i] <= temp && i < j)
                i++;

            if (i < j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                j--;
            }
        }

        a[left] = a[i];
        a[i] = temp;

        if (left < i - 1)
            quickSort(a, left, i - 1);
        if (i + 1 < right)
            quickSort(a, i + 1, right);
    }

    /**
     * ????<br/>
     * ?????,??????O(n2)
     *
     * @param a
     * @return
     */
    public static void choseSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min_index] > a[j]) {
                    min_index = j;
                }
            }
            if (i != min_index) {
                int temp = a[i];
                a[i] = a[min_index];
                a[min_index] = temp;
            }
        }
    }

    /**
     * ????<br/>
     * ????,??????O(n2)
     *
     * @param a
     * @return
     */
    public static void bubbleSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    /**
     * ??????<br/>
     * ????,?????O(n2)
     *
     * @param a
     * @return
     */
    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int pos = i - 1;
            while (pos >= 0 && a[pos] > temp) {
                a[pos + 1] = a[pos];
                pos--;
            }
            a[pos + 1] = temp;
        }
    }

    /**
     * ????<br/>
     * ?????,?????O(nlogn)
     *
     * @param a
     * @return
     */
    public static void shellSort(int[] a) {
        int d = a.length / 2;
        while (d >= 1) {
            for (int i = 0; i < d; i++) {
                for (int j = i + d; j < a.length; j = j + d) {
                    int temp = a[j];
                    int pos = j - d;
                    while (pos >= 0 && a[pos] > temp) {
                        a[pos + d] = a[pos];
                        pos -= d;
                    }
                    a[pos + d] = temp;
                }
            }
            d = d / 2;
        }

    }

    /**
     * ????<br/>
     * ????,?????O(nlogn),?????????
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    public static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            // ???????
            mergeSort(a, left, middle);
            // ???????
            mergeSort(a, middle + 1, right);
            // ??
            merge(a, left, middle, right);
        }
    }

    private static void merge(int[] a, int left, int middle, int right) {
        int[] tmpArr = new int[right - left + 1];
        int pos = 0;

        int i = left;// ??????
        int j = middle + 1; // ??????
        while (i <= middle && j <= right) {
            // ??????????????????
            if (a[i] <= a[j]) {
                tmpArr[pos++] = a[i++];
            } else {
                tmpArr[pos++] = a[j++];
            }
        }
        // ????????????
        while (i <= middle) {
            tmpArr[pos++] = a[i++];
        }
        while (j <= right) {
            tmpArr[pos++] = a[j++];
        }
        // ???????????
        int start = 0;
        while (left <= right) {
            a[left++] = tmpArr[start++];
        }
    }

    /**
     * ???<br/>
     * ?????,?????O(nlogn)
     * @param a
     * @return
     */
    public static void heapSort(int[] a) {
        int lastIndex = a.length - 1;
        for (int i = 0; i < lastIndex; i++) {
            // ??
            buildMaxHeap(a, lastIndex - i);
            // ???????????
            swap(a, 0, lastIndex - i);
            // System.out.println(Arrays.toString(a));
        }
    }

    private static void buildMaxHeap(int[] data, int lastIndex) {
        // ?lastIndex???(??????)??????
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k?????????
            int k = i;
            // ????k????????
            while (k * 2 + 1 <= lastIndex) {
                // k??????????
                int biggerIndex = 2 * k + 1;
                // ??biggerIndex??lastIndex,?biggerIndex+1???k?????????
                if (biggerIndex < lastIndex) {
                    // ??????????
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // biggerIndex????????????
                        biggerIndex++;
                    }
                }
                // ??k???????????????
                if (data[k] < data[biggerIndex]) {
                    // ????
                    swap(data, k, biggerIndex);
                    // ?biggerIndex??k,??while????????,????k??????????????
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[20];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(20);
        }


        for(int i:a){
            System.out.print(i+ "-");
        }
        quickSort(a, 0, a.length - 1);
        System.out.println();
        for(int i:a){
            System.out.print(i+ "-");
        }
        //mergeSort(a, 0, a.length - 1);
        //shellSort(a);
        //heapSort(a);
        //choseSort(a);
        //bubbleSort(a);
        //insertSort(a);
//        System.out.println(Arrays.toString(a));

    }

    public static void printArray(int [] a ){
        if (a == null)
            return;
        for(int i: a) {
            System.out.print(i);
            System.out.print("===");
        }
        System.out.println();
    }

    public static int[] generate(int n,int p){
        Random r = new Random();
        int[] res = new int[n];
        for(int i = 0;i<n;i++){
            res[i] = r.nextInt(p);
        }
        return res;
    }

    public static int[] generate(){
        return generate(20,100);
    }

    public static int[] generate(int n){
        return generate(n,100);
    }


}
