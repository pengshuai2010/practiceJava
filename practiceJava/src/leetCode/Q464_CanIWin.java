package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by speng on 11/27/16.
 */
public class Q464_CanIWin {
    private Map<Integer, Boolean> map;

    /**
     * simply using DFS won't work, because the time complexity will be O(2^n)
     * So we use memoization: memoize the intermediate results to avoid duplicate calculations. Thus the time complexity
     * is reduced from exponential to polynomial.
     * <p>
     * The "state" of this game is the unchosen numbers. We use HashMap to remember the states and their corresponding
     * results. But we cannot use boolean array as key because the equals() method of Array class simply compares if two
     * variables point to the same object in the memory. A List of Boolean will serve our purpose, but we need to make a new
     * copy of List when putting into a map. Arrays.toString(boolean[]) is convenient but slow. The most efficient way
     * is to use an integer and bit operations.
     */
    public boolean canIWin(int n, int desiredTotal) {
        if (n < 1)
            throw new RuntimeException("invalid input");
        if (desiredTotal <= 1)
            return true;
        if (n * (n + 1) / 2 < desiredTotal)
            return false;
        map = new HashMap<>();
        int chosen = 0;
        return canWin(chosen, desiredTotal, n);
    }

    /**
     * Note that who's the current player is not part of the game's state.
     *
     * @param chosen
     * @param remain
     * @param n
     * @return given this state, if the current player can win.
     */
    private boolean canWin(int chosen, int remain, int n) {
        if (map.containsKey(chosen))
            return map.get(chosen);
        for (int i = 0; i < n; i++) {
            if (getBit(chosen, i) == 0) {
                if (remain - (i + 1) <= 0) {
                    map.put(chosen, true);
                    return true;
                }
                boolean opWin = canWin(setBit(chosen, i), remain - (i + 1), n);
                if (!opWin) {
                    map.put(chosen, true);
                    return true;
                }
            }
        }
        map.put(chosen, false);
        return false;
    }

    private int getBit(int num, int i) {
        return num & 1 << i;
    }

    private int setBit(int num, int i) {
        return num | 1 << i;
    }

    private int clearBit(int num, int i) {
        return num & ~(1 << i);
    }
}
