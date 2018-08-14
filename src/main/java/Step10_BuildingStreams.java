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
    }
}
