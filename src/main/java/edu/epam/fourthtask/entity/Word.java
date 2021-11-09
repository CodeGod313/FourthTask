package edu.epam.fourthtask.entity;

import java.util.ArrayList;
import java.util.List;

public class Word implements TextComponent {
    List<TextComponent> symbols;

    public Word() {
        symbols = new ArrayList<>();
    }

    @Override
    public String restore() {
        StringBuilder stringBuilder = new StringBuilder();
        symbols
                .stream()
                .forEachOrdered(
                        x -> stringBuilder.append(x.restore())
                );
        return stringBuilder.toString();
    }

    @Override
    public void add(TextComponent component) {
        symbols.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        symbols.remove(component);
    }
}
