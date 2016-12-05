package vector;

/**
 * Created by melon on 05.12.16.
 */
public class Vector {
    public Vector(int[] coordinates) {
        for (int i = 0; i < coordinates.length; i++) {
            this.coordinates = coordinates;
        }
    }

    private int[] coordinates;

    public int[] getCoordinates() {
        return coordinates;
    }

    public int getDimCount() {
        return coordinates.length;
    }
    @Override
    public int hashCode() {
        int sum = 0;
        for (int coord : coordinates) {
            sum += coord;
        }
        return sum;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector))
            return false;
        if (getDimCount() != ((Vector) obj).getDimCount())
            return false;
        if (hashCode() != obj.hashCode())
            return false;
        int[] objectCoords = ((Vector) obj).getCoordinates();
        for (int i = 0; i < coordinates.length; i++) {
            if (objectCoords[i] != coordinates[i])
                return false;
        }
        return true;
    }

    public Vector add(Vector vector) {
        int[] addingCoordinates = vector.getCoordinates();
        int[] newCoordinates = new int[addingCoordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            newCoordinates[i] = coordinates[i] + addingCoordinates[i];
        }
        return new Vector(newCoordinates);
    }

    public Vector subtract(Vector vector) {
        int[] subtractingCoordinates = vector.getCoordinates();
        int[] newCoordinates = new int[subtractingCoordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            newCoordinates[i] = coordinates[i] - subtractingCoordinates[i];
        }
        return new Vector(newCoordinates);
    }

    public Vector intDiv(int number) {
        if (number == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        int[] newCoordinates = new int[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            newCoordinates[i] = coordinates[i] / number;
        }
        return new Vector(newCoordinates);
    }
    public boolean isZeroVector() {
        for (int x:coordinates) {
            if (x != 0)
                return false;
        }
        return true;
    }
    public int scalarProduct(Vector vector) {
        if (getDimCount() != vector.getDimCount())
            throw new IllegalArgumentException();
        int sum = 0;
        for (int i = 0; i < getDimCount(); i++) {
            sum += coordinates[i] * vector.getCoordinates()[i];
        }
        return sum;
    }
    public Vector multiply(int number) {
        int[] newCoordinates = new int[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            newCoordinates[i] = coordinates[i] * number;
        }
        return new Vector(newCoordinates);
    }
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < coordinates.length - 1; i++) {
            buffer.append(coordinates[i]);
            buffer.append(", ");
        }
        buffer.append(coordinates[coordinates.length - 1]);
        return String.format("Vector(%s)", buffer.toString());
    }
}
