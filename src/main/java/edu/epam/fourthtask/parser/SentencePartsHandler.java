package edu.epam.fourthtask.parser;

import edu.epam.fourthtask.composite.Symbol;
import edu.epam.fourthtask.composite.TextComponent;
import edu.epam.fourthtask.composite.Word;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentencePartsHandler extends TextHandler {

    public static final String REGEX_WORDS_AND_SYMBOLS = "[A-Za-z]+|[,\\.\\?\\!-=\\(\\)]|[\\<\\>\\^\\(\\)\\|\\&\\d\\~]+[\\d\\)]";
    public static final String REGEX_SYMBOLS = "[,\\.\\?\\!-=\\(\\)]";
    public static final String REGEX_EXPRESSION = "[\\<\\>\\^\\(\\)\\|\\&\\d\\~]+[\\d\\)]";
    public static final String REGEX_WORD = "[A-Za-z]+";

    @Override
    public void handle(TextComponent textComponent, String textPart) {
        Pattern pattern = Pattern.compile(REGEX_WORDS_AND_SYMBOLS);
        Matcher matcher = pattern.matcher(textPart);
        while (matcher.find()) {
            String sentencePart = textPart.substring(matcher.start(), matcher.end());
            if (sentencePart.matches(REGEX_SYMBOLS)) {
                TextComponent symbol = new Symbol(sentencePart.charAt(0));
                textComponent.add(symbol);
            }
            if (sentencePart.matches(REGEX_EXPRESSION)) {
                // TODO: 18.11.2021 add interpreter for expressions
            }
            if(sentencePart.matches(REGEX_WORD)){
                Word word = new Word(sentencePart);
                textComponent.add(word);
            }
        }
    }
}
