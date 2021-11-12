package edu.epam.fourthtask.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TextParserTest {
    public static final String TEXT = "    Oh my goooooooooooooooooooooooooooooooooood!\n" +
            "    Its a triple.\n";
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