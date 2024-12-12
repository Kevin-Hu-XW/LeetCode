package HashMap;


import java.util.*;


public class LRUCache_ extends LinkedHashMap<Integer, Integer>{
    int capacity = 0;
    public LRUCache_(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
    }

    public int get(int key) {

        return this.getOrDefault(key,-1);
    }
    public void put(int key, int value) {
            super.put(key,value);
    }
    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
        return this.size()>capacity;
    }
}
