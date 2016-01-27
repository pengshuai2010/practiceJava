package lintCode;

public class Q160 {
	public int findMin(int[] num) {
		/*
		 * num[mid] > num[e] means that pivot is in the right part(not including mid)
		 * num[mid] < num[e] means that right part is ordered, least number must be in
		 * the left part(including mid because num[mid] might be the least number)
		 * Since duplicates can exist, num[mid] == num[e] does not necessarily mean that
		 * right part is ordered, e.g.  [3, 4, 5, 1, 5] and mid is 2, e is 4. Nevertheless we can
		 * safely remove e form the region since it is repeated by mid.
		 * 
		 */
		int s = 0;
		int e = num.length - 1;
		int mid = (s + e) / 2;
		while (s < e) {
			mid = (s + e) / 2;
			if (num[mid] > num[e])
				s = mid + 1;
			else if (num[mid] < num[e])
				e = mid;
			else
				e = e - 1;
		}
		return num[s];
	}
	
	public static void main(String[] args) {
		int[] num = new int[] {1, 1, -1, 1};
		int res = new Q160().findMin(num);
		System.out.println(res);
	}

}
