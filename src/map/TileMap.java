package map;

import assets.Assets;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import util.ImageLoader;
import util.PathJoiner;
import util.TextFileReader;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Sathvik on 11/27/17.
 */
public class TileMap {

    private String name; // name used to find map file
    private String title; // title of map
    private SpriteSheet spriteSheet; // sprite sheet id

    private Map<Point, Tile> tiles;

    public TileMap(String name, String... options) {
        this.name = name;

        File file = PathJoiner.getFile("res", "maps", name + ".txt");
        //System.out.println(file.toString());
        try {
            TextFileReader fr = new TextFileReader(file);
            this.title = fr.readLine();
            //
            this.spriteSheet = Assets.spriteSheet(fr.readLine()); // find spritesheet
            int tileSizeW = spriteSheet.getTileSizeW();
            int tileSizeH = spriteSheet.getTileSizeH();

            this.tiles = new HashMap<>();
            // read tiles
            int x = -1;
            int y = 0;
            char ch = (char) fr.read();
            while (ch > 0 && ch < 128) {
                System.out.print(ch);
                x++;
                if (ch == '\n') {
                    y++;
                    x = -1;
                } else if (ch == ' ') {
                    ch = (char) fr.read();
                    continue; // ignore spaces
                }
                BufferedImage img = spriteSheet.getImageForChar(ch);
                if (img == null) {
                    ch = (char) fr.read();
                    continue; // continue if no image found for char
                }
                //
                tiles.put(new Point(x * tileSizeW, y * tileSizeH),
                        new Tile(img, x * tileSizeW, y * tileSizeH, tileSizeW, tileSizeH, false ));

                ch = (char) fr.read();
            }

            fr.close();
            System.out.println();



        } catch (IOException e) {
            System.out.println("File not found: " + file.toString());
        }
    }

    public List<ImageView> getTileViews() {
        List<ImageView> tileViews = new ArrayList<>();
        for (Point p : tiles.keySet()) {
            Tile tile = tiles.get(p);
            ImageView imageView = ImageLoader.toImageView(tile.getImage());
            imageView.setTranslateX(tile.getX());
            imageView.setTranslateY(tile.getY());
            tileViews.add(imageView);
        }
        return tileViews;
    }

}
