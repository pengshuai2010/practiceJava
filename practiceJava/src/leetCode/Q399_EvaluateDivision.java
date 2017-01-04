package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by speng on 1/3/17.
 */
public class Q399_EvaluateDivision {
    public static void main(String[] args) {
        String[][] equations = new String[][]{{"a", "b"}, {"b", "c"}};
        double[] values = new double[]{2.0, 3.0};
        String[][] queries = new String[][]{{"a", "b"}, {"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        Q399_EvaluateDivision solution = new Q399_EvaluateDivision();
        double[] res = solution.calcEquation(equations, values, queries);
        for (double num : res) {
            System.out.print(num + ", ");
        }
    }

    /**
     * Consider the variables as nodes. And an equation "a / b = value" means there is an edge from a to b whose weight
     * is value. Thus a directed weighted graph is formed. Suppose a / b = val1, and b / c = val2, define the distance
     * from a to c as dist(a, c) = weight(a, b) * weight(b, c), then a / c is the distance from a to c.
     */
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (equations == null || values == null || queries == null) {
            throw new java.lang.IllegalArgumentException();
        }
        Set<String> nodes = new HashSet<>();
        Map<String, Map<String, Double>> adjMatrix = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String dividend = equations[i][0];
            String divisor = equations[i][1];
            nodes.add(dividend);
            nodes.add(divisor);
            double val = values[i];
            if (!adjMatrix.containsKey(dividend)) {
                adjMatrix.put(dividend, new HashMap<>());
                adjMatrix.get(dividend).put(dividend, 1.0);
            }
            adjMatrix.get(dividend).put(divisor, val);
            if (!adjMatrix.containsKey(divisor)) {
                adjMatrix.put(divisor, new HashMap<>());
                adjMatrix.get(divisor).put(divisor, 1.0);
            }
            adjMatrix.get(divisor).put(dividend, 1.0 / val);
        }
        //There can be many queries. If use BSF or DFS, each query will take O(|V| + |E|) time.
        //So here we use a variant of Floyd–Warshall algorithm to calculate all-pairs shortest distance, which takes
        // O(|V|^3) time.
        for (String k : nodes) {
            for (String i : nodes) {
                for (String j : nodes) {
                    if (!adjMatrix.get(i).containsKey(j) &&
                            adjMatrix.get(i).containsKey(k) &&
                            adjMatrix.get(k).containsKey(j)) {
                        double val = adjMatrix.get(i).get(k) * adjMatrix.get(k).get(j);
                        adjMatrix.get(i).put(j, val);
                        adjMatrix.get(j).put(i, 1.0 / val);
                    }
                }
            }
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Double val = null;
            if (adjMatrix.containsKey(queries[i][0])) {
                val = adjMatrix.get(queries[i][0]).get(queries[i][1]);
            }
            res[i] = val == null ? -1 : val;
        }
        return res;
    }
}
