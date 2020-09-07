/**
 * Created by KSafonov on 15/09/2017.
 */
import java.io.*;
import java.nio.*;
public class MyFile {
    static void Swap(String a, String b){
        //String z = b;
        b = b + "bb";
        a = a + "aa";
    }
    public static void main(String[] args) {
        //Integer i = 100;
        String a = "a";
        String b = "b";
        //String z = b;
        //b = a;
        //a = z;
        Swap(a, b);
        System.out.println(a + b);




        System.out.println(Integer.rotateLeft(343588865,1));

       /* String[] vehicles = {"Kirill's car","Andrew's car", "bicycle"};

        for(String vehicle:vehicles){
            if (vehicle.endsWith("car")) System.out.println(vehicle);
        }*/


        //File file = new File("a\\b\\c\\file.txt"); //a\b\c\
        //File file = new File("a\\..\\b\\c\\file.txt");// b\c\
        //File file = new File("a\\b\\..\\file.txt"); //a\
        //File file = new File("a\\.\\b\\..\\c\\file.txt"); //a\c\
        //File file = new File("a\\.\\c\\file.txt"); //a\c\
        File file = new File(".\\a\\b\\..\\b\\c\\.\\file.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
       // System.out.println((file.getAbsolutePath()));
       // System.out.println(file.getPath());
       // System.out.println(file.getName());
       // System.out.println(file.getParent());
        try{
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //file.listFiles(f -> f.)
        /*
        try {
            System.out.println(file.getCanonicalPath());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }*/

    }
}
