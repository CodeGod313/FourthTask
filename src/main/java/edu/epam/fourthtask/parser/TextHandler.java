package edu.epam.fourthtask.parser;

import edu.epam.fourthtask.composite.TextComponent;
import edu.epam.fourthtask.exception.UnknownOperationException;

public abstract class TextHandler {
    public abstract void handle(TextComponent textComponent, String textPart) throws UnknownOperationException;
}
