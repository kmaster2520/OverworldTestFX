package map;

import java.awt.image.BufferedImage;

/**
 * Created by Sathvik on 11/27/17.
 */
public class Tile {

    private BufferedImage image;
    private int w;
    private int h;
    private boolean isSolid;

    public Tile(BufferedImage image, int w, int h, boolean isSolid) {
        this.image = image;
        this.w = w;
        this.h = h;
        this.isSolid = isSolid;
    }

}
