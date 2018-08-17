package dsa.datastructures;

public interface DataStructure<T extends Comparable<T>> {
    void add(T element);
    void remove(T element);
    void remove(int position);
    T get(int position);
    void set(int position, T element);
    void reverse();
    int size();


    default void swap(int pos1, int pos2){
        T temp = get(pos1);
        set(pos1, get(pos2));
        set(pos2, temp);
    }
}
