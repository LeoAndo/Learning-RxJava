package ch10;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Ch10_5 {
    @Test
    public void testSingle() {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Zeta");
        List<String> allWithLengthFour = source.filter(s ->
                s.length() == 4)
                .toList()
                .blockingGet();
        assertEquals(allWithLengthFour, Arrays.asList("Beta", "Zeta"));
    }
}
