import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {

        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[]{ 49, 32, 50, 32, 51, 13, 56, 55, 13, 53, 53,53,54});
        //java.io.InputStream inputStream = System.in;

        System.out.printf("%.6f", getStreamSum(inputStream));
    }

    public static double getStreamSum(InputStream inputStream){
        double result = 0;
        String currentLine;
        /*
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()){
            if (scanner.hasNextInt())
                result += scanner.nextInt();
            if (scanner.hasNextFloat())
                result += scanner.nextFloat();
            if (scanner.hasNextDouble())
                result += scanner.nextDouble();
        }
        */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try{
            while ((currentLine = bufferedReader.readLine()) != null)
            {
                String[] candidates = currentLine.split(" ");
                for(String candidate: candidates){
                    try{
                        result += Double.parseDouble(candidate);
                    } catch (NumberFormatException e) {}
                }
            }
        }
        catch(IOException ex){

        }
        return result;
    }
}
