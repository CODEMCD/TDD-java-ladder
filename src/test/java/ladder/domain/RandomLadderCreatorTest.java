package ladder.domain;

import ladder.core.NaturalNumber;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLadderCreatorTest {

    @Test
    void 랜덤_시작점_생성() {
        RandomLadderCreator creator = new RandomLadderCreator(new NaturalNumber(3), new NaturalNumber(4));
        int[] positions = creator.generateStartPositions();
        for (int i = 0; i < positions.length; i++) {
            System.out.println(String.format("position: %d", positions[i]));
        }

        // 4 * 5 => 20
        // 0 0 0 0 0
        // 0 0 0 0 0
        // 0 0 0 0 0
        // 0 0 0 0 0

        // 1 => 2, 5 => 6(x)
        // 20

        /**
         * 사람 수 배수가 되는 지점 X
         * 이미 생성되어 있는 지점에 선을 그을 때 X
         * 총 position 수 구하기
         *
         * 사다리 크기에 따라 임의로 생성되는 선의 수를 결정
         */
    }

    @Test
    void 라인_수() {
        int countOfLine = RandomLadderCreator.getCountOfLine(new NaturalNumber(20), 0.3);
        assertThat(6).isEqualTo(countOfLine);

        countOfLine = RandomLadderCreator.getCountOfLine(new NaturalNumber(5), 0.3);
        assertThat(1).isEqualTo(countOfLine);
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
