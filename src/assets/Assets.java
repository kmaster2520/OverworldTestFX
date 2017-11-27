package assets;

import map.SpriteSheet;
import map.TileMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sathvik on 11/27/17.
 *
 * A list of Assets in one class for easy access.
 */
public class Assets {

    private static Map<String, SpriteSheet> spriteSheets;
    private static Map<String, TileMap> tileMaps;

    /**
     * Initializes assets
     */
    public static void init() {
        spriteSheets = new HashMap<>();
        tileMaps = new HashMap<>();

        spriteSheets.put("fantasy", new SpriteSheet("fantasy", 32, 32));

    }

    /**
     *
     * @param name
     * @return spritesheet with name
     */
    public static SpriteSheet spriteSheet(String name) {
        return spriteSheets.get(name);
    }

    /**
     *
     * @param name
     * @return tilemap with name
     */
    public static TileMap tileMap(String name) {
        return tileMaps.get(name);
    }
}
