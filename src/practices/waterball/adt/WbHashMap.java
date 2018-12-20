package practices.waterball.adt;

import dsa.adt.Data;
import dsa.adt.HashMap;

import java.util.LinkedList;
import java.util.Objects;

public class WbHashMap implements HashMap {
    @SuppressWarnings("unchecked")
    private LinkedList<Slot>[] buckets = new LinkedList[59];

    @Override
    public int get(Data key) {
        int b = hashFunction(key);
        for (Slot slot : buckets[b]) {
            if (slot.key.equals(key))
                return slot.value;
        }
        throw new RuntimeException("Not found key : " + key);
    }

    @Override
    public void put(Data key, int value) {
        int b = hashFunction(key);
        if (buckets[b] == null)
            buckets[b] = new LinkedList<>();
        else
            System.out.println("Overflow at: " + key);
        buckets[b].add(new Slot(key, value));
    }

    private int hashFunction(Data d){
        return Math.abs(d.hashCode()) % buckets.length;
    }

    private class Slot{
        Data key;
        int value;

        public Slot(Data key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Slot slot = (Slot) o;
            return value == slot.value &&
                    Objects.equals(key, slot.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}
