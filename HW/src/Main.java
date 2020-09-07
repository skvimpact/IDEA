
//import static java.lang.System.*;
import java.io.*;

import java.lang.System.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args)  throws IOException {


        //java.io.InputStream is = System.in;
        //java.io.OutputStream os = System.out;

        ByteArrayInputStream is = new ByteArrayInputStream( new byte[]{13, 10, 65, 13, 10, 10, 13, 66,67, 13, 10, 64, 0, -1});
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        //Charset charset = StandardCharsets.UTF_8;
        Charset charset1 = Charset.defaultCharset();
        System.out.println(charset1);

        int currentByte = is.read();
        int nextByte = 0;
        try{
            while ( currentByte!= -1) {
                nextByte = is.read();
                if (!(currentByte == 13 && nextByte == 10))
                    os.write(currentByte);
                currentByte = nextByte;
            }

        }
        catch(Exception ex){

        }
        os.flush();



/*
        convert(is, os);*/
        for (byte i: os.toByteArray()) {
            System.out.println(i);
        }


    }

    private static void convert(InputStream inputStream,OutputStream outputStream) throws IOException {
        int buf1 = inputStream.read();
        int buf2;

        while(buf1 != -1){
            buf2 = inputStream.read();
            if (!(buf2 == 10 && buf1 == 13)){
                outputStream.write(buf1);
            }
            buf1 = buf2;
        }
        outputStream.flush();
    }
}
