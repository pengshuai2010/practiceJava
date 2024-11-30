package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q658_FindKClosestElements {
    // binary search + two pointers. The time complexity is O(log(n)) + O(k)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr.length < k) {
            throw new IllegalArgumentException("k is less than arr.length");
        }
        // ask whether can happen k > arr.length and how to break a tie
        int insertionPosition = Arrays.binarySearch(arr, x);
        // when the element is not found, binarySearch will return -(insertion position) - 1, and the (insertion position)
        // is the index of the first element that is greater than the search key.
        if (insertionPosition < 0) {
            insertionPosition = -insertionPosition - 1;
        }
        // e.g. with [1, 1, 10, 10] and x is 5 we would like i to be the index of last 1, j to be the index of first 10.
        int i = insertionPosition - 1;
        int j = insertionPosition;
        LinkedList<Integer> list = new LinkedList<>();
        while (i >= 0 && j < arr.length && list.size() < k) {
            if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
                list.addFirst(arr[i]);
                i--;
            } else {
                list.addLast(arr[j]);
                j++;
            }
        }
        if (i >= 0) {
            while (i >= 0 && list.size() < k) {
                list.addFirst(arr[i]);
                i--;
            }
        } else {
            while (j < arr.length && list.size() < k) {
                list.add(arr[j]);
                j++;
            }
        }
        return list;
    }
}
