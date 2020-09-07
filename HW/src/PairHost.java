import java.util.Objects;
import java.util.Optional;

/**
 * Created by KSafonov on 21/09/2017.
 */
public class PairHost {
    public static void main(String[] args) {
        Optional<String> a = Optional.of("ss");
        Optional<String> b = Optional.of("ss");
        boolean theyAreEqual = a.equals(b);

        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(2, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
int I = 0;
I += 1;

    }
}

class Pair <T,U>{
    private final T valueFirst;
    private final U valueSecond;

    private Pair(T valueFirst, U valueSecond){
        this.valueFirst = valueFirst;
        this.valueSecond = valueSecond;
    }

    public static <T,U> Pair<T,U> of(T valueFirst, U valueSecond) {
        return new Pair<>(valueFirst, valueSecond);
    }

    public T getFirst(){
        return valueFirst;
    }

    public U getSecond(){
        return valueSecond;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Pair)) return false;

        Pair<?,?> other = (Pair<?,?>) obj;
        return Objects.equals(valueFirst, other.getFirst()) && Objects.equals(valueSecond, other.getSecond());
    }

    @Override
    public int hashCode() {
        return new Long((valueFirst.hashCode())<< 32 + valueSecond.hashCode()).hashCode();
    }
}
