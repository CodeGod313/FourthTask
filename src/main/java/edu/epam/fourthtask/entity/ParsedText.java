package edu.epam.fourthtask.entity;

import java.util.List;

public class ParsedText implements TextComponent {
    private List<TextComponent> paragraphs;

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
    public List<TextComponent> receiveChild() {
        return paragraphs;
    }
}
