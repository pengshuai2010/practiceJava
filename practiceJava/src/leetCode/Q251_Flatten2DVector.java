package leetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by speng on 12/22/16.
 */
public class Q251_Flatten2DVector implements Iterator<Integer> {
    private List<Iterator<Integer>> iterators;
    private int curr;

    public Q251_Flatten2DVector(List<List<Integer>> vec2d) {
        iterators = new ArrayList<>();
        for (List<Integer> list : vec2d) {
            //maintain the invariant that iterators in the list are hasNext() == true
            if (list != null && list.size() > 0) {
                iterators.add(list.iterator());
            }
        }
        curr = 0;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            int val = iterators.get(curr).next();
            //maintain the invariant that curr always points to the ready-to-read iterator except when all numbers are read
            if (curr < iterators.size() && !iterators.get(curr).hasNext()) {
                curr++;
            }
            return val;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean hasNext() {
        return curr < iterators.size();
    }
}
