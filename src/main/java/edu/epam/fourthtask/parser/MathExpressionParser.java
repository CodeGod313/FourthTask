package edu.epam.fourthtask.parser;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathExpressionParser {
    static Logger logger = LogManager.getLogger(MathExpressionParser.class);
    public static final String DELIMITER = "\\s";
    public static final String NOT = "~";
    public static final String LEFT_SHIFT = "<<";
    public static final String RIGHT_SHIFT = ">>";
    public static final String AND = "&";
    public static final String XOR = "^";
    public static final String OR = "|";
    List<MathExpression> expressions = new ArrayList<>();

    public List<MathExpression> parseExpression(String expression) {
        String[] expressionPartsArray = expression.split(DELIMITER);
        Arrays.stream(expressionPartsArray).forEach(x -> {
            switch (x) {
                case NOT -> expressions.add(c -> c.push(~c.pop()));
                case LEFT_SHIFT -> expressions.add(c -> {
                    Integer secondValue = c.pop();
                    Integer firstValue = c.pop();
                    c.push(firstValue << secondValue);
                });
                case RIGHT_SHIFT -> expressions.add(c -> {
                    Integer secondValue = c.pop();
                    Integer firstValue = c.pop();
                    c.push(firstValue >> secondValue);
                });
                case AND -> expressions.add(c -> c.push(c.pop() & c.pop()));
                case XOR -> expressions.add(c -> c.push(c.pop() ^ c.pop()));
                case OR -> expressions.add(c -> c.push(c.pop() | c.pop()));
                default -> expressions.add(c -> c.push(Integer.valueOf(x)));
            }
        });
        return expressions;
    }
}
