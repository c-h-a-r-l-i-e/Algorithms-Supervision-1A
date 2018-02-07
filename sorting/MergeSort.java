package uk.ac.cam.cl.cm927.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Integer.highestOneBit(20));
        MergeSort sorter = new MergeSort();
        int[] toSort = {10001, 101, 2002, 10, 20, 30, 10000, 40, 3200, 60};
        sorter.sort(toSort, 0, toSort.length - 1);
        System.out.println(Arrays.toString(toSort));
    }


    private void sort(int[] toSort, int l, int r) {
        if (r - l < 1) {
            return;
        }
        int halfway = (l + r) / 2;


        sort(toSort, l, halfway);
        sort(toSort, halfway + 1, r);

        //Create a new array for the LHS of the merge
        int[] lhs = new int[halfway - l + 1];
        for (int i = 0; i < halfway - l + 1; i++) {
            lhs[i] = toSort[l + i];
        }

        //Start merging lhs into rhs
        int lPointer = 0;
        int rPointer = halfway + 1;

        while (l <= r && lPointer < lhs.length) {
            if (rPointer > r) {
                toSort[l++] = lhs[lPointer++];
            }
            else if (lhs[lPointer] < toSort[rPointer]) {
                toSort[l++] = lhs[lPointer++];
            }
            else {
                toSort[l++] = toSort[rPointer++];
            }
        }
    }
}
