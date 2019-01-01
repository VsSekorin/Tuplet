package com.vssekorin.tuplet;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.Test;
import static org.junit.Assert.*;

public final class Tuple1Test {

    private final String item = "My _1";
    private final Tuple1<String> tuple = new Tuple1<>(item);

    @Test
    public void _1() {
        assertEquals(item, tuple._1());
    }

    @Test
    public void containsTrue() {
        assertTrue(tuple.contains(item));
    }

    @Test
    public void containsFalse() {
        assertFalse(tuple.contains(6));
    }

    @Test
    public void toOptionalWithValue() {
        final Optional<String> optional = tuple.toOptional();
        assertTrue(optional.isPresent());
        assertEquals(item, optional.get());
    }

    @Test
    public void toOptionalWithoutValue() {
        final Tuple1<String> empty = new Tuple1<>(null);
        final Optional<String> optional = empty.toOptional();
        assertFalse(optional.isPresent());
    }

    @Test
    public void toArray() {
        final Object[] array = tuple.toArray();
        assertEquals(1, array.length);
        assertEquals(item, array[0]);
    }

    @Test
    public void toList() {
        final List<String> list = tuple.toList();
        assertEquals(1, list.size());
        assertEquals(item, list.get(0));
    }

    @Test
    public void toStream() {
        final Stream<String> stream = tuple.stream();
        assertEquals(1, stream.count());
    }

    @Test
    public void testToString() {
        final String str = tuple.toString();
        assertTrue(str.startsWith("Tuple1("));
        assertTrue(str.contains(item));
        assertTrue(str.endsWith(")"));
    }

    @Test
    public void similarTuplesAreEquals() {
        final Tuple1<String> other = new Tuple1<>(item);
        assertEquals(tuple, other);
    }

    @Test
    public void differentTuplesAreNotEquals() {
        final Tuple1<String> other = new Tuple1<>("Other _1");
        assertNotEquals(tuple, other);
    }

    @Test
    public void reverse() {
        final Tuple1<String> reversed = tuple.reverse();
        assertEquals(tuple, reversed);
    }

    @Test
    public void map() {
        final Tuple1<Integer> mapped = tuple.map(String::length);
        final Tuple1<Integer> expected = new Tuple1<>(item.length());
        assertEquals(expected, mapped);
    }
}