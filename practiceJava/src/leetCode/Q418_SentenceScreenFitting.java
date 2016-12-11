package leetCode;

/**
 * Created by shuaipeng on 12/7/16.
 */
public class Q418_SentenceScreenFitting {
    /**
     * brute force solution.
     */
    public int wordsTyping1(String[] sentence, int rows, int cols) {
        if (sentence == null || sentence.length == 0) {
            //throw exception?
        }
        if (rows < 1 || cols < 1) {
            return 0;
        }
        int i = 0, j = 0;
        int index = 0;
        int count = 0;
        //loop invariant: (i, j) is the where the next word begins
        while (i < rows) {
            if (j + sentence[index].length() - 1 < cols) {// if the word sentence[index] can fit in this row
                j += sentence[index].length() + 1;
                index++;
                if (index == sentence.length) {
                    count++;
                    index %= sentence.length;
                }
            } else {
                i++;
                j = 0;
            }
        }
        return count;
    }

    /**
     * DP with memoization. Memoization works best when the state transfer function is not clear.
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence == null || sentence.length == 0) {
            //throw exception?
        }
        if (rows < 1 || cols < 1) {
            return 0;
        }
        int i = 0;
        int index = 0;
        int count = 0;
        int[][] mapping = new int[sentence.length][];
        while (i < rows) {
            int[] res = helper(index, mapping, cols, sentence);
            index = res[0];
            count += res[1];
            i++;
        }
        return count;
    }

    /**
     * @return an int array. First element is the index of the word at the beginning of next row; second element is the
     * increment of count of sentences.
     */
    private int[] helper(int index, int[][] mapping, int cols, String[] sentence) {
        if (mapping[index] != null) {
            return mapping[index];
        }
        int startingIndex = index;
        int j = 0;
        int count = 0;
        while (j + sentence[index].length() - 1 < cols) {
            j += sentence[index].length() + 1;
            index++;
            if (index == sentence.length) {
                count++;
                index %= sentence.length;
            }
        }
        mapping[startingIndex] = new int[]{index, count};
        return mapping[startingIndex];
    }
}
