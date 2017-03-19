package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Point;

/**
 * Created by malik on 20.03.2017.
 */
public class MoveController {

    public boolean applyFigure(final Field field,
                               final Point point,
                               final String figure) {
        // BEGIN (write your solution here)
        if (checkCoordinate(point, field)){
            if (field.getFigure(point) == null) {
                field.setFigure(point, figure);
                return true;
            } else return false;
        }
        else return false;
        // END
    }

    // BEGIN (write your solution here) //You may want to check the coordinates in a separate method ???
    public boolean checkCoordinate(final Point point, final Field field) {
        int maxSize = field.getSize() -1;
        return (point.x < maxSize) && (point.x >= 0) && (point.y < maxSize) && (point.y >= 0);
    }
}
