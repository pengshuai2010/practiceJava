package basicAlgorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 12/25/16.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
