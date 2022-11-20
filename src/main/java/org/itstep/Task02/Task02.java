package org.itstep.Task02;


import java.util.*;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

public class Task02 {
    final static Scanner scanner = new Scanner(System.in);
    final static Scanner scanner1 = new Scanner(System.in);
    final static Random rnd = new Random(150);

    public static void main(String[] args) {
        Collection<Point<Integer, Integer>> points = asList(
                new Point(50, 250),
                new Point(350, 150),
                new Point(550, 750),
                new Point(230, 60),
                new Point(100, 80),
                new Point(130, 25),
                new Point(390, 90),
                new Point(280, 140),
                new Point(210, 370),
                new Point(310, 400),
                new Point(90, 130),
                new Point(110, 330)
        );
        Map<Double, Point<Integer, Integer>> map = null;
        while (true) {
            System.out.print("1-max x, 2-distance to start point, 3-create new collection , 4-collection sort by distance to down, 9-print existing collection, 0-Exit >>> ");
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    Point point = maxX(points);
                    System.out.println(point);
                    break;
                case 2:
                    map = null;
                    map = distanceToStart(points);
                    printPointWithDistance(map);
                    break;
                case 3:
                    System.out.print("Input quality of points >>> ");
                    final int number = scanner.nextInt();
                    Collection<Point<Integer, Integer>> newPoints = createCollection(number);
                    printPoint(newPoints);
                    break;
                case 4:
                    sortByDistanceToStart(points);
                    break;
                case 9:
                    printPoint(points);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Вы неправильно ввели данные");
                    break;
            }
        }
    }

    public static void printPoint(Collection<Point<Integer, Integer>> points) {
        System.out.println("All points ---------------------------------------------------------------");
        points.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------");
    }

    public static void printPointWithDistance(Map<Double, Point<Integer, Integer>> map) {
        System.out.println("All points ---------------------------------------------------------------");
        map.entrySet().forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------");
    }
    public static Point<Integer, Integer> maxX(Collection<Point<Integer, Integer>> points) {
        Point point = points.stream()
                .max(Comparator.comparing(Point::getX))
                .orElseThrow();
        return  point;
    }

    public static Map<Double, Point<Integer, Integer>> distanceToStart(Collection<Point<Integer, Integer>> points) {
        double[] arrDistance = points.stream()
                .mapToDouble(Task02::calculationDistanceToStart)
                .toArray();
        int[] index = {-1};
        Map<Double, Point<Integer, Integer>> map = points.stream()
                .collect(Collectors.toMap(item -> arrDistance[++index[0]], item -> item));
        return map;

//        double[] arr = points.stream()
//                .mapToDouble(Task02::distanceToStart)
//                .toArray();
//        System.out.println("---------------------------------------------------------------");
//        System.out.println("Distance each of points of stream to start point (0;0)");
//        int i = 0;
//
//
//        for (Point point : points) {
//            System.out.printf("%-21s - %.2f\n", point, arr[i]);
//            i++;
//        }
////        System.out.println(Arrays.toString(arr));
//        System.out.println("-----------------------------------------------------------------------");
    }


    public static Collection<Point<Integer, Integer>> createCollection(final int number) {
        List rezult = Stream.generate(() -> new Point(rnd.nextInt(number + 11), rnd.nextInt(number + 11)))
                .filter(p -> calculationDistanceToStart(p) > 5)
                .limit(number)
                .collect(toList());
        System.out.println("-New collection --------------------------------------------------------------");
        return rezult;
    }


    public static double calculationDistanceToStart(Point<Integer, Integer> p) {
        double rezult = Math.ceil(Math.sqrt(p.getX() * p.getX() + p.getY() * p.getY()));
        return rezult;
    }

    public static String [] sortByDistanceToStart(Collection<Point<Integer, Integer>> points) {
        System.out.println("-Sort existing collection to down--------------------------------------------------------------");
        String[] rezult = {""};
                distanceToStart(points)
                .entrySet()
                .stream()
                .sorted((x1, x2) -> x2.getKey().compareTo(x1.getKey()))
                .forEach(x -> rezult[0] += x.getKey() + " : " + x.getValue() + "\n");
        System.out.println(Arrays.toString(rezult));
        return rezult;
    }
}