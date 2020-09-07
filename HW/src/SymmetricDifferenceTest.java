import java.util.*;

/**
 * Created by KSafonov on 22/09/2017.
 */
//{1, 2, 3} и {0, 1, 2} равна {0, 3}.
public class SymmetricDifferenceTest {
    public static void main(String[] args) {
        /*
        Set<Integer> set1 = new TreeSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
*/
        //Set<Integer> set2 = new TreeSet<>();
       // set2.add(0);
       // set2.add(1);
       // set2.add(2);
/*
        Set<Integer> resultSet = new TreeSet<>();
        resultSet = symmetricDifference(set1, set2);
        for(Integer integer:resultSet) System.out.println(integer);
        */
        Set<String> set1 = new TreeSet<String>();
        set1.add("1");
        set1.add("2");
        set1.add("3");

        Set<String> set2 = new TreeSet<String>();
        set2.add("0");
        set2.add("1");
        set2.add("2");

        //Set<String> resultSet = new TreeSet<>();
        //resultSet = symmetricDifference(set1, set2);
        for(String integer:symmetricDifference(set1, set2)) System.out.println(integer);

//Set rs = new TreeSet

    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> resultSet = new HashSet<T>();

        for(T object:set1){
            if (!set2.contains(object))
                resultSet.add(object);
        }
        for(T object:set2){
            if (!set1.contains(object))
                resultSet.add(object);
        }
        return resultSet;
    }
}

