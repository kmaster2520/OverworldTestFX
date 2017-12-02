package util;

import javafx.scene.Node;

import java.util.Comparator;

/**
 * Created by Sathvik on 12/2/17.
 */
public class Comparators {

    /**
     * Comparator for sorting by z coordinate
     */
    public static Comparator<Node> zComparator = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            double c = o1.getTranslateZ() - o2.getTranslateZ();
            if (c > 0.0001) {
                return 1;
            }
            if (c < 0.0001) {
                return -1;
            } else {
                return o1.hashCode() - o2.hashCode();
            }
        }
    };

}
