package uk.ac.cam.cl.cm927.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class RadixSort {
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
        int base = 10;
        int digit = 0;
        boolean loop = true;
        while (loop) {
            LinkedList<Integer>[] counts = new LinkedList[base];
            for (int i = 0; i < base; i++) {
                counts[i] = new LinkedList<>();
            }

            //Count sort on individual digits of a certain base
            loop = false;
            for (int i : toSort) {
                if ((i / ((int) Math.pow(base, digit))) / base > 0) loop = true;
                counts[(i / ((int) Math.pow(base, digit))) % base].add(i);
            }

            //Place the elements back in the list
            int i = 0;
            for (int j = 0; j < base; j++) {
                for (int k : counts[j]) {
                    toSort[i++] = k;
                }
            }
            digit++;
        }
    }
}
