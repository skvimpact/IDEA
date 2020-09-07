/**
 * Created by KSafonov on 20/09/2017.
 */
import java.io.*;
import java.nio.charset.*;
public class Chars2 {
    public static void main(String[] args) {
        byte[] testData = {49, 32, 50, 32, 51};
        ByteArrayInputStream bais = new ByteArrayInputStream(testData);
        try {
            System.out.println( readAsString(bais, StandardCharsets.UTF_8 ) );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int readedBytes;
        byte[] buffer = new byte[512];
        while((readedBytes = inputStream.read(buffer, 0, buffer.length)) != -1){
            baos.write(buffer, 0, readedBytes);
        }
        baos.flush();
        return new String(baos.toByteArray(), charset);
    }
}
