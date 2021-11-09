package edu.epam.fourthtask.entity;

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
}
