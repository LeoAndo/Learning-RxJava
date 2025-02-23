package org.example.ch02;

import io.reactivex.Observable;

/**
 * このコードは、「RxJavaで`publish`メソッドを使った`hot observable`」の活用例を示しています。
 * 複数のObserverが同じデータストリームをリアルタイムに共有し、それぞれ異なる処理を行えることを理解するのに役立ちます。
 * <p>
 * - `Observable.just`を使用して、文字列のストリーム（`Alpha`, `Beta`, `Gamma`, `Delta`, `Epsilon`）を生成します。
 * - `.publish()`を呼び出すことで、"cold observable"（通常はサブスクライブするたびに独立してデータを発行）から"hot observable"に変換します。
 * - この結果、`connect()`を呼び出すまでデータの送信が開始されません。
 * - この形態により、複数のObserverが同じデータを共有することが可能になります。
 */
public class Ch2_14 {
    public static void main(String[] args) {
        var source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                        .publish();
//Set up observer 1
        var subscribe = source.subscribe(s -> System.out.println("Observer 1: " + s));
//Set up observer 2
        var subscribe1 = source.map(String::length)
                .subscribe(i -> System.out.println("Observer 2: " + i));

        //Fire!
        // - `connect()`を呼び出すことで、`publish()`によって作成された`hot observable`がデータの送信を開始します。
        // - この時点で、両方のObserver（Observer 1 と Observer 2）は配信されるデータを並行して受信します。
        source.connect();

        // - `dispose()`を呼び出すことで、各Observerのサブスクリプションを解除します。 この操作により、メモリリークを防止します。
        subscribe.dispose();
        subscribe1.dispose();
    }
}