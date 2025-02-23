package org.example.ch04;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * - `Observable.amb()` は RxJava のオペレーターです。
 * - 入力として複数の `Observable` のリスト（または配列）を受け取ります。
 * - これらの中から**最初にデータを発行し始めた（emission started first）`Observable`** を選択し、その発行データのみを購読します。他の `Observable` のデータは無視されます。
 * - 簡単に言えば、「どの `Observable` が最初にデータを出すかを競わせ、その発行データだけを伝える」という動作をします。
 */
public class Ch4_12 {
    public static void main(String[] args) {
//emit every second
        var source1 =
                Observable.interval(1, TimeUnit.SECONDS)
                        .take(2)
                        .map(l -> l + 1) // emit elapsed seconds
                        .map(l -> "Source1: " + l + " seconds");
//emit every 300 milliseconds
        var source2 =
                Observable.interval(300, TimeUnit.MILLISECONDS)
                        .map(l -> (l + 1) * 300) // emit elapsed milliseconds
                        .map(l -> "Source2: " + l + " milliseconds");
//emit Observable that emits first
        var subscribe = Observable.amb(Arrays.asList(source1, source2))
                .subscribe(i -> System.out.println("RECEIVED: " +
                        i));
//keep application alive for 5 seconds
        sleep(5000);

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