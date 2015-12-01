package graphAlgorithms;

public class Vertex {
	private double key;
	private Vertex pi;
	private int index;
	private String name;
	/**
	 * @return the index
	 */
	int getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	private void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the key
	 */
	public double getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
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
	 * @param pi
	 *            the pi to set
	 */
	public void setPi(Vertex pi) {
		this.pi = pi;
	}

	Vertex(int index, double key, Vertex pi, String name) {
		this.setIndex(index);
		this.key = key;
		this.pi = pi;
		this.setName(name);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName();
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
}
