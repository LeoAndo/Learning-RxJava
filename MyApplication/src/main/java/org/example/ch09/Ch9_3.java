package org.example.ch09;

import com.google.common.collect.ImmutableList;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;

public class Ch9_3 {
    public static void main(String[] args) {
        var subscribe = Flowable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                .compose(toImmutableList())
                .subscribe(System.out::println);
        var subscribe1 = Flowable.range(1, 10)
                .compose(toImmutableList())
                .subscribe(System.out::println);

        subscribe.dispose();
        subscribe.dispose();
    }

    public static <T> FlowableTransformer<T, ImmutableList<T>>
    toImmutableList() {
        return upstream ->
                upstream.collect(ImmutableList::<T>builder,
                                ImmutableList.Builder::add)
                        .map(ImmutableList.Builder::build)
                        .toFlowable(); // must turn Single into Flowable
    }
}