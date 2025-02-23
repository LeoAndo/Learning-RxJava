package org.example.ch04;

import io.reactivex.Observable;

/**
 * **`flatMap`**:
 * - 各要素（ここでは各文字列 `"Alpha"`, `"Beta"`, など）を別のストリーム（`Observable`）に変換します。
 * - 同時にそれらを1つの大きな連結されたストリームに統合します。
 * - 非同期的に処理されることがあるため、元の順序が保証されません。
 */
public class Ch4_5 {
    public static void main(String[] args) {
        var source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        var subscribe = source.flatMap(s -> Observable.fromArray(s.split("")))
                .subscribe(System.out::println);
        subscribe.dispose();
    }
}