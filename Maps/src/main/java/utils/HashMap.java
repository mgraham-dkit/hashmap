package utils;

/**
 *
 * @author michelle
 */
public class HashMap {
    private static final int DEFAULT_CAPACITY = 23;
    private Entry [] data;
    private int size;
    
    public HashMap(){
        data = new Entry[DEFAULT_CAPACITY];
    }
    
    public HashMap(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("Map capacity cannot be less than 1");
        }
        data = new Entry[capacity];
    }
    
    public int size(){
        return size;
    }
    
    private int calculateSlot(String key){
        int hash = key.hashCode();
        hash = Math.abs(hash) % data.length;
        return hash;
    }
    
    public String put(String key, String value){
        int slot = calculateSlot(key);
        if(data[slot] == null){
            Entry newEntry = new Entry(key, value);
            data[slot] = newEntry;
            size++;
            return null;
        }else{
            String oldValue = data[slot].updateValue(value);
            return oldValue;
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