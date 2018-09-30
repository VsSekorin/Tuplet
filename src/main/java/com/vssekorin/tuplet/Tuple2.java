package com.vssekorin.tuplet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class Tuple2<A, B> {

    private final A item1;
    private final B item2;

    public Tuple2(A src1, B src2) {
        this.item1 = src1;
        this.item2 = src2;
    }

    public A _1() {
        return this.item1;
    }

    public B _2() {
        return this.item2;
    }

    public boolean contains(Object obj) {
        return obj.equals(this.item1) || obj.equals(this.item2);
    }

    public Object[] toArray() {
        return this.toList().toArray();
    }

    public List<Object> toList() {
        return Arrays.asList(this.item1, this.item2);
    }

    public Stream<Object> toStream() {
        return Stream.of(this.item1, this.item2);
    }

    @Override
    public String toString() {
        return "Tuple2("
            + item1 + ", " + item2 + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) obj;
        if (item1 != null ? !item1.equals(tuple2.item1) : tuple2.item1 != null) return false;
        return item2 != null ? item2.equals(tuple2.item2) : tuple2.item2 == null;
    }

    @Override
    public int hashCode() {
        int result = item1 != null ? item1.hashCode() : 0;
        result = 31 * result + (item2 != null ? item2.hashCode() : 0);
        return result;
    }
}
