package graphAlgorithms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class AllPairs {

	public static void main(String[] args) throws FileNotFoundException {
		String fileName = args[0];
		FileReader fileReader = new FileReader(fileName);
		Scanner scanner = new Scanner(fileReader);
		int numVertices = scanner.nextInt();
		double[][] weights = new double[numVertices][numVertices];
		for(int i = 0; i < numVertices; i++)
			for(int j = 0; j < numVertices; j++)
				weights[i][j] = Double.POSITIVE_INFINITY;
		int numEdges = scanner.nextInt();
		for(int i = 0; i < numEdges; i++) {
			int tail = scanner.nextInt() - 1;
			int head = scanner.nextInt() - 1;
			double weight = scanner.nextDouble();
			weights[tail][head] = weight;
		}
		scanner.close();
		Graph graph = new Graph(weights, null);
		double[][] D = graph.floyd_warshall();
		if(D == null) {
			System.out.println("NULL");
			return;
		}
		double minimum = Double.POSITIVE_INFINITY;
		for(int i = 0; i < graph.numVertices(); i++)
			for(int j = 0; j < graph.numVertices(); j++) {
				if(i == j)
					continue;
				minimum = Math.min(minimum, D[i][j]);
			}
		System.out.println(minimum);
	}

	static void test() {
		double[][] W = {{0,            2.7,            3.1,            Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY},
		          {2.7,          0,              1,              Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY},
		          {3.1,          1,              0,              2.3,            Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY},
		          {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,   2.3,            0,              0.95,           Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY},
		          {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   0.95,           0,              1.7,            1.3,            Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY},
		          {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,   2.6,            Double.POSITIVE_INFINITY,   1.7,            0,              0.1,            Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY},
		          {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   1.3,            0.1,            0,              7.1,            Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   1.5},
		          {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   7.1,            0,              3.5,            Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY},
		          {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   3.5,            0,              0.5,            Double.POSITIVE_INFINITY},
		          {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   0.5,            0,              1.1},
		          {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   1.5,            Double.POSITIVE_INFINITY,   Double.POSITIVE_INFINITY,   1.1,            0}};

		Graph graph = new Graph(W, null);
		double[][] D = graph.floyd_warshall();
		if(D == null) {
			System.out.println("NULL");
			return;
		}
		double minimum = Double.POSITIVE_INFINITY;
		for(int i = 0; i < graph.numVertices(); i++)
			for(int j = 0; j < graph.numVertices(); j++) {
				if(i == j)
					continue;
				minimum = Math.min(minimum, D[i][j]);
			}
				
		Utility.print2DMatrix(D);
		System.out.println(minimum);
	}
}
