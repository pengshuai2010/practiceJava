package graphAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {
	private double[][] weights;
	private List<Vertex> vertices;
	private static final int MAX_VERTICES = 1000;
	/**
	 * @return the weights
	 */
	public double[][] getWeights() {
		return weights;
	}
	/**
	 * @param weights the weights to set
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
	 * @param vertices the vertices to set
	 */
	private void setVertices(List<Vertex> vertices) {
		this.vertices = vertices;
	}
	
	public int numVertices() {
		return this.getWeights().length;
	}
	
	public Graph(double[][] weights) {
		this.setWeights(weights);
		List<Vertex> vertexList = new ArrayList<Vertex>();
		for(int i = 0; i < this.weights.length; i++) {
			vertexList.add(new Vertex(Double.POSITIVE_INFINITY, null));
		}
		this.setVertices(vertexList);
	}
	
	public List<Vertex> getAdjacentVertices(Vertex vetex) {
		//TODO refactor this method to get adjacent vertices in O(1) time
		int index = this.getVertices().indexOf(vetex);
		List<Vertex> adjacentVertices = new ArrayList<Vertex>();
		for(int i = 0; i < this.getWeights().length; i++) {
			if(i != index && this.getWeights()[i][index] < Double.POSITIVE_INFINITY) {
				adjacentVertices.add(this.getVertices().get(i));
			}
		}
		return adjacentVertices;
	}
	
	public double getEdgeWeight(Vertex vertex1, Vertex vertex2) {
		//TODO refactor this method to get edge weight in O(1) time
		int index1 = this.getVertices().indexOf(vertex1);
		int index2 = this.getVertices().indexOf(vertex2);
		return this.getWeights()[index1][index2];
	}
	
	void mst() {
		for(Vertex vetex: this.getVertices()) {
			double inf = Double.POSITIVE_INFINITY;
			vetex.setKey(inf);
			vetex.setPi(null);
		}
		Vertex root = this.getVertices().get(0);
		root.setKey(0);
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>(Graph.MAX_VERTICES, new VertexSortByKeyComparator());
		for(Vertex vertex: this.getVertices()) {
			queue.add(vertex);
		}
		this.printMST();
		while(!queue.isEmpty()) {
			Vertex vertex = queue.poll();
			System.out.println("take out vertex " + this.getVertices().indexOf(vertex));
			for(Vertex adjacentVertex: this.getAdjacentVertices(vertex)) {
				System.out.println("update adjacent vertex " + this.getVertices().indexOf(adjacentVertex));
				if(queue.contains(adjacentVertex) && this.getEdgeWeight(vertex, adjacentVertex) < adjacentVertex.getKey()) {
					queue.remove(adjacentVertex);
					adjacentVertex.setPi(vertex);
					adjacentVertex.setKey(this.getEdgeWeight(vertex, adjacentVertex));
					queue.add(adjacentVertex);
				}
				this.printQueue(queue);
				this.printMST();
			}
		}
		this.printMST();
		System.out.println("MST Total Weight: " + this.getMSTWeight());
	}
	
	double getMSTWeight() {
		int totalWeight = 0;
		for(int i = 0; i < this.getWeights().length; i++) {
			Vertex pi = this.getVertices().get(i).getPi();
			int pi_index = this.getVertices().indexOf(pi);
			if(pi_index != -1) {
				totalWeight += this.getWeights()[i][pi_index];
			}
		}
		return totalWeight;
	}
	
	void printMST() {
		for(int i = 0; i < this.numVertices(); i++) {
			System.out.println(i + " -> " + this.getVertices().indexOf(this.getVertices().get(i).getPi()));
		}
		for(int i = 0; i < this.numVertices(); i++) {
			System.out.println(i + " key: " + this.getVertices().get(i).getKey());
		}
		System.out.println("================");
	}
	
	void printQueue(PriorityQueue<Vertex> queue) {
		System.out.print("[");
		for(Vertex vertex: queue) {
			System.out.print(this.getVertices().indexOf(vertex) + "\t");
		}
		System.out.print("]\n");
	}
	
	public static void main(String[] args) {
		double inf = Double.POSITIVE_INFINITY;
		double [][] weightMatrix = {
				{0,		4,		inf,	inf,	inf,	inf,	inf,	8,		inf}, 
				{4,		0,		8,		inf,	inf,	inf,	inf,	11,		inf},
				{inf,	8,		0,		7,		inf,	4,		inf,	inf,	2},
				{inf,	inf,	7,		0,		9,		14,		inf,	inf,	inf},
				{inf,	inf,	inf,	9,		0,		10,		inf,	inf,	inf},
				{inf,	inf,	4,		14,		10,		0,		2,		inf,	inf},
				{inf,	inf,	inf,	inf,	inf,	2,		0,		1,		6},
				{8,		11,		inf,	inf,	inf,	inf,	1,		0,		7},
				{inf,	inf,	2,		inf,	inf,	inf,	6,		7,		0}};
		
		Graph graph = new Graph(weightMatrix);
		graph.mst();
	}
}
