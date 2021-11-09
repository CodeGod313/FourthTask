package edu.epam.fourthtask.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextComponent {
    private List<TextComponent> words;

    public Sentence() {
        words = new ArrayList<>();
    }

    @Override
    public String restore() {
        StringBuilder stringBuilder = new StringBuilder();
        words
                .stream()
                .forEachOrdered(
                        x -> stringBuilder.append(x.restore())
                );
        return stringBuilder.toString();
    }

    @Override
    public void add(TextComponent component) {
        words.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        words.add(component);
    }
}
