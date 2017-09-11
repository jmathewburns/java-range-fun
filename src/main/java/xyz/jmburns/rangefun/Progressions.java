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

import java.lang.reflect.Array;

public class Progressions {
    private static final int DEFAULT_STEP = 1;

    private Progressions() {
        throw new AssertionError(
                "Progressions is not instantiable"
        );
    }

    public static Iterable<Integer> of(int start, int end, int step) {
        return new RangeInternal(start, end, step);
    }

    public static Iterable<Integer> of(int start, int end) {
        return of(start, end, DEFAULT_STEP);
    }

    public static RangeBuilder of(int start) {
        return new RangeBuilder()
                .from(start)
                .step(DEFAULT_STEP);
    }

    public static RangeBuilder of(Object array) {
        int length = Array.getLength(array);
       
        return new RangeBuilder()
                .from(0)
                .to(length - 1)
                .step(DEFAULT_STEP);
    }

    public static RangeBuilder to(int end) {
       return new RangeBuilder()
               .from(1)
               .to(end)
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

    public static RangeBuilder range(Object array) {
        return of(array);
    }
}