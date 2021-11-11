package edu.epam.fourthtask.entity;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements TextComponent {
    private List<TextComponent> sentences;

    public Paragraph() {
        sentences = new ArrayList<>();
    }

    @Override
    public String restore() {
        StringBuilder stringBuilder = new StringBuilder();
        sentences
                .stream()
                .forEachOrdered(
                        x -> stringBuilder.append(x.restore())
                );
        return stringBuilder.toString();
    }

    @Override
    public void add(TextComponent component) {
        sentences.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        sentences.add(component);
    }

    @Override
    public void addAll(List<TextComponent> textComponents) {
        sentences.addAll(textComponents);
    }

    @Override
    public void removeAll() {
        sentences.clear();
    }

    @Override
    public List<TextComponent> receiveChild() {
        return sentences;
    }
}
