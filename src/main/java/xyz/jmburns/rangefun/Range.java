/*
 * Copyright 2017 Jacques Burns
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the
 * Software, and to permit persons to whom the Software is furnished to do so, subject
 * to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package xyz.jmburns.rangefun;

/**
 * This class has no function on its own, but, along with {@code RangeBuilder}, serves
 * as the public API for the Range Fun(ctions) library, and is intended to be used in
 * most cases where ranges are created.
 */
public class Range {
    private static final int DEFAULT_STEP = 1;

    private Range() {
        throw new AssertionError(
                "Range is not instantiable"
        );
    }

    /**
     * Returns a new {@code Iterable<Integer>} set to provide a range for the
     * given values.
     *
     * Note that if intending to get a descending range (where {@code start} is greater than {@code end}), the
     * value of {@code step} need not be negative.
     *
     * @param start The beginning of the range, the first Integer to be returned by the
     *        {@code Iterable}'s {@code Iterator}.
     * @param end The end of the range. This value may or may not be returned by the
     *        {@code Iterable}'s {@code Iterator} (depending on the chosen step value),
     *        but it is guaranteed to never go beyond this value.
     * @param step The value by which the value returned by the {@code Iterable}'s {@code Iterator}
     *             will change upon each successive call to {@code next()}.
     * @return A new {@code Iterable<Integer>} set to provide a range for the
     *         given values.
     */
    public static Iterable<Integer> of(int start, int end, int step) {
        return new RangeImpl(start, end, step);
    }

    /**
     * Returns a new {@code Iterable<Integer>} set to provide a range for the
     * given {@code start} and {@code end} values, with a default {@code step} value of 1.
     *
     * @param start The beginning of the range, the first Integer to be returned by the
     *        {@code Iterable}'s {@code Iterator}.
     * @param end The end of the range. Since a default {@code step} value of one is used, this value is 
     *        guaranteed to be returned by the {@code Iterable}'s {@code Iterator}.
     * @return A new {@code Iterable<Integer>} set to provide a range for the
     *         given values.
     * @see Range#of(int, int, int)
     */
    public static Iterable<Integer> of(int start, int end) {
        return of(start, end, DEFAULT_STEP);
    }

    /**
     * Returns a new {@code RangeBuilder} with a 'from' value of {@code start}, and a default step of 1.
     *
     * This method is intended to serve as a natural entry point into the 'fluent' API provided by
     * {@code RangeBuilder}.
     *
     * @param start The supposed beginning of the range, passed to RangeBuilder. Can be
     *        overwritten at a later time through the {@code RangeBuilder} object.
     * @return A new {@code RangeBuilder} with a 'from' value of {@code start} and a default step of 1.
     * @see xyz.jmburns.rangefun.RangeBuilder
     */
    public static RangeBuilder of(int start) {
        return new RangeBuilder()
                .from(start)
                .step(DEFAULT_STEP);
    }

    /**
     * Returns a new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @implNote This method behaves exactly as if chaining {@code Range.of(0).to(array.length - 1).step(1)}
     *           and is intended to serve as a convenience method. Also, it returns a {@code RangeBuilder}
     *           to facilitate easy backwards iteration of the array.
     *
     * @param array The array from which to derive bounds for the returned {@code RangeBuilder}
     * @return A new {@code RangeBuilder} set to build a range over the length of the array.
     */
    public static RangeBuilder of(Object[] array) {
        return new RangeBuilder()
                .from(0)
                .to(array.length - 1)
                .step(DEFAULT_STEP);
    }

    /**
     * Returns a new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @implNote This method behaves exactly as if chaining {@code Range.of(0).to(array.length - 1).step(1)}
     *           and is intended to serve as a convenience method. Also, it returns a {@code RangeBuilder}
     *           to facilitate easy backwards iteration of the array.
     *
     * @param array The array from which to derive bounds for the returned {@code RangeBuilder}
     * @return A new {@code RangeBuilder} set to build a range over the length of the array.
     */
    public static RangeBuilder of(int[] array) {
        return new RangeBuilder()
                .from(0)
                .to(array.length - 1)
                .step(DEFAULT_STEP);
    }

