package dsa.adt;

import java.util.Objects;

/**
 * This data class is used as the element
 * of adt's, so that we can test if your
 * binary search tree's searching is correct.
 * Use the key field to see a data's identity
 */
public class Data implements Comparable<Data> {
    public int key;
    public char content;

    public Data(int key, char content) {
        this.key = key;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return key == data.key &&
                content == data.content;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, content);
    }

    @Override
    public String toString() {
        return "(" + String.valueOf(key) + "," + content + ")";
    }

    @Override
    public int compareTo(Data o) {
        return this.key - o.key;
    }
}
