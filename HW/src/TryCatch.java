/**
 * Created by KSafonov on 13/09/2017.
 */
public class TryCatch {
    public static void main(String[] args) {

        int i = 10;
        int j = 10;
        try{
            //j = i/0;
            for(int k=0; k<5;k++){
                if (k > 1) break;
            }

            return;
        } catch(Exception e){
            //j = i/0;
        } finally{
            System.out.println("I've finished");
        }
    }
}
