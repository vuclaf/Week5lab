
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
    
    public Pair(){
    }
    
    public void setKey(K newKey){
        this.key=newKey;
    }
    
    public void setValue(V newValue){
        this.value=newValue;
    }
    
    public String toString(){
        return key.toString() + value.toString();
    }
    
    
}