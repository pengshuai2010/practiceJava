package lintCode;

public class Q38 {
	int occurence = 0;
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
    		return 0;
    	search(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    	return occurence;
    }
    
    private void search(int[][] matrix, int target, int row1, int row2, int col1, int col2) {
    	if (row2 - row1 <= 0 || col2 - col1 <= 0)
    		return;
    	int s = 0;
    	int e = Math.min(row2 - row1,  col2 - col1);
    	int mid;
    	while (s <= e) {
    		mid = s + (e - s)/2;
    		if (matrix[row1 + mid][col1 + mid] > target)
    			e = mid - 1;
    		else if (matrix[row1 + mid][col1 + mid] < target)
    			s = mid + 1;
    		else {
    			occurence++;
    			break;
    		}
    		if (matrix[row1 + mid][col1 + mid] == target) {
    			search(matrix, target, row1 + mid + 1, row2, col1, col1 + mid - 1);
    			search(matrix, target, row1, row1 + mid - 1, col1 + mid + 1, col2);
    		} else if (matrix[row1 + mid][col1 + mid] < target) {
    			search(matrix, target, row1 + mid + 1, row2, col1, col1 + mid);
    			search(matrix, target, row1, row1 + mid, col1 + mid + 1, col2);
    		} else {
    			search(matrix, target, row1, row2, col1, col1 + mid - 1);
    			search(matrix, target, row1, row1 + mid - 1, col1 + mid, col2);
    		}
    	}
    }
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
		                              {1, 3, 5, 7},
		                              {2, 4, 7, 8},
		                              {3, 5, 9, 10}
		                            };
        int target = 7;
        int res = new Q38().searchMatrix(matrix, target);
        System.out.println(res);
	}

}
