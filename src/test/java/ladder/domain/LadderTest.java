package ladder.domain;

import ladder.core.NaturalNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {

    @Test
    void runWhenMultiRows() {
        // 1 -1 0 0
        // 0 1 -1 0
        // 0 0 1 -1
        Ladder ladder = new Ladder(new NaturalNumber(3), new NaturalNumber(4));
        ladder.drawLine(new NaturalNumber(1), new NaturalNumber(1));
        ladder.drawLine(new NaturalNumber(2), new NaturalNumber(2));
        ladder.drawLine(new NaturalNumber(3), new NaturalNumber(3));

        assertEquals(new Marker(4), ladder.run(new Marker(1)));
        assertEquals(new Marker(1), ladder.run(new Marker(2)));
        assertEquals(new Marker(2), ladder.run(new Marker(3)));
        assertEquals(new Marker(3), ladder.run(new Marker(4)));
    }

    @Test
    void 사다리_높이_위치가_0미만인_사다리에_그리는_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ladder ladder = new Ladder(new NaturalNumber(1), new NaturalNumber(3));
            ladder.drawLine(new NaturalNumber(0), new NaturalNumber(2));
        });
    }

    @Test
    void 사다리_최대_높이를_넘어서_그리는_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ladder ladder = new Ladder(new NaturalNumber(1), new NaturalNumber(3));
            ladder.drawLine(new NaturalNumber(2), new NaturalNumber(2));
        });
    }

    @Test
    void 라인이_없는_사다리_생성() {
        // 한 순간만 유추해보기
        Row[] rows = new Row[3];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Row(new NaturalNumber(3));
        }
        String result = Ladder.generate(rows, Position.create(1 ,1));
        assertThat("0* 0 0 \n0 0 0 \n0 0 0 \n").isEqualTo(result);
    }

    @Test
    void 라인이_있는_사다리_생성() {
        Row[] rows = new Row[3];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Row(new NaturalNumber(3));
        }
        rows[0].drawLine(new NaturalNumber(1));
        String result = Ladder.generate(rows, Position.create(1, 1));
        assertThat("1* -1 0 \n0 0 0 \n0 0 0 \n").isEqualTo(result);
    }
}
