package org.example.ch05;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

import java.util.concurrent.TimeUnit;

/**
 * 2つの `Observable` ストリーム (`source1` と `source2`) が作成され、
 * それらを `PublishSubject` を介してまとめて出力しています。
 * プログラムはそれらのストリームからのデータを途中まで受信し、それをコンソールに出力します。
 * <p>
 * - `PublishSubject`:
 * - ストリームのデータを複数の `Observable` からまとめて受け取り、他の箇所で利用するために公開するためのサブジェクトです。
 * - このコードでは、`source1` と `source2` の出力が `subject` を通じて統合されます。
 */
public class Ch5_21 {
    public static void main(String[] args) {
        var source1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(l -> (l + 1) + " seconds");
        var source2 = Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(l -> ((l + 1) * 300) + " milliseconds");
        var subject = PublishSubject.create();

        // `PublishSubject` にデータが流れるたびに、そのデータを標準出力 (コンソール) に表示します
        var subscribe = subject.subscribe(System.out::println);

        // `source1` によって生成されたデータが `subject` を通じて公開されるようになります。
        source1.subscribe(subject);
        // `source2` のデータも `subject` を通じて公開されます。
        source2.subscribe(subject);

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