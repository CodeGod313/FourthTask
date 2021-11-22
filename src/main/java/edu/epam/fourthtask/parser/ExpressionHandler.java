package edu.epam.fourthtask.parser;

import java.util.List;

public class ExpressionHandler {
    public static final String BITWISE_NOT_EXPRESSION = "~\\d+";
    public static final String BITWISE_LEFT_SHIFT_EXPRESSION = "(\\(.+\\)((<<)|(>>))\\(.+\\))|(\\(.+\\)((<<)|(>>))\\d+)|(\\d+((<<)|(>>))\\(.+\\))|(\\d+((<<)|(>>))\\d+)";
    public static final String BITWISE_AND_EXPRESSION = "(\\(.+\\)\\&\\(.+\\))|(\\(.+\\)\\&\\d+)|(\\d+\\&\\(.+\\))|(\\d+\\&\\d+)";
    public static final String BITWISE_XOR_EXPRESSION = "(\\(.+\\)\\^\\(.+\\))|(\\(.+\\)\\^\\d+)|(\\d+\\^\\(.+\\))|(\\d+\\^\\d+)";
    public static final String BITWISE_OR_EXPRESSION = "(\\(.+?\\)\\|\\(.+?\\))|(\\(.+?\\)\\|\\d+?)|(\\d+?\\|\\(.+?\\))|(\\d+?\\|\\d+?)";
    public static final String BITWISE_NOT = "~";
    public static final String BITWISE_LEFT_SHIFT = "<<";
    public static final String BITWISE_RIGHT_SHIFT = ">>";
    public static final String BITWISE_AND = "&";
    public static final String BITWISE_XOR = "^";
    public static final String BITWISE_OR = "|";
    public static final String REPLACEMENT_STRING = "z";
    Context context = new Context();

    public Integer handle(String expression) {
        String expressionWithBrackets = addBrackets(expression);
        MathExpressionParser mathExpressionParser = new MathExpressionParser();
        List<MathExpression> mathExpressions = mathExpressionParser.parseExpression(expressionWithBrackets);
        mathExpressions.forEach(x -> {
            x.interpret(context);
        });
        return 0;
    }

    private String addBrackets(String expression) {
        StringBuilder modifiedString = new StringBuilder(expression);
        insertBrackets(modifiedString, BITWISE_NOT);
        insertBrackets(modifiedString, BITWISE_LEFT_SHIFT);
        insertBrackets(modifiedString, BITWISE_RIGHT_SHIFT);
        insertBrackets(modifiedString, BITWISE_AND);
        insertBrackets(modifiedString, BITWISE_XOR);
        insertBrackets(modifiedString, BITWISE_OR);
        return modifiedString.toString();
    }

    private void insertBrackets(StringBuilder modifiedString, String operation) {
        while (modifiedString.indexOf(operation) != -1) {
            int i = modifiedString.indexOf(operation);
            int j = i + operation.length();
            if (i != 0 && !operation.equals(BITWISE_NOT)) {
                i--;
                if (modifiedString.charAt(i) == ')') {
                    int bracketsCount = 1;
                    while (bracketsCount != 0) {
                        i--;
                        switch (modifiedString.charAt(i)) {
                            case ')' -> bracketsCount++;
                            case '(' -> bracketsCount--;
                        }
                    }
                } else {
                    if (modifiedString.charAt(i) >= '0' && modifiedString.charAt(i) <= '9') {
                        while (i > 0 && modifiedString.charAt(i - 1) >= '0' && modifiedString.charAt(i - 1) <= '9') {
                            i--;
                        }
                    }
                }
            }
            // j
            if (j != modifiedString.length()) {
                if (modifiedString.charAt(j) == '(') {
                    int bracketsCount = 1;
                    while (bracketsCount != 0) {
                        j++;
                        switch (modifiedString.charAt(j)) {
                            case ')' -> bracketsCount--;
                            case '(' -> bracketsCount++;
                        }
                    }
                } else {
                    if (modifiedString.charAt(j) >= '0' && modifiedString.charAt(j) <= '9') {
                        while (j < modifiedString.length() && modifiedString.charAt(j) >= '0' && modifiedString.charAt(j) <= '9') {
                            j++;
                        }
                    }
                }
            }
            modifiedString.insert(j, ')');
            modifiedString.insert(i, '(');
            int operationStartIndex = modifiedString.indexOf(operation);
            modifiedString.replace(operationStartIndex, operationStartIndex + operation.length(), REPLACEMENT_STRING);
        }
        while (modifiedString.indexOf(REPLACEMENT_STRING) != -1) {
            int replacementStringStartIndex = modifiedString.indexOf(REPLACEMENT_STRING);
            modifiedString.replace(replacementStringStartIndex, replacementStringStartIndex + 1, operation);
        }
    }
}
