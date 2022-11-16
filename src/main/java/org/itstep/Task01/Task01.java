package org.itstep.Task01;

/**
 * Hello world!
 *
 */
public class Task01 {
    public static void main(String[] args) {
        Collection<Car> cars = Arrays.asList(
                new Car ("Mazda", 16, Gender.MAN),
                new Student("Петя", 23, Gender.MAN),
                new Student("Соня", 18, Gender.WOMEN),
                new Student("Виктор Петрович", 65, Gender.MAN),
                new Student("Дима", 25, Gender.MAN),
                new Student("Катя", 21, Gender.WOMEN),
                new Student("Семен", 33, Gender.MAN),
                new Student("Елена", 42, Gender.WOMEN),
                new Student("Иван Иванович", 69, Gender.MAN)
        );
    }
}
