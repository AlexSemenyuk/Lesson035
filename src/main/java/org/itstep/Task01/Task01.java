package org.itstep.Task01;


import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
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

        while (true) {
            System.out.print("1-cars, 2-cars by color, 3-cars above price , 4-cars by range makeYear, 5-cars (sort reverse priceпо уменьшению цены), 0-Exit >>> ");
            int n = scanner.nextInt();
            switch (n){
                case 1:
                    printCars(cars);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Ds неправильно ввели данные");
                    break;
            }
        }
    }


    public static void printCars (Collection cars){
        cars.stream()
                .forEach(x -> System.out.println(x));
    }

}
