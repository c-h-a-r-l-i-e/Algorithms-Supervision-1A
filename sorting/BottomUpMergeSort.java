package uk.ac.cam.cl.cm927.sorting;

import java.util.Arrays;

public class BottomUpMergeSort {
    public static void main(String[] args) {
        int[] toSort = {10001, 101, 2002, 10, 20, 30, 10000, 40, 60};
        BottomUpMergeSort.sort(toSort);
        System.out.println(Arrays.toString(toSort));
    }

    public static void sort (int[] toSort) {
        int len = toSort.length;
        int[] toSortPadded = new int[Integer.highestOneBit(len - 1)*2];
        Arrays.fill(toSortPadded, Integer.MIN_VALUE);
        for (int i = 0; i < len; i++) {
            toSortPadded[i] = toSort[i];
        }

        for (int size = 2; size <= toSortPadded.length; size *= 2) {
            System.out.println("Size" + size);
            for (int k = 0; k < toSortPadded.length; k += size) {
                int i = k;
                System.out.println("i: " + i);

                int halfway = i + size/2;

                //Create a new array for the LHS of the merge
                int[] lhs = new int[size/2];
                for (int j = 0; j < size/2; j++) {
                    lhs[j] = toSortPadded[i + j];
                }

                //Start merging lhs into rhs
                int lPointer = 0;
                int rPointer = halfway;
                int end = i + size - 1;
                System.out.println("End: "+end);

                while (i <= end && lPointer < size / 2) {
                    if (rPointer > end) {
                        toSortPadded[i++] = lhs[lPointer++];
                    }
                    else if (lhs[lPointer] < toSortPadded[rPointer]) {
                        toSortPadded[i++] = lhs[lPointer++];
                    }
                    else {
                        toSortPadded[i++] = toSortPadded[rPointer++];
                    }
                }
            }
        }
        for (int i = 0; i < len; i++) {
            toSort[i] = toSortPadded[i + (toSortPadded.length - toSort.length)];
        }

    }
}
