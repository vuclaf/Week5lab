

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MyArrayListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MyArrayListTest
{
    /**
     * Default constructor for test class MyArrayListTest
     */
    public MyArrayListTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void firstCase()
    {
        MyArrayList<Integer ,Integer> myArrayL1 = new MyArrayList<Integer ,Integer>();
        assertEquals(true, myArrayL1.add(new Pair(3,4)));
        assertEquals(true, myArrayL1.add(new Pair(2,3)));
        assertEquals(true, myArrayL1.add(new Pair(1,4)));
        //assertEquals(" 34 23 14", myArrayL1.toString());
        myArrayL1.stableQuicksort(0,myArrayL1.size()-1);
        assertEquals(" 23 34 14", myArrayL1.toString());
    }

    @Test
    public void secondCase()
    {
        MyArrayList<Integer,Integer> myArrayL1 = new MyArrayList<Integer,Integer>();
        assertEquals(true, myArrayL1.add(new Pair(0,2)));
        assertEquals(true, myArrayL1.add(new Pair(3,5)));
        assertEquals(true, myArrayL1.add(new Pair(4,5)));
        assertEquals(1, myArrayL1.binarySearch(5));
    }
}


