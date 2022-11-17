package org.itstep.Task02;

import org.itstep.Task01.Car;
import org.itstep.Task01.Task01;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class Task02Test {


    @Test
    void maxXText() {
        Collection<Point<Integer, Integer>> points = asList(
                new Point(50, 250),
                new Point(350, 150),
                new Point(550, 750),
                new Point(230, 60)
        );
        Point expected = points.stream()
                .max(Comparator.comparing(Point::getX))
                .orElseThrow();
        Point actual1 = Task02.maxX(points);
        Assertions.assertEquals(expected, actual1);
    }

    @Test
    void distanceToStart() {

    }

    @Test
    void createCollection() {
    }

    @Test
    void testDistanceToStart() {
    }

    @Test
    void sortByDistanceToStart() {
    }
}