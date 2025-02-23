package org.example.ch05;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * ### `.replay(1, TimeUnit.SECONDS)`
 * - `replay`はホットなObservableを生成し、発行された値をキャッシュします。
 * - このコードでは、過去「1秒間」の発行（バッファ）を保持する仕様です。
 * - たとえば、あるObserverが新たに購読した場合、その購読より1秒以内に発行されたデータは遡って受け取ります（過去データの再送）。
 * <p>
 * - **効果**：
 * - Observerが後から購読しても最近のデータを取得できるようにします。
 * - 過去の値が発行されなくなる「時間的範囲」は、指定された1秒間で制限されています。
 */
public class Ch5_18 {
    public static void main(String[] args) {
        var seconds =
                Observable.interval(300, TimeUnit.MILLISECONDS)
                        .map(l -> (l + 1) * 300) // map to elapsed milliseconds
                        .replay(1, TimeUnit.SECONDS)
                        .autoConnect();
//Observer 1
        var subscribe = seconds.subscribe(l -> System.out.println("Observer 1: " +
                l));
        sleep(2000);
//Observer 2
        var subscribe1 = seconds.subscribe(l -> System.out.println("Observer 2: " +
                l));
        sleep(1000);

        subscribe.dispose();
        subscribe1.dispose();
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}