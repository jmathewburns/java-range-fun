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

import java.util.Objects;
import java.util.PrimitiveIterator;

/**
 * This class represents the actual, immutable range of integers built by {@code RangeBuilder}
 * and the {@code xyz.jmburns.rangefun.Range} API.
 */
final class RangeInternal implements Iterable<Integer> {

    private final int start;
    private final int end;
    private final int step;
    private final boolean backwards;

    RangeInternal(int start, int end, int step) {
        this(start, end, step, false);
    }

    RangeInternal(int start, int end, int step, boolean halfClosed) {
        this.start = start;
        this.step = step;
        this.backwards = (start > end);

        int adjustedEnd = end;
        if (halfClosed) {
            adjustedEnd = backwards ? end + 1: end - 1;
        }
        this.end = adjustedEnd;
    }

    /**
     * Returns a new {@code Iterator} for this range.
     *
     * @implNote If a backwards iteration is detected, the returned Iterator
     *           is an instance of {@code ReverseRangeIterator}, otherwise
     *           it is a {@code SimpleRangeIterator}.
     *
     * @return A new {@code Iterator} using the values passed
     *         to this range during creation.
     */
    @Override
    public PrimitiveIterator.OfInt iterator() {
        if (backwards) {
            return new ReverseRangeIterator(start, end, step);
        }
        return new SimpleRangeIterator(start, end, step);
    }

    @Override
    public String toString() {
        return String.format("RangeInternal{start=%s, end=%s, step=%s}",
                             start, end, step);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RangeInternal other = (RangeInternal) o;

        return start == other.start &&
                end == other.end &&
                step == other.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, step);
    }
}