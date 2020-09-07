import java.util.Objects;
import java.util.function.*;

public class MyFunction {
    public static void main(String[] args) {

        //java.util.function.Consumer c = java.util.function.Consumer();
/*
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;*/
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        /*Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
*/
        System.out.println(ternaryOperator(Objects::isNull, obj -> 0, CharSequence::length));
//        System.out.println(TTT(x -> x * x * x));



    }

//    public static int CheckString(ternaryOperator ){

//    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return (T t) ->  condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

    public static double TTT(IntToDoubleFunction myFunction){
        int i = 9;
        return myFunction.applyAsDouble(i);
    }
    //public static <T,U>  TTT(Function<? super T, ? extends U> ifTrue){
//        return null;
//    }


}