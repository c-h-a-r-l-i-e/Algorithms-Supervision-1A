package uk.ac.cam.cl.cm927.sorting;

public class BinaryInsertionSort {
    public static void main(String[] args) {
        BinaryInsertionSort sorter = new BinaryInsertionSort();
        int[] toSort = {101, 2002, 10, 20, 30, 10000, 40, 3200, 10};
        sorter.sort(toSort);
        for (int item : toSort) {
            System.out.println(item);
        }
    }

    public void sort (int[] toSort) {
        for (int i = 1; i < toSort.length; i++) {
            insert(toSort, i, 0, i - 1);
        }
    }

    private void insert (int[] toSort, int itemPos, int start ,int end) {
        int item = toSort[itemPos];
        while (start < end) {
            if (item < toSort[(end + start) / 2]) {
                end = (end + start) / 2 - 1;
            }
            else {
                start = (end + start) / 2 + 1;
            }
        }
        if (item > toSort[start]) {
            start++;
        }
        for (int i = itemPos; i > start; i--){
            toSort[i] = toSort[i - 1];
        }
        toSort[start] = item;
    }
}
