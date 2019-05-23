package ladder.domain;

import ladder.core.NaturalNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @Test
    void position_생성() {
        Position position1 = Position.create(new NaturalNumber(3), new NaturalNumber(4));
        Position position2 = Position.create(3, 4);
        assertEquals(position1, position2);
    }

    @Test
    void 배열_인덱스_생성() {
        Position arrayPosition = Position.createFromArrayIndex(2, 3);
        Position position = Position.create(3, 4);
        assertEquals(arrayPosition, position);
    }
}
