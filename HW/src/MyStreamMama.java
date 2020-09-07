import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class MyStreamMama {

    public static class Word{
        String value;
        long frequency;
        public Word(String value, long frequency)
        {
            this.value = value;
            this.frequency = frequency;
        }
    }

    public static class WordComparator implements Comparator<Word> {
        public int compare(Word a, Word b) {
            int frequencyComare = Long.valueOf(b.frequency).compareTo(Long.valueOf(a.frequency));
            if (frequencyComare == 0)
                return a.value.compareTo(b.value);
            return frequencyComare;
        }
    }

    public static void main(String[] args) {

        //java.io.InputStream inputStream = System.in;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("yoyoyo.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        showWords(inputStream);
    }

    public static void showWords(InputStream is){
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        br.lines().flatMapToInt(s -> s.chars().map( c -> Character.isLetterOrDigit(c) ? c : ' ' ))
                  .map(Character::toLowerCase)
                  .forEach(sb::appendCodePoint);

        String[] rawWords = sb.toString().trim().split(" ");

        List<Word> distinctWords = new ArrayList<>();
        Arrays.stream(rawWords)
                .distinct()
                .forEach(c -> distinctWords.add(new Word(  c,
                        Arrays.stream(rawWords).filter(p -> (p.equals(c))).count()
                )));

        distinctWords.stream()
                .sorted(new WordComparator())
                .limit(11)
                .map(p -> p.value)
                .forEach(System.out::println);
    }
}
