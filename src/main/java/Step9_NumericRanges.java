import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Adwiti on 8/12/2018.
 */
public class Step9_NumericRanges {
    public static void main(String[] args) {
        /**
         * to generate even numbers from 1 to 20. 20 inclusive
         */
        IntStream intStream = IntStream.rangeClosed(1, 20).filter(i -> i % 2 == 0);
        List<Integer> evenNumbers = intStream.boxed().collect(Collectors.toList());
        System.out.println(evenNumbers);
        /*
        o/p will be
        [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
         */

        /**
         * to generate even numbers from 1 to 20, 20 exclusive
         */
        List<Integer> collect = IntStream.range(1, 20).filter(i -> i % 2 == 0).boxed().collect(Collectors.toList());
        System.out.println(collect);
        /*
        o/p will be
        [2, 4, 6, 8, 10, 12, 14, 16, 18]
         */

        /**
         * to get the sum of first 100 even numbers, 100 included
         */
        int sum = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0).sum();
        System.out.println(sum);

        /**
         * To get the sum of first 100 numbers, 100 not included
         */
        int sum1 = IntStream.range(1, 100).filter(i -> i % 2 == 0).sum();
        System.out.println(sum1);


        double sqrt = Math.sqrt(5 * 5 + 6 * 6);
        System.out.println(sqrt);
        System.out.println(sqrt % 1);

        /**
         * pythagorean triples, a*a + b*b = c*c
         */

        Stream<int[]> stream = IntStream.range(1, 100).boxed().flatMap(a -> IntStream.range(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));

        stream.limit(5).forEach(t -> {
            System.out.println(t[0] + "," + t[1] + "," + t[2]);
        });
    }
}
