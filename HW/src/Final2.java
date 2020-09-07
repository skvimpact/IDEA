/**
 * Created by KSafonov on 28/09/2017.
 */
public class Final2 {
}
/*
//import java.util.stream.Collectors;
public static interface Sendable {
    String getFrom();
    String getTo();
}

public static abstract class Something<T> implements Sendable {
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
    public T      getContent() {
        return content;
    }
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

public static class  MailService<T> implements Consumer<Object> {
    private List<? super Sendable> somethings  = new ArrayList<>();
    public MailService(){
    }

    public <T,U> Map<T,List<U>> getMailBox(){
        Map<T,List<U>> map = new HashMap<>();
        somethings.stream()
                .map(s -> (T)((Something<T>)s).getTo())
                .distinct()
                .forEach(d -> map.put(d,
                        somethings.stream()
                                .filter(l -> ((Something<T>)l).getTo() == null ? false : ((Something<T>)l).getTo().equals(d))
                                .map(l -> (U)((Something<T>)l).getContent())
                                .collect(java.util.stream.Collectors.toList())
                ));
        return map;
    }

    @Override
    public void accept(Object obj){
        somethings.add((Something<T>)obj);
    }
}
*/