package edu.epam.fourthtask.service.impl;

import edu.epam.fourthtask.entity.ParsedText;
import edu.epam.fourthtask.entity.Sentence;
import edu.epam.fourthtask.service.TextService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class TextServiceImpl implements TextService {
    @Override
    public void sortParagraphs(ParsedText parsedText) {
        parsedText
                .receiveChild()
                .stream()
                .sorted(Comparator.comparingInt(x -> x.receiveChild().size()));
    }

    @Override
    public List<Sentence> searchSentencesWithLongestWord(ParsedText parsedText) {
        // TODO: 09.11.2021 refactor govnocode
        String longestWord = parsedText
                .receiveChild()
                .stream()
                .map(x -> x.receiveChild()
                        .stream()
                        .reduce((y, z) -> {
                            if (z.restore().length() > y.restore().length()) {
                                return z;
                            } else {
                                return y;
                            }
                        }))
                .map(o -> o.get().restore())
                .findFirst()
                .get();
        // TODO: 09.11.2021 refactor this shit
        return parsedText
                .receiveChild()
                .stream()
                .map(x->x.receiveChild()
                            .stream()
                            .filter(
                                    y->y.receiveChild()
                                            .stream()
                                            .filter(z->z.restore().equals(longestWord))
                                            .count() != 0
                            )
                );
    }

    @Override
    public void deleteSentencesWithLessWordsThan(ParsedText parsedText, Integer count) {
        // TODO: 09.11.2021 add realisation
    }

    @Override
    public Map<String, Integer> findSameWordsWithQuantity(ParsedText parsedText) {
        // TODO: 09.11.2021 add realisation
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
