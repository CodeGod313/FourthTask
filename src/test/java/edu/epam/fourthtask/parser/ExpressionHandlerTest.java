package edu.epam.fourthtask.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExpressionHandlerTest {

    ExpressionHandler expressionHandler;
    @BeforeAll
    public void setUp(){
        expressionHandler = new ExpressionHandler();
    }


    @Test
    void handle() {
        Integer actual = expressionHandler.handle("(7^5|1&2<<(2|5>>2&71))|1200");
        Integer expected = 0;
        Assertions.assertEquals(expected, actual);
    }
}