package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Q1762_BuildingsWithAnOceanView {
    public int[] findBuildings(int[] heights) {
        if (heights.length == 0) {
            return new int[0];
        }
        int maxHeight = 0; // will there be a building of height 0?
        List<Integer> hasView = new ArrayList<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                hasView.add(i);
                maxHeight = heights[i];
            }
        }
        int[] answer = new int[hasView.size()];
        // reverse the order when copying
        for (int i = hasView.size() - 1; i >= 0; i--) {
            answer[hasView.size() - i - 1] = hasView.get(i);
        }
        return answer;
    }
}
