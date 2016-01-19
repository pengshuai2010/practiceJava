package lintCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q56 {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
    	if (numbers == null || numbers.length < 2) 
    		return new int[]{};
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i = 0; i < numbers.length; i++) {
    		map.put(numbers[i], i + 1);
    	}
    	return res;
    }
	public static void main(String[] args) {
//		int[] numbers = new int[] {2, 7, 11, 15};
//		int target = 9;
//		int[] numbers = new int[] {1, 0, -1};
//		int target = -1;
		int[] numbers = new int[] {1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99};
		int target = -64;
		int[] res = new Q56().twoSum(numbers, target);
		System.out.println(Arrays.toString(res));
	}

}
