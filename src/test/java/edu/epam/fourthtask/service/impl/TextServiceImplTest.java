package edu.epam.fourthtask.service.impl;

import edu.epam.fourthtask.composite.*;
import edu.epam.fourthtask.service.TextService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TextServiceImplTest {

    TextService textService;
    TextComponent text;
    TextComponent sentence1;
    TextComponent sentence2;
    TextComponent paragraph1;
    TextComponent paragraph2;

    @BeforeEach
    public void setUp() {
        textService = new TextServiceImpl();
        text = new ParsedText();
        paragraph1 = new Paragraph();
        sentence1 = new Sentence();
        sentence1.add(new Word("Biba"));
        sentence1.add(new Word("buba"));
        sentence1.add(new Word("buba"));
        sentence1.add(new Word("bu"));
        sentence1.add(new Symbol('.'));
        sentence2 = new Sentence();
        sentence2.add(new Word("Aoooo"));
        sentence2.add(new Word("uuuuuu"));
        sentence2.add(new Word("ppp"));
        sentence2.add(new Symbol('!'));
        paragraph1.add(sentence1);
        paragraph1.add(sentence2);
        paragraph2 = new Paragraph();
        paragraph2.add(sentence1);
        text.add(paragraph1);
        text.add(paragraph2);
    }

    @Test
    void sortParagraphs() {
        TextComponent expected = new ParsedText();
        expected.add(paragraph2);
        expected.add(paragraph1);
        textService.sortParagraphs((ParsedText) text);
        Assertions.assertEquals((ParsedText) expected, (ParsedText) text);
    }

    @Test
    void searchSentencesWithLongestWord() {
        TextComponent expected = sentence2;
        List<TextComponent> actual = textService.searchSentencesWithLongestWord((ParsedText) text);
        Assertions.assertEquals(expected, actual.get(0));
    }

    @Test
    void deleteSentencesWithLessWordsThan() {
        TextComponent expected = new ParsedText();
        expected.add(paragraph2);
        expected.add(paragraph2);
        textService.deleteSentencesWithLessWordsThan((ParsedText) text, 4);
        Assertions.assertEquals((ParsedText) expected, (ParsedText) text);
    }

    @Test
    void findSameWordsWithQuantity() {
        Integer expected = 4;
        Map<String, Integer> actual = textService.findSameWordsWithQuantity((ParsedText) text);
        Assertions.assertEquals(expected, actual.get("buba"));
    }

    @Test
    void countVowels() {
        Integer expected = 26;
        Integer actual = textService.countVowels((ParsedText) text);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countConsonants() {
        Integer expected = 18;
        Integer actual = textService.countConsonants((ParsedText) text);
        Assertions.assertEquals(expected, actual);
    }
}