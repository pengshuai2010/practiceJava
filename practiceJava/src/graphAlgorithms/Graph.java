package graphAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {
	private double[][] weights;
	private List<List<Vertex>> adjacencyList;

	/**
	 * @return the adjacencyList
	 */
	List<List<Vertex>> getAdjacencyList() {
		return adjacencyList;
	}

	/**
	 * @param adjacencyList
	 *            the adjacencyList to set
	 */
	private void setAdjacencyList(List<List<Vertex>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	private List<Vertex> vertices;
	private static final int MAX_VERTICES = 1000;

	private void deriveAdjListFromWeightMatrix() {
		double[][] weights = this.getWeights();
		List<List<Vertex>> adjList = new ArrayList<List<Vertex>>();
		for (int i = 0; i < weights.length; i++) {
			adjList.add(new ArrayList<Vertex>());
			for (int j = 0; j < weights[i].length; j++) {
				if (i != j && weights[i][j] < Double.POSITIVE_INFINITY) {
					adjList.get(i).add(this.getVertices().get(j));
				}
			}
		}
		this.setAdjacencyList(adjList);
	}

	/**
	 * @return the weights
	 */
	public double[][] getWeights() {
		return weights;
	}

	/**
	 * @param weights
	 *            the weights to set
	 */
	private void setWeights(double[][] weights) {
		this.weights = weights;
	}

	/**
	 * @return the vertices
	 */
	public List<Vertex> getVertices() {
		return vertices;
	}

	/**
	 * @param vertices
	 *            the vertices to set
	 */
	private void setVertices(List<Vertex> vertices) {
		this.vertices = vertices;
	}

	public int numVertices() {
		return this.getWeights().length;
	}

	public Graph(double[][] weights, String[] names) {
		this.setWeights(weights);
		List<Vertex> vertexList = new ArrayList<Vertex>();
		for (int i = 0; i < this.weights.length; i++) {
			vertexList.add(new Vertex(i, Double.POSITIVE_INFINITY, null, names[i]));
		}
		this.setVertices(vertexList);
		this.deriveAdjListFromWeightMatrix();
	}

	public List<Vertex> getAdjacentVertices(Vertex vetex) {
		int index = vetex.getIndex();
		List<Vertex> adjacentVertices = this.getAdjacencyList().get(index);
		return adjacentVertices;
	}

	public double getEdgeWeight(Vertex vertex1, Vertex vertex2) {
		int index1 = vertex1.getIndex();
		int index2 = vertex2.getIndex();
		return this.getWeights()[index1][index2];
	}

	void mst() {
		Vertex emptyVertex = new Vertex(-1, Double.POSITIVE_INFINITY, null, "NIL");
		for (Vertex vetex : this.getVertices()) {
			double inf = Double.POSITIVE_INFINITY;
			vetex.setKey(inf);
			vetex.setPi(emptyVertex);
		}
		Vertex root = this.getVertices().get(0);
		root.setKey(0);
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>(Graph.MAX_VERTICES, new VertexSortByKeyComparator());
		for (Vertex vertex : this.getVertices()) {
			queue.add(vertex);
		}
		this.printDebugInfo();
		while (!queue.isEmpty()) {
			Vertex vertex = queue.poll();
			System.out.println("take out vertex " + vertex.getIndex());
			for (Vertex adjacentVertex : this.getAdjacentVertices(vertex)) {
				System.out.println("update adjacent vertex " + adjacentVertex.getIndex());
				if (queue.contains(adjacentVertex)
						&& this.getEdgeWeight(vertex, adjacentVertex) < adjacentVertex.getKey()) {
					queue.remove(adjacentVertex);
					adjacentVertex.setPi(vertex);
					adjacentVertex.setKey(this.getEdgeWeight(vertex, adjacentVertex));
					queue.add(adjacentVertex);
				}
				this.printQueue(queue);
				this.printDebugInfo();
			}
		}
		this.printDebugInfo();
		System.out.println("MST Total Weight: " + this.getMSTWeight());
	}

	double getMSTWeight() {
		int totalWeight = 0;
		for (int i = 0; i < this.getWeights().length; i++) {
			Vertex pi = this.getVertices().get(i).getPi();
			int pi_index = pi.getIndex();
			if (pi_index != -1) {
				totalWeight += this.getWeights()[i][pi_index];
			}
		}
		return totalWeight;
	}

	void printDebugInfo() {
//		for (int i = 0; i < this.numVertices(); i++) {
//			System.out.println(i + ".pi = " + this.getVertices().get(i).getPi().getIndex());
//		}
//		for (int i = 0; i < this.numVertices(); i++) {
//			System.out.println(i + ".key = " + this.getVertices().get(i).getKey());
//		}
		for (Vertex vertex: this.getVertices()) {
			System.out.println(vertex + ".pi\t=\t" + vertex.getPi());
		}
		for (Vertex vertex: this.getVertices()) {
			System.out.println(vertex + ".key\t=\t" + vertex.getKey());
		}
		System.out.println("================");
	}

	/*
	 * the just shows what's in the queue, the printed sequence is not
	 * necessarily the sequence of the queue(probably not)
	 */
	void printQueue(PriorityQueue<Vertex> queue) {
		// System.out.print("queue head: " + queue.peek().getIndex() + "\n");
		System.out.print("queue content(not necessarily the sequence of the queue): [");
		for (Vertex vertex : queue) {
			System.out.print(vertex.getIndex() + "  ");
		}
		System.out.print("]\n");
	}
	
	private void initSingleSource(Vertex source) {
		Vertex emptyVertex = new Vertex(-1, Double.POSITIVE_INFINITY, null, "NIL");
		for(Vertex vertex: this.getVertices()) {
			vertex.setKey(Double.POSITIVE_INFINITY);
			vertex.setPi(emptyVertex);
		}
		source.setKey(0);
	}
	
	private void relax(Vertex u, Vertex v) {
		double W[][] = this.getWeights();
		if(v.getKey() > u.getKey() + W[u.getIndex()][v.getIndex()]) {
			v.setKey(u.getKey() + W[u.getIndex()][v.getIndex()]);
			v.setPi(u);
		}
	}
	
	public void dijkstra(Vertex source) {
		this.initSingleSource(source);
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>(Graph.MAX_VERTICES, new VertexSortByKeyComparator());
		for (Vertex vertex : this.getVertices()) {
			queue.add(vertex);
		}
		while(!queue.isEmpty()) {
			Vertex u = queue.poll();
			System.out.println("take out vertex " + u);
			for(Vertex v: this.getAdjacentVertices(u)) {
				System.out.println("update adjacent vertex " + v);
				this.relax(u, v);
				this.printDebugInfo();
			}
		}
	}

	public static void main(String[] args) {
		double inf = Double.POSITIVE_INFINITY;
		// //introduction to algorithms, page 635 example
		// double [][] weightMatrix = {
		// {0, 4, inf, inf, inf, inf, inf, 8, inf},
		// {4, 0, 8, inf, inf, inf, inf, 11, inf},
		// {inf, 8, 0, 7, inf, 4, inf, inf, 2},
		// {inf, inf, 7, 0, 9, 14, inf, inf, inf},
		// {inf, inf, inf, 9, 0, 10, inf, inf, inf},
		// {inf, inf, 4, 14, 10, 0, 2, inf, inf},
		// {inf, inf, inf, inf, inf, 2, 0, 1, 6},
		// {8, 11, inf, inf, inf, inf, 1, 0, 7},
		// {inf, inf, 2, inf, inf, inf, 6, 7, 0}};
		
//		//Exam2 (3)
//		double[][] weightMatrix = { { 0, inf, 1000, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf },
//				{ inf, 0, 1400, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf },
//				{ 1000, 1400, 0, 700, 1250, 1050, inf, inf, inf, inf, inf, inf, inf },
//				{ inf, inf, 700, 0, 300, inf, inf, inf, inf, inf, inf, inf, inf },
//				{ inf, inf, 1250, 300, 0, inf, 1150, inf, inf, inf, inf, inf, inf },
//				{ inf, inf, 1050, inf, inf, 0, inf, 850, inf, 1400, inf, inf, inf },
//				{ inf, inf, inf, inf, 1150, inf, 0, inf, 950, 1300, inf, inf, inf },
//				{ inf, inf, inf, inf, inf, 850, inf, 0, inf, 900, inf, inf, inf },
//				{ inf, inf, inf, inf, inf, inf, 950, inf, 0, inf, 1700, inf, inf },
//				{ inf, inf, inf, inf, inf, 1400, 1300, 900, inf, 0, 500, inf, inf },
//				{ inf, inf, inf, inf, inf, inf, inf, inf, 1700, 500, 0, 1650, 1200 },
//				{ inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 1650, 0, 1500 },
//				{ inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 1200, 1500, 0 } };
//		String names[] = { "Hangzhou", "Guangzhou", "Xian", "Lhasa", "Pataliputra", "Lop Nor", "Taxila", "Kashgar",
//				"Patalene", "Samarkand", "Rayy", "Antioch", "Constantinople" };
		
//		//introduction to algorithms, page 658 example
//		double[][] weightMatrix = {{0,10,inf,5,inf},
//				{inf,0,1,2,inf},
//				{inf,inf,0,inf,4},
//				{inf,3,9,0,2},
//				{7,inf,6,inf,0}};
//		String names[] = {"s", "t", "x", "y", "z"};
		
		//Exam2 (4)
		double[][] weightMatrix = { { 0, 1500, 1000, 1200, inf, inf, inf, inf },
				{ 1500, 0, inf, inf, 1000, inf, inf, inf }, 
				{ 1000, inf, 0, 800, inf, 1500, inf, inf },
				{ 1200, inf, 800, 0, 400, inf, inf, 1800 }, 
				{ inf, 1000, inf, 400, 0, inf, inf, 1500 },
				{ inf, inf, 1500, inf, inf, 0, 800, inf },
				{ inf, inf, inf, inf, inf, 800, 0, 400 },
				{ inf, inf, inf, 1800, 1500, inf, 400, 0 } };
		String names[] = { "LGA", "MIA", "MSN", "STL", "DFW", "SEA", "SFO", "LAX" };
		Graph graph = new Graph(weightMatrix, names);
		graph.mst();
//		graph.dijkstra(graph.getVertices().get(0));
	}
}
