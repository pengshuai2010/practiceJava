package leetCode;

/**
 * Created by speng on 12/4/16.
 */
public class Q434_NumberOfSegmentsInAString {
    public int countSegments(String s) {
        if (s == null) {
            return 0;
        }
        int count = 0;
        for (String token : s.split("\\s+")) {
            if (token.length() > 0) {
                count++;
            }
        }
        return count;
    }
}
