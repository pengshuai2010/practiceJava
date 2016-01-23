package lintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q50 {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
    	// use forward-backward-traversal
    	ArrayList<Long> products = new ArrayList<Long>();
    	if (A == null || A.size() == 0)
    		return products;
    	Map<Integer, Long> leftProducts = new HashMap<Integer, Long>();
    	leftProducts.put(-1, 1L);
    	for (int i = 0; i < A.size(); i++) 
    		leftProducts.put(i, leftProducts.get(i - 1)*A.get(i));
    	Map<Integer, Long> rightProducts = new HashMap<Integer, Long>();
    	rightProducts.put(A.size(), 1L);
    	for (int i = A.size() - 1; i >= 0; i--)
    		rightProducts.put(i, rightProducts.get(i + 1)*A.get(i));
    	for (int i = 0; i < A.size(); i++) {
    		long product = leftProducts.get(i - 1)*rightProducts.get(i + 1);
    		products.add(product);
    	}
    	return products;
    }
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
		System.out.println(A);
		ArrayList<Long> res = new Q50().productExcludeItself(A);
		System.out.println(res);
	}

}
