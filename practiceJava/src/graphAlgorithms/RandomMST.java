/**
 * 
 */
package graphAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author shuaipeng
 *
 */
public class RandomMST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length < 3) {
			System.out.println("Usage: java RandomMST [-uniform | -square | -cube]"
					+ " [number of vertices] [number of trials] ");
			System.exit(1);
		}
		String type = args[0];
		int numVertices = Integer.valueOf(args[1]);
		int numTrials = Integer.valueOf(args[2]);
		double total = 0;
		for(int i = 0; i < numTrials; i++) {
			List<Coord> coordList = generateCoordList(numVertices, type);
			double[][] weights = getWeightMatrix(numVertices, coordList, type);
			Graph graph = new Graph(weights, null);
			graph.mstPrim();
			total += graph.getMSTWeight();
		}
		double average = total/numTrials;
		System.out.println(average + "\t" + numVertices + "\t" + numTrials);
	}
	
	private static List<Coord> generateCoordList(int numVertices, String type) {
		List<Coord> coordList = new ArrayList<Coord>();
		switch (type) {
		case "-uniform":
			// TODO
			break;
		case "-square":
			for (int i = 0; i < numVertices; i++) {
				coordList.add(new Coord2D());
			}
			break;
		case "-cube":
			for (int i = 0; i < numVertices; i++) {
				coordList.add(new Coord3D());
			}
			break;
		default:
			System.out.println(
					"Usage: java RandomMST [-uniform | -square | -cube]" + " [number of vertices] [number of trials] ");
			System.exit(1);
		}
		return coordList;
	}
	
	private static double[][] getWeightMatrix(int numVertices, List<Coord> coordList, String type) {
		double[][] weights = new double[numVertices][numVertices];
		for(int i = 0; i < numVertices; i++) {
			weights[i][i] = 0;
		}
		if(type.equals("-uniform")) {
			Random randomGenerator = new Random();
			for(int i = 0; i < numVertices; i++) {
				for(int j = numVertices-1; j > i; j--) {
					weights[i][j] = randomGenerator.nextDouble();
				}
			}
		} else {
			for(int i = 0; i < numVertices; i++) {
				for(int j = numVertices-1; j > i; j--) {
					weights[i][j] = coordList.get(i).getDistance(coordList.get(j));
				}
			}
		}

		for(int i = 0; i < numVertices; i++) {
			for(int j = 0; j < i; j++) {
				weights[i][j] = weights[j][i];
			}
		}
		return weights;
	}

}
