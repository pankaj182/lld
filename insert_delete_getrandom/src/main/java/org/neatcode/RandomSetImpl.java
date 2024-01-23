package org.neatcode;

import java.util.ArrayList;
import java.util.HashMap;

public class RandomSetImpl<T> implements RandomSet<T> {
    ArrayList<T> nums;
    HashMap<T, Integer> locs;
    java.util.Random rand;
    /** Initialize your data structure here. */
    public RandomSetImpl() {
        rand = new java.util.Random();
        nums = new ArrayList();
        locs = new HashMap<T, Integer>();
    }

    public boolean insert(T val) {
        boolean contain = locs.containsKey(val);
        if ( contain ) return false;
        locs.put( val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean delete(T val) {
        boolean contain = locs.containsKey(val);
        if ( ! contain ) return false;
        int loc = locs.get(val);
        if (loc < nums.size() - 1 ) { // not the last one than swap the last one with this val
            T lastone = nums.get(nums.size() - 1 );
            nums.set( loc , lastone );
            locs.put(lastone, loc);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    public T getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }
}
