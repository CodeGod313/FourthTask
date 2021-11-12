package edu.epam.fourthtask.parser;

import edu.epam.fourthtask.composite.ParsedText;
import edu.epam.fourthtask.composite.TextComponent;

public class TextParser {
    private TextHandler successor = new ParagraphHandler();

    public TextComponent parseText(String text) {
        TextComponent parsedText = new ParsedText();
        successor.handle(parsedText, text);
        return parsedText;
    }
}
