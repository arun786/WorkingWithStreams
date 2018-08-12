import factory.DishFactory;
import model.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Adwiti on 8/12/2018.
 */
public class Step6_Reducing {
    public static void main(String[] args) {
        List<Dish> dishes = DishFactory.dishFactory();

        /**
         * To add sequence of numbers to get a single result, use Reduce
         */

        List<Integer> numbers = Arrays.asList(1, 4, 6, 7, 9, 10);
        Integer sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        /*
        o/p will be 37
         */

        /**
         * the above code can also be written as below
         */
        Integer sum1 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum1);

        Optional<Integer> sum2 = numbers.stream().reduce(Integer::sum);
        System.out.println(sum2);

        /**
         * To get the max value
         */
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println(max);

        Integer maximun = numbers.stream().reduce(0, Integer::max);
        System.out.println(maximun);

        /**
         * to get the minimum value
         */
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println(min);

        /**
         * To count the number of dishes
         */
        Integer numberOfDishes = dishes.stream().map(dish -> 1).reduce(0, Integer::sum);
        System.out.println(numberOfDishes);
        /*
        o/p will be 8
         */

        /**
         * to get the maximum of calories
         */
        Integer maxCalorie = dishes.stream().map(dish -> dish.getCalories()).reduce(0, Integer::max);
        System.out.println(maxCalorie);

        /**
         * to get the minimum of calories
         */
        Optional<Integer> minCalorie = dishes.stream().map(dish -> dish.getCalories()).reduce(Integer::min);
        System.out.println(minCalorie);

    }
}
