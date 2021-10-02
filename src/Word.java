package App;

import java.awt.*;

public class Word {
    private String word_tage;
    private String word_explain;

    /**
     * Constructor 1.
     */
    public Word() {

    }

    /**
     * Constructor with parameter.
     * @param target english word.
     * @param explain vietnamese translation.
     */
    public Word(String target, String explain) {
         this.word_tage = target;
         this.word_explain = explain;
    }

    public String getWord_tage() {
        return word_tage;
    }

    public void setWord_tage(String word_tage) {
        this.word_tage = word_tage;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }
}
