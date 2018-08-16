import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Adwiti on 8/13/2018.
 */
public class Step10_BuildingStreams {
    public static void main(String[] args) {
        /**
         * use of Stream.of
         */
        Stream<String> hello = Stream.of("Hello", " Arun", " How are you");
        List<String> collect = hello.map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);

        /**
         * Streams from Arrays
         */
        int [] numbers = {2,3,4,5,6,7};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);

        /**
         * Creating an infinite stream, using Stream.iterate
         */
        List<Integer> infiniteStream = Stream.iterate(0, n -> n + 2).limit(10).collect(Collectors.toList());
        System.out.println(infiniteStream);

        /**
         * fibonacci series
         */
        List<Integer> fibonnaci = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(20).map(t -> t[0]).collect(Collectors.toList());
        System.out.println(fibonnaci);
    }
}
