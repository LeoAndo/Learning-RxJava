package org.example.ch04;

import io.reactivex.Observable;

/**
 * - **`Observable.zip(...)`**
 * - 複数の`Observable`を1つにまとめるメソッドです。同じインデックス位置の要素をペアにして処理を行います。
 * - 処理内容は、ラムダ関数 `(s, i) -> s + "-" + i` で指定しています。
 * - この場合、1つ目のストリーム（`source1`の要素）と2つ目のストリーム（`source2`の要素）を`"-"`で結合した文字列を生成しています。
 */
public class Ch4_13 {
    public static void main(String[] args) {
        var source1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        var source2 = Observable.range(1, 6);
        var subscribe = Observable.zip(source1, source2, (s, i) -> s + "-" + i)
                .subscribe(System.out::println);

        subscribe.dispose();
    }
}