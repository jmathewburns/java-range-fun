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
package xyz.rangefun;

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
