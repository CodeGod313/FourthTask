package edu.epam.fourthtask.parser;

import edu.epam.fourthtask.entity.Paragraph;
import edu.epam.fourthtask.entity.ParsedText;
import edu.epam.fourthtask.entity.TextComponent;

import java.util.Arrays;

public class ParagraphHandler extends TextHandler {
    public static final String PARAGRAPH_DELIMITER = "\t.+(\n|$)";
    private TextHandler successor = new SentenceHandler();


    // TODO: 09.11.2021 add realisation
    @Override
    public void handle(TextComponent textComponent, String textPart) {
        String paragraphsString[] = textPart.split(PARAGRAPH_DELIMITER);
        Arrays.stream(paragraphsString)
                .forEachOrdered(x -> {
                    TextComponent paragraph = new Paragraph();
                    successor.handle(paragraph, x);
                    textComponent.add(paragraph);
                });
    }
}
