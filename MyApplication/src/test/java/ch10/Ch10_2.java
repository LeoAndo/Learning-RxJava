package ch10;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class Ch10_2 {
    @Test
    public void testBlockingSubscribe() {
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS)
                .take(5);

        source.test()
                .awaitDone(6, TimeUnit.SECONDS)  // Wait a bit longer than needed to ensure completion
                .assertValueCount(5)             // Verify we got 5 emissions
                .assertComplete()                // Verify the stream completed
                .assertNoErrors();              // Verify no errors occurred
    }

}
