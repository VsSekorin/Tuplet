package com.vssekorin.tuplet;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.*;

public class Tuple6Test {

    private final String item1 = "First _1";
    private final Integer item2 = 16;
    private final Boolean item3 = true;
    private final Character item4 = 'r';
    private final String item5 = "item";
    private final Long item6 = 3L;
    private final Tuple6<String, Integer, Boolean, Character, String, Long> tuple =
        new Tuple6<>(item1, item2, item3, item4, item5, item6);

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
    public void _4() {
        assertEquals(item4, tuple._4());
    }

    @Test
    public void _5() {
        assertEquals(item5, tuple._5());
    }

    @Test
    public void _6() {
        assertEquals(item6, tuple._6());
    }

    @Test
    public void reverse() {
        final Tuple6<Long, String, Character, Boolean, Integer, String> expected =
            new Tuple6<>(item6, item5, item4, item3, item2, item1);
        assertEquals(expected, tuple.reverse());
    }

    @Test
    public void map_1() {
        final Tuple6<Integer, Integer, Boolean, Character, String, Long> expected =
            new Tuple6<>(item1.length(), item2, item3, item4, item5, item6);
        assertEquals(expected, tuple.map_1(String::length));
    }

    @Test
    public void map_2() {
        final Function<Integer, Integer> inc = i -> i + 1;
        final Tuple6<String, Integer, Boolean, Character, String, Long> expected =
            new Tuple6<>(item1, item2 + 1, item3, item4, item5, item6);
        assertEquals(expected, tuple.map_2(inc));
    }

    @Test
    public void map_3() {
        final Function<Boolean, Boolean> not = b -> !b;
        final Tuple6<String, Integer, Boolean, Character, String, Long> expected =
            new Tuple6<>(item1, item2, !item3, item4, item5, item6);
        assertEquals(expected, tuple.map_3(not));
    }

    @Test
    public void map_4() {
        final Function<Character, String> func = c -> "qwe" + c;
        final Tuple6<String, Integer, Boolean, String, String, Long> expected =
            new Tuple6<>(item1, item2, item3, "qwer", item5, item6);
        assertEquals(expected, tuple.map_4(func));
    }

    @Test
    public void map_5() {
        final Tuple6<String, Integer, Boolean, Character, String, Long> expected =
            new Tuple6<>(item1, item2, item3, item4, "ITEM", item6);
        assertEquals(expected, tuple.map_5(String::toUpperCase));
    }

    @Test
    public void map_6() {
        final Tuple6<String, Integer, Boolean, Character, String, String> expected =
            new Tuple6<>(item1, item2, item3, item4, item5, "3");
        assertEquals(expected, tuple.map_6(Object::toString));
    }

    @Test
    public void containsCorrect() {
        assertTrue(tuple.contains("First _1"));
        assertTrue(tuple.contains(16));
        assertTrue(tuple.contains(true));
        assertTrue(tuple.contains('r'));
        assertTrue(tuple.contains("item"));
        assertTrue(tuple.contains(3L));
    }

    @Test
    public void containsFalse() {
        assertFalse(tuple.contains('a'));
    }

    @Test
    public void toArray() {
        final Object[] expected = {item1, item2, item3, item4, item5, item6};
        assertArrayEquals(expected, tuple.toArray());
    }

    @Test
    public void toList() {
        final List<Object> expected = Arrays.asList(item1, item2, item3, item4, item5, item6);
        assertEquals(expected, tuple.toList());
    }
}
