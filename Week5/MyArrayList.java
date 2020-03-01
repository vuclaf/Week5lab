import java.util.*;
/**
 * Write a description of class MyArrayList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyArrayList extends ArrayList<Pair>
{
    private ArrayList<Pair> myList = new ArrayList<Pair>();
    
    public MyArrayList(){
    }
    
    public void swapReferences(ArrayList<Pair> a, int low, int high){
        
    }
    
    private static <Pair extends Comparable<? super Pair>> 
    void quicksort( Pair [ ] a, int low, int high ){
    if( low + 3 > high ) insertionSort( a, low, high );
    else{ // Sort low, middle, high
        int middle = ( low + high ) / 2;
        if( a[ middle ].compareTo( a[ low ] ) < 0 )
            swapReferences( a, low, middle );
        if( a[ high ].compareTo( a[ low ] ) < 0 )
            swapReferences( a, low, high );
        if( a[ high ].compareTo( a[ middle ] ) < 0 )
            swapReferences( a, middle, high );
        // Place pivot at position high - 1
        swapReferences( a, middle, high - 1 );
        Pair pivot = a[ high - 1 ];

        // Begin partitioning
        int i, j;
        for( i = low, j = high - 1; ; ){
            while( a[ ++i ].compareTo( pivot ) < 0 );
            while( pivot.compareTo( a[ --j ] ) < 0 );
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
    
    public String toString(){
        String result=null;
        for(int i=0; i<myList.size(); i++){
            result+= " " + myList.get(i).toString();
        }
        return result;
    }
    
}
