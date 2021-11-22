package edu.epam.fourthtask.composite;

import java.util.List;

public class Word implements TextComponent {
    String wordString;

    public Word(String wordString) {
        this.wordString = wordString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        return wordString != null ? wordString.equals(word.wordString) : word.wordString == null;
    }

    @Override
    public int hashCode() {
        return wordString != null ? wordString.hashCode() : 0;
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
        throw new UnsupportedOperationException("Operation is unsupported");
    }

    @Override
    public List<TextComponent> receiveChild() {
        throw new UnsupportedOperationException("Operation is unsupported");
    }
}
