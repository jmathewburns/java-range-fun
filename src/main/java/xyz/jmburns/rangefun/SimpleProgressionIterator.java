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

class SimpleProgressionIterator implements Iterator<Integer> {
    private final int step;
    private final int end;
    private int current;

    SimpleProgressionIterator(int start, int end, int step) {
        this.current = start;
        this.end = end;
        this.step = step;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            int oldCurrent = current;
            current = current + step;
            return oldCurrent;
        } else {
            throw new NoSuchElementException(
                    "the end of the progression has been reached"
            );
        }
    }

    @Override
    public boolean hasNext() {
        return current <= end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SimpleProgressionIterator other = (SimpleProgressionIterator) o;

        return step == other.step &&
               end == other.end &&
               current == other.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(step, end, current);
    }

    @Override
    public String toString() {
        return String.format(
                "SimpleProgressionIterator{step=%s, end=%s, current=%s}",
                step, end, current
        );
    }
}
