package org.example.ch02;

import io.reactivex.Observable;

class Ch2_25 {
    private static int start = 1;
    private static int count = 5;

    public static void main(String[] args) {
        // `Observable.defer`は遅延実行のために使用され、
        //  購読（`subscribe`）が発生したタイミングで初めて内部のロジックを実行します。
        //  これにより、Observable生成時ではなく、購読時点で「最新の状態」が反映されます。
        var source = Observable.defer(() ->
                Observable.range(start, count));
        var subscribe = source.subscribe(i -> System.out.println("Observer 1: " + i));
//modify count
        count = 10;
        var subscribe1 = source.subscribe(i -> System.out.println("Observer 2: " + i));

        subscribe.dispose();
        subscribe1.dispose();
    }
}