package org.example.ch09;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

import java.util.concurrent.atomic.AtomicInteger;

public class Ch9_4 {
    public static void main(String[] args) {
        var indexedStrings =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                                "Epsilon")
                        .compose(withIndex());
        var subscribe = indexedStrings.subscribe(v ->
                System.out.println("Subscriber 1: " + v));
        var subscribe1 = indexedStrings.subscribe(v ->
                System.out.println("Subscriber 2: " + v));

        subscribe.dispose();
        subscribe1.dispose();
    }

    static <T> ObservableTransformer<T, IndexedValue<T>>
    withIndex() {
        final AtomicInteger indexer = new AtomicInteger(-1);
        return upstream -> upstream.map(v -> new
                IndexedValue<T>(indexer.incrementAndGet(), v));
    }

    static final class IndexedValue<T> {
        final int index;
        final T value;

        IndexedValue(int index, T value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return index + " - " + value;
        }
    }
}