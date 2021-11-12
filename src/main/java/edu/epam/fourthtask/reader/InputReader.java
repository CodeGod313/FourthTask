package edu.epam.fourthtask.reader;

import edu.epam.fourthtask.exception.WrongFilePathException;

import java.nio.file.Path;

public interface InputReader {
    String readTextFromFile(Path filepath) throws WrongFilePathException;
}
