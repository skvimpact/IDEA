/**
 * Created by KSafonov on 05/09/2017.
 */
public class Quiz2 {
    public static void main(String[] args) {
        /*
        System.out.println(booleanExpression(false, false,false,false));
        System.out.println(booleanExpression(false, false,false,true));
        System.out.println(booleanExpression(false, false,true,false));
        System.out.println(booleanExpression(false, false,true,true));
        System.out.println(booleanExpression(false, true,false,false));
        System.out.println(booleanExpression(false, true,false,true));
        System.out.println(booleanExpression(false, true,true,false));
        System.out.println(booleanExpression(false, true,true,true));
        System.out.println(booleanExpression(true, false,false,false));
        System.out.println(booleanExpression(true, false,false,true));
        System.out.println(booleanExpression(true, false,true,false));
        System.out.println(booleanExpression(true, false,true,true));
        System.out.println(booleanExpression(true, true,false,false));
        System.out.println(booleanExpression(true, true,false,true));
        System.out.println(booleanExpression(true, true,true,false));
        System.out.println(booleanExpression(true, true,true,true));*/
        //System.out.println(TTT( 6));
        //System.out.println(IsSpecial(5));
        //System.out.println(leapYearCount(1));
        //System.out.println(leapYearCount(4));
        //System.out.println(leapYearCount(100));
        //System.out.println(doubleExpression(.1,.2,.3));
        //System.out.println(flipBit(15, 4));
        //System.out.println(charExpression(6));
        //System.out.println(isPowerOfTwo(3));
        //System.out.println(java.lang.Integer.highestOneBit(0));
        //System.out.println(isPowerOfTwo(-2));
       // System.out.println("A" + 12  );
         System.out.println((int)Math.pow(5,3));
    //    Convert();
    }
    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
       // return ((a ^ b) & (c ^ d));// | ((a & b) ^ (c & d));
       // return  ((a & b) & !(c | d)) | ((c & d) & !(a | b));
       // return  ((a | b) ^ (c | d));
        return ((a ^ b) & (c ^ d)) | ((a & b) & !(c | d)) | ((c & d) & !(a | b));
    }

    public static int TTT(int b){
       // return a | b;
        //return 1 << 3;
        //return 0b0101;
        //return 1 << (b - 1); Good
        return ~1;
        //return 5 >> 1;
    }
    public static boolean IsSpecial(int Year){
        // return a | b;
        //return 1 << 3;
        //return 0b0101;
        return (((Year % 4) == 0) & ((Year % 100) != 0)) | ((Year % 400) == 0);
    }

    public static int leapYearCount(int year) {
        return year / 4 - year / 100 + year / 400;
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a + b - c) < 1E-4;
    }

    public static int flipBit(int value, int bitIndex) {
        return value ^ (1 << (bitIndex - 1));//... // put your implementation here
    }
    public static char charExpression(int a) {

        //char Slash;
        //Slash = '\\';
        //int newChar = (int)Slash + a;
        //System.out.println((int)Slash);
        return (char)((int)'\\' + a);


    }

    public static boolean isPowerOfTwo(int value) {

        return (java.lang.Integer.highestOneBit(Math.abs(value)) == Math.abs(value)) & (value != 0);
        //return ... // you implementation here

    }
    /*
    public static void Convert(){
      char A = 'a';
      int I;
      long L = 4;
      float F =5;
      byte B = 2;
      Character Cr;
      F = L;
      L = F;
      I = A;
      A = B;
      L = I;
        Cr = A;


    }*/

}
/*

 */