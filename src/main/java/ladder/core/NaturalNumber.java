package ladder.core;

import java.util.Objects;

public class NaturalNumber {
    private static final int INTERVAL = 1;
    private int number;

    public NaturalNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException(String.format("자연수는 1 이상이어야 합니다. 현재 값: %d", number));
        }

        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public int toArrayIndex() {
        return this.number - INTERVAL;
    }

    public static NaturalNumber createFromArrayIndex(int index) {
        return new NaturalNumber(index + INTERVAL);
    }

    public NaturalNumber multiply(NaturalNumber operand) {
        return new NaturalNumber(this.number * operand.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NaturalNumber that = (NaturalNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
