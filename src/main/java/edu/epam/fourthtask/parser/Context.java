package edu.epam.fourthtask.parser;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;

public class Context {
    ArrayDeque<Integer> contextValue = new ArrayDeque();

    public void push(@NotNull Integer number) {
        contextValue.push(number);
    }

    public Integer pop() {
        return contextValue.pop();
    }
}
