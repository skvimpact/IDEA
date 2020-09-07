/**
 * Created by KSafonov on 18/09/2017.
 * На вход подан InputStream, последовательно возвращающий три байта: 0x33 0x45 0x01. В качестве контрольной суммы должно быть возвращено число 71.
 */
import java.io.*;
public class ControlSum {
    public static void main(String[] args) {

        byte[] testData = {0x33,0x45,0x01};
        try(InputStream inputStream = new ByteArrayInputStream(testData)){
            System.out.println(checkSumOfStream(inputStream));
        }
        catch(IOException ex) {
        }
        //testInput.t
//        "MyStr".b

    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        // your implementation here
        //byte[] data;
        int controlSum = 0;
        int currentByte;
        while((currentByte = inputStream.read()) > -1){
            controlSum = Integer.rotateLeft(controlSum, 1) ^ currentByte;
        }
        return controlSum;
    }
}
