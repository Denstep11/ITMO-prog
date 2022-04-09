package data;

public class Coordinates {
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
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
