package dsa.datastructures;


public class Array<T extends Comparable<T>> extends AbstractDataStructure<T> {
    protected Object[] array;

    public Array(int capacity){
        array = new Object[capacity];
    }

    @Override
    public void add(T element) {
        throw new RuntimeException("Not supported.");
    }

    @Override
    public void remove(T element) {
        throw new RuntimeException("Not supported.");
    }

    @Override
    public void remove(int position) {
        throw new RuntimeException("Not supported.");
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int position) {
        return (T) array[position];
    }

    @Override
    public void set(int position, T element) {
        array[position] = element;
    }

    @Override
    public void reverse() {
        for(int i = 0; i < array.length/2; i++){
            Object temp = array[i];
            array[i] = array[array.length -i -1];
            array[array.length -i -1] = temp;
        }
    }

    @Override
    public int size() {
        return array.length;
    }

    public Object[] getArray(){
        return array;
    }
}
