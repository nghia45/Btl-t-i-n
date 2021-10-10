package com.example.telstar_dictionary;

public class Word {
    private String word_target;
    private String word_explain;

    /**
     * Constructor 1.
     */
    public Word() {

    }

    /**
     * Constructor with parameter.
     *
     * @param target  english word.
     * @param explain vietnamese translation.
     */
    public Word(String target, String explain) {
        this.word_target = target;
        this.word_explain = explain;
    }

    /**
     * Get the word.
     * @return the word.
     */
    public String getWord_target() {
        return word_target;
    }

    /**
     * Set or change the word.
     * @param word_target new word to be set.
     */
    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    /**
     * get translated.
     * @return meaning of word.
     */
    public String getWord_explain() {
        return word_explain;
    }

    /**
     * Set or change the meaning.
     * @param word_explain meaning to be set.
     */
    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    /**
     * Turn the word object into string.
     * @return string type of the word.
     */
    public String to_string() {
        return getWord_target() + "   " + getWord_explain();
    }
}
