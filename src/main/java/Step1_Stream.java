import factory.DishFactory;
import model.Dish;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Adwiti on 8/5/2018.
 */
public class Step1_Stream {
    public static void main(String[] args) {
        List<Dish> menu = DishFactory.dishFactory();
        /**
         * to get the name of the dishes where calories is less than 400
         */
        Stream<Dish> stream = menu.stream(); //this will create a stream
        Stream<Dish> dishStream = stream.filter(d -> d.getCalories() > 400); //this will filter the stream based on the calorie
        Stream<String> stringStream = dishStream.map(Dish::getName); //this will include names only in list
        List<String> collect = stringStream.collect(Collectors.toList());
        System.out.println(collect);

        /**
         * To collect only first three element where calorie is less than 400
         */
        List<String> first2WhereMenuHavingCaloriesLessThan400 = menu.stream().filter(dish -> dish.getCalories() > 400).limit(2).map(Dish::getName).collect(Collectors.toList());
        System.out.println(first2WhereMenuHavingCaloriesLessThan400);

        /**
         * to get the details of dishes where calorie is less than 4000
         */
        List<Dish> collect1 = menu.stream().filter(dish -> dish.getCalories() > 400).collect(Collectors.toList());
        System.out.println(collect1);


    }
}
