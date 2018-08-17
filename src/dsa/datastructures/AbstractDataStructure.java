package dsa.datastructures;

public abstract class AbstractDataStructure<T extends Comparable<T>> implements DataStructure<T> {

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append(get(0));
        for (int i = 1; i < size(); i ++)
            strb.append(',').append(get(i));
        return strb.toString();
    }
}
