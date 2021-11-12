package edu.epam.fourthtask.composite;

import java.util.ArrayList;
import java.util.List;

public class ParsedText implements TextComponent {
    private List<TextComponent> paragraphs;

    public ParsedText() {
        this.paragraphs = new ArrayList<>();
    }

    @Override
    public String restore() {
        StringBuilder stringBuilder = new StringBuilder();
        paragraphs
                .stream()
                .forEachOrdered(
                        x -> stringBuilder.append(x.restore())
                );
        return stringBuilder.toString();
    }

    @Override
    public void add(TextComponent component) {
        paragraphs.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        paragraphs.add(component);
    }

    @Override
    public void addAll(List<TextComponent> textComponents) {
        paragraphs.addAll(textComponents);
    }

    @Override
    public void removeAll() {
        paragraphs.clear();
    }

    @Override
    public List<TextComponent> receiveChild() {
        return paragraphs;
    }
}
