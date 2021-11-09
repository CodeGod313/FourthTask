package edu.epam.fourthtask.entity;

public interface TextComponent {
    String restore();
    void add(TextComponent component);
    void remove(TextComponent component);
}
