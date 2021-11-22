package edu.epam.fourthtask.parser;

import edu.epam.fourthtask.exception.UnknownOperationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TextParserTest {
    public static final String TEXT = "    It has survived - not only ( five ) centuries, but also the leap into 13<<2 electronic " +
            "typesetting, remaining 3>>5 essentially ~6&9|(3&4) unchanged. It was popularised in the " +
            "5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1) with the release of Letraset sheets containing " +
            "Lorem Ipsum passages, and more recently with desktop publishing software like Aldus " +
            "PageMaker including versions of Lorem Ipsum.\n" +
            "    It is a long established fact that a reader will be distracted by the readable content of a " +
            "page when looking at its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 " +
            "Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using ( Content " +
            "here ), content here', making it look like readable English. " +
            "It is a (7^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page " +
            "when looking at its layout.\n" +
            "    Bye.\n";
    public static final String PARSED_TEXT = "    It has survived - not only ( five ) centuries, but also the leap into 52 electronic typesetting, remaining 0 essentially 9 unchanged. It was popularised in the 5 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
            "    It is long established fact that reader will be distracted by the readable content of page when looking at its layout. The point of using 78 Ipsum is that it has normal distribution of letters, as opposed to using ( Content here ), content here ', making it look like readable English. It is 1202 established fact that reader will be of page when looking at its layout.\n" +
            "    Bye.\n";
    TextParser textParser;

    @BeforeAll
    public void setUp() {
        textParser = new TextParser();
    }

    @Test
    void parseText() throws UnknownOperationException {
        String expected = PARSED_TEXT;
        String actual = textParser.parseText(TEXT).restore();
        Assertions.assertEquals(expected, actual);
    }
}