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

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static xyz.jmburns.rangefun.RangeTestHelper.rangeReturnsExpectedInts;

public class RangeBuilderTest {
    @Test
    public void shouldCreateRangeBuilder() {
        new RangeBuilder();
    }

    @Test
    public void shouldCreateEquivalentRangeImpl() {
        int start = 0;
        int end = 8;
        int step = 4;

        RangeImpl expected = new RangeImpl(start, end, step);
        RangeImpl actual = (RangeImpl) new RangeBuilder()
                                            .from(start)
                                            .to(end)
                                            .step(step)
                                            .build();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateReversedRange() {
        int[] expectedIntegers = { 8, 6, 4, 2, 0, };
        Iterable<Integer> range = new RangeBuilder()
                                        .from(0)
                                        .to(8)
                                        .step(2)
                                        .reverse()
                                        .build();

        rangeReturnsExpectedInts(range, expectedIntegers);
    }

    @Test
    public void shouldImplicitlyCreateEquivalentRangeIterators() {
        RangeBuilder builder = new RangeBuilder()
                                    .from(1)
                                    .to(2)
                                    .step(3);

        assertEquals(builder.build().iterator(),
                     builder.iterator());
    }
}
