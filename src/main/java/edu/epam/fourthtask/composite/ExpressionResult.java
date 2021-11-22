package edu.epam.fourthtask.composite;

import java.util.List;

public class ExpressionResult implements TextComponent {
    Integer result;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpressionResult that = (ExpressionResult) o;

        return result != null ? result.equals(that.result) : that.result == null;
    }

    @Override
    public int hashCode() {
        return result != null ? result.hashCode() : 0;
    }

    public ExpressionResult(Integer result) {
        this.result = result;
    }

    @Override
    public String restore() {
        return result.toString();
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException();
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
