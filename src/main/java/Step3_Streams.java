import factory.DishFactory;
import model.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Adwiti on 8/8/2018.
 */
public class Step3_Streams {

    public static void main(String[] args) {
        List<Dish> dishes = DishFactory.dishFactory();

        /**
         * The below map will display only the name of all dishes
         */
        List<String> dishNames = dishes.stream().map(Dish::getName).collect(Collectors.toList());
        System.out.println(dishNames);

        /**
         * To get the length of each word in a list
         */
        List<String> names = Arrays.asList("Never", "Give", "Up", "Arun");
        List<Integer> lengthOfNames = names.stream().map(s -> s.length()).collect(Collectors.toList());
        System.out.println(lengthOfNames);

        /**
         * The above code can also be written as below
         */
        List<Integer> lngthOfNames = names.stream().map(String::length).collect(Collectors.toList());
        System.out.println(lngthOfNames);

        /**
         * Length of the name of each dish
         */
        List<Integer> lengthOfEachDishes = dishes.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
        System.out.println(lengthOfEachDishes);

    }
}
