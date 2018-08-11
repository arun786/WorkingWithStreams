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
         * to print words
         */
        List<String> seperatedWords = Arrays.asList("w e", "t h e", "pe op le");
        List<String> collect1 = seperatedWords.stream().map(w -> w.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(collect1);
        /*
        o/p will be as below
        [w, e, t, h, e, pe, op, le]
         */

        /**
         * Matrix Multiplication
         * [1,2,3]
         * [4,5]
         */
        List<Integer> num1 = Arrays.asList(1, 2, 3);
        List<Integer> num2 = Arrays.asList(4, 5);

        List<int[]> collect2 = num1.stream().flatMap(i -> num2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());
        for (int[] ints : collect2) {
            System.out.println(ints[0] + "," + ints[1]);
        }
        /*
        o/p will be
        1,4
        1,5
        2,4
        2,5
        3,4
        3,5
         */
    }
}
