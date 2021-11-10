package edu.epam.fourthtask.service;

import edu.epam.fourthtask.entity.ParsedText;
import edu.epam.fourthtask.entity.Sentence;
import edu.epam.fourthtask.entity.TextComponent;

import java.util.List;
import java.util.Map;

public interface TextService {
    void sortParagraphs(ParsedText parsedText);
    List<TextComponent> searchSentencesWithLongestWord(ParsedText parsedText);
    void deleteSentencesWithLessWordsThan(ParsedText parsedText, Integer count);
    Map<String, Integer> findSameWordsWithQuantity(ParsedText parsedText);
    Integer countVowels(ParsedText parsedText);
    Integer countConsonants(ParsedText parsedText);
}
