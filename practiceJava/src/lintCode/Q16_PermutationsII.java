package lintCode;

import java.util.*;

/**
 * Created by shuaipeng on 8/25/16.
 */
public class Q16_PermutationsII {

    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        if (nums == null) {
            return solutions;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int elem : nums) {
            list.add(elem);
        }
        dfsUsingList(list, new ArrayList<>(), solutions);
        return solutions;
    }

    /**
     * building an answer takes O(n^2) time, there are O(n!) answers in total, so time complexity is O(n^2 * n!)
     */
    private void dfsUsingList(List<Integer> nums, List<Integer> path, List<List<Integer>> solutions) {
        if (nums.size() == 0) {
            solutions.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            // note that list.get(int index) returns an Integer Object instead of primitive type int, and to compare
            // 2 Integer objects, we must use equals() method instead of '==' operator!
            if (i == 0 || !nums.get(i).equals(nums.get(i - 1))) {
                int value = nums.remove(i);
                path.add(value);
                dfsUsingList(nums, path, solutions);
                path.remove(path.size() - 1);
                nums.add(i, value);
            }
        }
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        if (nums == null) {
            return solutions;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int elem : nums) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }
        dfsUsingMap(map, nums.length, new ArrayList<>(), solutions);
        return solutions;
    }

    private void dfsUsingMap(Map<Integer, Integer> map, int n, List<Integer> path, List<List<Integer>> solutions) {
        if (path.size() == n) {
            solutions.add(new ArrayList<>(path));
            return;
        }
        for (int key : map.keySet()) {
            if (map.get(key) > 0) {
                map.put(key, map.get(key) - 1);
                path.add(key);
                dfsUsingMap(map, n, path, solutions);
                path.remove(path.size() - 1);
                map.put(key, map.get(key) + 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        if (nums == null) {
            return solutions;
        }
        Arrays.sort(nums);
        LinkedList<Integer> list = new LinkedList<>();
        for (int elem : nums) {
            list.add(elem);
        }
        dfsUsingDeque(list, new ArrayList<>(), solutions);
        return solutions;
    }

    private void dfsUsingDeque(Deque<Integer> nums, List<Integer> path, List<List<Integer>> solutions) {
        if (nums.size() == 0) {
            solutions.add(new ArrayList<>(path));
            return;
        }
        int prev = 0;
        for (int i = 0; i < nums.size(); i++) {
            //each time moves an element from head to tail. If the element is first one, or is different from previous one,
            //do a DFS before add it back to tail
            int value = nums.removeFirst();
            if (i == 0 || value != prev) {
                path.add(value);
                dfsUsingDeque(nums, path, solutions);
                path.remove(path.size() - 1);
                prev = value;
            }
            nums.addLast(value);
        }
    }
}
