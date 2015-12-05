package graphAlgorithms;

import java.util.Arrays;

public class Solutions {

	public static void main(String[] args) {
		exam2_3();
	}
	/*
	 * solution for Exam2 (3)
	 */
	public static void exam2_3() {
		double inf = Double.POSITIVE_INFINITY;
		double[][] weightMatrix = { { 0, inf, 1000, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf },
				{ inf, 0, 1400, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf },
				{ 1000, 1400, 0, 700, 1250, 1050, inf, inf, inf, inf, inf, inf, inf },
				{ inf, inf, 700, 0, 300, inf, inf, inf, inf, inf, inf, inf, inf },
				{ inf, inf, 1250, 300, 0, inf, 1150, inf, inf, inf, inf, inf, inf },
				{ inf, inf, 1050, inf, inf, 0, inf, 850, inf, 1400, inf, inf, inf },
				{ inf, inf, inf, inf, 1150, inf, 0, inf, 950, 1300, inf, inf, inf },
				{ inf, inf, inf, inf, inf, 850, inf, 0, inf, 900, inf, inf, inf },
				{ inf, inf, inf, inf, inf, inf, 950, inf, 0, inf, 1700, inf, inf },
				{ inf, inf, inf, inf, inf, 1400, 1300, 900, inf, 0, 500, inf, inf },
				{ inf, inf, inf, inf, inf, inf, inf, inf, 1700, 500, 0, 1650, 1200 },
				{ inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 1650, 0, 1500 },
				{ inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 1200, 1500, 0 } };
		String names[] = { "Hangzhou", "Guangzhou", "Xian", "Lhasa", "Pataliputra", "Lop Nor", "Taxila", "Kashgar",
				"Patalene", "Samarkand", "Rayy", "Antioch", "Constantinople" };
		Graph graph = new Graph(weightMatrix, Arrays.asList(names));
		graph.mstPrim();
	}
	
	/*
	 * solution for Exam2 (4)
	 */
	public static void exam2_4() {
		double inf = Double.POSITIVE_INFINITY;
		double[][] weightMatrix = { { 0, 1500, 1000, 1200, inf, inf, inf, inf },
				{ 1500, 0, inf, inf, 1000, inf, inf, inf }, 
				{ 1000, inf, 0, 800, inf, 1500, inf, inf },
				{ 1200, inf, 800, 0, 400, inf, inf, 1800 }, 
				{ inf, 1000, inf, 400, 0, inf, inf, 1500 },
				{ inf, inf, 1500, inf, inf, 0, 800, inf },
				{ inf, inf, inf, inf, inf, 800, 0, 400 },
				{ inf, inf, inf, 1800, 1500, inf, 400, 0 } };
		String names[] = { "LGA", "MIA", "MSN", "STL", "DFW", "SEA", "SFO", "LAX" };
		Graph graph = new Graph(weightMatrix, Arrays.asList(names));
		graph.dijkstra(graph.getVertices().get(5));//"SEA"
	}
}
