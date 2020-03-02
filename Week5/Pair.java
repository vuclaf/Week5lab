
/**
 * Composite design that store 2 values key and value
 *
 * @author EvanVu
 * @version 1
 */
public class Pair<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<Pair<K,V>>
{
    private K key;
    private V value;
    
    public Pair(K key, V value){
        this.key=key;
        this.value=value;
    }
    
    /**
     * Setters for Key and Value
     */
    public void setKey(K newKey){
        this.key=newKey;
    }
    
    public void setValue(V newValue){
        this.value=newValue;
    }
    
    /**
     * Getters for Key and Value
     */
    public K getKey(){
        return this.key;
    }
    
    public V getValue(){
        return this. value;
    }
    
    /**
     * Return the Pairs as a string of key and value
     */
    public String toString(){
        return key.toString() + value.toString();
    }
    
    /**
     * Compare two pairs by their values
     * @param the pair to compare against
     * @return 0 for equal, 1 for more than and -1 for less than
     */
    public int compareTo(Pair p){
        return this.value.compareTo((V)p.value);
    }
    /**
     * 
     * Compare two pairs by their keys
     * @param the pair to compare against
     * @return 0 for equal, 1 for more than and -1 for less than
     */
    public int compareToWithKey(Pair p){
        return this.key.compareTo((K)p.key);
    }
}