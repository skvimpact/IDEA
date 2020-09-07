import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * Created by KSafonov on 26/09/2017.
 */
public class MyStream {
    public static void main(String[] args)

    {
       //System.out.println(Integer.toString(123, 1));
       // int u = 123456;


        //System.out.println( 254 & 0xFF);


        pseudoRandomStream(13).forEach(System.out::println);
    }


    public static IntStream pseudoRandomStream(int seed) {
        //return IntStream.iterate(0, i -> i + 1).map(i -> random(seed,i) );
        return IntStream.iterate(seed, n -> mid(n * n)).limit(10);//n -> random(seed, n) );






    }

    public static int mid(int x){
        return (x - x / 10000* 10000) / 10;
    }

    public static int random(int seed, int step){
        int result = seed;
        for(int i = 0; i < step; i++)
            result = mid(result * result);
        return result;
    }

    //minMaxConsumer.accept(min, max);
    //minMaxConsumer.accept(null, null);
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        T min = null;
        T max = null;
        List<T> list = stream.sorted(order).collect(Collectors.toList());
        if (list.size() != 0){
            min = list.get(0);
            max = list.get(list.size() - 1);
        }
        minMaxConsumer.accept(min,max);

    }



}
