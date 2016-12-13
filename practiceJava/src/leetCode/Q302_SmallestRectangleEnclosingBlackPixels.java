package leetCode;

/**
 * Created by shuaipeng on 12/13/16.
 */
public class Q302_SmallestRectangleEnclosingBlackPixels {
    private int smallestX;
    private int smallestY;
    private int largestX;
    private int largestY;

    /**
     * use DFS to go over all black pixels. time complexity is O(mn). Space complexity is O(1) because we mark visited by
     * changing the element.
     */
    public int minArea1(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0) {
            return 0;
        }
        //when getting smallest/largest, always set proper INITIAL value!
        smallestX = image.length;
        smallestY = image[0].length;
        largestX = 0;
        largestY = 0;
        //use '2' to represent visited, save space
        dfs(image, x, y);
        return (largestX - smallestX + 1) * (largestY - smallestY + 1);
    }

    private void dfs(char[][] image, int x, int y) {
        image[x][y] = '2';//mark visited
        if (x == 0 || image[x - 1][y] == '0') {// update smallestX only when reaching upper bound
            smallestX = Math.min(smallestX, x);
        } else if (image[x - 1][y] == '1') {//go up only when element above it is not upper bound and is not visited
            dfs(image, x - 1, y);
        }
        if (x == image.length - 1 || image[x + 1][y] == '0') {
            largestX = Math.max(largestX, x);
        } else if (image[x + 1][y] == '1') {
            dfs(image, x + 1, y);
        }
        if (y == 0 || image[x][y - 1] == '0') {
            smallestY = Math.min(smallestY, y);
        } else if (image[x][y - 1] == '1') {
            dfs(image, x, y - 1);
        }
        if (y == image[x].length - 1 || image[x][y + 1] == '0') {
            largestY = Math.max(largestY, y);
        } else if (image[x][y + 1] == '1') {
            dfs(image, x, y + 1);
        }
    }

    /**
     * A brilliant solution. Use binary search and the idea of projection. Only that we don't need to actually project the
     * 2-D matrix to a 1-D array, we can find out if the column or row has at least one black pixel while doing binary
     * search.
     * <p>
     * Time complexity is O(m*log(n) + n*log(n)) because finding out if a row has at least one black pixel takes O(n) time,
     * and for a column it takes O(m) time.
     */
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0) {
            return 0;
        }
        //TODO make the code more compact
        int low = 0, high = x;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (hasBlackHorizontal(image, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        int smallestX = low;

        low = x;
        high = image.length - 1;
        while (low < high) {//not using "low <= high" because we are sure target is in [low, high]
            int mid = low + (high - low + 1) / 2;// plus one inside the perenthis to prevent infinite loop
            if (hasBlackHorizontal(image, mid)) {
                low = mid;//not "low = mid + 1" because we need to maintain loop invariant that there's at least one black in range [low, high]
            } else {
                high = mid - 1;
            }
        }
        int largestX = low;

        low = 0;
        high = y;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (hasBlackVertical(image, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        int smallestY = low;

        low = y;
        high = image[0].length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (hasBlackVertical(image, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        int largestY = low;

        return (largestX - smallestX + 1) * (largestY - smallestY + 1);
    }

    private boolean hasBlack(char[][] image, int mid, boolean isHorizontal) {
        int length = isHorizontal ? image[0].length : image.length;
        for (int i = 0; i < length; i++) {
            if ((isHorizontal ? image[mid][i] : image[i][mid]) == '1') {
                return true;
            }
        }
        return false;
    }

    private boolean hasBlackVertical(char[][] image, int j) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][j] == '1') {
                return true;
            }
        }
        return false;
    }

    private boolean hasBlackHorizontal(char[][] image, int i) {
        for (int j = 0; j < image[i].length; j++) {
            if (image[i][j] == '1') {
                return true;
            }
        }
        return false;
    }
}
