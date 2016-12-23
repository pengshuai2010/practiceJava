package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 12/22/16.
 */
public class Q243_ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length < 2) {
            return -1;
        }
        String last = null;
        int lastPos = -1;
        int minDis = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        list.add(word1);
        list.add(word2);
        for (int i = 0; i < words.length; i++) {
            if (list.contains(words[i])) {//note that we use words.equals(last) to handle last == null
                if (word1.equals(words[i]) && word2.equals(last) || word2.equals(words[i]) && word1.equals(last)) {
                    minDis = Math.min(minDis, i - lastPos);
                }
                last = words[i];
                lastPos = i;
            }
        }
        return minDis;
    }
}
