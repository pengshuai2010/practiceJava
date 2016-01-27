package lintCode;

/**
 * public class SVNRepo { public static boolean isBadVersion(int k); } you can
 * use SVNRepo.isBadVersion(k) to judge whether the kth code version is bad or
 * not.
 */
public class Q74 {
	/*
	 * First Bad Version Show result
	 * 
	 * The code base version is an integer start from 1 to n. One day, someone
	 * committed a bad version in the code case, so it caused this version and
	 * the following versions are all failed in the unit tests. Find the first
	 * bad version.
	 * 
	 * You can call isBadVersion to help you determine which version is the
	 * first bad one. The details interface can be found in the code's
	 * annotation part.
	 * 
	 * Example Given n = 5:
	 * 
	 * isBadVersion(3) -> false isBadVersion(5) -> true isBadVersion(4) -> true
	 * Here we are 100% sure that the 4th version is the first bad version.
	 * 
	 * Note Please read the annotation in code area to get the correct way to
	 * call isBadVersion in different language. For example, Java is
	 * SVNRepo.isBadVersion(v)
	 * 
	 * Challenge You should call isBadVersion as few as possible.
	 */
	/**
	 * @param n:
	 *            An integers.
	 * @return: An integer which is the first bad version.
	 */
	public int findFirstBadVersion(int n) {
		int s = 1;
		int e = n;
		if (isBadVersion(s))
			return s;
		if (!isBadVersion(e))
			return -1;
		int mid = s + (e - s) / 2;
		/*
		 * since method call isBadVersion() is expensive, we want to make as
		 * less calls as possible. Here we use "s = mid" instead of
		 * "s = mid + 1" because for the later we would need to check
		 * isBadVersion(mid + 1), and this call only shrink the region by 1
		 * instead of half. And in order to avoid infinite loop, we need to
		 * check the size of the region. if region size is 2, according to loop
		 * invariant, s is always good and e is always bad, so e must be the
		 * first bad version.
		 */
		while (s <= e) {
			if (e - s == 1)
				return e;
			mid = s + (e - s) / 2;
			if (isBadVersion(mid))
				e = mid;
			else
				s = mid;
		}
		return mid;
	}

	private boolean isBadVersion(int k) {
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
