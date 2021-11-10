package edu.epam.fourthtask.entity;

import java.util.List;

public interface TextComponent {
    String restore();
    void add(TextComponent component);
    void remove(TextComponent component);
    List<TextComponent> receiveChild();
}
