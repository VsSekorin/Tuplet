package com.vssekorin.tuplet;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class Tuple1Test {

    private final String item = "My item";
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
        Assert.assertEquals(1, array.length);
        Assert.assertEquals(item, array[0]);
    }

    @Test
    public void toList() {
        final List<String> list = tuple.toList();
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(item, list.get(0));
    }

    @Test
    public void toStream() {
        final Stream<String> stream = tuple.toStream();
        assertEquals(1, stream.count());
    }

    @Test
    public void testToString() {
        final String str = tuple.toString();
        Assert.assertTrue(str.startsWith("Tuple1("));
        Assert.assertTrue(str.contains(item));
        Assert.assertTrue(str.endsWith(")"));
    }

    @Test
    public void similarTuplesAreEquals() {
        final Tuple1<String> other = new Tuple1<>(item);
        Assert.assertEquals(tuple, other);
    }

    @Test
    public void differentTuplesAreNotEquals() {
        final Tuple1<String> other = new Tuple1<>("Other item");
        Assert.assertNotEquals(tuple, other);
    }
}