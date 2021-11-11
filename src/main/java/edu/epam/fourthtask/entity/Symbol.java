package edu.epam.fourthtask.entity;

import java.util.List;

public class Symbol implements TextComponent {
    private Character character;

    public Symbol(Character character) {
        this.character = character;
    }

    @Override
    public String restore() {
        return String.valueOf(character);
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addAll(List<TextComponent> textComponents) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TextComponent> receiveChild() {
        throw new UnsupportedOperationException();
    }
}
