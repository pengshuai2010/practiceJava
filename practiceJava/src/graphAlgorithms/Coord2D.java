/**
 * 
 */
package graphAlgorithms;

import java.util.Random;

/**
 * @author shuaipeng
 *
 */
public class Coord2D extends Coord {
	private double x;
	private double y;
	private Random raddomGenerator = new Random();
	
	public Coord2D() {
		this.x = this.raddomGenerator.nextDouble();
		this.y = this.raddomGenerator.nextDouble();
	}
	/* (non-Javadoc)
	 * @see graphAlgorithms.Coord#getDistance(graphAlgorithms.Coord)
	 */
	@Override
	public double getDistance(Coord other) {
		Coord2D obj = (Coord2D)other;
		return Math.sqrt( (this.x - obj.x)*(this.x - obj.x) 
				+ (this.y - obj.y)*(this.y - obj.y) );
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Coord2D [x=" + x + ", y=" + y + "]";
	}
}
