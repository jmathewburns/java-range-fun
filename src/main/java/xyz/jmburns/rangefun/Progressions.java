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
import java.util.Objects;

/**
 * This class forms most of the public API for this library, and is intended to be the point
 * of creation for all {@link xyz.jmburns.rangefun.Progression} outside of this library. '
 *
 * Note that all of the methods contained in this class are intended to be statically imported
 * before use, for enhanced readability. For instance, {@code for (int i : range(1, 5))} is
 * far better to read than {@code for (int i : Progressions.range(1, 5))}, and should thus be
 * preferred.
 */
public class Progressions {
    private static final int RANGE_STEP = 1;

    private Progressions() {
        throw new AssertionError(
                "Progressions is not instantiable"
        );
    }

    /**
     * Creates a new {@link Progression} instance with the given starting, ending, and stepping
     * values.
     *
     * @param start the first integer in the progression, inclusive
     * @param end the point which no integer in the progression will go over, but may or may not be equal to
     * @param step the amount by which each integer in the progression will differ from the previous one.
     *             Cannot be zero
     * @return a new Progression representing the given start, end, and step values
     * @throws IllegalArgumentException if step == 0
     */
    public static Progression progression(int start, int end, int step) {
        if (step == 0) { throw new IllegalArgumentException("step cannot be zero"); }
        return new Progression(start, end, step);
    }

    /**
     * Creates a new {@link Progression} instance that behaves like a range of integers, with the given
     * starting and ending values.
     *
     * @implNote This method behaves exactly as if calling {@code Progressions.progression(start, end, 1)}.
     *
     * @param start the first integer in the progression, inclusive
     * @param end the last integer in the progression, inclusive
     * @return a new Progression representing the given start and end values
     * @see Progressions#progression(int, int, int)
     */
    public static Progression range(int start, int end) {
        return progression(start, end, RANGE_STEP);
    }

    /**
     * Creates a new {@link Progression} instance that behaves like a range of integers, from 0 to the given
     * ending value, exclusive. This method is intended to be used when looping a certain number of times.
     *
     * @implNote This method behaves exactly as if calling {@code Progressions.range(0, to - 1)}.
     *
     * @param to the last integer in the progression, exclusive
     * @return a new Progression representing the given end value
     * @see Progressions#range(int, int)
     */
    public static Progression count(int to) {
        return range(0, to - 1);
    }

    /**
     * Creates a new {@link Progression} instance that behaves like a range of all valid indices
     * of the given array.
     *
     * @implNote This method behaves exactly as if calling {@code Progressions.count(array.length)}
     * when passed valid arguments.
     *
     * @param array the array for which to generate indices
     * @return a new Progression representing all valid indices of the given array
     * @see Progressions#count(int)
     * @throws NullPointerException if the given object is null
     * @throws IllegalArgumentException if the given object is not an array
     */
    public static Progression indices(Object array) {
        Objects.requireNonNull(array);
        int length = Array.getLength(array);

        return count(length);
    }
}