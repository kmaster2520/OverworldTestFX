package entity;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Sathvik on 12/1/17.
 */
public class Player extends ImageView {

    private static double speed = 10;

    public Player(Image img, double x, double y) {
        setImage(img);
        setTranslateX(x);
        setTranslateY(y);
    }

    public void shiftX(double dx) {
        setTranslateX(getTranslateX() + dx);
    }

    public void shiftY(double dy) {
        setTranslateY(getTranslateY() + dy);
    }

    public static double getSpeed() {
        return speed;
    }

}
