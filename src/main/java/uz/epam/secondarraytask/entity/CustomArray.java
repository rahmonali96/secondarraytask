package uz.epam.secondarraytask.entity;

import java.util.Arrays;
import java.util.StringJoiner;

public class CustomArray {
    private int id;
    private int[] ints;

    public CustomArray() {
    }

    public CustomArray(int id, int[] ints) {
        this.id = id;
        this.ints = ints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getInts() {
        return ints;
    }

    public void setInts(int[] ints) {
        this.ints = ints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomArray that = (CustomArray) o;

        if (id != that.id) return false;
        return Arrays.equals(ints, that.ints);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Arrays.hashCode(ints);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomArray.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("ints=" + Arrays.toString(ints))
                .toString();
    }
}
