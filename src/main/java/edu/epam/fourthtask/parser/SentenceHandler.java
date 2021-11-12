package edu.epam.fourthtask.parser;

import edu.epam.fourthtask.composite.Sentence;
import edu.epam.fourthtask.composite.TextComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceHandler extends TextHandler {

    private TextHandler successor = new SentencePartsHandler();
    public static final String REGEX_SENTENCE = "[A-Z].*(\\.{3}|\\!|\\?|\\.)";

    @Override
    public void handle(TextComponent textComponent, String textPart) {
        Pattern pattern = Pattern.compile(REGEX_SENTENCE);
        Matcher matcher = pattern.matcher(textPart);
        while (matcher.find()) {
            TextComponent sentence = new Sentence();
            successor.handle(sentence, textPart.substring(matcher.start(), matcher.end()));
            textComponent.add(sentence);
        }
    }
}
