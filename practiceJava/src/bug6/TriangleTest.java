/**
 * 
 */
package bug6;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author speng
 * created on Nov 5, 2015
 */
public class TriangleTest {

	@Test
	public void testCase1() {
		Triangle triangle = new Triangle(1, 90, 89);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.RIGHT);
	}
	
	@Test
	public void testCase2() {
		Triangle triangle = new Triangle(1, 89, 90);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.RIGHT);
	}
	
	@Test
	public void testCase3() {
		Triangle triangle = new Triangle(90, 1, 89);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.RIGHT);
	}
	
	@Test
	public void testCase4() {
		Triangle triangle = new Triangle(90, 89, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.RIGHT);
	}
	
	@Test
	public void testCase5() {
		Triangle triangle = new Triangle(89, 1, 90);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.RIGHT);
	}
	
	@Test
	public void testCase6() {
		Triangle triangle = new Triangle(89, 90, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.RIGHT);
	}
	
	@Test
	public void testCase7() {
		Triangle triangle = new Triangle(1, 1, 178);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.OBTUSE);
	}
	
	@Test
	public void testCase8() {
		Triangle triangle = new Triangle(1, 178, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.OBTUSE);
	}
	
	@Test
	public void testCase9() {
		Triangle triangle = new Triangle(178, 1, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.OBTUSE);
	}
	
	@Test
	public void testCase10() {
		Triangle triangle = new Triangle(89, 89, 2);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.ACUTE);
	}
	
	@Test
	public void testCase11() {
		Triangle triangle = new Triangle(89, 2, 89);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.ACUTE);
	}
	
	@Test
	public void testCase12() {
		Triangle triangle = new Triangle(2, 89, 89);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.ACUTE);
	}
	
	
	@Test
	public void testCase13() {
		Triangle triangle = new Triangle(1, 88, 91);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.OBTUSE);
	}
	
	@Test
	public void testCase14() {
		Triangle triangle = new Triangle(1, 91, 88);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.OBTUSE);
	}
	
	@Test
	public void testCase15() {
		Triangle triangle = new Triangle(88, 1, 91);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.OBTUSE);
	}
	
	@Test
	public void testCase16() {
		Triangle triangle = new Triangle(88, 91, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.OBTUSE);
	}
	
	@Test
	public void testCase17() {
		Triangle triangle = new Triangle(91, 1, 88);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.OBTUSE);
	}
	
	@Test
	public void testCase18() {
		Triangle triangle = new Triangle(91, 88, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.OBTUSE);
	}
	
	@Test
	public void testCase19() {
		Triangle triangle = new Triangle(0, 90, 90);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
	}
	
	@Test
	public void testCase20() {
		Triangle triangle = new Triangle(90, 0, 90);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
	}
	
	
	@Test
	public void testCase21() {
		Triangle triangle = new Triangle(90, 90, 0);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
	}
	
	
	@Test
	public void testCase22() {
		Triangle triangle = new Triangle(180, 0, 0);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
	}
	
	@Test
	public void testCase23() {
		Triangle triangle = new Triangle(0, 180, 0);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
	}
	
	@Test
	public void testCase24() {
		Triangle triangle = new Triangle(0, 0, 180);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
	}
	
	@Test
	public void testCase25() {
		Triangle triangle = new Triangle(177, 1, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
	}
	
	@Test
	public void testCase26() {
		Triangle triangle = new Triangle(1, 177, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
	}
	
	@Test
	public void testCase27() {
		Triangle triangle = new Triangle(1, 1, 177);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
	}
	
	@Test
	public void testCase28() {
		Triangle triangle = new Triangle(178, 2, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
	}
	
	
	@Test
	public void testCase29() {
		Triangle triangle = new Triangle(178, 1, 2);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
	}
	
	@Test
	public void testCase30() {
		Triangle triangle = new Triangle(2, 178, 1);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
	}
	
	@Test
	public void testCase31() {
		Triangle triangle = new Triangle(2, 1, 178);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
	}
	
	@Test
	public void testCase32() {
		Triangle triangle = new Triangle(1, 178, 2);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
	}
	
	@Test
	public void testCase33() {
		Triangle triangle = new Triangle(1, 2, 178);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
	}
	
	@Test
	public void testCase34() {
		Triangle triangle = new Triangle(0, 0, 0);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
	}
	
	@Test
	public void testCase35() {
		Triangle triangle = new Triangle(90, 90, 90);
		assertTrue(triangle.reportTriangleType() == Triangle.TriangleType.NOTRIANGLE);
	}
}
