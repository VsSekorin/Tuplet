package com.vssekorin.tuplet;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public final class Tuple5<A, B, C, D, E> implements Serializable {

    private final A item1;
    private final B item2;
    private final C item3;
    private final D item4;
    private final E item5;

    public Tuple5(final A src1, final B src2, final C src3, final D src4, final E src5) {
        this.item1 = src1;
        this.item2 = src2;
        this.item3 = src3;
        this.item4 = src4;
        this.item5 = src5;
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

    public E _5() {
        return item5;
    }

    public Tuple5<E, D, C, B, A> reverse() {
        return new Tuple5<>(item5, item4, item3, item2, item1);
    }

    public <T> Tuple5<T, B, C, D, E> map_1(final Function<A, T> map) {
        return new Tuple5<>(map.apply(item1), item2, item3, item4, item5);
    }

    public <T> Tuple5<A, T, C, D, E> map_2(final Function<B, T> map) {
        return new Tuple5<>(item1, map.apply(item2), item3, item4, item5);
    }

    public <T> Tuple5<A, B, T, D, E> map_3(final Function<C, T> map) {
        return new Tuple5<>(item1, item2, map.apply(item3), item4, item5);
    }

    public <T> Tuple5<A, B, C, T, E> map_4(final Function<D, T> map) {
        return new Tuple5<>(item1, item2, item3, map.apply(item4), item5);
    }

    public <T> Tuple5<A, B, C, D, T> map_5(final Function<E, T> map) {
        return new Tuple5<>(item1, item2, item3, item4, map.apply(item5));
    }

    public boolean contains(final Object obj) {
        return obj.equals(item1) || obj.equals(item2) || obj.equals(item3) || obj.equals(item4)
            || obj.equals(item5);
    }

    public Object[] toArray() {
        return this.toList().toArray();
    }

    public List<Object> toList() {
        return Arrays.asList(this.item1, this.item2, this.item3, this.item4, this.item5);
    }

    public Stream<Object> stream() {
        return Stream.of(this.item1, this.item2, this.item3, this.item4, this.item5);
    }

    @Override
    public String toString() {
        return "Tuple5(" + item1 + ", " + item2 + ", " + item3 + ", " + item4 + ", " + item5 + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple5<?, ?, ?, ?, ?> tuple5 = (Tuple5<?, ?, ?, ?, ?>) o;
        if (item1 != null ? !item1.equals(tuple5.item1) : tuple5.item1 != null) return false;
        if (item2 != null ? !item2.equals(tuple5.item2) : tuple5.item2 != null) return false;
        if (item3 != null ? !item3.equals(tuple5.item3) : tuple5.item3 != null) return false;
        if (item4 != null ? !item4.equals(tuple5.item4) : tuple5.item4 != null) return false;
        return item5 != null ? item5.equals(tuple5.item5) : tuple5.item5 == null;
    }

    @Override
    public int hashCode() {
        int result = item1 != null ? item1.hashCode() : 0;
        result = 31 * result + (item2 != null ? item2.hashCode() : 0);
        result = 31 * result + (item3 != null ? item3.hashCode() : 0);
        result = 31 * result + (item4 != null ? item4.hashCode() : 0);
        result = 31 * result + (item5 != null ? item5.hashCode() : 0);
        return result;
    }
}
