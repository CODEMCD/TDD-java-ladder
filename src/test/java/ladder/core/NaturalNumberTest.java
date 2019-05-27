package ladder.core;

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

    @Test
    void 배열_인덱스_생성() {
        NaturalNumber actual = NaturalNumber.createFromArrayIndex(1);
        assertThat(new NaturalNumber(2)).isEqualTo(actual);
    }

    @Test
    void 곱셈() {
        NaturalNumber number = new NaturalNumber(3);
        NaturalNumber actual = number.multiply(new NaturalNumber(4));
        assertThat(new NaturalNumber(12)).isEqualTo(actual);
    }
}
