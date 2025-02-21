package ch10;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class Ch10_1 {
    @Test
    public void testBlockingSubscribe() {
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS)
                .take(5);

        // Using TestObserver
        source.test()
            .awaitDone(6, TimeUnit.SECONDS)
            .assertValueCount(5)
            .assertComplete();
    }
}
