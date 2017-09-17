
package sortingalgorithms;

import java.util.Arrays;
import static sortingalgorithms.SortTester.experimentOne;

public class Sorts {

//returns true only if a is sorted from smallest to largest values
    public static boolean isSorted(int[] a) {
        for(int i = 0; i <= a.length - 2; i++) {
        if(a[i + 1] < a[i])
            return false;
    }
    return true;
    }

    public static void mergeSort(int[] a) {
        int[] tmp = new int[a.length];
        mergeSort(a, 0, a.length - 1);
    }

    public static void mergeSort(int[] a, int left, int right) {

        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    //merges slices a[i.. j] and a[j + 1 …  k] for 0<=  i <=j < k < a.length
    public static void merge(int[] a, int left, int mid, int right) {
        
        int[] tmp = new int[a.length];
        for (int i = left; i <= right; i++) {
            tmp[i] = a[i];
        }

        int current = left;
        int tmpLeft = left;
        int tmpRight = mid + 1;

        while (tmpLeft <= mid && tmpRight <= right) {
            if (tmp[tmpLeft] <= tmp[tmpRight]) {
                a[current] = tmp[tmpLeft];
                tmpLeft++;

            } else {
                a[current] = tmp[tmpRight];
                tmpRight++;
            }
            current++;
        }

        int remaining = mid - tmpLeft;
        for (int i = 0; i <= remaining; i++) {
            a[current + i] = tmp[tmpLeft + i];
        }
    }

    public static void quickSort(int[] a) {
        int[] tmp = new int[a.length];
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int left, int right) {
        int index = partition(a, left, right);
        if (left < index - 1) { // Sort left half
            quickSort(a, left, index - 1);
        }
        if (index < right) { // Sort right half
            quickSort(a, index, right);
        }

    }

    public static void swapReferences(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static int partition(int a[], int left, int right) {
        int pivot = a[(left + right) / 2]; // Pick a pivot point. Can be an element.

        while (left <= right) { // Until we've gone through the whole array
            // Find element on left that should be on right
            while (a[left] < pivot) {
                left++;
            }

            // Find element on right that should be on left
            while (a[right] > pivot) {
                right--;
            }

            // Swap elements and move left and right indices
            if (left <= right) {
                swapReferences(a, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] x = {1, 33, 22, 5, 6, 2, 7, 8, 10, 11};
        System.out.println(Arrays.toString(x));
        quickSort(x);
        System.out.println(Arrays.toString(x));
        System.out.println(isSorted(x));
        experimentOne();

    }

}
