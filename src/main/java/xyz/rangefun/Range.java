package xyz.rangefun;

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

    public static RangeBuilder of(int start) {
        return new RangeBuilder()
                .from(start)
                .step(DEFAULT_STEP);
    }
    
    public static RangeBuilder of(Object[] array) {
        return new RangeBuilder()
                .from(0)
                .to(array.length - 1)
                .step(DEFAULT_STEP);
    }

    public static RangeBuilder of(int[] array) {
        return new RangeBuilder()
                .from(0)
                .to(array.length - 1)
                .step(DEFAULT_STEP);
    }

    public static RangeBuilder of(long[] array) {
        return new RangeBuilder()
                .from(0)
                .to(array.length - 1)
                .step(DEFAULT_STEP);
    }

    public static RangeBuilder of(float[] array) {
        return new RangeBuilder()
                .from(0)
                .to(array.length - 1)
                .step(DEFAULT_STEP);
    }

    public static RangeBuilder of(double[] array) {
        return new RangeBuilder()
                .from(0)
                .to(array.length - 1)
                .step(DEFAULT_STEP);
    }

    public static RangeBuilder of(byte[] array) {
        return new RangeBuilder()
                .from(0)
                .to(array.length - 1)
                .step(DEFAULT_STEP);
    }

    public static RangeBuilder of(char[] array) {
        return new RangeBuilder()
                .from(0)
                .to(array.length - 1)
                .step(DEFAULT_STEP);
    }

    public static RangeBuilder of(short[] array) {
        return new RangeBuilder()
                .from(0)
                .to(array.length - 1)
                .step(DEFAULT_STEP);
    }
    
    public static Iterable<Integer> range(int start, int end, int step) {
        return of(start, end, step);
    }

    public static Iterable<Integer> range(int start, int end) {
        return of(start, end);
    }

    public static Iterable<Integer> range(int start) {
        return of(start);
    }

    public static RangeBuilder range(Object[] array) {
        return of(array);
    }

    public static RangeBuilder range(int[] array) {
        return of(array);
    }

    public static RangeBuilder range(long[] array) {
        return of(array);
    }

    public static RangeBuilder range(float[] array) {
        return of(array);
    }

    public static RangeBuilder range(double[] array) {
        return of(array);
    }

    public static RangeBuilder range(byte[] array) {
        return of(array);
    }

    public static RangeBuilder range(short[] array) {
        return of(array);
    }

    public static RangeBuilder range(char[] array) {
        return of(array);
    }
}
