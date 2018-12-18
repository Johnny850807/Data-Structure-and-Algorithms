package dsa.adt;

import java.util.Objects;

/**
 * This data class is used as the element
 * of adt's, so that we can test if your
 * binary search tree's searching is correct.
 * Use the id field to test two datas' identities
 */
public class Data implements Comparable<Data>{
    public int id;
    public char content;

    public Data(int id, char content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return id == data.id &&
                content == data.content;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    @Override
    public int compareTo(Data o) {
        return this.id - o.id;
    }
}
