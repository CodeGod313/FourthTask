package edu.epam.fourthtask.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TextParserTest {
    public static final String TEXT = "    It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!\n" +
            "    It is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?\n" +
            "    It is a established fact that a reader will be of a page when looking at its layout...";
    TextParser textParser;

    @BeforeAll
    public void setUp() {
        textParser = new TextParser();
    }

    @Test
    void parseText() {
        String expected = TEXT;
        String actual = textParser.parseText(TEXT).restore();
        Assertions.assertEquals(expected, actual);
    }
}