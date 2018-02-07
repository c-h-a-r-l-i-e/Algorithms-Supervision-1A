package uk.ac.cam.cl.cm927.sorting;

import java.util.Arrays;
import java.util.Random;

public class CountingSort {
    public static void main(String[] args) {
        Random gen = new Random(0);
        int[] toSort = new int[1000000];
        for (int i = 0; i < toSort.length; i++) {
            toSort[i] = gen.nextInt(1000000);
        }

        long startTime = System.nanoTime();
        sort(toSort);
        long duration = System.nanoTime() - startTime;
        int[] copy = toSort;
        Arrays.sort(toSort);
        if (Arrays.equals(copy, toSort)) {
            System.out.println("SUCCESS");
        }
        //System.out.println(Arrays.toString(toSort));
        System.out.println("Took " + duration / 1000000 + "ms");
    }

    public static void sort(int[] toSort) {
        int max = toSort[0];
        int min = toSort[0];
        for (int i = 1; i < toSort.length; i++) {
            if (toSort[i] > max) max = toSort[i];
            if (toSort[i] < min) min = toSort[i];
        }
        int[] collect = new int[max - min + 1];
        for (int num : toSort) {
            collect[num - min]++;
        }
        int ind = 0;
        for (int i = 0; i < collect.length; i++) {
            for (int j = 0; j < collect[i]; j++) {
                toSort[ind++] = i + min;
            }
        }
    }
}
