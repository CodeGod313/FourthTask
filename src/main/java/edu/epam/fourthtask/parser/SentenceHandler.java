package edu.epam.fourthtask.parser;

import edu.epam.fourthtask.entity.Sentence;
import edu.epam.fourthtask.entity.TextComponent;

import java.util.Arrays;

public class SentenceHandler extends TextHandler {

    private TextHandler successor = new SentencePartsHandler();
    public static final String SENTENCE_DELIMITER = "[A-Z].*(\\.{3}|\\!|\\?|\\.)";

    @Override
    public void handle(TextComponent textComponent, String textPart) {
        String[] sentences = textPart.split(SENTENCE_DELIMITER);
        Arrays.stream(sentences).forEachOrdered(x -> {
            TextComponent sentence = new Sentence();
            successor.handle(sentence, textPart);
            textComponent.add(sentence);
        });
    }
}
