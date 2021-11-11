package edu.epam.fourthtask.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextComponent {
    private List<TextComponent> wordsAndSymbols;

    public Sentence() {
        wordsAndSymbols = new ArrayList<>();
    }

    @Override
    public String restore() {
        StringBuilder stringBuilder = new StringBuilder();
        wordsAndSymbols
                .stream()
                .forEachOrdered(
                        x -> stringBuilder.append(x.restore())
                );
        return stringBuilder.toString();
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
