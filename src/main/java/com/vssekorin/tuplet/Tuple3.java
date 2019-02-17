package com.vssekorin.tuplet;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public final class Tuple3<A, B, C> implements Serializable {

    private final A item1;
    private final B item2;
    private final C item3;

    public Tuple3(final A src1, final B src2, final C src3) {
        this.item1 = src1;
        this.item2 = src2;
        this.item3 = src3;
    }

    public A _1() {
        return this.item1;
    }

    public B _2() {
        return this.item2;
    }

    public C _3() {
        return this.item3;
    }

    public <T> Tuple4<T, A, B, C> addFirst(final T src) {
        return new Tuple4<>(src, item1, item2, item3);
    }

    public <T> Tuple4<A, B, C, T> addLast(final T src) {
        return new Tuple4<>(item1, item2, item3, src);
    }

    public Tuple3<C, B, A> reverse() {
        return new Tuple3<>(this.item3, this.item2, this.item1);
    }

    public <T> Tuple3<T, B, C> map_1(final Function<A, T> map) {
        return new Tuple3<>(map.apply(this.item1), this.item2, this.item3);
    }

    public <T> Tuple3<A, T, C> map_2(final Function<B, T> map) {
        return new Tuple3<>(this.item1, map.apply(this.item2), this.item3);
    }

    public <T> Tuple3<A, B, T> map_3(final Function<C, T> map) {
        return new Tuple3<>(this.item1, this.item2, map.apply(this.item3));
    }

    public boolean contains(final Object obj) {
        return obj.equals(this.item1) || obj.equals(this.item2) || obj.equals(this.item3);
    }

    public Object[] toArray() {
        return this.toList().toArray();
    }

    public List<Object> toList() {
        return Arrays.asList(this.item1, this.item2, this.item3);
    }

    public Stream<Object> stream() {
        return Stream.of(this.item1, this.item2, this.item3);
    }

    @Override
    public String toString() {
        return "Tuple3(" + item1 + ", " + item2 + ", " + item3 +")";
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple3<?, ?, ?> tuple3 = (Tuple3<?, ?, ?>) o;
        if (item1 != null ? !item1.equals(tuple3.item1) : tuple3.item1 != null) return false;
        if (item2 != null ? !item2.equals(tuple3.item2) : tuple3.item2 != null) return false;
        return item3 != null ? item3.equals(tuple3.item3) : tuple3.item3 == null;
    }

    @Override
    public int hashCode() {
        int result = item1 != null ? item1.hashCode() : 0;
        result = 31 * result + (item2 != null ? item2.hashCode() : 0);
        result = 31 * result + (item3 != null ? item3.hashCode() : 0);
        return result;
    }
}
