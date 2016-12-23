package leetCode;

/**
 * Created by speng on 12/23/16.
 */
public class Q245_ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length < 2) {
            return -1;
        }
        String last = null;
        int lastPos = -1;
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (word1.equals(words[i]) && word2.equals(last) || word2.equals(words[i]) && word1.equals(last)) {
                    int dis = i - lastPos;
                    minDis = Math.min(minDis, dis);
                }
                last = words[i];
                lastPos = i;
            }
        }
        return minDis;
    }

}
