package edu.epam.fourthtask.composite;

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
        throw new UnsupportedOperationException("Operation is unsupported");
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException("Operation is unsupported");
    }

    @Override
    public void addAll(List<TextComponent> textComponents) {
        throw new UnsupportedOperationException("Operation is unsupported");
    }

    @Override
    public void removeAll() {
        throw new UnsupportedOperationException("Operation is unsupported");
    }

    @Override
    public List<TextComponent> receiveChild() {
        throw new UnsupportedOperationException();
    }
}
