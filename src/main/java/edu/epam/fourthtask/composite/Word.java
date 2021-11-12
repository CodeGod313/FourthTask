package edu.epam.fourthtask.composite;

import java.util.List;

public class Word implements TextComponent {
    String wordString;

    public Word(String wordString) {
        this.wordString = wordString;
    }

    @Override
    public String restore() {
        return wordString;
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
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TextComponent> receiveChild() {
        throw new UnsupportedOperationException();
    }
}
