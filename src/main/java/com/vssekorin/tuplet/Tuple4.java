package com.vssekorin.tuplet;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public final class Tuple4<A, B, C, D> implements Serializable {

    private final A item1;
    private final B item2;
    private final C item3;
    private final D item4;

    public Tuple4(final A src1, final B src2, final C src3, final D src4) {
        this.item1 = src1;
        this.item2 = src2;
        this.item3 = src3;
        this.item4 = src4;
    }

    public A _1() {
        return item1;
    }

    public B _2() {
        return item2;
    }

    public C _3() {
        return item3;
    }

    public D _4() {
        return item4;
    }

    public <T> Tuple5<T, A, B, C, D> addFirst(final T src) {
        return new Tuple5<>(src, item1, item2, item3, item4);
    }

    public <T> Tuple5<A, B, C, D, T> addLast(final T src) {
        return new Tuple5<>(item1, item2, item3, item4, src);
    }

    public Tuple4<D, C, B, A> reverse() {
        return new Tuple4<>(item4, item3, item2, item1);
    }

    public <T> Tuple4<T, B, C, D> map_1(final Function<A, T> map) {
        return new Tuple4<>(map.apply(item1), item2, item3, item4);
    }

    public <T> Tuple4<A, T, C, D> map_2(final Function<B, T> map) {
        return new Tuple4<>(item1, map.apply(item2), item3, item4);
    }

    public <T> Tuple4<A, B, T, D> map_3(final Function<C, T> map) {
        return new Tuple4<>(item1, item2, map.apply(item3), item4);
    }

    public <T> Tuple4<A, B, C, T> map_4(final Function<D, T> map) {
        return new Tuple4<>(item1, item2, item3, map.apply(item4));
    }

    public boolean contains(final Object obj) {
        return obj.equals(item1) || obj.equals(item2) || obj.equals(item3) || obj.equals(item4);
    }

    public Object[] toArray() {
        return this.toList().toArray();
    }

    public List<Object> toList() {
        return Arrays.asList(this.item1, this.item2, this.item3, this.item4);
    }

    public Stream<Object> stream() {
        return Stream.of(this.item1, this.item2, this.item3, this.item4);
    }

    @Override
    public String toString() {
        return "Tuple4(" + item1 + ", " + item2 + ", " + item3 + ", " + item4 + ")";
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tuple4<?, ?, ?, ?> tuple4 = (Tuple4<?, ?, ?, ?>) obj;
        if (item1 != null ? !item1.equals(tuple4.item1) : tuple4.item1 != null) return false;
        if (item2 != null ? !item2.equals(tuple4.item2) : tuple4.item2 != null) return false;
        if (item3 != null ? !item3.equals(tuple4.item3) : tuple4.item3 != null) return false;
        return item4 != null ? item4.equals(tuple4.item4) : tuple4.item4 == null;
    }

    @Override
    public int hashCode() {
        int result = item1 != null ? item1.hashCode() : 0;
        result = 31 * result + (item2 != null ? item2.hashCode() : 0);
        result = 31 * result + (item3 != null ? item3.hashCode() : 0);
        result = 31 * result + (item4 != null ? item4.hashCode() : 0);
        return result;
    }
}
