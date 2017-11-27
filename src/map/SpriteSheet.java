package map;

import util.ImageLoader;
import util.PathJoiner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Sathvik on 11/27/17.
 */
public class SpriteSheet {

    private int tileSizeX;
    private int tileSizeY;
    private String name;
    private BufferedImage image;

    /**
     * Creates Spritesheet with name and tile size
     * @param name
     * @param tileSizeX horizontal width of a tile
     * @param tileSizeY vertical height of a tile
     */
    public SpriteSheet(String name, int tileSizeX, int tileSizeY) {
        this.name = name;
        this.tileSizeX = tileSizeX;
        this.tileSizeY = tileSizeY;

        File file = PathJoiner.getFile("res", "spritesheets", name + ".png");
        System.out.println(file.toString());
        try {
            this.image = ImageLoader.loadImage(file);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    /**
     * returns one tile from the larger spritesheet
     * @param r row
     * @param c column
     * @return tile image at a given row and column
     */
    public BufferedImage getTileAt(int r, int c) {
        return image.getSubimage(c * tileSizeX, r * tileSizeY, tileSizeX, tileSizeY);
    }
}