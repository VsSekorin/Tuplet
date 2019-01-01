package com.vssekorin.tuplet;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public final class TupleTest {

    @Test
    public void fromMap() {
        final Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        final List<Tuple2<String, Integer>> fromMap = Tuple.from(map);
        final List<Tuple2<String, Integer>> expected = Arrays.asList(
            new Tuple2<>("one", 1), new Tuple2<>("two", 2)
        );
        assertEquals(expected, fromMap);
    }
}