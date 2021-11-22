package edu.epam.fourthtask.reader.impl;

import edu.epam.fourthtask.exception.WrongFilePathException;
import edu.epam.fourthtask.reader.InputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InputReaderImplTest {

    public static final String EXPECTED = "    It has survived - not only (five) centuries, but also the leap into 13<<2 electronic typesetting, remaining 3>>5 essentially ~6&9|(3&4) unchanged. It was popularised in the 5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
            "    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English.It is a (7^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page when looking at its layout.\n" +
            "    Bye.\n";
    InputReader inputReader;

    @BeforeAll
    public void setUp() {
        inputReader = new InputReaderImpl();
    }


    @Test
    void readTextFromFile() throws WrongFilePathException {
        String expected = EXPECTED;
        Path path = Paths.get("src/test/resources/input/testData.txt");
        String actual = inputReader.readTextFromFile(path);
        Assertions.assertEquals(expected, actual);
    }
}