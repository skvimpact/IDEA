import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collector;

/**
 * Created by KSafonov on 27/09/2017.
 */
public class FinalTask {
    public static void main(String[] args) {
        // Random variables
        String randomFrom = "..."; // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        String randomTo = "...";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        int randomSalary = 100;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.

        MailMessage firstMessage = new MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );
        MailMessage secondMessage = new MailMessage(
                "d",
                "Christopher Nolan",
                "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
        );

        MailMessage thirdMessage = new MailMessage(
                "Stephen Hawking",
                "Christopher Nolan",
                "Я так и не понял Интерстеллар."
        );
        System.out.println(firstMessage.getContent().endsWith("Howard!"));
        /*MailMessage firstMessage = new MailMessage(
                null,
                "H.P. Lovecraft",
                null
        );
        MailMessage secondMessage = new MailMessage(
                null,
                null,
                null
        );

        MailMessage thirdMessage = new MailMessage(
                null,
                null,
                null
        );*/


        List<MailMessage> messages= Arrays.asList(firstMessage, secondMessage, thirdMessage);
        MailService<String> mailService = new MailService<>();
        messages.stream().forEachOrdered(mailService);


        Map<String, List<String>> mailBox = mailService.getMailBox();
        System.out.println(mailBox.get("H.P. Lovecraft"));
        System.out.println(mailBox.get("Christopher Nolan"));

       /* Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", 100);
        Salary salary3 = new Salary("FC Barcelona", "Lionel Messi", 200);
        Salary salary1 = new Salary("FC Barcelona", "Lionel Messi", 300);*/
        //Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);

/*        Salary salary1 = new Salary(null, null, null);
        Salary salary2 = new Salary(null, null, null);
        Salary salary3 = new Salary(null, null, null);

        MailService<Integer> salaryService = new MailService<>();
        Arrays.asList(salary1, salary2, salary3).forEach(salaryService);
        Map<String, List<Integer>> salaries = salaryService.getMailBox();

       System.out.println(salaries.get("Lionel Messi"));*/
    }

    public static class MyHashMap<K, V> extends HashMap<K, List<V>> {
        @Override
        public List<V> get(Object key) {
            return this.getOrDefault(key, new LinkedList<>());
        }
    }

    public static class  MailService<T> implements Consumer<Sendable<T>> {
        private  final Map<String,List<T>> map;

        public MailService(){
            map = new MyHashMap<>();
        }

        public  Map<String, List<T>> getMailBox(){
            return map;
        }
        @Override
        public void accept(Sendable<T> sendable){
            List<T> list = map.get(sendable.getTo());
            list.add(sendable.getContent());
            map.put(sendable.getTo(), list);
        }
    }
    public static interface Sendable<T> {
        String getFrom();
        String getTo();
        T getContent();
    }











    public static abstract class Something<T> implements Sendable<T> {
        private String from;
        private String to;
        private T      content;

        public Something(String from, String to, T content) {
            this.from    = from;
            this.to      = to;
            this.content = content;
        }

        public String getFrom()    { return from; }
        public String getTo()      { return to; }
        public T      getContent() { return content; }
    }

    public static class MailMessage extends Something<String> {
        public MailMessage(String from, String to, String message){
            super(from, to, message);
        }
    }

    public static class Salary extends Something<Integer>{
        public Salary(String from, String to, Integer salary){
            super(from, to, salary);
        }
    }
}

