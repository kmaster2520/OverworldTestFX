package assets;

import map.SpriteSheet;
import map.TileMap;

import java.util.Map;
import java.util.Set;

/**
 * Created by Sathvik on 11/27/17.
 */
public class Assets {

    private static Map<String, SpriteSheet> spriteSheets;
    private static Map<String, TileMap> tileMaps;

    /**
     * Initializes assets
     */
    public static void init() {

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
