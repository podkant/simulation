package Simulation;

public class Coordinates {
    public final int SCALING = 10;
    public int width;
    public int height;

    @Override
    public boolean equals(Object obj) {
        if (obj==this) {
            return true;
        }
        if (!(obj instanceof Coordinates)){
            return false;
        }
        Coordinates c=(Coordinates) obj;
        return width == c.width && height == c.height;
    }

    public Coordinates(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
