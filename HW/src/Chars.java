import org.omg.CORBA.portable.InputStream;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Created by KSafonov on 19/09/2017.
 */
public class Chars {
    public static void main(String[] args) {
        char[] data = {'ы', 'Ы'};



/*
        String yoyo = "Ыы";
        Reader reader = new CharArrayReader(data);

        try {

            int i = reader.read();
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        //ByteArrayInputStream


        //try (Reader reader2 = new InputStreamReader(reader, StandardCharsets.UTF_8)) {
        //}

        //while
       /* try(Reader reader = new InputStreamReader(new CharArrayReader(char[]{'Ы'}), StandardCharsets.UTF_8)){

        }*/
        /*
        String aaa;
        StringReader reader = new StringReader("This is\n a simple\nstring");
        BufferedReader a  = new BufferedReader(reader);
        try {
            while ((aaa = a.readLine()) != null)
            {
                System.out.println(aaa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //Files.re
        /*
        char a;
        int result;
        try {
            while ((result = reader.read())!=0){
                a = (char)result;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //StringWriter writer = new StringWriter();
        /*
        Writer writer = null;
        //ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            FileOutputStream baos = new FileOutputStream("yoyoyo.txt");
            writer = new OutputStreamWriter(baos, StandardCharsets.UTF_8);

            try {
                writer.write("Ы");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
int gg;
        try {
            Reader reader = new InputStreamReader(new FileInputStream("yoyoyo.txt"), StandardCharsets.UTF_8);
            try {
                while ((gg = reader.read()) != -1){
                    System.out.println(gg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


/*
        byte[] Bs = baos.toByteArray();
        int[] I = new int[Bs.length];


        for(byte B: Bs) {
            System.out.println((int)B);
        }*/
        //System.out.println((byte)1067);
        //System.out.println((byte)(1067>>>8));
    }
}
