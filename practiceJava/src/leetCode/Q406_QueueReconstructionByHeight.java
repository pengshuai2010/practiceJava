package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by shuaipeng on 12/13/16.
 */
public class Q406_QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0] == null || people[0].length != 2) {
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                if (a1[0] == a2[0]) {
                    return a1[1] - a2[1];
                }
                return a2[0] - a1[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            int[] person = people[i];
            list.add(person[1], person);
        }
        return list.toArray(new int[][]{});
    }
}
