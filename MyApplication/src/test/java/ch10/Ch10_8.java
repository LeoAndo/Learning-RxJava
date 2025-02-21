package ch10;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Ch10_8 {
    @Test
    public void testBlockingForEach() {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Zeta");
        source.filter(s -> s.length() == 5)
                .blockingForEach(s -> assertEquals(5, s.length()));
    }
}
