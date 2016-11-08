package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuaipeng on 11/7/16.
 */
public class Q433_MinimumGeneticMutation {
    private int minDepth;
    private boolean foundSolution;

    public static void main(String[] args) {
        Q433_MinimumGeneticMutation solution = new Q433_MinimumGeneticMutation();
        String start = "AAAA";
        String end = "ACCC";
        String[] bank = new String[]{"ACCC", "AACC", "AAAC", "AAAT"};
        System.out.println(solution.minMutation(start, end, bank));
    }

    public int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || start.length() != end.length() || bank == null || bank.length == 0)
            return -1;
        if (start.equals(end))
            return 0;
        minDepth = Integer.MAX_VALUE;
        foundSolution = false;
        Set<String> path = new HashSet<>();
        dfs(bank, start, end, path, 0);
        if (foundSolution)
            return minDepth;
        return -1;
    }

    /**
     * since we don't need to record the path in sequence, we can use a set to keep record which genes we have visited.
     * so that we can find out if we have visited a gene in O(1) time.
     * This is better than removing then adding back elements to an array list, which take O(n) time.
     */
    private void dfs(String[] bank, String curr, String aim, Set<String> path, int depth) {
        if (curr.equals(aim)) {
            minDepth = Math.min(minDepth, depth);
            foundSolution = true;
            return;
        }
        for (String gene : bank) {
            if (!path.contains(gene) && getDis(gene, curr) == 1) {
                path.add(gene);
                dfs(bank, gene, aim, path, depth + 1);
                path.remove(gene);
            }
        }
    }

    private int getDis(String s1, String s2) {
        int dis = 0;
        // assuming same length
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i))
                dis++;
        return dis;
    }
}
