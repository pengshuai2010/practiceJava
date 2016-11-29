package leetCode;

/**
 * Created by speng on 11/25/16.
 */
public class Q307_RangeSumQueryMutable {
    /**
     * segment tree
     */
    public class NumArray {
        int[] tree;
        int n;

        public NumArray(int[] nums) {
            // for(int num: nums) {
            //     System.out.print(num + ", ");
            // }
            // System.out.println();
            n = nums.length;
            tree = new int[2 * n];
            System.arraycopy(nums, 0, tree, n, n);
            for (int i = n - 1; i > 0; i--) {
                tree[i] = tree[2 * i] + tree[2 * i + 1];
            }
        }

        public void update(int i, int val) {
            // System.out.println("update: i = " + i + " val = " + val);
            i += n;
            int diff = val - tree[i];
            while (i > 0) {
                tree[i] += diff;
                i /= 2;
            }
        }

        public int sumRange(int i, int j) {
            // System.out.println("sum range: i = " + i + " j = " + j);
            i += n;
            j += n;
            int sum = 0;
            while (i <= j) {
                if (i % 2 == 1) {// i is a right son
                    sum += tree[i];
                    i++;
                }
                if (j % 2 == 0) {// j is a left son
                    sum += tree[j];
                    j--;
                }
                i /= 2;
                j /= 2;
            }
            // note that when i = 3, j = 4, the next iteration will be i = 2, j = 1.
            // so we cannot assume that when loop while(i < j) break, i will be equal to j.
            return sum;
        }
    }

}
