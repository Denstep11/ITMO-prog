package data;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private Double x;
    private float y;

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y+", ";
    }
}
