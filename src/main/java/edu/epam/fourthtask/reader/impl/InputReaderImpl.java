package edu.epam.fourthtask.reader.impl;

import edu.epam.fourthtask.exception.WrongFilePathException;
import edu.epam.fourthtask.reader.InputReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class InputReaderImpl implements InputReader {
    static Logger logger = LogManager.getLogger(InputReaderImpl.class);

    @Override
    public String readTextFromFile(Path filePath) throws WrongFilePathException {
        try (Stream<String> lines = Files.lines(filePath)) {
            StringBuilder sb = new StringBuilder();
            lines.forEach(x -> sb.append(x));
            return sb.toString();
        } catch (IOException ex) {
            logger.error("Wrong file path " + filePath, ex);
            throw new WrongFilePathException(filePath.toString(), ex);
        }
    }
}
