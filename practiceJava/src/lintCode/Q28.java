package lintCode;

public class Q28 {
	/*
	 * Search a 2D Matrix Show result
	 * 
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix.
	 * 
	 * This matrix has the following properties:
	 * 
	 * Integers in each row are sorted from left to right. The first integer of
	 * each row is greater than the last integer of the previous row. Example
	 * Consider the following matrix:
	 * 
	 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] Given target = 3,
	 * return true.
	 */
	/**
	 * @param matrix,
	 *            a list of lists of integers
	 * @param target,
	 *            an integer
	 * @return a boolean, indicate whether matrix contains target
	 */
	public boolean searchMatrix1(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
			return false;
		int s = 0, e = matrix.length - 1;
		int mid = 0;
		while (s <= e) {
			mid = (s + e) / 2;
			if (matrix[mid][0] > target)
				e = mid - 1;
			else if (matrix[mid][0] < target)
				if (matrix[mid][matrix[mid].length - 1] < target)
					s = mid + 1;
				else {
					break;
				}
			else
				return true;
		}
		int row = mid;
		s = 0;
		e = matrix[row].length - 1;
		while (s <= e) {
			mid = (s + e) / 2;
			if (matrix[row][mid] > target)
				e = mid - 1;
			else if (matrix[row][mid] < target)
				s = mid + 1;
			else
				return true;
		}
		if (matrix[row][mid] == target)
			return true;
		else
			return false;
	}
	/*
	 * same time complexity, but uses only one binary search
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
			return false;
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		int s = 0, e = numRows*numCols - 1, mid = (s + e)/2;
		while (s <= e) {
			mid = (s + e)/2;
			int row = mid/numCols;
			int col = mid - row*numCols;
			if (target > matrix[row][col])
				s = mid + 1;
			else if (target < matrix[row][col])
				e = mid - 1;
			else
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
//		 int target = 3;
//		 int target = -1;
//		 int target = 50;
		int target = 51;
		boolean res = new Q28().searchMatrix(matrix, target);
		System.out.println(res);
	}

}
