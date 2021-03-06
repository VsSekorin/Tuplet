package com.vssekorin.tuplet;

import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;
import static org.junit.Assert.*;

public final class Tuple2Test {

    private final String item1 = "First _1";
    private final Integer item2 = 16;
    private final Tuple2<String, Integer> tuple = new Tuple2<>(item1, item2);

    @Test
    public void _1() {
        assertEquals(item1, tuple._1());
    }

    @Test
    public void _2() {
        assertEquals(item2, tuple._2());
    }

    @Test
    public void containsItemsIsCorrect() {
        assertTrue(tuple.contains(item1));
        assertTrue(tuple.contains(item2));
    }

    @Test
    public void containsFalse() {
        assertFalse(tuple.contains(0));
    }

    @Test
    public void toArray() {
        final Object[] array = tuple.toArray();
        assertEquals(2, array.length);
        assertEquals(item1, array[0]);
        assertEquals(item2, array[1]);
    }

    @Test
    public void toList() {
        final List<Object> list = tuple.toList();
        assertEquals(2, list.size());
        assertEquals(item1, list.get(0));
        assertEquals(item2, list.get(1));
    }

    @Test
    public void toStream() {
        final Stream<Object> stream = tuple.stream();
        assertEquals(2, stream.count());
    }

    @Test
    public void testToString() {
        final String str = tuple.toString();
        assertTrue(str.startsWith("Tuple2("));
        assertTrue(str.contains(item1));
        assertTrue(str.contains(item2.toString()));
        assertTrue(str.endsWith(")"));
    }

    @Test
    public void similarTuplesAreEquals() {
        final Tuple2<String, Integer> other = new Tuple2<>(item1, item2);
        assertEquals(tuple, other);
    }

    @Test
    public void differentTuplesAreNotEquals() {
        final Tuple2<String, Integer> other = new Tuple2<>("Other _1", 0);
        assertNotEquals(tuple, other);
    }

    @Test
    public void reverse() {
        final Tuple2<Integer, String> reversed = tuple.reverse();
        final Tuple2<Integer, String> expected = new Tuple2<>(item2, item1);
        assertEquals(expected, reversed);
    }

    @Test
    public void map1() {
        final Tuple2<Integer, Integer> mapped = tuple.map_1(String::length);
        final Tuple2<Integer, Integer> expected = new Tuple2<>(item1.length(), item2);
        assertEquals(expected, mapped);
    }

    @Test
    public void map2() {
        final Tuple2<String, String> mapped = tuple.map_2(Object::toString);
        final Tuple2<String, String> expected = new Tuple2<>(item1, item2.toString());
        assertEquals(expected, mapped);
    }
}
