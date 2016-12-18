package basicAlgorithms;

import java.util.Random;

/**
 * Created by speng on 12/17/16.
 */
public class RangeMinimumQuery {
    private int[] tree;
    private int[] nums;

    public RangeMinimumQuery(int[] heights) {
        if (heights == null || heights.length == 0) {
            return;
        }
        int n = heights.length;
        nums = heights;
        tree = new int[2 * n];
        for (int i = n; i < 2 * n; i++) {
            tree[i] = i - n;
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = heights[tree[2 * i]] < heights[tree[2 * i + 1]] ? tree[2 * i] : tree[2 * i + 1];
        }

    }

    public static void main(String[] args) {
        Random rand = new Random();
        int len = 100;
        int[] input = new int[len];
        for (int i = 0; i < len; i++) {
            input[i] = rand.nextInt();
        }
        RangeMinimumQuery solution = new RangeMinimumQuery(input);
        int numTests = 10000;
        for (int i = 0; i < numTests; i++) {
            int start = rand.nextInt(len);
            int end = rand.nextInt(len);
            if (start > end) {
                int tmp = start;
                start = end;
                end = tmp;
            }
            if (solution.query(start, end) != solution.queryComparison(start, end)) {
                System.out.println("error");
                for (int k = start; k <= end; k++) {
                    System.out.print(input[k] + ", ");
                }
                System.out.println();
                System.out.println("start = " + start);
                System.out.println("end = " + end);
                System.out.println(solution.query(start, end));
                System.out.println(solution.queryComparison(start, end));
                break;
            }
        }
    }

    public int query(int i, int j) {
        int minIndex = i;//choose an arbitrary number in range [i, j]
        int n = tree.length / 2;
        i += n;
        j += n;
        while (i <= j) {
            if (i % 2 == 1) {
                minIndex = nums[minIndex] < nums[tree[i]] ? minIndex : tree[i];
                i++;
            }
            i /= 2;
            if (j % 2 == 0) {
                minIndex = nums[minIndex] < nums[tree[j]] ? minIndex : tree[j];
                j--;
            }
            j /= 2;
        }
        return minIndex;
    }

    private int queryComparison(int i, int j) {
        int minIndex = i;
        for (int k = i; k <= j; k++) {
            minIndex = nums[minIndex] < nums[k] ? minIndex : k;
        }
        return minIndex;
    }
}
