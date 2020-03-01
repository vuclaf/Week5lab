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
         this.myList = new ArrayList<Pair<K,V>>();
    }
    
    public static final <Pair> void swapReferences(ArrayList<Pair> a, int index1, int index2 )
    {
        Pair tmp = a.get(index1);
        a.set(index1, a.get(index2));
        a.set(index2, tmp);
    }
    
    public static <Pair extends Comparable<? super Pair>> void insertionSort(ArrayList<Pair> a){
        for( int p =1; p< a.size(); p++){
            Pair temp = a.get(p);
            int j=p;
            for (;j>0&&temp.compareTo(a.get(j-1))<0; j--)
                a.set(j,a.get(j-1));
            a.set(j,temp);
        }
    }
    
    private static <Pair extends Comparable<? super Pair>> 
    void quicksort( ArrayList<Pair> a, int low, int high ){
    if( low + 50 > high ) insertionSort(a);
    else{ // Sort low, middle, high
        int middle = ( low + high ) / 2;
        if( a.get(middle).compareTo(a.get(low)) < 0 )
            swapReferences( a, low, middle );
        if( a.get(high).compareTo( a.get(low) ) < 0 )
            swapReferences( a, low, high );
        if( a.get(high).compareTo( a.get(high) ) < 0 )
            swapReferences( a, middle, high );
        // Place pivot at position high - 1
        swapReferences( a, middle, high - 1 );
        Pair pivot = a.get(high-1);

        // Begin partitioning
        int i, j;
        for( i = low, j = high - 1; ; ){
            while( a.get(++i).compareTo( pivot ) < 0 );
            while( pivot.compareTo( a.get(--j) ) < 0 );
            if( i >= j )
                break;
                swapReferences( a, i, j );
            }
        // Restore pivot
            swapReferences( a, i, high - 1 );
            quicksort( a, low, i - 1 ); // Sort small elements
            quicksort( a, i + 1, high ); // Sort large elements
        }
    }
    
    public <Pair extends Comparable<? super Pair>> 
    void stableQuickSort(ArrayList<Pair<K,V>> a){
        ArrayList<Pair<Integer,V>> b = new ArrayList<Pair<Integer,V>>();
        for(Integer i=0; i<a.size(); i++){
            b.set(i,a.get(i));
        }
        
    }
    
    public String toString(){
        String result=null;
        for(int i=0; i<myList.size(); i++){
            result+= " " + myList.get(i).toString();
        }
        return result;
    }
    
}
