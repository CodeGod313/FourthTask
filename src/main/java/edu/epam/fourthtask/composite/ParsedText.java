package edu.epam.fourthtask.composite;

import java.util.ArrayList;
import java.util.List;

public class ParsedText implements TextComponent {
    private List<TextComponent> paragraphs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParsedText that = (ParsedText) o;

        return paragraphs != null ? paragraphs.equals(that.paragraphs) : that.paragraphs == null;
    }

    @Override
    public int hashCode() {
        return paragraphs != null ? paragraphs.hashCode() : 0;
    }

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
