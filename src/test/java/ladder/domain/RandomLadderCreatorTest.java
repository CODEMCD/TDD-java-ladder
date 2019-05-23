package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomLadderCreatorTest {

    @Test
    void 랜덤_시작점_생성() {
        for (int i = 0; i < 10; i++) {
            System.out.println(randInt(1, 20));
        }

        // 4 * 5 => 20
        // 0 0 0 0 0
        // 0 0 0 0 0
        // 0 0 0 0 0
        // 0 0 0 0 0

        // 1 => 2, 5 => 6(x)
        // 20

        /**
         * 5의 배수가 되는 지점 X
         * 이미 생성되어 있는 지점에 선을 그을 때 X
         * 사다리 크기에 따라 임의로 생성되는 선의 수를 결정
         */
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNumber = rand.nextInt((max - min) + 1) + min;
        return randomNumber;
    }
}
