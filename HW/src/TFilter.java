
import java.util.Arrays;

public class TFilter{
    public static void main(String[] args) {


        //SpamAnalyzer dd = new SpamAnalyzer(new String[]{"быстро", "дёшево"});
        //System.out.println(dd.getKeywords());

        TextAnalyzer[] analyzers = new TextAnalyzer[]{
                new SpamAnalyzer(new String[]{"быстро2", "дёшево"}),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(20)};

        System.out.println(Tool.checkLabels(analyzers, "Быстро и качественно устраним все проблемы):)"));
    }



}

enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}

interface TextAnalyzer {
    Label processText(String text);
}


class Tool{
    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        Label currentLabel;
        for(TextAnalyzer textAnalyzer: analyzers) {
            currentLabel = textAnalyzer.processText(text);
            if (currentLabel != Label.OK) return currentLabel;
        }
        return Label.OK;
    }
}

abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    public Label processText(String text) {
        String[] keywords = getKeywords();
        for (String keyword : keywords) {
            if (text.contains(keyword)) {
                return getLabel();
            }
        }
        return Label.OK;
    }

}

class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {

    private final String[] keywords;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = Arrays.copyOf(keywords, keywords.length);
    }
    protected String[] getKeywords() {
        return keywords;
    }
    protected Label getLabel() {
        return Label.SPAM;
    }
   // protected String[] getKeywords() {return keywords;}

    //protected Label getLabel() {return this.label;}
}

class NegativeTextAnalyzer  extends KeywordAnalyzer implements TextAnalyzer {
    //private final Label label = Label.NEGATIVE_TEXT;
    private final String[] keywords = { ":(", "=(",":|"};

    protected String[] getKeywords() {
        return keywords;
    }
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
    //protected String[] getKeywords(){return keywords;}

    //protected Label getLabel(){return this.label;}
}

class TooLongTextAnalyzer implements TextAnalyzer {
    private final Label label = Label.TOO_LONG;
    private final int maxLength;
    public TooLongTextAnalyzer(int maxLength){
        this.maxLength = maxLength;
    }

    protected Label getLabel() {return this.label;}

    public Label processText(String text){
        if (text.length() > maxLength) return getLabel();
        return Label.OK;
    }
}
