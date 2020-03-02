import java.util.*;
/**
 * Write a description of class MyArrayList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyArrayList<K extends Comparable<K>, V extends Comparable<V>> extends ArrayList<Pair<K,V>>
{
    private ArrayList<Pair<K,V>> myList;
    
    public MyArrayList(){
    }
    
    /**
     * Method to swap values in the list of Pairs
     */
    public void swapReferences(int index1, int index2 )
    {
        Pair<K,V> tmp = this.get(index1);
        this.set(index1, this.get(index2));
        this.set(index2, tmp);
    }
    
    /**
     * Perform insertionSort on the list of Pairs
     */
    public void insertionSort(){
        for( int p =1; p< this.size(); p++){
            Pair temp = this.get(p);
            int j=p;
            for (;j>0&&temp.compareTo(this.get(j-1))<0; j--)
                this.set(j,this.get(j-1));
            this.set(j,temp);
        }
    }
    
    /**
     * Quicksort for ArrayList of Pairs
     * @param two ends of the ArrayList of Pairs
     */
    public void quicksort( int low, int high ){
    if( low + 50 > high ) this.insertionSort();
    else{ // Sort low, middle, high
        int middle = ( low + high ) / 2;
        if( this.get(middle).compareTo(this.get(low)) < 0 )
            this.swapReferences(low, middle );
        if( this.get(high).compareTo( this.get(low) ) < 0 )
            this.swapReferences(low, high );
        if( this.get(high).compareTo( this.get(high) ) < 0 )
            this.swapReferences(middle, high );
        // Place pivot at position high - 1
        this.swapReferences( middle, high - 1 );
        Pair pivot = this.get(high-1);

        // Begin partitioning
        int i, j;
        for( i = low, j = high - 1; ; ){
            while( this.get(++i).compareTo( pivot ) < 0 );
            while( pivot.compareTo( this.get(--j) ) < 0 );
            if( i >= j )
                break;
                this.swapReferences( i, j );
            }
        // Restore pivot
            this.swapReferences( i, high - 1 );
            this.quicksort( low, i - 1 ); // Sort small elements
            this.quicksort( i + 1, high ); // Sort large elements
        }
    }
    
    /**
     * A method to stably sort ArrayList of Pairs
     * @param two ends of the list
     */
    public void stableQuicksort( int low, int high){
        Integer index = 0;
        MyArrayList<K,V> aux = this;
        for(Pair pair: aux){
            pair.setKey((K) index);
            index++;    
        }
        int middle = ( low + high ) / 2;
        if( aux.get(middle).compareTo(aux.get(low)) < 0 )
            aux.swapReferences( low, middle );
        if( aux.get(high).compareTo( aux.get(low) ) < 0 )
            aux.swapReferences( low, high );
        if( aux.get(high).compareTo( aux.get(high) ) < 0 )
            aux.swapReferences( middle, high );
        // Place pivot at position high - 1
        aux.swapReferences( middle, high - 1 );
        Pair pivot = aux.get(high-1);

        // Begin partitioning
        int i, j;
        for( i = low, j = high - 1; ; ){
            //Check if values are equal, compare by keys
            while( aux.get(++i).compareTo( pivot ) < 0 || (aux.get(i).compareTo(pivot)==0 && aux.get(i).compareToWithKey(pivot)<0));
            while( pivot.compareTo( aux.get(--j) ) < 0 || (aux.get(j).compareTo(pivot)==0 && aux.get(j).compareToWithKey(pivot)>0));
            if( i >= j )break;
                aux.swapReferences( i, j );    
            }
        // Restore pivot
            aux.swapReferences( i, high - 1 );
            aux.quicksort( low, i - 1 ); // Sort small elements
            aux.quicksort( i + 1, high ); // Sort large elements
            
        //Restore old keys
        for (Pair pair:aux){
            int pos = (int) pair.getKey();
            K oldKey = this.get(pos).getKey();
            pair.setKey(oldKey);
        }
        int p=0;
        for (Pair pair:this){
            pair.setValue(aux.get(p).getValue());
            pair.setKey(aux.get(p).getKey());
            p++;
        }
    }
    /**
     * A method to perform a binary search on the ArrayList of Pair
     * @return the index of wanted value in the ArrayList
     */
    public int binarySearch(V wantedValue){
        int low=0; int max=this.size()-1;
        while (low<max){
            int med = low + (max - low)/2;
            if (this.get(med).getValue().compareTo(wantedValue)==0){
                return med;
            }
            if (this.get(med).getValue().compareTo(wantedValue)<0){
                low=med+1;
            }
            else max=med-1;
        }
        return -1;
    }
    
    /**
     * A method to to return the Pairs in the list as a string
     * @return Pairs on the list as a string
     */
    public String toString(){
        String result=" ";
        for(int i=0; i<this.size(); i++){
            result+= " " + this.get(i).toString();
        }
        return result;
    }
    
}
