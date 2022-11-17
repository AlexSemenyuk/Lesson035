package org.itstep.Task01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

class Task01Test {

    @Test
    void carsByColorTest() {
        Collection<Car> cars = Arrays.asList(
                new Car("Mazda", 2018, 8000, "Green", 2.0),
                new Car("BMW", 2012, 7000, "Black", 2.5),
                new Car("Hyundai", 2007, 5000, "Red", 1.6),
                new Car("Nissan", 2015, 10000, "Gray", 2.0)
        );
        String line = "Gray";
        Collection<Car> expected = cars.stream()
                .filter(x -> line.equalsIgnoreCase(x.getColor()))
                .collect(Collectors.toList());
        Collection<Car> actual1 = Task01.carsByColor(cars, line);
        Assertions.assertEquals(expected, actual1);
    }

    @Test
    void carsAbovePriceTest() {
        Collection<Car> cars = Arrays.asList(
                new Car("Mazda", 2018, 8000, "Green", 2.0),
                new Car("BMW", 2012, 7000, "Black", 2.5),
                new Car("Hyundai", 2007, 5000, "Red", 1.6),
                new Car("Nissan", 2015, 10000, "Gray", 2.0)
        );
        int line = 6_000;
        Collection<Car> expected = cars.stream()
                .filter(x -> line < x.getPrice())
                .collect(Collectors.toList());
        Collection<Car> actual1 = Task01.carsAbovePrice(cars, line);
        Assertions.assertEquals(expected, actual1);
    }

    @Test
    void carsByTimeRangeTest() {
        Collection<Car> cars = Arrays.asList(
                new Car("Mazda", 2018, 8000, "Green", 2.0),
                new Car("BMW", 2012, 7000, "Black", 2.5),
                new Car("Hyundai", 2007, 5000, "Red", 1.6),
                new Car("Nissan", 2015, 10000, "Gray", 2.0)
        );
        int[] line = {2012, 2015};
        Collection<Car> expected = cars.stream()
                .filter(x -> line[0] <= x.getMakeYear())
                .filter(x -> line[1] >= x.getMakeYear())
                .collect(Collectors.toList());
        Collection<Car> actual1 = Task01.carsByTimeRange(cars, line);
        Assertions.assertEquals(expected, actual1);
    }

    @Test
    void carsBySortedPriceTest() {
        Collection<Car> cars = Arrays.asList(
                new Car("Mazda", 2018, 8000, "Green", 2.0),
                new Car("BMW", 2012, 7000, "Black", 2.5),
                new Car("Hyundai", 2007, 5000, "Red", 1.6),
                new Car("Nissan", 2015, 10000, "Gray", 2.0)
        );
        Collection<Car> expected = cars.stream()
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .collect(Collectors.toList());
        Collection<Car> actual1 = Task01.carsBySortedPrice(cars);
        Assertions.assertEquals(expected, actual1);
    }
}

