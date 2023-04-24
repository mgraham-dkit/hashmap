package utils;

import java.util.LinkedList;

/**
 *
 * @author michelle
 */
public class CollisionChainedHashMap {
    private static final int DEFAULT_CAPACITY = 103;
    private LinkedList<Entry> [] data;
    private int size;
    
    public CollisionChainedHashMap(){
        data = new LinkedList[DEFAULT_CAPACITY];
    }
    
    public CollisionChainedHashMap(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("Map capacity cannot be less than 1");
        }
        data = new LinkedList[capacity];
    }
    
    public int size(){
        return size;
    }
    
    private int hash(String key){
        int hash = key.hashCode();
        hash = Math.abs(hash);
        hash = hash % data.length;
        return hash;
    }
    
    public String put(String key, String value){
        if(key == null || value == null){
            throw new IllegalArgumentException("Null fields not permitted");
        }
        
        int slot = hash(key);
        
        if(data[slot] == null){
            // If it's a new entry to an empty slot
            data[slot] = new LinkedList();
            Entry newEntry = new Entry(key, value);
            data[slot].add(newEntry);
            size++;
            return null;
        }else{
            // If it's an update
            for(Entry e : data[slot]){
                if(e.key.equals(key)){
                    String oldValue = e.updateValue(value);
                    return oldValue;
                }
            }
            // Add collision
            Entry newEntry = new Entry(key, value);
            data[slot].add(newEntry);
            size++;
            return null;
        }
    }
    
    public String get(String key){
        int slot = hash(key);
        if(data[slot] != null){
            for(Entry e: data[slot]){
                if(e.key.equals(key)){
                    return e.value;
                }
            }
            return null;
        }else{
            return null;
        }
    }
    
    private static class Entry{
        private final String key;
        private String value;
        
        public Entry(String key, String value){
            this.key = key;
            this.value = value;
        }
        
        public String getKey(){
            return key;
        }
        public String getValue(){
            return value;
        }
        public String updateValue(String newValue){
            String oldValue = value;
            this.value = newValue;
            return oldValue;
        }
    }
}
