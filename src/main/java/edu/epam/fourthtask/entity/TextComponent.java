package edu.epam.fourthtask.entity;

import java.util.List;

public interface TextComponent {
    String restore();

    void add(TextComponent component);

    void remove(TextComponent component);

    void addAll(List<TextComponent> textComponents);

    void removeAll();

    List<TextComponent> receiveChild();
}
