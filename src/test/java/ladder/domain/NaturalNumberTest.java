package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NaturalNumberTest {
    @Test
    void 자연수_생성() {
        NaturalNumber naturalNumber = new NaturalNumber(1);
        assertThat(1).isEqualTo(naturalNumber.getNumber());
    }

    @Test
    void 영보다_작은_자연수_생성_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            new NaturalNumber(0);
        });
    }

    @Test
    void 배열_인덱스로_변경() {
        NaturalNumber number = new NaturalNumber(3);
        assertThat(2).isEqualTo(number.toArrayIndex());
    }
}
