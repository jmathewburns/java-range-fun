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

import java.util.Objects;
import java.util.PrimitiveIterator;

public class RangeBuilder implements Iterable<Integer> {
    private int start;
    private int end;
    private int step;

    public RangeBuilder() {
        /* Suppresses default constructor. */
    }

    public RangeBuilder from(int start) {
        this.start = start;

        return this;
    }

    public RangeBuilder to(int end) {
        this.end = end;

        return this;
    }

    public RangeBuilder step(int step) {
        this.step = step;

        return this;
    }

    public RangeBuilder reverse() {
        int temp = start;
        start = end;
        end = temp;

        return this;
    }

    public Iterable<Integer> build() {
        return new RangeImpl(start, end, step);
    }

    @Override
    public PrimitiveIterator.OfInt iterator() {
        return (PrimitiveIterator.OfInt) build().iterator();
    }

    @Override
    public String toString() {
        return String.format("RangeBuilder{start=%s, end=%s, step=%s}",
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

        RangeBuilder other = (RangeBuilder) o;

        return start == other.start &&
                end == other.end &&
                step == other.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, step);
    }
}
