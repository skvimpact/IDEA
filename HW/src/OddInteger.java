import java.io.ByteArrayInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class OddInteger {
    public static void main(String[] args) {
      //  java.io.OutputStream outputStream = System.out;
        //FileOutputStream outputStream = null;
        //try {
//            outputStream = new FileOutputStream("Odd.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[]{ 49, 32, 50, 32, 51,  32, 52, 32, 53});//, 32, 52, 32, 53, 32, 54, 32, 55, 32, 53, 32, 32});
        //ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[]{ 32, 32, 32, 32, 50, 32, 51, 32, 52, 32, 53, 32, 52, 32, 55});

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        DataOutputStream daos = new DataOutputStream(outputStream);
       // //java.io.InputStream inputStream = System.in;

        ArrayList<Integer> integers = handleDate(inputStream);
        for ( int i =  0 ; i < integers.size(); i++){
        //for ( int i = integers.size() - 1 ; i >=0 ; i--){
            System.out.print(integers.get(i) + " ");
        }


    }
    public static ArrayList<Integer> handleDate(InputStream inputStream) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(inputStream);
        int position = 0, myInt;
        while (scanner.hasNextInt()) {
            myInt = scanner.nextInt();
            if ((position++ % 2) != 0) list.add(myInt);
        }
        return list;
    }

/*
    static class MyComp implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return b.compareTo(a);
        }
    }*/
}
