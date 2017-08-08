package xyz.cques.rangefun;

/**
 * Created by Jacques on 2017/06/20.
 */
public class Range {
    private static final int DEFAULT_STEP = 1;

    private Range() {
        throw new AssertionError(
                "Range is not instantiable"
        );
    }

    public static Iterable<Integer> of(int start, int end, int step) {
        return new RangeImpl(start, end, step);
    }

    public static Iterable<Integer> of(int start, int end) {
        return of(start, end, DEFAULT_STEP);
    }
}
