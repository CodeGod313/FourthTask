package edu.epam.fourthtask.parser;

import edu.epam.fourthtask.entity.Symbol;
import edu.epam.fourthtask.entity.TextComponent;
import edu.epam.fourthtask.entity.Word;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentencePartsHandler extends TextHandler {

    public static final String REGEX_WORDS_AND_SYMBOLS = "[A-Za-z]+|[,\\.\\?\\!-=\\(\\)]";
    public static final String REGEX_SYMBOLS = "[,\\.\\?\\!-=\\(\\)]";

    @Override
    public void handle(TextComponent textComponent, String textPart) {
        Pattern pattern = Pattern.compile(REGEX_WORDS_AND_SYMBOLS);
        Matcher matcher = pattern.matcher(textPart);
        while (matcher.find()) {
            String sentencePart = textPart.substring(matcher.start(), matcher.end());
            if (sentencePart.matches(REGEX_SYMBOLS)) {
                TextComponent symbol = new Symbol(sentencePart.charAt(0));
                textComponent.add(symbol);
            } else {
                TextComponent word = new Word(sentencePart);
                textComponent.add(word);
            }
        }
    }
}
