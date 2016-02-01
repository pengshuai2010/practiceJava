package lintCode;

public class Q38 {
	/*
	 * Search a 2D Matrix II Show result
	 * 
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix, return the occurrence of it.
	 * 
	 * this matrix has the following properties:
	 * 
	 * Integers in each row are sorted from left to right. Integers in each
	 * column are sorted from up to bottom. No duplicate integers in each row or
	 * column. Example Consider the following matrix:
	 * 
	 * [ [1, 3, 5, 7], [2, 4, 7, 8], [3, 5, 9, 10] ] Given target = 3, return 2.
	 * 
	 * Challenge O(m+n) time and O(1) extra space
	 */
	/**
	 * @param matrix:
	 *            A list of lists of integers
	 * @param: A
	 *             number you want to search in the matrix
	 * @return: An integer indicate the occurrence of target in the given matrix
	 */
	public int searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int occurence = 0;
		int row = 0;
		int col = matrix[0].length - 1;
		while (row <= matrix.length - 1 && col >= 0) {
			if (matrix[row][col] < target)
				row++;
			else if (matrix[row][col] > target)
				col--;
			else {
				row++;
				col--;
				occurence++;
			}
		}
		return occurence;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 2, 4, 7, 8 }, { 3, 5, 9, 10 } };
		int target = 5;
		int res = new Q38().searchMatrix(matrix, target);
		System.out.println(res);
	}

}
