package graphAlgorithms;

import java.util.Comparator;

public class VertexSortByKeyComparator implements Comparator<Vertex> {

	@Override
	public int compare(Vertex v1, Vertex v2) {
		return v1.getKey() < v2.getKey() ? -1 : v2.getKey()  == v2.getKey()  ? 0 : 1;
	}


}
