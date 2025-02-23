package org.example.ch04;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * - **`withLatestFrom`**
 * - あるObservable（ここでは**`source2`**）に、別のObservable（ここでは**`source1`**）の「最新の値」を組み合わせます。
 * - **動作の仕組み**
 * - `source2` が値を1つ出力するごとに、その時点で **`source1` の最新値** を取得し、組み合わせた結果を生成します。
 */
public class Ch4_16 {
    public static void main(String[] args) {
        var source1 = Observable.interval(300, TimeUnit.MILLISECONDS);
        var source2 = Observable.interval(1, TimeUnit.SECONDS);
        var subscribe = source2
                .withLatestFrom(source1, (l1, l2) -> "SOURCE 2: " + l1 + " SOURCE 1: " + l2)
                .subscribe(System.out::println);
        sleep(3000);

        subscribe.dispose();
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}