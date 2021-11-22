package edu.epam.fourthtask.parser;

import edu.epam.fourthtask.composite.Paragraph;
import edu.epam.fourthtask.composite.TextComponent;
import edu.epam.fourthtask.exception.UnknownOperationException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphHandler extends TextHandler {
    static Logger logger = LogManager.getLogger(ParagraphHandler.class);
    public static final String REGEX_PARAGRAPH = "\\s{4}.+($|\\n)";
    private TextHandler successor = new SentenceHandler();

    @Override
    public void handle(TextComponent textComponent, String textPart) throws UnknownOperationException {
        Pattern pattern = Pattern.compile(REGEX_PARAGRAPH);
        Matcher matcher = pattern.matcher(textPart);
        while (matcher.find()) {
            TextComponent paragraph = new Paragraph();
            successor.handle(paragraph, textPart.substring(matcher.start(), matcher.end()));
            textComponent.add(paragraph);
        }
    }
}
