package edu.epam.fourthtask.composite;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextComponent {
    public static final String SPACE = " ";
    private List<TextComponent> wordsAndSymbols;
    public static final String REGEX_SYMBOLS = "[,\\.\\?\\!-=\\(\\)]";

    public Sentence() {
        wordsAndSymbols = new ArrayList<>();
    }

    @Override
    public String restore() {
        StringBuilder stringBuilder = new StringBuilder();
        wordsAndSymbols
                .stream()
                .forEachOrdered(x -> {
                    if (!x.restore().matches(REGEX_SYMBOLS)) {
                        stringBuilder.append(SPACE);
                    }
                    stringBuilder.append(x.restore());
                });
        return stringBuilder.toString().trim();
    }

    @Override
    public void add(TextComponent component) {
        wordsAndSymbols.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        wordsAndSymbols.add(component);
    }

    @Override
    public void addAll(List<TextComponent> textComponents) {
        wordsAndSymbols.addAll(textComponents);
    }

    @Override
    public void removeAll() {
        wordsAndSymbols.clear();
    }

    @Override
    public List<TextComponent> receiveChild() {
        return wordsAndSymbols;
    }
}
