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
     * A brute force method is to go over all elements in the matrix, if the element is a black pixels, compare and upate.
     * It takes O(mn) time and O(1) space.
     *
     * use DFS to go over all black pixels. time complexity is O(mn). Although we saved some space by marking vistied on
     * the original matrix, Space complexity is still O(mn) because in the worst case we need to store all vertices in the
     * traversed graph, which is number of black pixels. Note that don't forget the space of stack when analyzing space
     * complexity of DFS!
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
        if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == '1') {
            image[x][y] = '2';//mark visited
            smallestX = Math.min(smallestX, x);
            largestX = Math.max(largestX, x);
            smallestY = Math.min(smallestY, y);
            largestY = Math.max(largestY, y);
            dfs(image, x - 1, y);
            dfs(image, x + 1, y);
            dfs(image, x, y - 1);
            dfs(image, x, y + 1);
        }
    }

    /**
     * A brilliant solution. Make use of the fact that all black pixels are connected. It can be proved that If there
     * are only one black pixel region, then in a projected 1D array all the black pixels are connected, so we can do
     * binary search in the projected 1-D array. The trick is that we don't do projection before binary search but do it
     * as needed while doing binary search.
     *
     * Use binary search and the idea of projection. Only that we don't need to actually project the
     * 2-D matrix to a 1-D array, we can find out if the column or row has at least one black pixel while doing binary
     * search.
     * <p>
     * Time complexity is O(m*log(n) + n*log(n)) because finding out if a row has at least one black pixel takes O(n) time,
     * and for a column it takes O(m) time.
     * Space complexity is O(1)
     */
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0) {
            return 0;
        }
        int smallestX = findLowerBound(image, x, true);
        int largestX = findUpperBound(image, x, true);
        int smallestY = findLowerBound(image, y, false);
        int largestY = findUpperBound(image, y, false);
        return (largestX - smallestX + 1) * (largestY - smallestY + 1);
    }

    private int findLowerBound(char[][] image, int index, boolean isXdirection) {
        int low = 0, high = index;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (hasBlack(image, mid, isXdirection)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * @param image
     * @param index
     * @param isXdirection if true, we are searching in the x direction, i.e. finding the bottom row of the rectangle;
     *                     else, find the right-most column of the rectangle
     * @return
     */
    private int findUpperBound(char[][] image, int index, boolean isXdirection) {
        int low = index;
        int high = isXdirection ? image.length - 1 : image[0].length - 1;
        while (low < high) {//not using "low <= high" because we are sure target is in [low, high]
            int mid = low + (high - low + 1) / 2;// plus one inside the perenthis to prevent infinite loop
            if (hasBlack(image, mid, isXdirection)) {
                low = mid;//not "low = mid + 1" because we need to maintain loop invariant that there's at least one black in range [low, high]
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     *
     * @param image
     * @param mid
     * @param isHorizontal when true, try to find if there's at least one black pixel in the row image[mid]; else try to
     *                     find if there's at least one black pixel in the column image[][mid]
     * @return
     */
    private boolean hasBlack(char[][] image, int mid, boolean isHorizontal) {
        int length = isHorizontal ? image[0].length : image.length;
        for (int i = 0; i < length; i++) {
            if ((isHorizontal ? image[mid][i] : image[i][mid]) == '1') {
                return true;
            }
        }
        return false;
    }
}
