package edu.epam.fourthtask.composite;

import java.util.List;

public class Expression implements TextComponent{
    String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    @Override
    public String restore() {
        return expression;
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
