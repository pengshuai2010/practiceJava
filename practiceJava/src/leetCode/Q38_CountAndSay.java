package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 11/12/16.
 */
public class Q38_CountAndSay {
    public String countAndSay(int n) {
        if (n < 1)
            return "";
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int k = 1; k < n; k++) {
            List<Integer> tmp = new ArrayList<>();
            int count = 1;
            int i;
            for (i = 0; i < list.size(); i++) {
                if (i > 0) {
                    if (list.get(i).equals(list.get(i - 1))) {
                        count++;
                    } else {
                        tmp.add(count);
                        tmp.add(list.get(i - 1));
                        count = 1;
                    }
                }
            }
            tmp.add(count);
            tmp.add(list.get(i - 1));
            list = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : list)
            sb.append(Integer.toString(num));
        return sb.toString();
    }
}
