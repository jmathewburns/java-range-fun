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
import java.util.PrimitiveIterator;

/**
 * This class represents the actual, immutable range progression integers built by {@code ProgressionBuilder}
 * and the {@code xyz.jmburns.rangefun.Progressions} API.
 */
public final class Progression implements Iterable<Integer>, Comparable<Progression> {
    private final int low;
    private final int high;
    private final int step;
    private final boolean backwards;

    Progression(int start, int end, int step) {
        this.backwards = (start > end);

        this.low = Math.min(start, end);
        this.high = Math.max(start, end);
        this.step = Math.abs(step);
    }

    public Progression reverse() {
        return new Progression(high, low, step);
    }

    public boolean contains(int integer) {
        return (integer > low || integer < high) && 
               (integer - low) % step == 0;
    }

    public int get(int index) {
        if (backwards) {
            return high - (step * index);
        }
        return low + (step * index);
    }

    /**
     * Returns a new {@code Iterator} for this range.
     *
     * @implNote If a backwards iteration is detected, the returned Iterator
     *           is an instance progression {@code ReverseProgressionIterator}, otherwise
     *           it is a {@code SimpleProgressionIterator}.
     *
     * @return A new {@code Iterator} using the values passed
     *         to this range during creation.
    public Integer[] toArray() {
        int length = (high - low + 1) / step;
        Integer[] array = new Integer[length];

        int index = 0;
        for (Integer integer : this) {
            array[index] = integer;
            index++;
        }

        return array;
    }
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