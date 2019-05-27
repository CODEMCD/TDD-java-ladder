package ladder.domain;

import ladder.core.NaturalNumber;

import java.util.Random;

public class RandomLadderCreator {

    private static final double DEFAULT_LINE_RATIO = 0.3;
    private NaturalNumber totalPositions;
    private Row[] rows;

    RandomLadderCreator(NaturalNumber height, NaturalNumber noOfPerson) {
        totalPositions = height.multiply(noOfPerson);
        rows = new Row[height.getNumber()];
        for (int i = 0; i < height.getNumber(); i++) {
            rows[i] = new Row(noOfPerson);
        }
    }

    public static int getCountOfLine(NaturalNumber totalPositions, double ratio) {
        return (int) (totalPositions.getNumber() * ratio);
    }

    void drawLine(NaturalNumber height, NaturalNumber startPosition) {
        if (isOverHeight(height)) {
            throw new IllegalArgumentException(String.format("사다리 최대 높이를 넘어섰습니다. 현재 값 : %d", height));
        }

        rows[height.toArrayIndex()].drawLine(startPosition);
    }

    private boolean isOverHeight(NaturalNumber height) {
        return height.toArrayIndex() > rows.length - 1;
    }

    public Row[] getLadder() {
        return this.rows;
    }

    int[] generateStartPositions() {
        int countOfLine = getCountOfLine(totalPositions, DEFAULT_LINE_RATIO);
        int[] startPositions = new int[countOfLine];
        for (int i = 0; i < startPositions.length; i++) {
            startPositions[i] = randInt(1, totalPositions.getNumber());
        }
        return startPositions;
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
