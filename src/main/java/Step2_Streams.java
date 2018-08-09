import factory.DishFactory;
import model.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Adwiti on 8/5/2018.
 */
public class Step2_Streams {

    public static void main(String[] args) {
        List<Dish> menus = DishFactory.dishFactory();

        /**
         * Filtering a stream with predicate, this will filter all the vegetarian dish
         */
        List<Dish> vegDish = menus.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        System.out.println(vegDish);


        /**
         * Filtering unique elements from a list of integer, use of distinct
         */
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 5, 3, 4, 6, 8, 9, 11, 20, 10, 11, 12, 14, 13);
        List<Integer> distinctNumber = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctNumber);

        /**
         * filtering even numbers from a stream
         */
        List<Integer> evenNumbers = numbers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers);

        /**
         * filtering even distinct numbers from a stream
         */
        List<Integer> evenDistinctNumbers = numbers.stream().filter(i -> i % 2 == 0).distinct().collect(Collectors.toList());
        System.out.println(evenDistinctNumbers);

        /**
         * filtering first 3 even distinct numbers from a stream
         */
        List<Integer> first3EvenDistinctNumbers = numbers.stream().filter(i -> i % 2 == 0).distinct().limit(3).collect(Collectors.toList());
        System.out.println(first3EvenDistinctNumbers);

        /**
         * filtering even distinct numbers skipping the first 2 numbers
         */
        List<Integer> evenDistinctNumbersSkippingFirst2 = numbers.stream().filter(i -> i % 2 == 0).distinct().skip(2).collect(Collectors.toList());
        System.out.println(evenDistinctNumbersSkippingFirst2);

        /**
         * Filter first 2 meat dishes
         */
        List<Dish> first2MeatDish = menus.stream().filter(d -> d.getType() == Dish.Type.MEAT).limit(2).collect(Collectors.toList());
        System.out.println(first2MeatDish);
    }
}
