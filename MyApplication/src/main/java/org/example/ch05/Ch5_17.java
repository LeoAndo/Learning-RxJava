package org.example.ch05;

import io.reactivex.Observable;

/**
 * #### . **`.replay(1)` **
 * - `.replay(1)` は、**`ReplaySubject`** のように動作する `Observable` を返します。
 * - 具体的には「最後にエミットされた値」をバッファとして保持し、新しい `Observer` が購読を開始した際にその値を即座に受け取れるようにします。
 * - 引数の `1` は「**最新の 1 件のエミット値をキャッシュする**」ことを意味します。
 * <p>
 * 例えば、
 * - この Observable が `"Epsilon"` を最後にエミットしている場合、新しく購読する `Observer` は必ず `"Epsilon"` を最初に受け取れます。
 */
public class Ch5_17 {
    public static void main(String[] args) {
        var source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                        .replay(1)
                        .autoConnect();
//Observer 1
        source.subscribe(l -> System.out.println("Observer 1: " +
                l));
//Observer 2
        source.subscribe(l -> System.out.println("Observer 2: " +
                l));
    }
}