package chapter6.countmaxmin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class CountMaxMin {
    private static final Logger logger = LoggerFactory.getLogger(CountMaxMin.class);

    public static void main(String[] args) {

        List<Dish> dishes = dishBuilder();
        /**
         * Get the count of Non veg dishes
         */

        List<Dish> collect = dishes.stream().filter(dish -> dish.getType() == Dish.Type.MEAT || dish.getType() == Dish.Type.FISH).collect(Collectors.toList());
        logger.info("List of non veg dishes, {}", collect);
        logger.info("Count of Non veg dishes, {}", collect.stream().count());

        /**
         * To get the maximun value of calorie amongst all the dishes
         */

        List<Dish> dishes1 = dishBuilder();
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> collect1 = dishes1.stream().collect(Collectors.maxBy(dishComparator));
        logger.info("Maximun calories dish is {}", collect1.get());

        /**
         * The same code can be written as under
         */
        List<Dish> dishes3 = dishBuilder();
        Optional<Dish> max = dishes3.stream().max(dishComparator);
        logger.info("Maximum calories dish {}", max.get());

        /**
         * To get the minimum value
         */

        List<Dish> dishes2 = dishBuilder();
        Optional<Dish> collect2 = dishes2.stream().collect(Collectors.minBy(dishComparator));
        logger.info("Minimum calorie dish is {}", collect2.get());

        /**
         * The same code can be written as below
         */
        List<Dish> dishes4 = dishBuilder();
        Optional<Dish> min = dishes4.stream().min(Comparator.comparingInt(Dish::getCalories));
        logger.info("Minimum calorie for dish {}", min.get());

        /**
         * Summarization
         */
        List<Dish> dishes5 = dishBuilder();
        IntSummaryStatistics collect3 = dishes5.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        logger.info("Summation of calories for all dishes, {}", collect3.getSum());
        logger.info("Average of calories for all dishes, {}",collect3.getAverage());
        logger.info("Max calorie, {}",collect3.getMax());
        logger.info("Min calorie, {}",collect3.getMin());

    }

    public static List<Dish> dishBuilder() {
        return Arrays.asList(
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("Season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 800, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );
    }
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class Dish {

    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;

    public enum Type {
        MEAT, FISH, OTHER
    }

}
