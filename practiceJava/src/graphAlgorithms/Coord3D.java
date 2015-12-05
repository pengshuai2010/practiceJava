/**
 * 
 */
package graphAlgorithms;

import java.util.Random;

/**
 * @author shuaipeng
 *
 */
public class Coord3D extends Coord {
	private double x;
	private double y;
	private double z;
	private Random raddomGenerator = new Random();
	
	public Coord3D() {
		this.x = this.raddomGenerator.nextDouble();
		this.y = this.raddomGenerator.nextDouble();
		this.z = this.raddomGenerator.nextDouble();
	}
	/* (non-Javadoc)
	 * @see graphAlgorithms.Coord#getDistance(graphAlgorithms.Coord)
	 */
	@Override
	public double getDistance(Coord other) {
		Coord3D obj = (Coord3D)other;
		return Math.sqrt( (this.x - obj.x)*(this.x - obj.x) 
				+ (this.y - obj.y)*(this.y - obj.y)
				+ (this.z - obj.z)*(this.z - obj.z));
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Coord3D [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

}
