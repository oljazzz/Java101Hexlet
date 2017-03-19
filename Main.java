import io.hexlet.xo.controllers.MoveController;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Point;

/**
 * Created by malik on 20.03.2017.
 */
public class Main {

    public static void main(String[] args) {
        final Field field = new Field();
        final MoveController mc = new MoveController();

        for (int i = 0; i < field.getSize(); i++) {
            for (int i2 = 0; i2 < field.getSize(); i2++) {
                final Point p = new Point();
                p.x = i;
                p.y = i2;
                field.setFigure(p, String.format("%d-%d", i, i2));
            }
        }

        for (int i = 0; i < field.getSize(); i++) {
            for (int i2 = 0; i2 < field.getSize(); i2++) {
                final Point p = new Point();
                p.x = i;
                p.y = i2;
                final String figure = String.format("%d-%d", i, i2);
                if (!field.getFigure(p).equals(figure)) {
                    throw new RuntimeException(String.format("figure on X=%d, Y=%d equals to %s instead of %s", i, i2, field.getFigure(p), figure));
                }
                field.setFigure(p, null);
            }
        }

        final Point p = new Point();
        p.x = 1;
        p.y = 1;
        if (!mc.applyFigure(field, p, "X")) {
            throw new RuntimeException("method return false when applying figure to the empty items");
        }
        if (mc.applyFigure(field, p, "X")) {
            throw new RuntimeException("method return true when applying figure to the non empty items");
        }
        final Point p2 = new Point();
        p2.x = -1;
        p2.y = -1;
        if (mc.applyFigure(field, p2, "X")) {
            throw new RuntimeException("method return true when applying figure to the (-1, -1)");
        }
    }
}
