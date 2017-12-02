package util;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Sathvik on 11/27/17.
 *
 * The ImageLoader class handles the code for
 * loading image files.
 */
public class ImageLoader {

    /**
     * Loads image from a file location
     * @param file the image file
     * @return the image at the file location
     * @throws IOException if image cannot be loaded properly
     */
    public static BufferedImage loadImage(File file) throws IOException {
        return ImageIO.read(file);
    }

    /**
     * Loads image from a file location and converts into an FX image
     * @param file
     * @return the fx image at the file location
     * @throws IOException if image cannot be loaded properly
     */
    public static Image loadFXImage(File file) throws IOException {
        return toFXImage(loadImage(file));
    }

    /**
     * Converts buffered image to an FX image
     * @param image the buffered image to be converted
     * @return Java FX image
     */
    public static Image toFXImage(BufferedImage image) {
        return SwingFXUtils.toFXImage(image, null);
    }

    /**
     * Converts buffered image to an ImageView
     * @param image the buffered image to be converted
     * @return ImageView
     */
    public static ImageView toImageView(BufferedImage image) {
        return new ImageView(toFXImage(image));
    }
}
