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

    /**
     * binary indexed tree
     * read the following link to learn the intuition behind binary indexed tree
     * http://cs.stackexchange.com/questions/10538/bit-what-is-the-intuition-behind-a-binary-indexed-tree-and-how-was-it-thought-a
     * <p>
     * Another way to understand binary indexed tree is to imagine there two trees, one for updating, one for querying.
     * In the tree for updating, while node index <= n, add delta to node value, then node index moves up by adding LSB
     * In the tree for querying, whhile node index > 0, add node value to sum, then node index moves up by removing LSB
     * see the two pictures in http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
     */
    public class NumArrayBIT {
        private int[] tree;
        private int[] array;
        private int n;

        public NumArrayBIT(int[] nums) {
            n = nums.length;
            array = new int[n];//we don't have control over the input array nums, so better to make our own copy
            tree = new int[n + 1];
            for (int i = 0; i < n; i++) {
                update(i, nums[i]);
            }
        }

        public void update(int i, int val) {
            int delta = val - array[i];
            array[i] = val;//don't forget also update original array
            i++;
            while (i <= n) {
                tree[i] += delta;
                i += i & (-i);//add LSB
            }
        }

        private int query(int i) {
            i++;
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & (-i);//minus LSB
            }
            return sum;
        }

        public int sumRange(int i, int j) {
            return query(j) - query(i - 1);
        }
    }

}
