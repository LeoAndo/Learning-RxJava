package org.example.ch02;

import io.reactivex.Observable;

/**
 * このコードは、RxJavaを使用してリアクティブプログラミングの基本を学ぶための例です。
 * 特に、「ホット」か「コールド」な`Observable`の特性について進めています。
 * このコードで使用している`Observable.range()`は「コールドな`Observable`」であり、
 * 新しい`Observer`（購読者）が登録されるたびに、最初からデータを送信します
 */
public class Ch2_24 {
    private static int start = 1;
    private static int count = 5;

    public static void main(String[] args) {
        // 1. `Observable.range(start, count)` により、
        // 指定された範囲（1から始まり5個の整数）を生成する特殊なコールドな`Observable`が作成されます。
        // - この時点で`Observable`自体はデータを流しません。データは`subscribe`を呼び出して
        // 購読者（Observer）が登録されて初めて流れます。
        // - 変更された`count`（10）ではなく、最初に生成された時点での`count`（5）の値が使用されます。
        var source = Observable.range(start, count);
        var subscribe = source.subscribe(i -> System.out.println("Observer 1: " + i));
        // modify count
        // - ここが重要なポイントです。この操作により、`count`の値は「5」から「10」に変更されますが、
        // 既に生成・定義された`Observable` `source`には影響を与えません。
        // RxJavaの`Observable.range(start, count)`は、`source`が生成された時点でその内容が決定されているため、
        // それ以降に外部変数を変更しても反映されません。
        count = 10;
        var subscribe1 = source.subscribe(i -> System.out.println("Observer 2: " + i));

        subscribe.dispose();
        subscribe1.dispose();
    }
}