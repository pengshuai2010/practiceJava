package lintCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shuaipeng on 8/25/16.
 */
public class Q16 {

    //TODO use iterative version of DFS to solve this problem
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(2);
        System.out.println(new Q16().permuteUnique(nums));
    }

    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();
        if (nums == null || nums.size() == 0)
            return permutations;
        List<Integer> permutation = new ArrayList<>();
        LinkedList<Integer> remainingNums = new LinkedList<>();
        remainingNums.addAll(nums);
        Collections.sort(remainingNums);
        dfs(remainingNums, permutation, permutations);
        return permutations;
    }

    private void dfs(LinkedList<Integer> remainingNums, List<Integer> permutation, List<ArrayList<Integer>> permutations) {
        if (remainingNums.size() == 0) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.addAll(permutation);
            permutations.add(tmp);
            return;
        }
        // if we use an array boolean[] visited to mark which element is already in the permutation, it will take O(n) time
        // to find an unvisited element. So instead, we use a linked list to store remaining elements.
        // if the numbers are guaranteed to be different, we can use list.contains() to decide if an element is visited,
        // but this too shall take O(n) time
        int size = remainingNums.size();
        // use this trick to escape duplicates
        boolean isFirst = true;
        int lastNum = -1;
        for (int i = 0; i < size; i++) {
            int num = remainingNums.remove();
            if (!isFirst && num == lastNum) {
                remainingNums.add(num);
                continue;
            }
            permutation.add(num);
            dfs(remainingNums, permutation, permutations);
            permutation.remove(permutation.size() - 1);
            remainingNums.add(num);
            isFirst = false;
            lastNum = num;
        }
    }
}
