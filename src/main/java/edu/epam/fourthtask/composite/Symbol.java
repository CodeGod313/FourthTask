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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol = (Symbol) o;

        return character != null ? character.equals(symbol.character) : symbol.character == null;
    }

    @Override
    public int hashCode() {
        return character != null ? character.hashCode() : 0;
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
        throw new UnsupportedOperationException("Operation is unsupported");
    }
}
