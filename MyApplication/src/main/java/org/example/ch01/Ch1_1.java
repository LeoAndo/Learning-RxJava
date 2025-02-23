package org.example.ch01;

import io.reactivex.Observable;

/**
 * RxJavaを使用したリアクティブプログラミングの基本的な例です。
 * リアクティブプログラミングでは、データフローやイベントの流れを「ストリーム」として扱い、非同期で処理を行います。
 * このコードは、RxJavaの「値を発行して応答する」という基本的な仕組みをデモンストレーションするものです。
 * 同様の使い方を拡張することで、非同期データ処理やイベント駆動型のシステムを実装することが可能です。
 */
public class Ch1_1 {
    public static void main(String[] args) {
        // `Observable.just()` は、指定された複数の値
        // （ここでは "Alpha", "Beta", "Gamma", "Delta", "Epsilon"）を順番に発行する（`emit` する）`Observable` を作成します。
        var myStrings =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");

        // `Observable` を購読することで、発行された要素を受け取って何らかの処理を実行します。
        // 購読の動作
        // 1. `Observable` は一つずつ値を発行します。
        // 2. 各値がラムダ式に渡されます。
        // 3. 渡された値が `System.out.println()` によってコンソールにプリントされます。
        var subscribe = myStrings.subscribe(System.out::println);
        // - ストリームの利用が終わった後に、`dispose` メソッドを呼び出すことで、リソースを明示的に解放します。これにより、購読が終了し、ストリームの処理が停止します
        subscribe.dispose();
    }
}