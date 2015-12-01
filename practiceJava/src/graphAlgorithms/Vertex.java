package graphAlgorithms;

public class Vertex {
	private double key;
	private Vertex pi;
	/**
	 * @return the index
	 */
	int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	private void setIndex(int index) {
		this.index = index;
	}

	private int index;
	
	/**
	 * @return the key
	 */
	public double getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(double key) {
		this.key = key;
	}

	/**
	 * @return the pi
	 */
	public Vertex getPi() {
		return pi;
	}

	/**
	 * @param pi the pi to set
	 */
	public void setPi(Vertex pi) {
		this.pi = pi;
	}

	Vertex(int index, double key, Vertex pi) {
		this.setIndex(index);
		this.key = key;
		this.pi = pi;
	}
}
