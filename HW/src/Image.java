/**
 * Created by KSafonov on 08/09/2017.
 */

public class Image {
    public static void main(String[] args) {
        ComplexNumber first = new  ComplexNumber(1,2);
        ComplexNumber second = new  ComplexNumber(2,1);
      //  java.lang.Double myDouble = 9.0;
      //  int i = myDouble.hashCode();

/*
        Long myLong = new Long(0);
        long justLong = 9234;

        myLong.hashCode();
        System.out.println(justLong);
        int i = d.hashCode();




        Long myLong2 = new Long(0);
        int j = myLong2.hashCode();

            ComplexNumber first = new ComplexNumber(5,-6);
            ComplexNumber second = new ComplexNumber(5,-6);*/
        System.out.println(first.equals(second));
        System.out.println(first.hashCode() + " ><"+ second.hashCode());
        //System.out.println(first.getIm());
        }
}

