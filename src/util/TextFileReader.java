package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Sathvik on 11/27/17.
 */
public class TextFileReader extends BufferedReader {

    public TextFileReader(File file) throws IOException {
        super(new FileReader(file));
    }

    public int readInt() throws IOException {
        int value = 0;
        char c = (char) read();
        while (c >= '0' && c <= '9') {
            value = value * 10 + (c - '0');
        }
        return value;
    }

}
