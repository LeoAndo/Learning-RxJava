package ch10;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Ch10_7 {
    @Test
    public void testIterable() {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Zeta");
        Iterable<String> allWithLengthFive = source.filter(s ->
                s.length() == 5)
                .blockingIterable();
        for (String s: allWithLengthFive) {
            assertEquals(5, s.length());
        }
    }
}
