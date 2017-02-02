package lintCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by shuaipeng on 2/2/17.
 */
public class Q605_SequenceReconstruction {
    /**
     * Topological sorting. The reconstructed sequence must be unique, that means at each layer there is only one node.
     * There are some corner cases to be taken care of. e.g. org = [1], seqs = [[], []]. org = [1], seqs = [[1, 2]]
     *
     * @param org  a permutation of the integers from 1 to n
     * @param seqs a list of sequences
     * @return true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if (org == null || seqs == null) {
            throw new java.lang.IllegalArgumentException();
        }
        int n = org.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {//nodes starts from 1
            graph.add(new ArrayList<Integer>());
        }
        int[] indegree = new int[n + 1];//nodes starts from 1
        int count = 0;
        for (int[] seq : seqs) {
            if (seq.length > 0 && (seq[0] < 1 || seq[0] > n)) {
                return false;
            }
            count += seq.length;
            for (int i = 1; i < seq.length; i++) {
                if (seq[i] < 1 || seq[i] > n) {
                    return false;
                }
                graph.get(seq[i - 1]).add(seq[i]);
                indegree[seq[i]]++;
            }
        }
        if (org.length > 0 && count == 0) {//handle the case org = [1], seqs = [[], []]
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                if (queue.size() > 1) {
                    return false;
                }
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int curr = queue.poll();
            if (curr != org[index]) {
                return false;
            }
            index++;
            for (int next : graph.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return true;
    }
}
