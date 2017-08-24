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
 * The other half of the public API, this class provides a 'fluent' way to create
 * and customise ranges.
 */
public class RangeBuilder implements Iterable<Integer> {
    private int start;
    private int end;
    private int step;
    private boolean halfClosed = false;


    /**
     * Creates a new {@code RangeBuilder} with 'from', 'to', and 'step' value of 0.
     */
    public RangeBuilder() {
        /* Suppresses default constructor. */
    }

    /**
     * Sets the beginning of the range to be built.
     *
     * @param start The beginning of the range to be built, and the first Integer to
     *              be returned by the built range's {@code Iterator}.
     * @return The same {@code RangeBuilder} object on which this method was called.
     */
    public RangeBuilder from(int start) {
        this.start = start;

        return this;
    }

    /**
     * Sets the end of the range to be built.
     *
     * @param end The end of the range. This value may or may not be returned by the built
     *            range's {@code Iterator} (depending on the chosen 'step' value), but it
     *            is guaranteed to never go beyond this value.
     * @return The same {@code RangeBuilder} object on which this method was called.
     */
    public RangeBuilder to(int end) {
        this.end = end;
        this.halfClosed = false;

        return this;
    }

    /**
     * Sets the end of the half-closed range to be built. The given value will NOT be returned
     * by the built range's {@code Iterator}.
     *
     * @param end The end of the range. This value will not be returned by the built
     *            range's {@code Iterator}.
     * @return The same {@code RangeBuilder} object on which this method was called.
     * @since 0.1.2
     */
    public RangeBuilder until(int end) {
        this.end = end;
        this.halfClosed = true;

        return this;
    }

    /**
     * Sets the 'step' of the range to be built.
     *
     * Note that if intending to build a descending range (where the 'from' value is greater than the
     * 'to' value), the value of {@code step} need not be negative, and a negative or positive
     * {@code step} will have no impact on the function of the range, either way.
     *
     * @param step The value by which the value returned by the {@code Iterable}'s {@code Iterator}
     *             will change upon each successive call to {@code next()}.
     * @return The same {@code RangeBuilder} object on which this method was called.
     */
    public RangeBuilder step(int step) {
        this.step = step;

        return this;
    }

    /**
     * Reverses the range to be built, so that its {@code Iterator} will iterate from the given 'to'
     * value, to the given 'from' value.
     *
     * @implNote Successive calls to {@code reverse()} will cancel each other out, so calling
     *           {@code rangeBuilder.reverse().reverse()} will be the same as never calling it,
     *           and calling {@code rangeBuilder.reverse().reverse().reverse()} will be the same
     *           as only calling it once, and so on.
     *
     * @return The same {@code RangeBuilder} object on which this method was called.
     */
    public RangeBuilder reverse() {
        int temp = start;
        start = end;
        end = temp;

        return this;
    }

    /**
     * Builds the range, whose {@code Iterator} will generate {@code Integer}
     * values as set by calls to {@code RangeBuilder}'s methods.
     *
     * Be aware that there is no functionality in place to ensure that the 'step' value is not
     * 0, and, if it is, the built range's {@code Iterator} might iterate indefinitely.
     *
     * @return A new {@code Iterable<Integer>}, whose {@code Iterator} will generate {@code Integer}
     * values as set by calls to {@code RangeBuilder}'s methods.
     */
    public Iterable<Integer> build() {
        return new RangeInternal(start, end, step, halfClosed);
    }

    /**
     * Returns an {@code Iterator} for a range built using the current values set
     * for this {@code RangeBuilder}.
     *
     * @implNote This method behaves exactly as if calling {@code build().iterator()} on this
     *           {@code RangeBuilder}, and is included for convenience, when storing the built
     *           range is not important.
     *
     * Be aware that there is no functionality in place to ensure that the 'step' value is not
     * 0, and, if it is, the built range's {@code Iterator} might iterate indefinitely.
     *
     * @return A new {@code Iterator} for a range built using the current values set
     *         for this {@code RangeBuilder}.
     */
    @Override
    public PrimitiveIterator.OfInt iterator() {
        return (PrimitiveIterator.OfInt) build().iterator();
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return String.format("RangeBuilder{start=%s, end=%s, step=%s}",
                            start, end, step);
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RangeBuilder other = (RangeBuilder) o;

        return start == other.start &&
                end == other.end &&
                step == other.step;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(start, end, step);
    }
}
