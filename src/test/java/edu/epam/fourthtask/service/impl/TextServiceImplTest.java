package edu.epam.fourthtask.service.impl;

import edu.epam.fourthtask.service.TextService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TextServiceImplTest {

    TextService textService;

    // TODO: 11.11.2021  add realisation
    @BeforeAll
    public void setUp(){
        textService = new TextServiceImpl();
    }

    @Test
    void sortParagraphs() {
    }

    @Test
    void searchSentencesWithLongestWord() {
    }

    @Test
    void deleteSentencesWithLessWordsThan() {
    }

    @Test
    void findSameWordsWithQuantity() {
    }

    @Test
    void countVowels() {
    }

    @Test
    void countConsonants() {
    }
}