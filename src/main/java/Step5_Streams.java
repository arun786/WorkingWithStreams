import factory.DishFactory;
import model.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Adwiti on 8/11/2018.
 */
public class Step5_Streams {
    public static void main(String[] args) {
        List<Dish> dishes = DishFactory.dishFactory();

        boolean b = dishes.stream().anyMatch(Dish::isVegetarian);
        if (b) {
            System.out.println("There are few dishes which are vegetarian");
        }

        List<Dish> vegDishes = dishes.stream().filter(Dish::isVegetarian).collect(Collectors.toList());

        boolean b1 = vegDishes.stream().allMatch(Dish::isVegetarian);
        if (b1) {
            System.out.println("All dishes are vegetarian");
        }

        List<Dish> lowCalorie = dishes.stream().filter(d -> d.getCalories() < 500).collect(Collectors.toList());

        boolean b2 = lowCalorie.stream().noneMatch(d -> d.getCalories() >= 500);
        if (b2) {
            System.out.println("All dishes are low calorie");
        }

        dishes.stream().filter(Dish::isVegetarian).findAny().ifPresent( d -> System.out.print(d));
        /*
        o/p will be
        Dish(name=french fries, vegetarian=true, calories=530, type=OTHER)
         */

        System.out.println();
        List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 7);
        Optional<Integer> first = numbers.stream().map(d -> d * d).filter(x -> x % 5 == 0).findFirst();
        System.out.println(first);
        /*
        Optional[25]
         */


    }
}
