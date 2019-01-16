package com.vssekorin.tuplet;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.*;

public class Tuple3Test {

    private final String item1 = "First _1";
    private final Integer item2 = 16;
    private final Boolean item3 = true;
    private final Tuple3<String, Integer, Boolean> tuple = new Tuple3<>(item1, item2, item3);

    @Test
    public void _1() {
        assertEquals(item1, tuple._1());
    }

    @Test
    public void _2() {
        assertEquals(item2, tuple._2());
    }

    @Test
    public void _3() {
        assertEquals(item3, tuple._3());
    }

    @Test
    public void reverse() {
        final Tuple3<Boolean, Integer, String> expected = new Tuple3<>(item3, item2, item1);
        assertEquals(expected, tuple.reverse());
    }

    @Test
    public void map_1() {
        final Tuple3<Integer, Integer, Boolean> expected =
            new Tuple3<>(item1.length(), item2, item3);
        assertEquals(expected, tuple.map_1(String::length));
    }

    @Test
    public void map_2() {
        final Function<Integer, Integer> inc = i -> i + 1;
        final Tuple3<String, Integer, Boolean> expected = new Tuple3<>(item1, item2 + 1, item3);
        assertEquals(expected, tuple.map_2(inc));
    }

    @Test
    public void map_3() {
        final Function<Boolean, Boolean> not = b -> !b;
        final Tuple3<String, Integer, Boolean> expected = new Tuple3<>(item1, item2, !item3);
        assertEquals(expected, tuple.map_3(not));
    }

    @Test
    public void containsCorrect() {
        assertTrue(tuple.contains("First _1"));
        assertTrue(tuple.contains(16));
        assertTrue(tuple.contains(true));
    }

    @Test
    public void containsFalse() {
        assertFalse(tuple.contains('a'));
    }

    @Test
    public void toArray() {
        final Object[] expected = {item1, item2, item3};
        assertArrayEquals(expected, tuple.toArray());
    }

    @Test
    public void toList() {
        final List<Object> expected = Arrays.asList(item1, item2, item3);
        assertEquals(expected, tuple.toList());
    }
}
