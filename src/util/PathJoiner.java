package util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Sathvik on 11/27/17.
 */
public class PathJoiner {

    /**
     * creates file path from components
     * @param first root resource directory
     * @param args file path components
     * @return file with given path
     */
    public static File getFile(String first, String... args) {
        Path fileLoc = Paths.get(first, args);
        return fileLoc.toFile();
    }

    /**
     * creates path from compents
     * @param first root resource directory
     * @param args file path components
     * @return path
     */
    public static Path getPath(String first, String... args) {
        Path fileLoc = Paths.get(first, args);
        return fileLoc;
    }

}
