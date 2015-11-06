/**
 * 
 */
package bug5;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author speng
 * created on Nov 5, 2015
 */
public class TriangleTest {

	@Test
	public void testRightTriangle() {
		//test case 1-6
		Triangle triangle = new Triangle(1, 90, 89);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.RIGHT);
		triangle = new Triangle(1, 89, 90);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.RIGHT);
		triangle = new Triangle(90, 1, 89);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.RIGHT);
		triangle = new Triangle(90, 89, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.RIGHT);
		triangle = new Triangle(89, 1, 90);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.RIGHT);
		triangle = new Triangle(89, 90, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.RIGHT);
	}

	@Test
	public void testObtuseTriangle() {
		//test case 7-9
		Triangle triangle = new Triangle(1, 1, 178);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.OBTUSE);
		triangle = new Triangle(1, 178, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.OBTUSE);
		triangle = new Triangle(178, 1, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.OBTUSE);
		//test case 13-18
		triangle = new Triangle(1, 88, 91);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.OBTUSE);
		triangle = new Triangle(1, 91, 88);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.OBTUSE);
		triangle = new Triangle(88, 1, 91);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.OBTUSE);
		triangle = new Triangle(88, 91, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.OBTUSE);
		triangle = new Triangle(91, 1, 88);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.OBTUSE);
		triangle = new Triangle(91, 88, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.OBTUSE);
	}
	
	@Test
	public void testAcuteTriangle() {
		//test case 10-12
		Triangle triangle = new Triangle(89, 89, 2);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.ACUTE);
		triangle = new Triangle(89, 2, 89);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.ACUTE);
		triangle = new Triangle(2, 89, 89);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.ACUTE);
	}
	
	@Test
	public void testInvalidTriangle() {
		//test case 19-21
		Triangle triangle = new Triangle(0, 90, 90);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
		triangle = new Triangle(90, 0, 90);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
		triangle = new Triangle(90, 90, 0);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
		//test case 22-24
		triangle = new Triangle(180, 0, 0);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
		triangle = new Triangle(0, 180, 0);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
		triangle = new Triangle(0, 0, 180);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
		//test case 25-27
		triangle = new Triangle(177, 1, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
		triangle = new Triangle(1, 177, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
		triangle = new Triangle(1, 1, 177);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
		//test case 28-33
		triangle = new Triangle(178, 2, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
		triangle = new Triangle(178, 1, 2);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
		triangle = new Triangle(2, 178, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
		triangle = new Triangle(2, 1, 178);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
		triangle = new Triangle(1, 178, 2);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
		triangle = new Triangle(1, 2, 178);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
		//test case 34
		triangle = new Triangle(0, 0, 0);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
		//test case 35
		triangle = new Triangle(90, 90, 90);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
	}
}
