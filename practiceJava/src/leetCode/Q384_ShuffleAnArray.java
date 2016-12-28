package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by speng on 12/28/16.
 */
public class Q384_ShuffleAnArray {
    private int[] origin;
    private Random rand;

    public Q384_ShuffleAnArray(int[] nums) {//ask interview what to do with null and empty array
        origin = nums;
        rand = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return origin;//make a copy and return? or return underlying origin. because user might change returned array
    }

    /** Returns a random shuffling of the array. */
    /**
     * use Java API: static void Collections.shuffle(List<?> list)
     */
    public int[] shuffle1() {
        List<Integer> list = new ArrayList<>();
        for (int num : origin) {
            list.add(num);
        }
        Collections.shuffle(list);
        int[] shuffled = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            shuffled[i] = list.get(i);
        }
        return shuffled;
    }

    /**
     * The Fisher-Yates algorithm https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm
     */
    public int[] shuffle() {
        int[] shuffled = origin.clone();
        for (int i = 0; i < shuffled.length; i++) {
            int j = rand.nextInt(i + 1);
            int tmp = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = tmp;
        }
        return shuffled;
    }
}
