package com.vssekorin.tuplet;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public final class Tuple0Test {

    private final Tuple0 tuple = new Tuple0();

    @Test
    public void contains() {
        assertFalse(tuple.contains("something"));
    }

    @Test
    public void toOptionalWithoutValue() {
        final Optional<Object> optional = tuple.toOptional();
        assertFalse(optional.isPresent());
    }

    @Test
    public void toArray() {
        final Object[] array = tuple.toArray();
        assertEquals(0, array.length);
    }

    @Test
    public void toList() {
        final List<Object> list = tuple.toList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void toStream() {
        final Stream<Object> stream = tuple.stream();
        assertEquals(0, stream.count());
    }

    @Test
    public void testToString() {
        assertEquals("Tuple0", tuple.toString());
    }

    @Test
    public void similarTuplesAreEquals() {
        final Tuple0 other = new Tuple0();
        assertEquals(tuple, other);
    }

    @Test
    public void reverse() {
        final Tuple0 reversed = tuple.reverse();
        assertEquals(tuple, reversed);
    }
}
