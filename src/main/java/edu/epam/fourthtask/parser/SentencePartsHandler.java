package edu.epam.fourthtask.parser;

import edu.epam.fourthtask.entity.Symbol;
import edu.epam.fourthtask.entity.TextComponent;
import edu.epam.fourthtask.entity.Word;

import java.util.Arrays;

public class SentencePartsHandler extends TextHandler {

    public static final String WORDS_AND_SYMBOLS_DELIMITER = "[A-Za-z]+|[,\\.\\?\\!]";
    public static final String SYMBOLS_DELIMITER = "[,\\.\\?\\!]";

    @Override
    public void handle(TextComponent textComponent, String textPart) {
        String[] sentenceParts = textPart.split(WORDS_AND_SYMBOLS_DELIMITER);
        Arrays.stream(sentenceParts).forEachOrdered(x -> {
            if (x.matches(SYMBOLS_DELIMITER)) {
                TextComponent symbol = new Symbol(x.charAt(0));
                textComponent.add(symbol);
            } else {
                TextComponent word = new Word(x);
                textComponent.add(word);
            }
        });
    }
}
