package com.vssekorin.tuplet;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public final class Tuple6<A, B, C, D, E, F> implements Serializable {

    private final A item1;
    private final B item2;
    private final C item3;
    private final D item4;
    private final E item5;
    private final F item6;

    public Tuple6(final A src1, final B src2, final C src3, final D src4, final E src5, final F src6) {
        this.item1 = src1;
        this.item2 = src2;
        this.item3 = src3;
        this.item4 = src4;
        this.item5 = src5;
        this.item6 = src6;
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

    public F _6() {
        return item6;
    }

    public Tuple6<F, E, D, C, B, A> reverse() {
        return new Tuple6<>(item6, item5, item4, item3, item2, item1);
    }

    public <T> Tuple6<T, B, C, D, E, F> map_1(final Function<A, T> map) {
        return new Tuple6<>(map.apply(item1), item2, item3, item4, item5, item6);
    }

    public <T> Tuple6<A, T, C, D, E, F> map_2(final Function<B, T> map) {
        return new Tuple6<>(item1, map.apply(item2), item3, item4, item5, item6);
    }

    public <T> Tuple6<A, B, T, D, E, F> map_3(final Function<C, T> map) {
        return new Tuple6<>(item1, item2, map.apply(item3), item4, item5, item6);
    }

    public <T> Tuple6<A, B, C, T, E, F> map_4(final Function<D, T> map) {
        return new Tuple6<>(item1, item2, item3, map.apply(item4), item5, item6);
    }

    public <T> Tuple6<A, B, C, D, T, F> map_5(final Function<E, T> map) {
        return new Tuple6<>(item1, item2, item3, item4, map.apply(item5), item6);
    }

    public <T> Tuple6<A, B, C, D, E, T> map_6(final Function<F, T> map) {
        return new Tuple6<>(item1, item2, item3, item4, item5, map.apply(item6));
    }

    public boolean contains(final Object obj) {
        return obj.equals(item1) || obj.equals(item2) || obj.equals(item3) || obj.equals(item4)
            || obj.equals(item5) || obj.equals(item6);
    }

    public Object[] toArray() {
        return this.toList().toArray();
    }

    public List<Object> toList() {
        return Arrays.asList(this.item1, this.item2, this.item3, this.item4, this.item5, this.item6);
    }

    public Stream<Object> stream() {
        return Stream.of(this.item1, this.item2, this.item3, this.item4, this.item5, this.item6);
    }

    @Override
    public String toString() {
        return "Tuple6(" +
            item1 + ", " + item2 + ", " + item3 + ", " + item4 + ", " + item5 + ", " + item6 + ")";
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Tuple6<?, ?, ?, ?, ?, ?> that = (Tuple6<?, ?, ?, ?, ?, ?>) obj;
        return Objects.equals(item1, that.item1) && Objects.equals(item2, that.item2)
            && Objects.equals(item3, that.item3) && Objects.equals(item4, that.item4)
            && Objects.equals(item5, that.item5) && Objects.equals(item6, that.item6);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item1, item2, item3, item4, item5, item6);
    }
}
