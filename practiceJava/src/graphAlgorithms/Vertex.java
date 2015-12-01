package graphAlgorithms;

public class Vertex {
	private double key;
	private Vertex pi;
	
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

	Vertex(double key, Vertex pi) {
		this.key = key;
		this.pi = pi;
	}
}
