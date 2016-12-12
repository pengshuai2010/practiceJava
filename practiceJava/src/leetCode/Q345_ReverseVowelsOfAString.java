package leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by speng on 12/11/16.
 */
public class Q345_ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        //both upper and lower case!
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] a = s.toCharArray();
        int i = 0, j = a.length - 1;
        while (i < j) {
            if (!vowels.contains(a[i])) {
                i++;
            } else if (!vowels.contains(a[j])) {
                j--;
            } else {
                char tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;//move i, j after swap!
                j--;
            }
        }
        return new String(a);
    }
}