    /**
     * Returns a new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @implNote This method behaves exactly as if chaining {@code Range.of(0).to(array.length - 1).step(1)}
     *           and is intended to serve as a convenience method. Also, it returns a {@code RangeBuilder}
     *           to facilitate easy backwards iteration of the array.
     *
     * @param array The array from which to derive bounds for the returned {@code RangeBuilder}
     * @return A new {@code RangeBuilder} set to build a range over the length of the array.
     */
    public static RangeBuilder of(long[] array) {
        return new RangeBuilder()
                .from(0)
                .to(array.length - 1)
                .step(DEFAULT_STEP);
    }

    /**
     * Returns a new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @implNote This method behaves exactly as if chaining {@code Range.of(0).to(array.length - 1).step(1)}
     *           and is intended to serve as a convenience method. Also, it returns a {@code RangeBuilder}
     *           to facilitate easy backwards iteration of the array.
     *
     * @param array The array from which to derive bounds for the returned {@code RangeBuilder}
     * @return A new {@code RangeBuilder} set to build a range over the length of the array.
     */
    public static RangeBuilder of(float[] array) {
        return new RangeBuilder()
                .from(0)
                .to(array.length - 1)
                .step(DEFAULT_STEP);
    }

    /**
     * Returns a new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @implNote This method behaves exactly as if chaining {@code Range.of(0).to(array.length - 1).step(1)}
     *           and is intended to serve as a convenience method. Also, it returns a {@code RangeBuilder}
     *           to facilitate easy backwards iteration of the array.
     *
     * @param array The array from which to derive bounds for the returned {@code RangeBuilder}
     * @return A new {@code RangeBuilder} set to build a range over the length of the array.
     */
    public static RangeBuilder of(double[] array) {
        return new RangeBuilder()
                .from(0)
                .to(array.length - 1)
                .step(DEFAULT_STEP);
    }

    /**
     * Returns a new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @implNote This method behaves exactly as if chaining {@code Range.of(0).to(array.length - 1).step(1)}
     *           and is intended to serve as a convenience method. Also, it returns a {@code RangeBuilder}
     *           to facilitate easy backwards iteration of the array.
     *
     * @param array The array from which to derive bounds for the returned {@code RangeBuilder}
     * @return A new {@code RangeBuilder} set to build a range over the length of the array.
     */
    public static RangeBuilder of(byte[] array) {
        return new RangeBuilder()
                .from(0)
                .to(array.length - 1)
                .step(DEFAULT_STEP);
    }

    /**
     * Returns a new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @implNote This method behaves exactly as if chaining {@code Range.of(0).to(array.length - 1).step(1)}
     *           and is intended to serve as a convenience method. Also, it returns a {@code RangeBuilder}
     *           to facilitate easy backwards iteration of the array.
     *
     * @param array The array from which to derive bounds for the returned {@code RangeBuilder}
     * @return A new {@code RangeBuilder} set to build a range over the length of the array.
     */
    public static RangeBuilder of(char[] array) {
        return new RangeBuilder()
                .from(0)
                .to(array.length - 1)
                .step(DEFAULT_STEP);
    }

    /**
     * Returns a new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @implNote This method behaves exactly as if chaining {@code Range.of(0).to(array.length - 1).step(1)}
     *           and is intended to serve as a convenience method. Also, it returns a {@code RangeBuilder}
     *           to facilitate easy backwards iteration of the array.
     *
     * @param array The array from which to derive bounds for the returned {@code RangeBuilder}
     * @return A new {@code RangeBuilder} set to build a range over the length of the array.
     */
    public static RangeBuilder of(short[] array) {
        return new RangeBuilder()
                .from(0)
                .to(array.length - 1)
                .step(DEFAULT_STEP);
    }

