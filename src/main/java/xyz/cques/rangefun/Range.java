package xyz.cques.rangefun;

/**
 * Created by Jacques on 2017/06/20.
 */
public class Range {
    public static Interval of(int low, int high) {
        return (() -> new RangeIterator(low, high));
    }

}
