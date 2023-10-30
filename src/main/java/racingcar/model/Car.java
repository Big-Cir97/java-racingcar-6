package racingcar.model;

import java.util.Objects;

public class Car {
    private static final int START_MOVING_DISTANCE = 0;
    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;

    private static final String INVALID_NAME_LENGTH_RANGE = "자동차 이름 길이는 1~5 입니다.";

    private String name;
    private int distance;

    public Car(String name) {
        validateNameLengthRange(name);
        this.name = name;
        this.distance = START_MOVING_DISTANCE;
    }

    private void validateNameLengthRange(String name) {
        if (isRange(name)) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_RANGE);
        }
    }

    private boolean isRange(String name) {
        int length = name.length();
        return !(length >= NAME_MIN_LENGTH && length <= NAME_MAX_LENGTH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
