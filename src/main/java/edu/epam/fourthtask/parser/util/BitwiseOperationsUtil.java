package edu.epam.fourthtask.parser.util;

import edu.epam.fourthtask.exception.UnknownOperationException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BitwiseOperationsUtil {
    static Logger logger = LogManager.getLogger(BitwiseOperationsUtil.class);
    public static final String BITWISE_NOT = "~";
    public static final String BITWISE_LEFT_SHIFT = "<<";
    public static final String BITWISE_AND = "&";
    public static final String BITWISE_XOR = "^";
    public static final String BITWISE_OR = "|";
    public static final String BITWISE_RIGHT_SHIFT = ">>";
    public static final String OPENING_BRACKET = "(";
    public static final String CLOSING_BRACKET = ")";

    public Integer receivePriority(String operation) throws UnknownOperationException {
        switch (operation) {
            case BITWISE_NOT -> {
                return 5;
            }
            case BITWISE_LEFT_SHIFT, BITWISE_RIGHT_SHIFT -> {
                return 4;
            }
            case BITWISE_AND -> {
                return 3;
            }
            case BITWISE_XOR -> {
                return 2;
            }
            case BITWISE_OR -> {
                return 1;
            }
            case OPENING_BRACKET -> {
                return 0;
            }
            default -> {
                logger.error("Operation " + operation + "is not supported");
                throw new UnknownOperationException("Operation " + operation + "is not supported");
            }
        }
    }
}