    /**
     * Returns a new {@code Iterable<Integer>} set to provide a range for the
     * given values.
     *
     * Note that if intending to get a descending range (where {@code start} is greater than {@code end}), the
     * value of {@code step} need not be negative.
     *
     * @implNote This method behaves exactly as if calling {@code Range.of(start, end, step)} and us
     *           intended to serve as a convenience method to preserve readability when {@code Range}
     *           is statically imported.
     *
     * @param start The beginning of the range, the first Integer to be returned by the
     *        {@code Iterable}'s {@code Iterator}.
     * @param end The end of the range. This value may or may not be returned by the
     *        {@code Iterable}'s {@code Iterator} (depending on the chosen step value),
     *        but it is guaranteed to never go beyond this value.
     * @param step The value by which the value returned by the {@code Iterable}'s {@code Iterator}
     *        will change upon each successive call to {@code next()}.
     * @return A new {@code Iterable<Integer>} set to provide a range for the
     *         given values.
     *
     * @see Range#of(int, int, int)
     */
    public static Iterable<Integer> range(int start, int end, int step) {
        return of(start, end, step);
    }

    /**
     * Returns a new {@code Iterable<Integer>} set to provide a range for the
     * given {@code start} and {@code end} values, with a default {@code step} value of 1.
     *
     * @implNote This method behaves exactly as if calling {@code Range.of(start, end)} and us
     *           intended to serve as a convenience method to preserve readability when {@code Range}
     *           is statically imported.
     *
     * @param start The beginning of the range, the first Integer to be returned by the
     *        {@code Iterable}'s {@code Iterator}.
     * @param end The end of the range. Since a default {@code step} value of one is used, this value 
     *        is guaranteed to be returned by the {@code Iterable}'s {@code Iterator}.
     * @return A new {@code Iterable<Integer>} set to provide a range for the
     *         given values.
     * @see Range#of(int, int, int)
     * @see Range#of(int, int)
     */
    public static Iterable<Integer> range(int start, int end) {
        return of(start, end);
    }

    /**
     * Returns a new {@code RangeBuilder} with a 'from' value of {@code start}, and a default step of 1.
     *
     * This method is intended to serve as a natural entry point into the 'fluent' API provided by
     * {@code RangeBuilder}.
     *
     * @implNote This method behaves exactly as if calling {@code Range.of(start)} and us
     *           intended to serve as a convenience method to preserve readability when {@code Range}
     *           is statically imported.
     *
     * @param start The supposed beginning of the range, passed to RangeBuilder. Can be
     *        overwritten at a later time through the {@code RangeBuilder} object.
     * @return A new {@code RangeBuilder} with a 'from' value of {@code start} and a default step of 1.
     * @see xyz.jmburns.rangefun.RangeBuilder
     * @see Range#of(int)
     */
    public static Iterable<Integer> range(int start) {
        return of(start);
    }

    /**
     * Returns a new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @implNote This method behaves exactly as if chaining {@code Range.of(0).to(array.length - 1).step(1)}
     *           and is intended to serve as a convenience method. Also, it returns a {@code RangeBuilder}
     *           to facilitate easy backwards iteration of the array.
     *
     * @implNote This method also behaves exactly as if calling {@code Range.of(array)} and us
     *           intended to serve as a convenience method to preserve readability when {@code Range}
     *           is statically imported.
     *
     * @param array The array from which to derive bounds for the returned {@code RangeBuilder}
     * @return A new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @see Range#of(Object[])
     */
    public static RangeBuilder range(Object[] array) {
        return of(array);
    }

    /**
     * Returns a new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @implNote This method behaves exactly as if chaining {@code Range.of(0).to(array.length - 1).step(1)}
     *           and is intended to serve as a convenience method. Also, it returns a {@code RangeBuilder}
     *           to facilitate easy backwards iteration of the array.
     *
     * @implNote This method also behaves exactly as if calling {@code Range.of(array)} and us
     *           intended to serve as a convenience method to preserve readability when {@code Range}
     *           is statically imported.
     *
     * @param array The array from which to derive bounds for the returned {@code RangeBuilder}
     * @return A new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @see Range#of(int[])
     */
    public static RangeBuilder range(int[] array) {
        return of(array);
    }

