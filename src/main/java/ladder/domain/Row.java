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
        this.persons = new int[noOfPersons];
    }

    void drawLine(int startPosition) {
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
