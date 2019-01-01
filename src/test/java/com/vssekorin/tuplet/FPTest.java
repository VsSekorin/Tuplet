package com.vssekorin.tuplet;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public final class FPTest {

    @Test
    public void zip() {
        final List<Integer> first = Arrays.asList(1, 2, 3);
        final List<String> second = Arrays.asList("one", "two", "three");
        final List<Tuple2<Integer, String>> zipped = FP.zip(first, second);
        assertEquals(3, zipped.size());
        assertEquals(new Tuple2<>(1, "one"), zipped.get(0));
        assertEquals(new Tuple2<>(2, "two"), zipped.get(1));
        assertEquals(new Tuple2<>(3, "three"), zipped.get(2));
    }
}