package lintCode;

public class Q54 {
	/*
	 * String to Integer II Show result 

Implement function atoi to convert a string to an integer.

If no valid conversion could be performed, a zero value is returned.

If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
	 */
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
    	if (str == null)
    		return 0;
    	boolean isPositive = true;
    	String str1 = str.trim();
    	if (str1.length() == 0)
    		return 0;
    	char ch = str1.charAt(0);
    	if (ch == '-') {
    		isPositive = false;
    		str1 = str1.substring(1, str1.length());
    	}
    	else if (ch == '+') {
    		str1 = str1.substring(1, str1.length());
    	}
    	if (str1.length() == 0)
    		return 0;
    	int value = 0;
    	for (int i = 0; i < str1.length(); i++) {
    		ch = str1.charAt(i);
    		if (ch == '.')
    			return value;
    		int digit = ch - '0';
    		if (digit < 0 || digit > 9)
    			return value;
    		int newValue;
    		if (isPositive) {
    			newValue = value*10 + digit;
    			if (newValue < value)
    				return Integer.MAX_VALUE;
    		}
    		else {
    			newValue = value*10 - digit;
    			if (newValue > value)
    				return Integer.MIN_VALUE;
    		}
    		value = newValue;
    	}
    	return value;
    }
	public static void main(String[] args) {
	//	String str = "123123123123123";
//		String str = "   -123123123123123";
//		String str = "123123   ";
//		String str = "    -123123";
//		String str = "0";
//		String str = "0.23";
//		String str = "-0.23";
//		String str = "+1";
		String str = " 123lin t";

		int res = new Q54().atoi(str);
		System.out.println(res);
	}

}
