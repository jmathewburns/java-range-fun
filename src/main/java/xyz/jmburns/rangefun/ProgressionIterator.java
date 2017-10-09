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
import java.util.NoSuchElementException;
import java.util.Objects;

class ProgressionIterator implements Iterator<Integer>, Comparable<ProgressionIterator> {
    private final Bounds bounds;
    private final int step;
    private final int end;
    private int current;

    private ProgressionIterator(int start, int end, int step, Bounds bounds) {
        this.bounds = bounds;
        this.current = start;
        this.step = step;
        this.end = end;
    }

    static ProgressionIterator ascending(int start, int end, int step) {
        //invariants: end >= start, step > 0
        return new ProgressionIterator(start, end, step, Bounds.UPPER);
    }

    static ProgressionIterator descending(int start, int end, int step) {
        //invariants: end <= start, step > 0
        return new ProgressionIterator(start, end, -step, Bounds.LOWER);
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            int old = current;
            current = current + step;
            return old;
        } else {
            throw new NoSuchElementException(
                    "the end of the progression has been reached"
            );
        }
    }

    @Override
    public boolean hasNext() {
        return !bounds.crossed(current, end);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgressionIterator other = (ProgressionIterator) o;
        return step == other.step &&
               end == other.end &&
               current == other.current &&
               bounds == other.bounds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bounds, step, end, current);
    }

    @Override
    public String toString() {
        return String.format(
                "ProgressionIterator{bounds=%s, step=%s, end=%s, current=%s}",
                bounds, step, end, current
        );
    }

    @Override
    public int compareTo(ProgressionIterator other) {
        if (this == other) return 0;
        int result =  bounds.compareTo(other.bounds);
        if (result == 0) { result = Integer.compare(step, other.step); }
        if (result == 0) { result = Integer.compare(end, other.end); }
        if (result == 0) { result = Integer.compare(current, other.current); }
        return result;
    }
}
