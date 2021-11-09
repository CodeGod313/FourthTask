package edu.epam.fourthtask.parser;

public class ParagraphHandler extends TextHandler{
    public static final String PARAGRAPH_DELIMITER = "\t";
    private TextHandler successor = new SentenceHandler();


    // TODO: 09.11.2021 add realisation
    @Override
    public String handle(String textPart) {
        return successor.handle(textPart.split(PARAGRAPH_DELIMITER));
    }
}
