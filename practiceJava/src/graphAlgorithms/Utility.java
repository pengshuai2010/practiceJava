/**
 * 
 */
package graphAlgorithms;

/**
 * @author speng
 * created on Dec 18, 2015
 */
public class Utility {
	static void print2DMatrix(double [][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
