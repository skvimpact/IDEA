import java.util.*;


/**
 * Created by KSafonov on 29/09/2017.
 */
public class JavaMap {
    public static void main(String[] args) {
        Map<Integer,String> map = new TreeMap<>();
        map.put(1,"1aaa");
        map.put(2,"2sss");
        map.put(3,"3ddd");
      //  map.put(null,"3-first");
      //  map.put(null,"3-second");
        map.put(4,"4ddd");
        //map.put(null,"3-third");
        for(Integer i:map.keySet()){
            System.out.println(map.get(i));
        }

    }
}
