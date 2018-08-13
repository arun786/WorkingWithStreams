import factory.DishFactory;
import model.Dish;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

/**
 * Created by Adwiti on 8/12/2018.
 */
public class Step8_IssueOfBoxing {

    public static void main(String[] args) {
        List<Dish> dishes = DishFactory.dishFactory();

        /**
         * To get the sum of calories in the dishes, the below code has issue with boxing and unboxing
         */

        Integer sumOfCalories = dishes.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        System.out.println(sumOfCalories);

        /**
         * here the issue of boxing and unboxing is resolved
         */
        int sumOfCaloriesWithMapToInt = dishes.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sumOfCaloriesWithMapToInt);

        /**
         * to get the max
         */
        Optional<Integer> maxCalorie = dishes.stream().map(Dish::getCalories).reduce(Integer::max);
        System.out.println(maxCalorie);

        OptionalInt maxCaloie = dishes.stream().mapToInt(Dish::getCalories).max();
        System.out.println(maxCaloie);

        /**
         * to get the min
         */
        Optional<Integer> minV = dishes.stream().map(Dish::getCalories).reduce(Integer::min);
        System.out.println(minV);

        /**
         * here when you get the value of OptionalInt, you can specify the default value also using orElse
         */
        OptionalInt min = dishes.stream().mapToInt(Dish::getCalories).min();
        System.out.println(min.orElse(1));

        /**
         * to get the average
         */
        Integer sumOfCaloriesOfAllDishes = dishes.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        long count = dishes.stream().count();
        double avg = (double) sumOfCaloriesOfAllDishes / count;
        System.out.println(avg);

        OptionalDouble average = dishes.stream().mapToInt(Dish::getCalories).average();
        System.out.println(average.getAsDouble());
    }
}
