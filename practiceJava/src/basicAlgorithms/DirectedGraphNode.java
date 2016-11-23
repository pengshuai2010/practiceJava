package basicAlgorithms;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 8/21/16.
 */
public class DirectedGraphNode {
    public List<DirectedGraphNode> neighbors;
    int label;

    public DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "DirectedGraphNode{" +
                "label=" + label +
                '}';
    }


}
