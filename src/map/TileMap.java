package map;

import assets.Assets;
import util.ImageLoader;
import util.PathJoiner;
import util.TextFileReader;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
            String spritesheetid = fr.readLine();
            this.spriteSheet = Assets.spriteSheet(spritesheetid);
            this.tiles = new HashMap<>();
            int x = 0;
            int y = 0;
            char c = (char) fr.read();
            do {
                if (c == '\n') {
                    y++;
                    x = -1;
                }
                c = (char) fr.read();
                x++;
            } while (c > 0);
            fr.close();



        } catch (IOException e) {
            System.out.println("File not found: " + file.toString());
        }
    }
}
