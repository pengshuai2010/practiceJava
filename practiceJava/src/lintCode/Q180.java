package lintCode;

public class Q180 {
	/*
	 * Binary Representation Show result
	 * 
	 * 45:00 Start Given a (decimal - e.g. 3.72) number that is passed in as a
	 * string, return the binary representation that is passed in as a string.
	 * If the fractional part of the number can not be represented accurately in
	 * binary with at most 32 characters, return ERROR.
	 * 
	 * Example For n = "3.72", return "ERROR".
	 * For n = "3.5", return "11.1".
	 * 
	 * NOTE
	 * double type has a 15–17 significant decimal digits precision. we must
	 * handle the case when input string has more than 15 valid digits
	 */
	/**
	 * @param n:
	 *            Given a decimal number that is passed in as a string
	 * @return: A string
	 */
	public String binaryRepresentation(String n) {
		double num = Double.valueOf(n);
		String sign = "";
		if (num < 0) {
			num = -num;
			sign = "-";
		}
		int a = (int) num;
		double b = parseFraction(n);
		String intPart = Integer.toBinaryString(a);
		if (b == 0)
			return sign + intPart;
		StringBuilder fractionPart = new StringBuilder();
		int i = 0;
		double tmp = b;
		do {
			tmp = tmp * 2;
			if (tmp >= 1) {
				fractionPart.append("1");
				tmp = tmp - 1;
			} else {
				fractionPart.append("0");
			}
			i++;
		} while (tmp != 0 && i < 32);
		if (i >= 32)
			return "ERROR";
		String res = sign + intPart + "." + fractionPart.toString();
		return res;
	}

	private static double parseFraction(String n) {
		int dotIndex = n.lastIndexOf('.');
		if (dotIndex == -1)
			return 0;
		String fraction = n.substring(dotIndex);
		fraction = "0" + fraction;
		return Double.parseDouble(fraction);
	}

	public static void main(String[] args) {
		// String n = "3.5";
		// String n = "3.72";
		// String n = "0";
		// String n = "-1.75";
		// String n = "6.125";
		String n = "28187281.128121212121";

		String binaryRepr = new Q180().binaryRepresentation(n);
		System.out.println(binaryRepr);
	}

}
