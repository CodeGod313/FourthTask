package edu.epam.fourthtask.parser;

import edu.epam.fourthtask.exception.UnknownOperationException;
import edu.epam.fourthtask.parser.util.BitwiseOperationsUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionHandler {
    static Logger logger = LogManager.getLogger(ExpressionHandler.class);
    public static final String OPERATION_PARTS = "\\d+|\\(|\\)|>>|<<|\\&|\\^|\\||~";
    public static final String SPACE = " ";
    Context context = new Context();

    public Integer handle(String expression) throws UnknownOperationException {
        MathExpressionParser mathExpressionParser = new MathExpressionParser();
        String polishExpression = toPolishNotation(expression);
        List<MathExpression> mathExpressions = mathExpressionParser.parseExpression(polishExpression);
        mathExpressions.forEach(x -> x.interpret(context));
        return context.pop();
    }

    private String toPolishNotation(String expression) throws UnknownOperationException {
        Pattern pattern = Pattern.compile(OPERATION_PARTS);
        Matcher matcher = pattern.matcher(expression);
        StringBuilder polishExpression = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        BitwiseOperationsUtil bitwiseOperationsUtil = new BitwiseOperationsUtil();
        while (matcher.find()) {
            String expressionPart = matcher.group();
            switch (expressionPart) {
                case BitwiseOperationsUtil.BITWISE_AND, BitwiseOperationsUtil.BITWISE_OR, BitwiseOperationsUtil.BITWISE_XOR, BitwiseOperationsUtil.BITWISE_NOT, BitwiseOperationsUtil.BITWISE_RIGHT_SHIFT, BitwiseOperationsUtil.BITWISE_LEFT_SHIFT -> {
                    Integer priorityInStack = null;
                    if (!stack.isEmpty()) {
                        priorityInStack = bitwiseOperationsUtil.receivePriority(stack.peek());
                    }
                    Integer currentPriority = bitwiseOperationsUtil.receivePriority(expressionPart);
                    if (stack.isEmpty() || priorityInStack < currentPriority) {
                        stack.push(expressionPart);
                    } else {
                        while (!stack.isEmpty() && priorityInStack >= currentPriority) {
                            polishExpression.append(stack.pop());
                            polishExpression.append(SPACE);
                            if (!stack.isEmpty()) {
                                priorityInStack = bitwiseOperationsUtil.receivePriority(stack.peek());
                            }
                        }
                        stack.push(expressionPart);
                    }
                }
                case BitwiseOperationsUtil.OPENING_BRACKET -> stack.push(expressionPart);
                case BitwiseOperationsUtil.CLOSING_BRACKET -> {
                    String symbolFromStack;
                    while (!(symbolFromStack = stack.pop()).equals(BitwiseOperationsUtil.OPENING_BRACKET)) {
                        polishExpression.append(symbolFromStack);
                        polishExpression.append(SPACE);
                    }
                }
                default -> {
                    polishExpression.append(expressionPart);
                    polishExpression.append(SPACE);
                }
            }
        }
        while (!stack.isEmpty()) {
            polishExpression.append(stack.pop());
            polishExpression.append(SPACE);
        }
        return polishExpression.toString().trim();
    }

}
