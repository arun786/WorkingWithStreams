import factory.DishFactory;
import model.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Adwiti on 8/9/2018.
 */
public class Step4_Streams {
    public static void main(String[] args) {
        List<Dish> dishes = DishFactory.dishFactory();

        /**
         * To get individual characters, the below code wont work as the map returns string array
         */
        List<String> words = Arrays.asList("Hello", "World");
        List<String[]> collect = words.stream().map(word -> word.split("")).collect(Collectors.toList());
        System.out.println(collect);

        /**
         * The below code will print the individual letters
         */
        List<String> individualLetters = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(individualLetters);

        /**
         * To get distinct individual letters
         */
        List<String> distinctIndividualLetters = words.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(distinctIndividualLetters);

        /**
         * Given a list of numbers, print the square of the numbers
         */

        List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 7, 9);
        List<Integer> squareOfNumber = numbers.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println(squareOfNumber);

        /**
         * Matrix Multiplication
         */


    }
}
