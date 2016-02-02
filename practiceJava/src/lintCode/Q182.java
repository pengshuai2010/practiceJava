package lintCode;

import java.util.ArrayList;
import java.util.List;

public class Q182 {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
	if (A == null || A.length() == 0 || A.length() <= k)
	    return "";
	List<Character> remain = new ArrayList<Character>();
	for (int i = 0; i < A.length(); i++)
	    remain.add(A.charAt(i));
	StringBuilder builder = new StringBuilder();
	for (int i = 0; i < A.length() - k; i++) {
	    int leastIndex = 0;
	    for (int j = 0; j <= k && j < remain.size(); j++) {
		if (remain.get(j) < remain.get(leastIndex)) {
		    leastIndex = j;
		}
	    }
	    builder.append(remain.remove(leastIndex));
	    for (int j = 0; j < leastIndex; j++)
		remain.remove(j);
	}
	return builder.toString();
    }
    public static void main(String[] args) {
//	String A = "178542";
//	int k = 4;
//	String A = "";
//	int k = 4;
//	String A = "1234";
//	int k = 4;
//	String A = "1234";
//	int k = 0;
	String A = "254193";
	int k = 1;
	String res = new Q182().DeleteDigits(A, k);
	System.out.println(res);
    }

}
