package ladder.domain;

import ladder.core.NaturalNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderRunnerTest {

    @Test
    void 라인이_없는_사다리_생성() {
        // 한 순간만 유추해보기
        Row[] rows = new Row[3];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Row(new NaturalNumber(3));
        }
        String result = LadderRunner.generate(rows, Position.create(1 ,1));
        assertThat("0* 0 0 \n0 0 0 \n0 0 0 \n").isEqualTo(result);
    }

    @Test
    void 라인이_있는_사다리_생성() {
        Row[] rows = new Row[3];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Row(new NaturalNumber(3));
        }
        rows[0].drawLine(new NaturalNumber(1));
        String result = LadderRunner.generate(rows, Position.create(1, 1));
        assertThat("1* -1 0 \n0 0 0 \n0 0 0 \n").isEqualTo(result);
    }
}
