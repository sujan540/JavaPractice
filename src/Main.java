import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
/*        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);*/

/*        List<Integer> numbers = Arrays.asList(3,2,2,3,7,3,5);
        List<Integer> sq = numbers.stream().map(i->i*i).distinct().collect(Collectors.toList());

        sq.stream().forEach(System.out::println);*/

/*
        List<String> strings = Arrays.asList("","","Sujan");
        System.out.println(strings.stream().count());
        System.out.println(strings.stream().filter(s -> s.isEmpty()).count());
*/
/*
        List<Integer> numbers = Arrays.asList(3,2,2,3,7,3,5);
        numbers.stream().sorted().forEach(System.out::println);*/
        List<Integer> numbers = Arrays.asList(3,2,2,3,7,3,5);
        IntSummaryStatistics stat = numbers.stream().mapToInt((x)->x).summaryStatistics();

        System.out.print(stat.getMax());

        System.out.print(stat.getCount());
    }
}
