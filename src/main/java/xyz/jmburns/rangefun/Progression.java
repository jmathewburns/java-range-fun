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

import java.util.Iterator;
import java.util.Objects;

/**
 * This class represents an progression of integers, as built by the
 * {@link xyz.jmburns.rangefun.Progressions} API.
 *
 * The class is also fully suitable for use in Map and Collection instances,
 * since it provides well-behaved implementations of {@code equals},
 * {@code hashCode}, and {@code compareTo}. It is also designed to be
 * completely immutable.
 */
public final class Progression implements Iterable<Integer>, Comparable<Progression> {
    private final int low;
    private final int high;
    private final int step;
    private final boolean backwards;

    private int length = -1;

    Progression(int start, int end, int step) {
        this.backwards = (start > end);

        this.low = Math.min(start, end);
        this.high = Math.max(start, end);
        this.step = Math.abs(step);
    }

    /**
     * Creates a new {@code Progression} instance whose starting value is this progression's ending value,
     * and whose ending value is this progression's starting value. For example,
     * {@code progression(1, 5, 1).reverse().equals(progression(5, 1, 1)}
     * will evaluate to {@code true}.
     *
     * This method is intended to be used to easily iterate backwards over an array.
     *
     * @return a new Progression instance, created from this one, but with values swapped so that the
     *         progression is iterated backwards.
     */
    public Progression reverse() {
        return new Progression(high, low, step);
    }

    /**
     * Determines whether or not iteration over this progression would produce the given integer.
     *
     * For example, {@code Progressions.progression(1, 5, 2).contains(3)} would evaluate to {@code true},
     * while {@code Progressions.range(7, 5).contains(4)} would evaluate to {@code false}.
     *
     * @implNote Progressions are lazily-evaluated, so this method is guaranteed to run in constant time.
     *
     * @param integer the integer whose range is to be evaluated
     * @return true if iteration over this progression would produce the given integer, false otherwise
     * @see xyz.jmburns.rangefun.Progressions#progression(int, int, int)
     * @see xyz.jmburns.rangefun.Progressions#range(int, int)
     */
    public boolean contains(int integer) {
        return (integer > low || integer < high) && 
               Math.floorMod(integer - low, step) == 0;
    }

    /**
     * Returns the integer at the specified index in the progression. Indexing begins at zero.
     *
     * For example, {@code Progressions.range(5, 9).get(2)} would evaluate to 7, since 7 is the third
     * (counting from zero) integer in the range of 5, 6, 7, 8, 9.
     *
     * @implNote Progressions are lazily-evaluated, so repeated calls to {@code get(int)} may not
     * provide optimal performance. In those cases, it might be worth calling {@code toArray()}
     * and accessing the returned array by index instead, since it would produce the same results, without
     * unnecessary recalculation.
     *
     * @param index the index to look up
     * @return the integer at the specified index in the progression
     * @see Progression#toArray()
     * @see xyz.jmburns.rangefun.Progressions#range(int, int)
     * @throws IndexOutOfBoundsException if the given index is negative or greater than or equal to {@link #length()}
     */
    public int get(int index) {
        Objects.checkIndex(index, length());
        return calculateForIndex(index);
    }

    private int calculateForIndex(int index) {
        if (backwards) {
            return high - (step * index);
        }
        return low + (step * index);
    }

    /**
     * Returns a new {@code Integer} array filled with all the integers in this progression, in iteration order.
     *
     * For example, {@code Progressions.range(1, 5).toArray()} will evaluate to an array containing the
     * integers 1, 2, 3, 4, 5.
     *
     * @return a new Integer array filled by all the integers in this progression
     * @see xyz.jmburns.rangefun.Progressions#range(int, int)
     */
    public Integer[] toArray() {
        int length = length();
        Integer[] array = new Integer[length];

        int index = 0;
        for (Integer integer : this) {
            array[index] = integer;
            index++;
        }

        return array;
    }

    /**
     * Calculates the length of this progression, with the step value taken into account.
     * For example, {@code progression(0, 6, 2).length()} will evaluate to 3.
     *
     * @return the length of the progression
     */
    public int length() {
        if (length == -1) {
            length = ((high - low) / step) + 1;
        }
        return length;
    }

    /**
     * @return a new Iterator over this progression
     */
    @Override
    public Iterator<Integer> iterator() {
        if (backwards) {
            return new ReverseProgressionIterator(high, low, step);
        }
        return new SimpleProgressionIterator(low, high, step);
    }

    @Override
    public String toString() {
        return String.format(
                "Progression{low=%s, high=%s, step=%s, backwards=%s}",
                low, high, step, backwards
        );
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Progression other = (Progression) object;

        return low == other.low && 
               high == other.high &&
               step == other.step &&
               backwards == other.backwards;
    }

    @Override
    public int hashCode() {
        return Objects.hash(low, high, step, backwards);
    }

    @Override
    public int compareTo(Progression other) {
        int result = Integer.compare(low, other.low);
        if (result == 0) { result = Integer.compare(high, other.high); }
        if (result == 0) { result = Integer.compare(step, other.step); }
        if (result == 0) { result = Boolean.compare(backwards, other.backwards); }
        return result;
    }
}