package org.itstep.Task01;


import java.util.*;
import java.util.stream.Collectors;

public class Task01 {
    final static Scanner scanner = new Scanner(System.in);
    final static Scanner scanner1 = new Scanner(System.in);

    public static void main(String[] args) {

        Collection<Car> cars = Arrays.asList(
                new Car("Mazda", 2018, 8000, "Green", 2.0),
                new Car("BMW", 2012, 7000, "Black", 2.5),
                new Car("Hyundai", 2007, 5000, "Red", 1.6),
                new Car("Nissan", 2015, 10000, "Gray", 2.0),
                new Car("Renault", 2012, 6000, "Metallic", 1.5),
                new Car("Skoda", 2006, 5000, "Red", 1.8),
                new Car("Mercedes", 2018, 28000, "White", 2.5),
                new Car("Chevrolet", 2006, 4000, "Gray", 1.5),
                new Car("Daewoo", 2006, 2500, "Green", 1.0)
        );
        String line = "";
        Collection<Car> newCars = null;
        while (true) {
            System.out.print("1-cars, 2-cars by color, 3-cars above the price , 4-cars by range makeYear, 5-cars (sort reverse price), 0-Exit >>> ");
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    printCars(cars);
                    break;
                case 2:
                    newCars = null;
                    line = "";
                    System.out.print("Input color cars >>> ");
                    line = scanner1.nextLine();
                    newCars = carsByColor(cars, line);
                    printCars(newCars);
                    break;
                case 3:
                    newCars = null;
                    System.out.print("Input cars price >>> ");
                    final int price = scanner.nextInt();
                    newCars = carsAbovePrice(cars, price);
                    printCars(newCars);
                    break;
                case 4:
                    newCars = null;
                    int[] years = {0, 0};
                    while (true) {
                        System.out.print("Input start of the time range makeYear >>> ");
                        years[0] = scanner.nextInt();
                        System.out.print("Input end of the time range makeYear >>> ");
                        years[1] = scanner.nextInt();
                        if (years[0] > 1900 && years[0] <= 2022 && years[1] <= 2022 && years[1] >= years[0]) {
                            break;
                        } else {
                            System.out.println("Вы неправильно ввели данные");
                        }
                    }
                    newCars = carsByTimeRange(cars, years);
                    printCars(newCars);
                    break;
                case 5:
                    newCars = null;
                    newCars = carsBySortedPrice(cars);
                    printCars(newCars);
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


    public static void printCars(Collection<Car> cars) {
        System.out.println("All cars ---------------------------------------------------------------");
        cars.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------");
    }

    public static Collection<Car> carsByColor(Collection<Car> cars, String line) {
        System.out.println("All cars with " + line + " color ----------------------------------------------");
        Collection<Car> rezult = cars.stream()
                .filter(x -> line.equalsIgnoreCase(x.getColor()))
                .collect(Collectors.toList());
        return rezult;
    }

    public static Collection<Car> carsAbovePrice(Collection<Car> cars, int price) {
        System.out.println("All cars with price above " + price + "----------------------------------------------");
        Collection <Car> rezult = cars.stream()
                .filter(x -> price < x.getPrice())
                .collect(Collectors.toList());
        return rezult;
    }

    public static Collection<Car> carsByTimeRange(Collection<Car> cars, int [] years) {
        System.out.println("All cars with makeYear between " + years[0] + " and " + years[1] + "------------");
        Collection <Car> rezult = cars.stream()
                .filter(x -> years[0] <= x.getMakeYear())
                .filter(x -> years[1] >= x.getMakeYear())
                .collect(Collectors.toList());
        return rezult;
    }

    public static Collection<Car>  carsBySortedPrice(Collection<Car> cars) {
        System.out.println("All cars with reverse sort by price -------------------------------------");
        Collection <Car> rezult = cars.stream()
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .collect(Collectors.toList());
        return rezult;
    }

}
