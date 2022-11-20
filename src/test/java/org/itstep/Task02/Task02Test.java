package org.itstep.Task02;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;


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
    void distanceToStartTest() {
        Collection<Point<Integer, Integer>> points = asList(
                new Point(50, 250),
                new Point(350, 150),
                new Point(550, 750),
                new Point(230, 60)
        );
        double[] arrDistance = points.stream()
                .mapToDouble(Task02::calculationDistanceToStart)
                .toArray();
        int[] index = {-1};
        Map<Double, Point<Integer, Integer>> expected = points.stream()
                .collect(Collectors.toMap(item -> arrDistance[++index[0]], item -> item));
        Map<Double, Point<Integer, Integer>> actual = Task02.distanceToStart(points);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createCollection() {
        int number = 15;
        final Random rnd = new Random(150);
        List expected = Stream.generate(() -> new Point(rnd.nextInt(number + 11), rnd.nextInt(number + 11)))
                .filter(p -> calc(p) > 5)
                .limit(number)
                .collect(toList());
        Collection<Point<Integer, Integer>> actual = Task02.createCollection(number);
        Assertions.assertEquals(expected, actual);
    }

    public static double calc(Point<Integer, Integer> p) {
        double rezult = Math.ceil(Math.sqrt(p.getX() * p.getX() + p.getY() * p.getY()));
        return rezult;
    }

    @Test
    void calculationDistanceToStartTest() {
        Point<Integer, Integer> p = new Point(50, 250);
        double expected = Math.ceil(Math.sqrt(p.getX() * p.getX() + p.getY() * p.getY()));
        double actual = Task02.calculationDistanceToStart(p);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void sortByDistanceToStartTest() {
        Collection<Point<Integer, Integer>> points = asList(
                new Point(50, 250),
                new Point(350, 150),
                new Point(550, 750),
                new Point(230, 60)
        );
        double[] arrDistance = points.stream()
                .mapToDouble(Task02::calculationDistanceToStart)
                .toArray();
        int[] index = {-1};
        String[] expected = {""};
        points.stream()
                .collect(Collectors.toMap(item -> arrDistance[++index[0]], item -> item))
                .entrySet()
                .stream()
                .sorted((x1, x2) -> x2.getKey().compareTo(x1.getKey()))
                .forEach(x -> expected[0] += x.getKey() + " : " + x.getValue() + "\n");

        String[] actual = Task02.sortByDistanceToStart(points);
        Assertions.assertArrayEquals(expected, actual);
    }


}