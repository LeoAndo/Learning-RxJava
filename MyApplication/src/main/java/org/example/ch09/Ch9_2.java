package org.example.ch09;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

public class Ch9_2 {
    public static void main(String[] args) {
        var subscribe = Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                .compose(joinToString("/"))
                .subscribe(System.out::println);

        subscribe.dispose();
    }

    public static ObservableTransformer<String, String>
    joinToString(String separator) {
        return upstream -> upstream
                .collect(StringBuilder::new, (b, s) -> {
                    if (b.isEmpty())
                        b.append(s);
                    else
                        b.append(separator).append(s);
                })
                .map(StringBuilder::toString)
                .toObservable();
    }
}