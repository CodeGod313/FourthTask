package edu.epam.fourthtask.entity;

public class Symbol implements TextComponent{
    private Character symbol;

    @Override
    public String restore() {
        return String.valueOf(symbol);
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
