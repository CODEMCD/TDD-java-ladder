package ladder.domain;

public class Row {
    int[] persons;

    Row(int noOfPersons) {
        this.persons = new int[noOfPersons];
    }

    public void drawLine(int startPosition) {
        persons[startPosition] = 1;
        persons[startPosition + 1] = -1;
    }

    public int move(int nthOfPerson) {
        if (isNoLine(nthOfPerson)) {
            return nthOfPerson;
        }
        if (persons[nthOfPerson] == 1) {
            return nthOfPerson + 1;
        }
        return nthOfPerson - 1;
    }

    private boolean isNoLine(int nthOfPerson) {
        return persons[nthOfPerson] == 0;
    }
}
