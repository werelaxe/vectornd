package vector;

import numbers.ComplexNumber;

/**
 * Created by melon on 05.12.16.
 */
public class Vector {
    public Vector(ComplexNumber[] coordinates) {
        for (int i = 0; i < coordinates.length; i++) {
            this.coordinates = coordinates;
        }
    }

    private ComplexNumber[] coordinates;

    public ComplexNumber[] getCoordinates() {
        return coordinates;
    }

    public int getDimCount() {
        return coordinates.length;
    }
    @Override
    public int hashCode() {
        ComplexNumber sum = new ComplexNumber(0,0);
        for (ComplexNumber coord : coordinates) {
            sum = sum.add(coord);
        }
        return sum.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector))
            return false;
        if (getDimCount() != ((Vector) obj).getDimCount())
            return false;
        if (hashCode() != obj.hashCode())
            return false;
        ComplexNumber[] objectCoords = ((Vector) obj).getCoordinates();
        for (int i = 0; i < coordinates.length; i++) {
            if (objectCoords[i] != coordinates[i])
                return false;
        }
        return true;
    }

    public Vector add(Vector vector) {
        ComplexNumber[] addingCoordinates = vector.getCoordinates();
        ComplexNumber[] newCoordinates = new ComplexNumber[addingCoordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            newCoordinates[i] = coordinates[i].add(addingCoordinates[i]);
        }
        return new Vector(newCoordinates);
    }

    public Vector subtract(Vector vector) {
        ComplexNumber[] subtractingCoordinates = vector.getCoordinates();
        ComplexNumber[] newCoordinates = new ComplexNumber[subtractingCoordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            newCoordinates[i] = coordinates[i].sub(subtractingCoordinates[i]);
        }
        return new Vector(newCoordinates);
    }

    public Vector intDiv(ComplexNumber number) {
        if (number.equals(new ComplexNumber(0, 0))) {
            throw new IllegalArgumentException("Division by zero");
        }
        ComplexNumber[] newCoordinates = new ComplexNumber[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            newCoordinates[i] = coordinates[i].div(number);
        }
        return new Vector(newCoordinates);
    }
    public boolean isZeroVector() {
        for (ComplexNumber x:coordinates) {
            if (!x.equals(new ComplexNumber(0, 0)))
                return false;
        }
        return true;
    }
    public ComplexNumber scalarProduct(Vector vector) {
        if (getDimCount() != vector.getDimCount())
            throw new IllegalArgumentException();
        ComplexNumber sum = new ComplexNumber(0, 0);
        for (int i = 0; i < getDimCount(); i++) {
            sum = sum.add(coordinates[i].mul(vector.getCoordinates()[i]));
        }
        return sum;
    }
    public Vector multiply(ComplexNumber number) {
        ComplexNumber[] newCoordinates = new ComplexNumber[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            newCoordinates[i] = coordinates[i].mul(number);
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
