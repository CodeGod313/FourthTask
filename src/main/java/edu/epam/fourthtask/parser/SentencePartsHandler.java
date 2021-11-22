package edu.epam.fourthtask.parser;

import edu.epam.fourthtask.composite.ExpressionResult;
import edu.epam.fourthtask.composite.Symbol;
import edu.epam.fourthtask.composite.TextComponent;
import edu.epam.fourthtask.composite.Word;
import edu.epam.fourthtask.exception.UnknownOperationException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentencePartsHandler extends TextHandler {
    static Logger logger = LogManager.getLogger(SentencePartsHandler.class);
    public static final String REGEX_WORDS_AND_SYMBOLS = "[A-Za-z-]+|\\(?[\\<\\>\\^\\(\\)\\|\\&\\d\\~]+[\\d\\)]|[,\\.\\?\\!-=\\(\\)]";
    public static final String REGEX_SYMBOLS = "[,\\.\\?\\!-=\\(\\)]";
    public static final String REGEX_EXPRESSION = "\\(?[\\<\\>\\^\\(\\)\\|\\&\\d\\~]+[\\d\\)]";
    public static final String REGEX_WORD = "[A-Za-z]+-?[A-Za-z]+";

    @Override
    public void handle(TextComponent textComponent, String textPart) throws UnknownOperationException {
        Pattern pattern = Pattern.compile(REGEX_WORDS_AND_SYMBOLS);
        Matcher matcher = pattern.matcher(textPart);
        while (matcher.find()) {
            String sentencePart = textPart.substring(matcher.start(), matcher.end());
            if (sentencePart.matches(REGEX_SYMBOLS)) {
                TextComponent symbol = new Symbol(sentencePart.charAt(0));
                textComponent.add(symbol);
            }
            if (sentencePart.matches(REGEX_EXPRESSION)) {
                ExpressionHandler expressionHandler = new ExpressionHandler();
                try {
                    TextComponent expressionResult = new ExpressionResult(expressionHandler.handle(sentencePart));
                    textComponent.add(expressionResult);
                } catch (UnknownOperationException e) {
                    logger.error("Wrong operation call in parser", e);
                    throw new UnknownOperationException("Wrong operation call in parser", e);
                }
            }
            if (sentencePart.matches(REGEX_WORD)) {
                Word word = new Word(sentencePart);
                textComponent.add(word);
            }
        }
    }
}