    /**
     * Returns a new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @implNote This method behaves exactly as if chaining {@code Range.of(0).to(array.length - 1).step(1)}
     *           and is intended to serve as a convenience method. Also, it returns a {@code RangeBuilder}
     *           to facilitate easy backwards iteration of the array.
     *
     * @implNote This method also behaves exactly as if calling {@code Range.of(array)} and us
     *           intended to serve as a convenience method to preserve readability when {@code Range}
     *           is statically imported.
     *
     * @param array The array from which to derive bounds for the returned {@code RangeBuilder}
     * @return A new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @see Range#of(long[])
     */
    public static RangeBuilder range(long[] array) {
        return of(array);
    }

    /**
     * Returns a new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @implNote This method behaves exactly as if chaining {@code Range.of(0).to(array.length - 1).step(1)}
     *           and is intended to serve as a convenience method. Also, it returns a {@code RangeBuilder}
     *           to facilitate easy backwards iteration of the array.
     *
     * @implNote This method also behaves exactly as if calling {@code Range.of(array)} and us
     *           intended to serve as a convenience method to preserve readability when {@code Range}
     *           is statically imported.
     *
     * @param array The array from which to derive bounds for the returned {@code RangeBuilder}
     * @return A new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @see Range#of(float[])
     */
    public static RangeBuilder range(float[] array) {
        return of(array);
    }

    /**
     * Returns a new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @implNote This method behaves exactly as if chaining {@code Range.of(0).to(array.length - 1).step(1)}
     *           and is intended to serve as a convenience method. Also, it returns a {@code RangeBuilder}
     *           to facilitate easy backwards iteration of the array.
     *
     * @implNote This method also behaves exactly as if calling {@code Range.of(array)} and us
     *           intended to serve as a convenience method to preserve readability when {@code Range}
     *           is statically imported.
     *
     * @param array The array from which to derive bounds for the returned {@code RangeBuilder}
     * @return A new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @see Range#of(double[])
     */
    public static RangeBuilder range(double[] array) {
        return of(array);
    }

    /**
     * Returns a new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @implNote This method behaves exactly as if chaining {@code Range.of(0).to(array.length - 1).step(1)}
     *           and is intended to serve as a convenience method. Also, it returns a {@code RangeBuilder}
     *           to facilitate easy backwards iteration of the array.
     *
     * @implNote This method also behaves exactly as if calling {@code Range.of(array)} and us
     *           intended to serve as a convenience method to preserve readability when {@code Range}
     *           is statically imported.
     *
     * @param array The array from which to derive bounds for the returned {@code RangeBuilder}
     * @return A new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @see Range#of(byte[])
     */
    public static RangeBuilder range(byte[] array) {
        return of(array);
    }

    /**
     * Returns a new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @implNote This method behaves exactly as if chaining {@code Range.of(0).to(array.length - 1).step(1)}
     *           and is intended to serve as a convenience method. Also, it returns a {@code RangeBuilder}
     *           to facilitate easy backwards iteration of the array.
     *
     * @implNote This method also behaves exactly as if calling {@code Range.of(array)} and us
     *           intended to serve as a convenience method to preserve readability when {@code Range}
     *           is statically imported.
     *
     * @param array The array from which to derive bounds for the returned {@code RangeBuilder}
     * @return A new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @see Range#of(short[])
     */
    public static RangeBuilder range(short[] array) {
        return of(array);
    }

    /**
     * Returns a new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @implNote This method behaves exactly as if chaining {@code Range.of(0).to(array.length - 1).step(1)}
     *           and is intended to serve as a convenience method. Also, it returns a {@code RangeBuilder}
     *           to facilitate easy backwards iteration of the array.
     *
     * @implNote This method also behaves exactly as if calling {@code Range.of(array)} and us
     *           intended to serve as a convenience method to preserve readability when {@code Range}
     *           is statically imported.
     *
     * @param array The array from which to derive bounds for the returned {@code RangeBuilder}
     * @return A new {@code RangeBuilder} set to build a range over the length of the array.
     *
     * @see Range#of(char[])
     */
    public static RangeBuilder range(char[] array) {
        return of(array);
    }
}