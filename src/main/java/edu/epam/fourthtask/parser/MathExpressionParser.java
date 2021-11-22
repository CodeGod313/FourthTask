package edu.epam.fourthtask.parser;

import java.util.ArrayList;
import java.util.List;

public class MathExpressionParser {
    public static final String BITWISE_LEFT_SHIFT_EXPRESSION = "(\\(.+\\)<<\\(.+\\))|(\\(.+\\)<<\\d+)|(\\d+<<\\(.+\\))|(\\d+<<\\d+)";
    public static final String BITWISE_RIGHT_SHIFT_EXPRESSION = "(\\(.+\\)>>\\(.+\\))|(\\(.+\\)>>\\d+)|(\\d+>>\\(.+\\))|(\\d+>>\\d+)";
    public static final String BITWISE_AND_EXPRESSION = "(\\(.+\\)\\&\\(.+\\))|(\\(.+\\)\\&\\d+)|(\\d+\\&\\(.+\\))|(\\d+\\&\\d+)";
    public static final String BITWISE_XOR_EXPRESSION = "(\\(.+\\)\\^\\(.+\\))|(\\(.+\\)\\^\\d+)|(\\d+\\^\\(.+\\))|(\\d+\\^\\d+)";
    public static final String BITWISE_OR_EXPRESSION = "(\\(.+?\\)\\|\\(.+?\\))|(\\(.+?\\)\\|\\d+?)|(\\d+?\\|\\(.+?\\))|(\\d+?\\|\\d+?)";
    public static final String REGEX_OPERATIONS = "<<|>>|~|\\^|\\&";
    public static final String REGEX_SENTENCE_IN_BRACKETS = "(.+)";
    List<MathExpression> expressions = new ArrayList<>();

    public List<MathExpression> parseExpression(String expression) {

        return null;
    }
}
