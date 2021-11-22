package edu.epam.fourthtask.parser;

import edu.epam.fourthtask.composite.ParsedText;
import edu.epam.fourthtask.composite.TextComponent;
import edu.epam.fourthtask.exception.UnknownOperationException;

public class TextParser {
    private TextHandler successor = new ParagraphHandler();

    public TextComponent parseText(String text) throws UnknownOperationException {
        TextComponent parsedText = new ParsedText();
        successor.handle(parsedText, text);
        return parsedText;
    }
}
