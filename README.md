# java-ladder
사다리타기 미션 저장소

To do list
- NaturalNumber.toArrayIndex() 위치
- NaturalNumber.toArrayIndex() 메서드 이름
- Row.isOverNoOfPersons() 메서드 이름

- Node Direction 접근 리팩토링
- enum 부분에 대한 리팩토링

---
Done
- LadderTest의 테스트를 RowTest
- Row의 moveRow => move 로 rename
- move() 메서드 리팩토링 부분 찾아보기

- isLeftDirection() 메서드 rename
- 1, -1 값을 명확히 한다.
- 상수 값을 enum으로 변경

- Row 생성자 예외 처리
    - noOfPerson > 0
- drawLine 메서드 예외 처리
    - startPosition < 0 => 예외
    - 5 => 0 ~ 4 => 최대 위치 3, startPosition >= persons.length - 1 => 예외
    - 현재 위치 값이 -1 => 예외(덮어쓰기 금지)
- move 메서드 예외 처리 (drawLine메서드와 동일)

- run 메서드 리팩토링