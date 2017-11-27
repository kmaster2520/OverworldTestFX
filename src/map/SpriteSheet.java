package map;

import util.ImageLoader;
import util.PathJoiner;
import util.TextFileReader;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Sathvik on 11/27/17.
 *
 * Contains the set of tiles that are used for making maps.
 */
public class SpriteSheet {

    private int tileSizeW;
    private int tileSizeH;
    private String name;
    private BufferedImage image;

    private Map<Character, Tile> charConversions;

    /**
     * Creates Spritesheet with name and tile size
     * @param name the unique id for this spritesheet
     * @param tileSizeW horizontal width of a tile
     * @param tileSizeH vertical height of a tile
     */
    public SpriteSheet(String name, int tileSizeW, int tileSizeH) {
        this.name = name;
        this.tileSizeW = tileSizeW;
        this.tileSizeH = tileSizeH;

        File file = PathJoiner.getFile("res", "spritesheets", name + ".png");
        //System.out.println(file.toString());
        try {
            this.image = ImageLoader.loadImage(file);
        } catch (IOException e) {
            System.out.println("File not found: " + file.toString());
        }

        File convertFile = PathJoiner.getFile("res", "spritesheetconversions", name + ".txt");
        try {
            TextFileReader fr = new TextFileReader(convertFile);
            char ch = (char) fr.read();
            while (ch > 0) {
                int r = fr.readInt();
                int c = fr.readInt();
                BufferedImage tileImg = getTileAt(r, c);
                charConversions.put(ch, new Tile(tileImg, tileSizeW, tileSizeW, false));
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("File not found: " + convertFile.toString());
        }

    }

    /**
     * returns one tile from the larger spritesheet
     * @param r row
     * @param c column
     * @return tile image at a given row and column
     */
    public BufferedImage getTileAt(int r, int c) {
        return image.getSubimage(c * tileSizeW, r * tileSizeH, tileSizeW, tileSizeH);
    }

    /**
     * Returns tile image for text char
     * @param c the character to convert
     * @return image
     */
    public Tile getImageForChar(char c) {
        return charConversions.get(c);
    }
}