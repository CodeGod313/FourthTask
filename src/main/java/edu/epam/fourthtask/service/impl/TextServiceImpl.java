package edu.epam.fourthtask.service.impl;

import edu.epam.fourthtask.entity.ParsedText;
import edu.epam.fourthtask.entity.Sentence;
import edu.epam.fourthtask.entity.TextComponent;
import edu.epam.fourthtask.service.TextService;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class TextServiceImpl implements TextService {
    public static final String REGEX_SYMBOLS = "[,\\.\\?\\!]";

    @Override
    public void sortParagraphs(ParsedText parsedText) {
        parsedText
                .receiveChild()
                .stream()
                .sorted(Comparator.comparingInt(x -> x.receiveChild().size()));
    }

    @Override
    public List<TextComponent> searchSentencesWithLongestWord(ParsedText parsedText) {
        List<TextComponent> paragraphs = parsedText.receiveChild();
        List<TextComponent> sentences = new ArrayList<>();
        paragraphs.forEach(x -> sentences.addAll(x.receiveChild()));
        List<TextComponent> sentenceComponents = new ArrayList<>();
        sentences.forEach(x -> sentenceComponents.addAll(x.receiveChild()));
        List<String> words = sentenceComponents
                .stream()
                .map(TextComponent::restore)
                .filter(x -> !x.matches(REGEX_SYMBOLS))
                .toList();
        String longestWord = words
                .stream()
                .max(Comparator.comparingInt(String::length))
                .get();
        List<TextComponent> filteredSentences = sentences
                .stream()
                .filter(x -> {
                    List<String> longestWords = x.receiveChild()
                            .stream()
                            .map(TextComponent::restore)
                            .filter(y -> y.equals(longestWord))
                            .toList();
                    return longestWords.size() > 0;
                })
                .toList();
        return filteredSentences;
    }

    @Override
    public void deleteSentencesWithLessWordsThan(ParsedText parsedText, Integer count) {
        List<TextComponent> paragraphs = parsedText.receiveChild();
        for (TextComponent currentParagraph : paragraphs) {
            List<TextComponent> sentences = currentParagraph.receiveChild();
            List<TextComponent> sentencesToRemove = new ArrayList<>();
            sentences.forEach(x -> {
                List<String> words = x
                        .receiveChild()
                        .stream()
                        .map(TextComponent::restore)
                        .filter(y -> !y.matches(REGEX_SYMBOLS))
                        .toList();
                if (words.size() < count) {
                    sentencesToRemove.add(x);
                }
            });
            sentencesToRemove.forEach(currentParagraph::remove);
        }
    }

    @Override
    public Map<String, Integer> findSameWordsWithQuantity(ParsedText parsedText) {

    }

    @Override
    public Integer countVowels(ParsedText parsedText) {
        // TODO: 09.11.2021 add realisation
    }

    @Override
    public Integer countConsonants(ParsedText parsedText) {
        // TODO: 09.11.2021 add realisation
    }
}
