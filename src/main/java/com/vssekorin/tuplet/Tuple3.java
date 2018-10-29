package com.vssekorin.tuplet;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public final class Tuple3<A, B, C> {

    public final A _1;
    public final B _2;
    public final C _3;

    public Tuple3(final A src1, final B src2, final C src3) {
        this._1 = src1;
        this._2 = src2;
        this._3 = src3;
    }

    public Tuple3<C, B, A> reverse() {
        return new Tuple3<>(this._3, this._2, this._1);
    }

    public <T> Tuple3<T, B, C> map_1(final Function<A, T> map) {
        return new Tuple3<>(map.apply(this._1), this._2, this._3);
    }

    public <T> Tuple3<A, T, C> map_2(final Function<B, T> map) {
        return new Tuple3<>(this._1, map.apply(this._2), this._3);
    }

    public <T> Tuple3<A, B, T> map_3(final Function<C, T> map) {
        return new Tuple3<>(this._1, this._2, map.apply(this._3));
    }

    public boolean contains(final Object obj) {
        return obj.equals(this._1) || obj.equals(this._2) || obj.equals(this._3);
    }

    public Object[] toArray() {
        return this.toList().toArray();
    }

    public List<Object> toList() {
        return Arrays.asList(this._1, this._2, this._3);
    }

    public Stream<Object> stream() {
        return Stream.of(this._1, this._2, this._3);
    }

    @Override
    public String toString() {
        return "Tuple3("
            + _1 + ", " + _2 + ", " + _3 +")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple3<?, ?, ?> tuple3 = (Tuple3<?, ?, ?>) o;

        if (_1 != null ? !_1.equals(tuple3._1) : tuple3._1 != null) return false;
        if (_2 != null ? !_2.equals(tuple3._2) : tuple3._2 != null) return false;
        return _3 != null ? _3.equals(tuple3._3) : tuple3._3 == null;
    }

    @Override
    public int hashCode() {
        int result = _1 != null ? _1.hashCode() : 0;
        result = 31 * result + (_2 != null ? _2.hashCode() : 0);
        result = 31 * result + (_3 != null ? _3.hashCode() : 0);
        return result;
    }
}
