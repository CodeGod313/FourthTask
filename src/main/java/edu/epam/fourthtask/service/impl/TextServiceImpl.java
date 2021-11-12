package edu.epam.fourthtask.service.impl;

import edu.epam.fourthtask.composite.ParsedText;
import edu.epam.fourthtask.composite.TextComponent;
import edu.epam.fourthtask.service.TextService;

import java.util.*;

public class TextServiceImpl implements TextService {
    public static final String REGEX_SYMBOLS = "[,\\.\\?\\!]";
    public static final String REGEX_VOWELS = "[AEIOUY]";
    public static final String REGEX_CONSONANTS = "[BCDFGHJKLMNPQRSTVWXYZ]";

    @Override
    public void sortParagraphs(ParsedText parsedText) {
        List<TextComponent> sortedParagraphs = parsedText
                .receiveChild()
                .stream()
                .sorted(Comparator.comparingInt(x -> x.receiveChild().size()))
                .toList();
        parsedText.removeAll();
        parsedText.addAll(sortedParagraphs);
    }

    @Override
    public List<TextComponent> searchSentencesWithLongestWord(ParsedText parsedText) {
        List<TextComponent> paragraphs = parsedText.receiveChild();
        List<TextComponent> sentences = new ArrayList<>();
        paragraphs.forEach(x -> sentences.addAll(x.receiveChild()));
        List<String> words = receiveAllWords(parsedText);
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
        List<String> words = receiveAllWords(parsedText);
        Map<String, Integer> sameWords = new HashMap<>();
        words.stream().forEach(x -> {
            if (sameWords.containsKey(x)) {
                Integer oldQuantity = sameWords.get(x);
                sameWords.replace(x, ++oldQuantity);
            } else {
                sameWords.put(x, 1);
            }
        });
        return sameWords;
    }

    @Override
    public Integer countVowels(ParsedText parsedText) {
        String text = parsedText.restore();
        text = text.toUpperCase();
        String vowels[] = text.split(REGEX_VOWELS);
        return vowels.length;

    }

    @Override
    public Integer countConsonants(ParsedText parsedText) {
        String text = parsedText.restore();
        text = text.toUpperCase();
        String consonants[] = text.split(REGEX_CONSONANTS);
        return consonants.length;
    }

    private List<String> receiveAllWords(ParsedText parsedText) {
        List<TextComponent> paragraphs = parsedText.receiveChild();
        List<TextComponent> sentences = new ArrayList<>();
        paragraphs.forEach(x -> sentences.addAll(x.receiveChild()));
        List<TextComponent> sentenceComponents = new ArrayList<>();
        sentences.forEach(x -> sentenceComponents.addAll(x.receiveChild()));
        return sentenceComponents
                .stream()
                .map(TextComponent::restore)
                .filter(x -> !x.matches(REGEX_SYMBOLS))
                .toList();
    }
}
