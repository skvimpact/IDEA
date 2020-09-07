/**
 * Created by KSafonov on 07/09/2017.
 */
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public class Palindrome {
    public static void main(String[] args) {
        //System.out.println(isPalindrome("Ёtan na<>,t"));
        //String[] MyInfo = {"DEV", "uAT", "PROD", "A", "_UAT", "_PROD"};
        //TT(MyInfo);
        //System.out.println(factorial(5));
        int[] a1 = {-8, 0, 2, 2};
        int[] a2 = {-100, 1, 3};
        int[] result = new int[a1.length + a2.length];
        result = mergeArrays(a1, a2);
//        a.length
        System.out.println(Arrays.toString(result));
//        System.out.println(Arrays.toString(b));
    }
    public static boolean isPalindrome(String text) {
        String JustText = text.replaceAll("[^а-яА-Яa-zA-Z]", "").toLowerCase();
        StringBuilder sb = new StringBuilder().append(JustText);
        System.out.println(sb + ">=<" + JustText);
        return sb.reverse().toString().equals(JustText);
    }
    public static void TT(String... MyInfo){

        for(String I : MyInfo) {
            if (I.toUpperCase().equals("UAT")) continue;
//            if (I.toUpperCase() == "UAT") continue;
            //if (I == "uAt") continue;

            System.out.println(I.toLowerCase());
        }


    }
    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.valueOf(value);
        for (int i = value - 1; i > 1; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        int a1index = 0, a2index = 0;

        for( int i = 0; i < a1.length + a2.length; i++) {
            if ((a2index < a2.length) && ((a1index == a1.length) || (a1[a1index] > a2[a2index])))
                result[i] = a2[a2index++];
            else
                result[i] = a1[a1index++];
        }
        return result;
    }
}
