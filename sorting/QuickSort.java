package uk.ac.cam.cl.cm927.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        Random gen = new Random(0);
        int[] toSort = new int[1000000];
        for (int i = 0; i < toSort.length; i++) {
            toSort[i] = gen.nextInt(1000000);
        }


        long startTime = System.nanoTime();
        randomSort(toSort, 0, toSort.length - 1);
        long duration = System.nanoTime() - startTime;
        //System.out.println(Arrays.toString(toSort));
        System.out.println("Took " + duration / 1000000 + "ms");
    }

    public static void sort (int[] toSort, int leftBound, int rightBound) {
        if (leftBound >= rightBound) return;

        int comp = toSort[leftBound];
        int l = leftBound + 1;
        int r = rightBound;

        while (l != r) {
            if (toSort[l] > comp && toSort[r] < comp) {
                swap(toSort, l, r);
            }
            else if (toSort[r] >= comp) {
                r--;
            }
            else if (toSort[l] <= comp) {
                l++;
            }
        }
        if (toSort[l] < toSort[leftBound]) swap(toSort, leftBound, l);

        sort(toSort, leftBound, l - 1);
        sort(toSort, l, rightBound);
    }

    public static void swap(int[] toSort, int pos1, int pos2) {
        int temp = toSort[pos1];
        toSort[pos1] = toSort[pos2];
        toSort[pos2] = temp;
    }


    public static void randomSort (int[] toSort, int leftBound, int rightBound) {
        if (leftBound >= rightBound) return;

        swap(toSort, leftBound, leftBound + (int) (Math.random() * (rightBound - leftBound)));

        int comp = toSort[leftBound];
        int l = leftBound + 1;
        int r = rightBound;

        while (l != r) {
            if (toSort[l] > comp && toSort[r] < comp) {
                swap(toSort, l, r);
            }
            else if (toSort[r] >= comp) {
                r--;
            }
            else if (toSort[l] <= comp) {
                l++;
            }
        }
        if (toSort[l] < toSort[leftBound]) swap(toSort, leftBound, l);

        sort(toSort, leftBound, l - 1);
        sort(toSort, l, rightBound);
    }
}
