package edu.epam.fourthtask.composite;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements TextComponent {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paragraph paragraph = (Paragraph) o;

        return sentences != null ? sentences.equals(paragraph.sentences) : paragraph.sentences == null;
    }

    @Override
    public int hashCode() {
        return sentences != null ? sentences.hashCode() : 0;
    }

    public static final String TABULATION = "    ";
    public static final String NEW_LINE = "\n";
    private List<TextComponent> sentences;

    public Paragraph() {
        sentences = new ArrayList<>();
    }

    @Override
    public String restore() {
        StringBuilder stringBuilder = new StringBuilder();
        sentences
                .stream()
                .forEachOrdered(x -> {
                    stringBuilder.append(TABULATION);
                    stringBuilder.append(x.restore());
                    stringBuilder.append(NEW_LINE);
                });
        return stringBuilder.toString();
    }

    @Override
    public void add(TextComponent component) {
        sentences.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        sentences.remove(component);
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
