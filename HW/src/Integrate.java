/**
 * Created by KSafonov on 11/09/2017.
 */
import java.util.function.DoubleUnaryOperator;
public class Integrate {
    public static void main(String[] args) {
        //CharSequence cs = new CharSequence();
        //int i = cs.length();


        byte[] Z= {'a','b','c','3','2','1'};

       // String f = "qwe";
        //int u = f.length();

       // double myResult = integrate(x -> 1, 0, 10);
        //result.
        //System.out.println(myResult);
        AsciiCharSequence cs = new AsciiCharSequence(Z);
        System.out.println(cs.length() + "><" + cs.subSequence(1,2) + "><" + cs.toString());
    }

    public static double integrate2(DoubleUnaryOperator f, double a, double b) {

        double x;
        double delta = 1e-6;
        double oldResult = a * delta;
        double difference = 1e-10;
        double newResult = oldResult + 2 * difference;

        while (Math.abs(newResult - oldResult) > difference) {
            x = a;
            delta = delta / 2;
            oldResult = newResult;
            newResult = 0;
            while (x < b) {
                newResult += f.applyAsDouble(x) * delta;
                x += delta;
            }
        }
        return newResult;
    }
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double delta = 1e-6;
        double Result = 0;

        while (a < b) {
                Result += f.applyAsDouble(a) * delta;
                a += delta;
        }
        return Result;
    }


}
