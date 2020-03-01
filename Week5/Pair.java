
/**
 * Composite design that store 2 values key and value
 *
 * @author EvanVu
 * @version 1
 */
public class Pair<K extends Comparable<K>, V extends Comparable<V>>
{
    private K key;
    private V value;
    
    public Pair(K key, V value){
        this.key=key;
        this.value=value;
    }
    
    public void setKey(K newKey){
        this.key=newKey;
    }
    
    public void setValue(V newValue){
        this.value=newValue;
    }
    
    public K getKey(){
        return this.key;
    }
    
    public V getValue(){
        return this. value;
    }
    
    public String toString(){
        return key.toString() + value.toString();
    }
}