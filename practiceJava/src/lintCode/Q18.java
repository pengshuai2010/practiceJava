package lintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by speng on 8/24/16.
 */
public class Q18 {
    public static void main(String[] args) {
        ArrayList<Integer> S = new ArrayList<>();
        S.add(-1);
        S.add(1);
        S.add(2);
        System.out.println(new Q18().subsetsWithDup(S));
    }

    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());
        if (S == null || S.size() == 0)
            return subsets;

        int[] nums = new int[S.size()];
        for (int i = 0; i < S.size(); i++)
            nums[i] = S.get(i);
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        dfs(nums, 0, new ArrayList<Integer>(), subsets);
        return subsets;

    }

    private void dfs(int[] nums, int index, List<Integer> subset, List<ArrayList<Integer>> subsets) {
        if (index >= nums.length)
            return;
        // a trick to skip duplicate numbers
        boolean isFirst = true;
        int lastNum = -1;
        for (int i = index; i < nums.length; i++) {
            if (!isFirst && nums[i] == lastNum)
                continue;
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.addAll(subset);
            tmp.add(nums[i]);
            subsets.add(tmp);
            dfs(nums, i + 1, tmp, subsets);
            lastNum = nums[i];
            isFirst = false;
        }
    }
}
