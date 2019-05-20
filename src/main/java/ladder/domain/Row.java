package ladder.domain;

class Row {
    private enum Direction {
        LEFT(-1),
        CENTER(0),
        RIGHT(1);

        private int number;

        Direction(int number) {
            this.number = number;
        }

        int getNumber() {
            return number;
        }
    }

    private int[] persons;

    Row(int noOfPersons) {
        if (noOfPersons < 1) {
            throw new IllegalArgumentException(String.format("사람 수는 한 명 이상이어야 합니다. 현재 값 : %d", noOfPersons));
        }
        this.persons = new int[noOfPersons];
    }

    void drawLine(int startPosition) {
        if (startPosition < 0) {
            throw new IllegalArgumentException(String.format("시작점은 0 이상이어야 합니다. 현재 값 : %d", startPosition));
        }
        if (startPosition >= persons.length - 1) {
            throw new IllegalArgumentException(String.format("시작점은 &d 미만이어야 합니다. 현재 값 : %d", persons.length - 1, startPosition));
        }

        int currentValue = persons[startPosition];
        if(currentValue == -1) {
            throw new IllegalArgumentException("선을 그을 수 없는 위치입니다.");
        }
        persons[startPosition] = Direction.RIGHT.getNumber();
        persons[startPosition + 1] = Direction.LEFT.getNumber();
    }

    int move(int nthOfPerson) {
        if (isNoLine(nthOfPerson)) {
            return nthOfPerson;
        }
        if (isRightDirection(nthOfPerson)) {
            return nthOfPerson + 1;
        }
        return nthOfPerson - 1;
    }

    private boolean isRightDirection(int nthOfPerson) {
        return persons[nthOfPerson] == Direction.RIGHT.getNumber();
    }

    private boolean isNoLine(int nthOfPerson) {
        return persons[nthOfPerson] == Direction.CENTER.getNumber();
    }
}
